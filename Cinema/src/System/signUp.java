package System;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtNewUsername;
	private JPasswordField txtNewPassword;
	private JTextField txtNewEmail;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up for Casey-flix");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblNewLabel.setBounds(140, 6, 342, 37);
		contentPane.add(lblNewLabel);
		
		txtNewUsername = new JTextField();
		txtNewUsername.setBounds(218, 132, 212, 26);
		contentPane.add(txtNewUsername);
		txtNewUsername.setColumns(10);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setBounds(218, 170, 212, 26);
		contentPane.add(txtNewPassword);
		
		txtNewEmail = new JTextField();
		txtNewEmail.setBounds(218, 208, 212, 26);
		contentPane.add(txtNewEmail);
		txtNewEmail.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(124, 137, 82, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(124, 175, 70, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(124, 213, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnConfirmSignup = new JButton("Sign Up");
		btnConfirmSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
		btnConfirmSignup.setBounds(208, 287, 117, 29);
		contentPane.add(btnConfirmSignup);
	}
	
	public void signUp()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/cinema","root","root");
			Statement state = con.createStatement();
			String sql = "Select * from users where username = '"+txtNewUsername.getText()+"'";
			
			ResultSet results = state.executeQuery(sql);
			if(results.next())
			{
				txtNewUsername.setBackground(Color.RED);
			}
			else
			{
				sql = "INSERT into users (username, password, email) values ('"+txtNewUsername.getText()+"','"+txtNewPassword.getText().toString()+"','"+txtNewEmail.getText()+"');";
				System.out.println(sql);
				state.executeUpdate(sql);
				
				setVisible(false);
			    dispose();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
