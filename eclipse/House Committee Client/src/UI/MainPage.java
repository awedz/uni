package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;

import BL.Bl;
import Enums.*;
import Message.GetTenantPymantsMessage;
import Message.InsertUpdateTenantPaymentMessage;
import Message.Message;
import Validation.InputIntValidation;

public class MainPage {
	// main components
	private int _clientID = 0;
	private ClientType _clientType;

	private Bl _conn;

	private JFrame f_mainFrame;
	private JTabbedPane tp_tabbed;// tab component

	// monthly components
	private JPanel pnl_monthly;
	private JTable t_monthData;
	private JScrollPane sp_monthly;
	private String[][] monthlyData;
	private String[] monthDetailsHeader = { "Apartment", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
			"12" };
	private DefaultTableModel monthlyTableModel;

	// year sum components
	private JPanel pnl_yearSum;
	private JTable t_yearSum;
	private JScrollPane sp_yearSum;
	private String[][] yearSumData;
	private String[] yearSumHeader = { "Apartment", "Total sum" };
	private DefaultTableModel yearlTableModel;

	// insert tab components
	private GridBagConstraints gbc;

	private JPanel pnl_insert;

	private JLabel lbl_apartmentNumber;
	private JLabel lbl_amount;
	private JLabel lbl_month;

	private JTextField txt_apartmentNumber;
	private JTextField txt_amount;
	private JComboBox cb_month;

	private JButton btn_done;

	// log in

	LoginPage log;

	public MainPage() throws UnknownHostException, IOException {
		_conn = new Bl();
		f_mainFrame = new JFrame();
		f_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f_mainFrame.setMinimumSize(new Dimension(600, 600));

		tp_tabbed = new JTabbedPane();

		f_mainFrame.add(tp_tabbed, BorderLayout.CENTER);
		log = new LoginPage(_conn);
		log.SetValidationListener((id, type) -> {
			try {
				UserIsValidated(id, type);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public void InitTenantData() throws ClassNotFoundException, IOException {
		String[] yearSumHeader = { "Month", "Sum Payed" };
		GetTenantPymantsMessage msg = new GetTenantPymantsMessage(ClientType.Tenants, ReqType.GetTenantPymants);
		msg.setClientID(_clientID);
		t_monthData = new JTable(_conn.GetTenantYearDetails(msg), yearSumHeader);
		sp_monthly = new JScrollPane(t_monthData);
		pnl_monthly = new JPanel(new BorderLayout(1, 1));
		pnl_monthly.add(sp_monthly);
		f_mainFrame.add(pnl_monthly, BorderLayout.CENTER);
	}

	public void _InitTabbedPanelCommittee() throws ClassNotFoundException, IOException {
		_InitInsertPanel();
		_InitYearSumPanel();
		_InitMonthDetailsPanel();
	}

	private void _InitInsertPanel() {
		gbc = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		pnl_insert = new JPanel(grid);

		lbl_apartmentNumber = new JLabel("Apartment Number");
		lbl_amount = new JLabel("Amount");
		lbl_month = new JLabel("Month");

		txt_apartmentNumber = new JTextField(50);

		txt_amount = new JTextField(50);

		PlainDocument validatorApartment = (PlainDocument) txt_apartmentNumber.getDocument();
		validatorApartment.setDocumentFilter(new InputIntValidation());
		PlainDocument validatorAmount = (PlainDocument) txt_amount.getDocument();
		validatorAmount.setDocumentFilter(new InputIntValidation());

		cb_month = new JComboBox(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" });

		
		btn_done = new JButton("done");
		btn_done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int apartment = Integer.parseInt(txt_apartmentNumber.getText());
				int month = Integer.parseInt((String) cb_month.getSelectedItem());
				int sum = Integer.parseInt(txt_amount.getText());
				System.out.println(txt_apartmentNumber.getText() + " " + (String) cb_month.getSelectedItem() + " "
						+ txt_amount.getText());
				try {
					//insert and update tables
					_InsertPayment(apartment, month, sum);
					monthlyData = _conn.GetCommitteeMonthDetails();
					monthlyTableModel.setDataVector(monthlyData, monthDetailsHeader);

					yearSumData = _conn.GetCommitteeYearDetails();
					yearlTableModel.setDataVector(yearSumData, yearSumHeader);
					
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		pnl_insert.add(lbl_apartmentNumber, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 30;
		pnl_insert.add(txt_apartmentNumber, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnl_insert.add(lbl_amount, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 100;
		gbc.ipady = 30;
		pnl_insert.add(txt_amount, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnl_insert.add(lbl_month, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.ipadx = 100;
		gbc.ipady = 30;
		pnl_insert.add(cb_month, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		pnl_insert.add(btn_done, gbc);

		tp_tabbed.add("Insert Payment", pnl_insert);

	}

	private void _InitYearSumPanel() throws ClassNotFoundException, IOException {

		yearSumData = _conn.GetCommitteeYearDetails();
		yearlTableModel = new DefaultTableModel(yearSumData, yearSumHeader);
		t_yearSum = new JTable(yearlTableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		sp_yearSum = new JScrollPane(t_yearSum, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		t_yearSum.setEnabled(false);
		pnl_yearSum = new JPanel(new BorderLayout(1, 1));
		pnl_yearSum.add(sp_yearSum);
		tp_tabbed.addTab("Year Sum", pnl_yearSum);
	}

	private void _InitMonthDetailsPanel() throws ClassNotFoundException, IOException {

		monthlyData = _conn.GetCommitteeMonthDetails();
		monthlyTableModel = new DefaultTableModel(monthlyData, monthDetailsHeader);
		t_monthData = new JTable(monthlyTableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		sp_monthly = new JScrollPane(t_monthData, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		t_monthData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// t_monthData.setEnabled(false);
		pnl_monthly = new JPanel(new BorderLayout(1, 1));
		pnl_monthly.add(sp_monthly);
		tp_tabbed.addTab("Month Details", pnl_monthly);
	}

	public void UserIsValidated(int clientID, ClientType type) throws ClassNotFoundException, IOException {
		_clientID = clientID;
		_clientType = type;

		// _InitTabbedPanel();
		if (_clientType == ClientType.Committee) {
			_InitTabbedPanelCommittee();

		} else {
			InitTenantData();
		}
		f_mainFrame.pack();
		f_mainFrame.setVisible(true);
	}

	private void _InsertPayment(int apartmentNumber, int monthNumber, int amount)
			throws ClassNotFoundException, IOException {
		InsertUpdateTenantPaymentMessage msg = new InsertUpdateTenantPaymentMessage(ClientType.Committee,
				ReqType.InsertTenantPayment);
		msg.setamount(amount);
		msg.setClientID(apartmentNumber);
		msg.setmonthNum(monthNumber);
		_conn.InsertPayment(msg);
	}

}
