package ro.tuc.pt.Assignment4.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textCNP;
	private JTextField textNume;
	private JTextField textPhone;
	private JTextField textNumeDelete;
	private JTable table;
	private JTextField textCNPlist;
	private JTable table_1;
	private JButton btnAdaugare;
	private JComboBox comboBoxDelete;
	private JButton btnStergere;
	private JComboBox comboBoxList;
	private JTextField textNumeAddAc;
	private JTextField textDepozitAddAc;
	private JButton btnAddAc;
	private JComboBox comboBoxAddAc;
	private JComboBox comboBoxTypeAddAc;
	private JTable table_2;
	private JTextField textidContAcc;
	private JTextField textTipAcc;
	private JTextField textSumaAcc;
	private JButton btnUpdate;
	private JButton btnStergereCont;
	private JButton btnRefresh;
	private JTextField textNumeDepuneri;
	private JTextField textSumaDepuneri;
	private JTextField textDepunere;
	private JComboBox comboBoxContDepuneri;
	private JComboBox comboBoxCNPDepuneri;
	private JButton btnDepunere;
	private JButton btnRetragere;
	private JButton btnLichidare;

	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 575, 383);
		contentPane.add(tabbedPane);

		JPanel panelClient = new JPanel();
		tabbedPane.addTab("Clienti", null, panelClient, null);
		panelClient.setLayout(null);

		JPanel panelAddClients = new JPanel();
		panelAddClients.setBorder(
				new TitledBorder(null, "Adaugare Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAddClients.setBounds(26, 23, 195, 160);
		panelClient.add(panelAddClients);
		panelAddClients.setLayout(null);

		JLabel lblCnp = new JLabel("CNP:");
		lblCnp.setBounds(10, 38, 46, 14);
		panelAddClients.add(lblCnp);

		JLabel lblNume = new JLabel("Nume:");
		lblNume.setBounds(10, 63, 46, 14);
		panelAddClients.add(lblNume);

		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(10, 95, 46, 14);
		panelAddClients.add(lblTelefon);

		textCNP = new JTextField();
		textCNP.setBounds(58, 35, 86, 20);
		panelAddClients.add(textCNP);
		textCNP.setColumns(10);

		textNume = new JTextField();
		textNume.setText("");
		textNume.setBounds(58, 63, 86, 20);
		panelAddClients.add(textNume);
		textNume.setColumns(10);

		textPhone = new JTextField();
		textPhone.setBounds(58, 92, 86, 20);
		panelAddClients.add(textPhone);
		textPhone.setColumns(10);

		btnAdaugare = new JButton("Adaugare");
		btnAdaugare.setBounds(42, 126, 89, 23);
		panelAddClients.add(btnAdaugare);

		JPanel panelDeleteClient = new JPanel();
		panelDeleteClient.setBorder(
				new TitledBorder(null, "Stergere client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDeleteClient.setBounds(26, 194, 195, 150);
		panelClient.add(panelDeleteClient);
		panelDeleteClient.setLayout(null);

		JLabel lblNume_1 = new JLabel("Nume:");
		lblNume_1.setBounds(20, 56, 46, 14);
		panelDeleteClient.add(lblNume_1);

		comboBoxDelete = new JComboBox();
		comboBoxDelete.setBounds(66, 20, 85, 22);
		panelDeleteClient.add(comboBoxDelete);

		JLabel lblCnp_1 = new JLabel("CNP:");
		lblCnp_1.setBounds(20, 24, 46, 14);
		panelDeleteClient.add(lblCnp_1);

		textNumeDelete = new JTextField();
		textNumeDelete.setBounds(65, 53, 86, 20);
		panelDeleteClient.add(textNumeDelete);
		textNumeDelete.setColumns(10);

		btnStergere = new JButton("Stergere");
		btnStergere.setBounds(47, 104, 89, 23);
		panelDeleteClient.add(btnStergere);

		JPanel panelSeeClients = new JPanel();
		panelSeeClients
				.setBorder(new TitledBorder(null, "Lista Clienti", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSeeClients.setBounds(231, 23, 329, 321);
		panelClient.add(panelSeeClients);
		panelSeeClients.setLayout(null);

		JScrollPane scrollPaneClienti = new JScrollPane();
		scrollPaneClienti.setBounds(21, 31, 285, 149);
		panelSeeClients.add(scrollPaneClienti);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CNP", "Name", "Phone" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneClienti.setViewportView(table);

		JLabel lblClient = new JLabel("Client:");
		lblClient.setBounds(25, 196, 46, 14);
		panelSeeClients.add(lblClient);

		comboBoxList = new JComboBox();
		comboBoxList.setBounds(75, 192, 64, 22);
		panelSeeClients.add(comboBoxList);

		JLabel lblNewLabel = new JLabel("CNP:");
		lblNewLabel.setBounds(163, 196, 46, 14);
		panelSeeClients.add(lblNewLabel);

		textCNPlist = new JTextField();
		textCNPlist.setBounds(198, 193, 86, 20);
		panelSeeClients.add(textCNPlist);
		textCNPlist.setColumns(10);

		JScrollPane scrollPaneClient = new JScrollPane();
		scrollPaneClient.setBounds(25, 227, 283, 83);
		panelSeeClients.add(scrollPaneClient);

		table_1 = new JTable();
		table_1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "CNP", "Name", "Account", "Type", "Ammount" }) {
					Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class,
							Float.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		scrollPaneClient.setViewportView(table_1);

		JPanel panelConturi = new JPanel();
		tabbedPane.addTab("Conturi", null, panelConturi, null);
		panelConturi.setLayout(null);

		JPanel panelAddAccount = new JPanel();
		panelAddAccount.setLayout(null);
		panelAddAccount.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Adaugare cont", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAddAccount.setBounds(26, 11, 195, 202);
		panelConturi.add(panelAddAccount);

		JLabel label = new JLabel("CNP:");
		label.setBounds(10, 38, 46, 14);
		panelAddAccount.add(label);

		JLabel label_1 = new JLabel("Nume:");
		label_1.setBounds(10, 63, 46, 14);
		panelAddAccount.add(label_1);

		JLabel lblTip = new JLabel("Tip:");
		lblTip.setBounds(10, 95, 46, 14);
		panelAddAccount.add(lblTip);

		textNumeAddAc = new JTextField();
		textNumeAddAc.setText("");
		textNumeAddAc.setColumns(10);
		textNumeAddAc.setBounds(58, 63, 127, 20);
		panelAddAccount.add(textNumeAddAc);

		textDepozitAddAc = new JTextField();
		textDepozitAddAc.setColumns(10);
		textDepozitAddAc.setBounds(58, 120, 127, 20);
		panelAddAccount.add(textDepozitAddAc);

		btnAddAc = new JButton("Adaugare");
		btnAddAc.setBounds(43, 165, 89, 23);
		panelAddAccount.add(btnAddAc);

		comboBoxAddAc = new JComboBox();
		comboBoxAddAc.setBounds(58, 34, 127, 22);
		panelAddAccount.add(comboBoxAddAc);

		comboBoxTypeAddAc = new JComboBox();
		comboBoxTypeAddAc.setModel(new DefaultComboBoxModel(new String[] { "Savings account", "Spendings account" }));
		comboBoxTypeAddAc.setBounds(58, 88, 127, 22);
		panelAddAccount.add(comboBoxTypeAddAc);

		JLabel lblDepozit = new JLabel("Depozit:");
		lblDepozit.setBounds(10, 120, 46, 14);
		panelAddAccount.add(lblDepozit);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Lista conturi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(231, 11, 329, 333);
		panelConturi.add(panel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 309, 125);
		panel_2.add(scrollPane);

		table_2 = new JTable();
		table_2.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "CNP", "Name", "Account", "Type", "Ammount" }) {
					Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class,
							Float.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		scrollPane.setViewportView(table_2);

		JLabel lblCont = new JLabel("Cont:");
		lblCont.setBounds(89, 174, 46, 14);
		panel_2.add(lblCont);

		textidContAcc = new JTextField();
		textidContAcc.setEditable(false);
		textidContAcc.setBounds(131, 171, 86, 20);
		panel_2.add(textidContAcc);
		textidContAcc.setColumns(10);

		JLabel lblTip_1 = new JLabel("Tip:");
		lblTip_1.setBounds(95, 202, 46, 14);
		panel_2.add(lblTip_1);

		textTipAcc = new JTextField();
		textTipAcc.setEditable(false);
		textTipAcc.setBounds(131, 199, 86, 20);
		panel_2.add(textTipAcc);
		textTipAcc.setColumns(10);

		JLabel lblSuma = new JLabel("Suma:");
		lblSuma.setBounds(95, 230, 46, 14);
		panel_2.add(lblSuma);

		textSumaAcc = new JTextField();
		textSumaAcc.setBounds(131, 227, 86, 20);
		panel_2.add(textSumaAcc);
		textSumaAcc.setColumns(10);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(120, 283, 89, 23);
		panel_2.add(btnUpdate);

		btnStergereCont = new JButton("Stergere");
		btnStergereCont.setBounds(21, 283, 89, 23);
		panel_2.add(btnStergereCont);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(219, 283, 89, 23);
		panel_2.add(btnRefresh);

		JPanel panelTransactions = new JPanel();
		tabbedPane.addTab("Tranzactii", null, panelTransactions, null);
		panelTransactions.setLayout(null);

		JPanel panelDepuneri = new JPanel();
		panelDepuneri.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tranzactii", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDepuneri.setBounds(72, 44, 387, 238);
		panelTransactions.add(panelDepuneri);
		panelDepuneri.setLayout(null);

		JLabel lblCnp_2 = new JLabel("CNP:");
		lblCnp_2.setBounds(85, 41, 46, 14);
		panelDepuneri.add(lblCnp_2);

		JLabel lblNume_2 = new JLabel("Nume:");
		lblNume_2.setBounds(85, 66, 46, 14);
		panelDepuneri.add(lblNume_2);

		JLabel lblCont_1 = new JLabel("Cont:");
		lblCont_1.setBounds(85, 91, 46, 14);
		panelDepuneri.add(lblCont_1);

		JLabel lblSumaCurenta = new JLabel("Suma curenta:");
		lblSumaCurenta.setBounds(85, 116, 70, 14);
		panelDepuneri.add(lblSumaCurenta);

		JLabel lblDepunere = new JLabel("Depunere:");
		lblDepunere.setBounds(85, 141, 70, 14);
		panelDepuneri.add(lblDepunere);

		textNumeDepuneri = new JTextField();
		textNumeDepuneri.setText("");
		textNumeDepuneri.setBounds(161, 63, 152, 20);
		panelDepuneri.add(textNumeDepuneri);
		textNumeDepuneri.setColumns(10);

		textSumaDepuneri = new JTextField();
		textSumaDepuneri.setText("");
		textSumaDepuneri.setBounds(161, 113, 152, 20);
		panelDepuneri.add(textSumaDepuneri);
		textSumaDepuneri.setColumns(10);

		textDepunere = new JTextField();
		textDepunere.setBounds(161, 138, 152, 20);
		panelDepuneri.add(textDepunere);
		textDepunere.setColumns(10);

		comboBoxContDepuneri = new JComboBox();
		comboBoxContDepuneri.setBounds(161, 87, 152, 22);
		panelDepuneri.add(comboBoxContDepuneri);

		comboBoxCNPDepuneri = new JComboBox();
		comboBoxCNPDepuneri.setBounds(161, 37, 152, 22);
		panelDepuneri.add(comboBoxCNPDepuneri);

		btnDepunere = new JButton("Depunere");
		btnDepunere.setBounds(44, 194, 89, 23);
		panelDepuneri.add(btnDepunere);

		btnRetragere = new JButton("Retragere");
		btnRetragere.setBounds(148, 194, 89, 23);
		panelDepuneri.add(btnRetragere);

		btnLichidare = new JButton("Lichidare");
		btnLichidare.setBounds(264, 194, 89, 23);
		panelDepuneri.add(btnLichidare);
	}

	public JButton getBtnRetragere() {
		return btnRetragere;
	}

	public void setBtnRetragere(JButton btnRetragere) {
		this.btnRetragere = btnRetragere;
	}

	public JButton getBtnLichidare() {
		return btnLichidare;
	}

	public void setBtnLichidare(JButton btnLichidare) {
		this.btnLichidare = btnLichidare;
	}

	public JButton getBtnDepunere() {
		return btnDepunere;
	}

	public void setBtnDepunere(JButton btnDepunere) {
		this.btnDepunere = btnDepunere;
	}

	public JComboBox getComboBoxContDepuneri() {
		return comboBoxContDepuneri;
	}

	public void setComboBoxContDepuneri(JComboBox comboBoxContDepuneri) {
		this.comboBoxContDepuneri = comboBoxContDepuneri;
	}

	public JComboBox getComboBoxCNPDepuneri() {
		return comboBoxCNPDepuneri;
	}

	public void setComboBoxCNPDepuneri(JComboBox comboBoxCNPDepuneri) {
		this.comboBoxCNPDepuneri = comboBoxCNPDepuneri;
	}

	public JTextField getTextNumeDepuneri() {
		return textNumeDepuneri;
	}

	public void setTextNumeDepuneri(JTextField textNumeDepuneri) {
		this.textNumeDepuneri = textNumeDepuneri;
	}

	public JTextField getTextSumaDepuneri() {
		return textSumaDepuneri;
	}

	public void setTextSumaDepuneri(JTextField textSumaDepuneri) {
		this.textSumaDepuneri = textSumaDepuneri;
	}

	public JTextField getTextDepunere() {
		return textDepunere;
	}

	public void setTextDepunere(JTextField textDepunere) {
		this.textDepunere = textDepunere;
	}

	
	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public void setBtnRefresh(JButton btnRefresh) {
		this.btnRefresh = btnRefresh;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnStergereCont() {
		return btnStergereCont;
	}

	public void setBtnStergereCont(JButton btnStergereCont) {
		this.btnStergereCont = btnStergereCont;
	}

	public JTextField getTextidContAcc() {
		return textidContAcc;
	}

	public void setTextidContAcc(JTextField textidContAcc) {
		this.textidContAcc = textidContAcc;
	}

	public JTextField getTextTipAcc() {
		return textTipAcc;
	}

	public void setTextTipAcc(JTextField textTipAcc) {
		this.textTipAcc = textTipAcc;
	}

	public JTextField getTextSumaAcc() {
		return textSumaAcc;
	}

	public void setTextSumaAcc(JTextField textSumaAcc) {
		this.textSumaAcc = textSumaAcc;
	}


	public JTable getTable_2() {
		return table_2;
	}

	public void setTable_2(JTable table_2) {
		this.table_2 = table_2;
	}

	public JTextField getTextNumeAddAc() {
		return textNumeAddAc;
	}

	public void setTextNumeAddAc(JTextField textNumeAddAc) {
		this.textNumeAddAc = textNumeAddAc;
	}

	public JTextField getTextDepozitAddAc() {
		return textDepozitAddAc;
	}

	public void setTextDepozitAddAc(JTextField textDepozitAddAc) {
		this.textDepozitAddAc = textDepozitAddAc;
	}



	public JButton getBtnAddAc() {
		return btnAddAc;
	}

	public void setBtnAddAc(JButton btnAddAc) {
		this.btnAddAc = btnAddAc;
	}

	public JComboBox getComboBoxAddAc() {
		return comboBoxAddAc;
	}

	public void setComboBoxAddAc(JComboBox comboBoxAddAc) {
		this.comboBoxAddAc = comboBoxAddAc;
	}

	public JComboBox getComboBoxTypeAddAc() {
		return comboBoxTypeAddAc;
	}

	public void setComboBoxTypeAddAc(JComboBox comboBoxTypeAddAc) {
		this.comboBoxTypeAddAc = comboBoxTypeAddAc;
	}

	public void actionAddClient(ActionListener l) {
		this.btnAdaugare.addActionListener(l);
	}

	public void actionDeleteClient(ActionListener l) {
		this.btnStergere.addActionListener(l);
	}

	public void actionAddAccount(ActionListener l) {
		this.btnAddAc.addActionListener(l);
	}

	public void actionUpdateAcc(ActionListener l) {
		this.btnUpdate.addActionListener(l);
	}

	public void actionDeleteAcc(ActionListener l) {
		this.btnStergereCont.addActionListener(l);
	}

	

	public void actionDepunere(ActionListener l) {
		this.btnDepunere.addActionListener(l);
	}

	public void actionLichidare(ActionListener l) {
		this.btnLichidare.addActionListener(l);
	}

	public void actionRetragere(ActionListener l) {
		this.btnRetragere.addActionListener(l);
	}
	public JTextField getTextCNP() {
		return textCNP;
	}

	public void setTextCNP(JTextField textCNP) {
		this.textCNP = textCNP;
	}

	public JTextField getTextNume() {
		return textNume;
	}

	public void setTextNume(JTextField textNume) {
		this.textNume = textNume;
	}

	public JTextField getTextPhone() {
		return textPhone;
	}

	public void setTextPhone(JTextField textPhone) {
		this.textPhone = textPhone;
	}

	public JTextField getTextCNPDelete() {
		return textNumeDelete;
	}

	public void setTextCNPDelete(JTextField textCNPDelete) {
		this.textNumeDelete = textCNPDelete;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextCNPlist() {
		return textCNPlist;
	}

	public void setTextCNPlist(JTextField textCNPlist) {
		this.textCNPlist = textCNPlist;
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JButton getBtnAdaugare() {
		return btnAdaugare;
	}

	public void setBtnAdaugare(JButton btnAdaugare) {
		this.btnAdaugare = btnAdaugare;
	}

	public JComboBox getComboBoxDelete() {
		return comboBoxDelete;
	}

	public void setComboBoxDelete(JComboBox comboBoxDelete) {
		this.comboBoxDelete = comboBoxDelete;
	}

	public JButton getBtnStergere() {
		return btnStergere;
	}

	public JTextField getTextNumeDelete() {
		return textNumeDelete;
	}

	public void setTextNumeDelete(JTextField textNumeDelete) {
		this.textNumeDelete = textNumeDelete;
	}

	public void setBtnStergere(JButton btnStergere) {
		this.btnStergere = btnStergere;
	}

	public JComboBox getComboBoxList() {
		return comboBoxList;
	}

	public void setComboBoxList(JComboBox comboBoxList) {
		this.comboBoxList = comboBoxList;
	}
}
