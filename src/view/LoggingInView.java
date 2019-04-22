package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controller.generalController;
import model.account;
import model.generalModel;

import javax.swing.JButton;

import model.Database;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoggingInView extends JFrame{
	private JTextField UsernameTextField;
	private JPasswordField PasswordTextField;
	account logIn;
	Boolean entrance;
	Database theAccounts;
	
	private volatile static LoggingInView modelInstance = null;
	
	public static LoggingInView getInstance() {
        if (modelInstance == null) {
        	modelInstance = new LoggingInView();
        }
		return modelInstance;
	
	}
	
	public LoggingInView() {
		getContentPane().setBackground(new Color(254,254,250));
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuestView.class.getResource("/images/spotify.png")));
		setTitle("Not So Spotify");
		
		this.setSize(600, 450);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(100, 204, 90, 50);
		getContentPane().add(lblUsername);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsernameTextField.setBounds(189, 213, 295, 32);
		getContentPane().add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		PasswordTextField = new JPasswordField(40);
		PasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PasswordTextField.setColumns(10);
		PasswordTextField.setBounds(189, 251, 295, 32);
		getContentPane().add(PasswordTextField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(100, 242, 90, 50);
		getContentPane().add(lblPassword);
		
		JButton btnConfirm = new JButton("LOG IN");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirm.setBackground(new Color(254,254,250));
		btnConfirm.setBounds(375, 318, 109, 49);
		getContentPane().add(btnConfirm);
		
		JButton btnNotSoSpotify = new JButton("");
		btnNotSoSpotify.setBackground(new Color(254,254,250));
		btnNotSoSpotify.setIcon(new ImageIcon(LoggingInView.class.getResource("/images/spotify.png")));
		btnNotSoSpotify.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNotSoSpotify.setBounds(242, 11, 182, 153);
		btnNotSoSpotify.setBorder(null);
		getContentPane().add(btnNotSoSpotify);
		
		JLabel lblNewLabel = new JLabel("Not So");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(159, 51, 99, 86);
		getContentPane().add(lblNewLabel);
		btnConfirm.addActionListener(new confirmButton());
	}
	
	class confirmButton implements ActionListener
	{
	public void actionPerformed (ActionEvent account)
		{
			String registeredUsername = UsernameTextField.getText();
			String registeredPassword = new String(PasswordTextField.getPassword());
			logIn = new account(registeredUsername,registeredPassword);
			generalController.getInstance().gettingRegisteredAccountData(registeredUsername, registeredPassword);
			RegisteredUserView.getInstance().setUserName(registeredUsername);
			HomeView.getInstance().setUserName(registeredUsername);
			closingWindow();
			SelectAccount.getInstance().setVisible(false);
		}
	}
	
	public void entranceAllowed() {
		JOptionPane.showMessageDialog(null,"Successfully Logged In! Welcome back!");
		HomeView.getInstance().setVisible(true);
	}
	
	public void entranceDenied() {
		JOptionPane.showMessageDialog(null, "Failed to Log Into Your Account!");
	}
	
	public String gettingUsername() {
		String username = UsernameTextField.getText();
		return username;
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
}