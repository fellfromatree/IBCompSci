package System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
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
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuTitle = new JLabel("Casey-flix");
		lblMenuTitle.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblMenuTitle.setBounds(210, 6, 157, 43);
		contentPane.add(lblMenuTitle);
		
		JList list = new JList();
		list.setBounds(140, 92, 295, 199);
		contentPane.add(list);
		
		List movData = getMovies();
		list.setListData(movData.toArray());
		
		JButton btnLeaveMenu = new JButton("Logout");
		btnLeaveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnLeaveMenu.setBounds(234, 314, 117, 29);
		contentPane.add(btnLeaveMenu);
		
		JLabel lblNewLabel = new JLabel("Currently Showing");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(196, 61, 184, 35);
		contentPane.add(lblNewLabel);
		
	}
	
	public List getMovies()
	{
		List<String> movies = new ArrayList<String>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://studentdb.mrcasey.org:3306/mrcaseyo_nlcs_pcasey","mrcaseyo_nlcs_pcasey","Pass");
			Statement state = con.createStatement();
			String sql = "Select * from cinema_movies";
			
			ResultSet results = state.executeQuery(sql);
			while(results.next())
			{
				movies.add(results.getString("title"));
				System.out.println(results.getString("title"));
			}
			
			
		}
		catch(Exception e)
		{
			
		}
		
		return movies;
	}
}
