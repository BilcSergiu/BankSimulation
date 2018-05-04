package ro.tuc.pt.Assignment4.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ro.tuc.pt.Assignment4.Model.Account;
import ro.tuc.pt.Assignment4.Model.Bank;
import ro.tuc.pt.Assignment4.Model.Person;
import ro.tuc.pt.Assignment4.Model.SavingAccount;
import ro.tuc.pt.Assignment4.Model.SpendingAccount;
import ro.tuc.pt.Assignment4.View.View;

public class Controller {

	private Bank bank;
	private View view;
	private Account account;

	public Controller() {
		this.view = new View();
		view.setVisible(true);
		this.bank = new Bank();
		fillCbDeleteClient();
		fillClientsTable();
		fillCbAddAccount();
		fillAccountsTable();
		fillCbDepuneri();

		view.actionAddClient(l -> {
			int cnp = Integer.parseInt(this.view.getTextCNP().getText());
			String name = view.getTextNume().getText();
			String phone = view.getTextPhone().getText();
			Person client = new Person(cnp, name, phone);
			bank.addPerson(client);
			fillCbDeleteClient();
			fillClientsTable();
			fillCbAddAccount();
			bank.writePersons(bank.getHashClients());
			bank.writeAccounts(bank.getHashAccounts());
		});

		view.actionDeleteClient(l -> {
			int cnp = Integer.parseInt(this.view.getComboBoxDelete().getSelectedItem().toString());
			Person client = bank.getHashClients().get(cnp);
			bank.removePerson(client);
			fillCbDeleteClient();
			fillClientsTable();
			fillCbAddAccount();
			bank.writePersons(bank.getHashClients());
			bank.writeAccounts(bank.getHashAccounts());
		});

		view.actionAddAccount(l -> {
			int cnp = Integer.parseInt(this.view.getComboBoxAddAc().getSelectedItem().toString());
			Person client = bank.getHashClients().get(cnp);
			Account account = null;
			int value = Integer.parseInt(view.getTextDepozitAddAc().getText());
			if (view.getComboBoxTypeAddAc().getSelectedItem().equals("Spendings account")) {
				account = new SpendingAccount(value, client);
			} else {
				if (view.getComboBoxTypeAddAc().getSelectedItem().equals("Savings account")) {
					account = new SavingAccount(value, client);
				}
			}
			bank.addAccount(account);
			bank.writePersons(bank.getHashClients());
			bank.writeAccounts(bank.getHashAccounts());
			fillAccountsTable();
		});

		view.actionUpdateAcc(l -> {
			if (account != null) {
				view.getTable_2().clearSelection();
				account.setValue(Double.parseDouble(view.getTextSumaAcc().getText()));
				bank.updateAccount(account);
				bank.writePersons(bank.getHashClients());
				bank.writeAccounts(bank.getHashAccounts());
				fillAccountsTable();
			} else {
				JOptionPane.showMessageDialog(view, "Nici un cont nu a fost selectat!");
			}
		});

		view.actionDeleteAcc(l -> {
			if (account != null) {
				bank.removeAccount(account);
				bank.writePersons(bank.getHashClients());
				bank.writeAccounts(bank.getHashAccounts());
				fillAccountsTable();
			} else {
				JOptionPane.showMessageDialog(view, "Nici un cont nu a fost selectat!");
			}
		});

		view.actionDepunere(l -> {
			if (account != null) {
				account.addMoney(Double.parseDouble(view.getTextDepunere().getText()));
				bank.updateAccount(account);
				bank.writePersons(bank.getHashClients());
				bank.writeAccounts(bank.getHashAccounts());
				fillAccountsTable();
				fillCbAccountDepuneri();
			} else {
				JOptionPane.showMessageDialog(view, "Not an existing account!");
			}
		});

		view.actionRetragere(l -> {
			if (account != null) {
				if (account.getValue() >= Double.parseDouble(view.getTextDepunere().getText())) {
					account.removeMoney(Double.parseDouble(view.getTextDepunere().getText()));
					bank.updateAccount(account);
					bank.writePersons(bank.getHashClients());
					bank.writeAccounts(bank.getHashAccounts());
					fillCbAccountDepuneri();
					fillAccountsTable();
				} else {
					JOptionPane.showMessageDialog(view, "Not enough funds!");
				}
			} else {
				JOptionPane.showMessageDialog(view, "Not an existing account!");
			}
		});

		view.actionLichidare(l -> {
			if (account != null) {
				account.setValue(0);
				bank.updateAccount(account);
				bank.writePersons(bank.getHashClients());
				bank.writeAccounts(bank.getHashAccounts());
				fillCbAccountDepuneri();
				fillAccountsTable();
			}
		});

		this.view.getComboBoxDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (view.getComboBoxDelete().getSelectedItem() != null) {
					int cnp = Integer.parseInt(view.getComboBoxDelete().getSelectedItem().toString());
					// System.out.println(cnp);
					if (bank.getHashClients().containsKey(cnp) != false) {
						// System.out.println(cnp);
						Person person = bank.getHashClients().get(cnp);
						view.getTextNumeDelete().setText(person.getName());
					}
				}
			}
		});

		this.view.getComboBoxAddAc().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (view.getComboBoxAddAc().getSelectedItem() != null) {
					int cnp = Integer.parseInt(view.getComboBoxAddAc().getSelectedItem().toString());
					// System.out.println(cnp);
					if (bank.getHashClients().containsKey(cnp) != false) {
						// System.out.println(cnp);
						Person person = bank.getHashClients().get(cnp);
						view.getTextNumeAddAc().setText(person.getName());
					}
				}
			}
		});

		this.view.getComboBoxCNPDepuneri().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (view.getComboBoxCNPDepuneri().getSelectedItem() != null) {
					int cnp = Integer.parseInt(view.getComboBoxCNPDepuneri().getSelectedItem().toString());
					// System.out.println(cnp);
					if (bank.getHashClients().containsKey(cnp) != false) {
						// System.out.println(cnp);
						Person person = bank.getHashClients().get(cnp);
						view.getTextNumeDepuneri().setText(person.getName());
						fillCbAccountDepuneri();
					}
				}
			}
		});

		this.view.getComboBoxContDepuneri().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (view.getComboBoxContDepuneri().getSelectedItem() != null) {
					String id = view.getComboBoxContDepuneri().getSelectedItem().toString();
					int cnp = Integer.parseInt(view.getComboBoxCNPDepuneri().getSelectedItem().toString());
					if (!id.equals("")) {
						account = bank.getAccount(cnp, id);
						if (account != null) {
							view.getTextSumaDepuneri().setText(Double.toString(account.getValue()));
							if (account.getId().startsWith("Sp")) {
								view.getBtnDepunere().setVisible(true);
								view.getTextDepunere().setVisible(true);
								view.getBtnRetragere().setVisible(true);
							} else {
								//view.getBtnDepunere().setVisible(false);
								view.getTextDepunere().setVisible(false);
								view.getBtnRetragere().setVisible(false);
							}

						}
					} else {
						account = null;
					}
				}
			}
		});

		this.view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				if (view.getTable().getSelectedRow() > -1) {
					if (view.getTable().getValueAt(view.getTable().getSelectedRow(), 0) != null) {
						int cnp = Integer
								.parseInt(view.getTable().getValueAt(view.getTable().getSelectedRow(), 0).toString());
						Person person = bank.getHashClients().get(cnp);
						view.getTextCNPlist().setText(Integer.toString(person.getCNP()));
						view.getComboBoxList().removeAllItems();
						view.getComboBoxList().addItem(person.getName());
						fillAccountsTableForClient();
					}

				}
			}
		});

		this.view.getTable_2().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				if (view.getTable_2().getSelectedRow() > -1) {
					if (view.getTable_2().getValueAt(view.getTable_2().getSelectedRow(), 2) != null) {
						String id = view.getTable_2().getValueAt(view.getTable_2().getSelectedRow(), 2).toString();
						int cnp = Integer.parseInt(
								view.getTable_2().getValueAt(view.getTable_2().getSelectedRow(), 0).toString());
						if (!id.equals("")) {
							account = bank.getAccount(cnp, id);
							view.getTextidContAcc().setText(account.getId());
							view.getTextTipAcc().setText(
									view.getTable_2().getValueAt(view.getTable_2().getSelectedRow(), 3).toString());
							view.getTextSumaAcc().setText(Double.toString(account.getValue()));
						} else {
							account = null;
						}

					}
				}
			}
		});
	}

	public void fillCbDeleteClient() {
		view.getComboBoxDelete().removeAllItems();
		List<Person> clients = bank.allClients();
		for (Person client : clients) {
			view.getComboBoxDelete().addItem(client.getCNP());
			view.getTextNumeDelete().setText(client.getName());
		}
	}

	public void fillCbAddAccount() {
		view.getComboBoxAddAc().removeAllItems();
		List<Person> clients = bank.allClients();
		for (Person client : clients) {
			view.getComboBoxAddAc().addItem(client.getCNP());
			view.getTextNumeAddAc().setText(client.getName());
		}
	}

	public void fillCbDepuneri() {
		view.getComboBoxCNPDepuneri().removeAllItems();
		List<Person> clients = bank.allClients();
		for (int i = 0; i < clients.size(); i++) {
			view.getComboBoxCNPDepuneri().addItem(clients.get(i).getCNP());

		}
		if (clients.size() > 0) {
			view.getTextNumeDepuneri().setText(clients.get(0).getName());
		}
		//fillCbAccountDepuneri();
	}

	public void fillCbAccountDepuneri() {
		view.getComboBoxContDepuneri().removeAllItems();
		int cnp = Integer.parseInt(view.getComboBoxCNPDepuneri().getSelectedItem().toString());
		List<Account> acc = bank.readAccount(cnp);
		if (acc != null) {

			for (int i = 0; i < acc.size(); i++) {
				view.getComboBoxContDepuneri().addItem(acc.get(i).getId());
			}
			if (acc.size() > 0) {
				view.getTextSumaDepuneri().setText(Double.toString(acc.get(0).getValue()));
			}
			if (acc != null) {
				// account = bank.getAccount(cnp, acc.get(0).getId());
			}
		}
	}

	public void fillClientsTable() {
		view.getTextCNPlist().setText("");
		view.getComboBoxList().removeAllItems();
		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		Object rowData[] = new Object[3];
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		List<Person> clients = bank.allClients();

		for (int i = 0; i < clients.size(); i++) {
			rowData[0] = clients.get(i).getCNP();
			rowData[1] = clients.get(i).getName();
			rowData[2] = clients.get(i).getPhone();

			model.addRow(rowData);
		}
	}

	public void fillAccountsTable() {
		// view.getTextCNPlist().setText("");
		// view.getComboBoxList().removeAllItems();
		DefaultTableModel model = (DefaultTableModel) view.getTable_2().getModel();
		Object rowData[] = new Object[5];
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		List<Person> clients = bank.allClients();
		List<Account> accounts = bank.allAccounts();

		for (int i = 0; i < accounts.size(); i++) {
			rowData[0] = accounts.get(i).getPerson().getCNP();
			Person client = bank.getHashClients().get(accounts.get(i).getPerson().getCNP());
			rowData[1] = client.getName();
			rowData[2] = accounts.get(i).getId();
			if (accounts.get(i).getId().startsWith("Sp")) {
				rowData[3] = "Spendings account";
			} else {
				rowData[3] = "Savings account";
			}
			rowData[4] = accounts.get(i).getValue();

			model.addRow(rowData);
		}
	}

	public void fillAccountsTableForClient() {
		// view.getTextCNPlist().setText("");
		// view.getComboBoxList().removeAllItems();
		DefaultTableModel model = (DefaultTableModel) view.getTable_1().getModel();
		Object rowData[] = new Object[5];
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		if (!view.getTextCNPlist().getText().equals("")) {
			List<Account> accounts = bank.readAccount(Integer.parseInt(view.getTextCNPlist().getText()));
			if (accounts != null) {
				for (int i = 0; i < accounts.size(); i++) {
					rowData[0] = accounts.get(i).getPerson().getCNP();
					Person client = bank.getHashClients().get(accounts.get(i).getPerson().getCNP());
					rowData[1] = client.getName();
					rowData[2] = accounts.get(i).getId();
					if (accounts.get(i).getId().startsWith("Sp")) {
						rowData[3] = "Spendings account";
					} else {
						rowData[3] = "Savings account";
					}
					rowData[4] = accounts.get(i).getValue();

					model.addRow(rowData);
				}
			}
		}
	}
}
