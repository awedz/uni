package UI;

import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

	private GridBagLayout grid;
	private GridBagConstraints gbc;

	private JLabel lbl_password;
	private JLabel lbl_username;

	private JPasswordField txt_password;
	private JTextField txt_username;

	private JCheckBox chbox_isNewPassword;
	private boolean isNewPassword;
	private JButton btn_com;
	private JButton btn_res;

	public LoginPage() {
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
				if (chbox_isNewPassword.isSelected()) {
					System.out.println("new password");
					//send renew password message to server
					//after ok response open next window and dispose this
				} else {
					System.out.println("fetching com data from db");
					
				}
			}
		});
		this.add(btn_com, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		btn_res.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (chbox_isNewPassword.isSelected())
					System.out.println("new password");
				else
					System.out.println("fetching res data from db");
				// show com window
				// setVisible(false);
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
	public boolean ValidateUser()
	{
		String pass =txt_password.getPassword().toString();
		String name = txt_username.getText();
		boolean ret;
		return (pass.equals("asd") && name.equals("asd")) ? true : false;
			
	}
	public void AddValidUserListener()
	{
		
	}
}
