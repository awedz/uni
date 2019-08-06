package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BL.Bl;
import Contracts.IValidatedClientListener;
import Enums.*;
import Message.LoginMessage;

public class LoginPage extends JFrame {

	private IValidatedClientListener _listener;
	private Bl _conn;
	private GridBagLayout grid;
	private GridBagConstraints gbc;

	private JLabel lbl_password;
	private JLabel lbl_username;

	private JPasswordField txt_password;
	private JTextField txt_username;

	private JCheckBox chbox_isNewPassword;
	private JButton btn_com;
	private JButton btn_res;

	private ReqType _req;
	private ClientType _cType;

	public LoginPage(Bl conn) throws UnknownHostException, IOException {
		_conn = conn;
		grid = new GridBagLayout();
		gbc = new GridBagConstraints();

		setLayout(grid);
		setTitle("Log in");
		lbl_username = new JLabel("Username");
		txt_username = new JTextField(200);

		lbl_password = new JLabel("Password");
		txt_password = new JPasswordField();
		btn_com = new JButton("log as comittee");
		btn_res = new JButton("log as resident");

		chbox_isNewPassword = new JCheckBox("Renew password");

		this.setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(lbl_username, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 30;
		this.add(txt_username, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(lbl_password, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 100;
		gbc.ipady = 30;
		this.add(txt_password, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		btn_com.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_cType = ClientType.Committee;
				if (chbox_isNewPassword.isSelected()) {
					System.out.println("new password");
					_req = ReqType.NewPassword;
					UpdatePassword();
				} else {
					_req = ReqType.Login;
					try {
						ValidateUser();
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		this.add(btn_com, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		btn_res.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_cType = ClientType.Tenants;
				if (chbox_isNewPassword.isSelected()) {
					_req = ReqType.NewPassword;
					UpdatePassword();
				} else {
					_req = ReqType.Login;
					try {
						ValidateUser();
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}         
				} 
			}
		});
		this.add(btn_res, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		chbox_isNewPassword.setSelected(false);
		this.add(chbox_isNewPassword, gbc);

		setSize(500, 300);
		setPreferredSize(getSize());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void UpdatePassword()
	{

		// send data to server

		LoginMessage msg = new LoginMessage(_cType, _req);

		msg.Pswd = new String(txt_password.getPassword());
		msg.UserName = txt_username.getText();
		try {
			_conn.UpdatePassword(msg);

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void ValidateUser() throws ClassNotFoundException, IOException {

		// send data to server

		LoginMessage msg = new LoginMessage(_cType, _req);

		msg.Pswd = new String(txt_password.getPassword());
		msg.UserName = txt_username.getText();

		int res = 0;
		try {
			res = _conn.ValidateUser(msg);
			if (res > 0) {
				// activate callback
				if (_listener != null) {
					_listener.ValidatedListener(res, _cType);
					setVisible(false);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SetValidationListener(IValidatedClientListener Listener) {
		_listener = Listener;
	}

}
