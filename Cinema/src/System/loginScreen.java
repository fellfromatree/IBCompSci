package System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class loginScreen {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginScreen window = new loginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Casey-flix");
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblTitle.setBounds(263, 6, 151, 55);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(50, 195, 114, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 223, 114, 16);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(176, 190, 257, 26);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp s = new signUp();
				s.setVisible(true);;
			}
		});
		btnSignUp.setBounds(50, 289, 117, 29);
		frame.getContentPane().add(btnSignUp);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginConnect();
			}
		});
		
		btnLogin.setBounds(176, 289, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		btnReset.setBounds(305, 289, 117, 29);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("exit");
						{
							if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?","Casey-flix",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
							{
								System.exit(0);
							}
						}
			}
		});
		btnExit.setBounds(434, 289, 117, 29);
		frame.getContentPane().add(btnExit);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				if(keycode==KeyEvent.VK_ENTER)
				{
					loginConnect();
				}
			}
		});
		txtPassword.setBounds(176, 218, 257, 26);
		frame.getContentPane().add(txtPassword);
	}
	
	
	public void loginConnect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://studentdb.mrcasey.org:3306/mrcaseyo_nlcs_pcasey","mrcaseyo_nlcs_pcasey","Pass");
			Statement state = con.createStatement();
			String sql = "Select * from cinema_users where username = '"+txtUsername.getText()+"' and password = '"+txtPassword.getText().toString()+"'";
			
			ResultSet results = state.executeQuery(sql);
			if(results.next())
			{
				JOptionPane.showMessageDialog(frame, "You're logged in.");
				mainMenu mm = new mainMenu();
				mm.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Incorrect username or password.");
				resetForm();
			}
		}
		catch(Exception e)
		{
			frame = new JFrame("error");
			JOptionPane.showMessageDialog(frame, "Something went wrong.");
			System.out.println(e);
		}
	}
	
	public void resetForm()
	{
		txtUsername.setText(null);
		txtPassword.setText(null);
	}
}
