package com.brainmentors.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.UserInfo;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserScreen extends JFrame {
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		
	UserScreen window = new UserScreen();
					
	}

	/**
	 * Create the application.
	 */
	UserDAO userDAO=new UserDAO();
	private void doLogin() {
		String userid=useridtxt.getText();
		char[] password=passwordField.getPassword();
		
		UserDTO userDTO=new UserDTO(userid, password);
		try {
			String message="";
			if(userDAO.isLogin(userDTO))
			{   
				message="Welcome "+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this, message); 
				setVisible(false);
				dispose();
				DashBoard dashboard = new DashBoard(message);
				dashboard.setVisible(true); 
			}
			else {
				message="Invalid User ID or Password...";
				JOptionPane.showMessageDialog(this, message);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	private  void register() {
		String userid=useridtxt.getText();
		char[] password=passwordField.getPassword();
		
		UserDTO userDTO=new UserDTO(userid, password);
		try {
		int result=userDAO.add(userDTO);
		if(result>0) {
			JOptionPane.showMessageDialog(this, "Registered Successfully...");
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Registering Failed...");
		}
		}
		catch(ClassNotFoundException | SQLException ex) {
		System.out.println("DataBase Issue...");
		ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some Generic Exception...");
			ex.printStackTrace(); //where is the exception
		}
		System.out.println("User ID " + userid+" Password "+password);
		
		
	}
	
	public UserScreen() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblNewLabel.setBounds(346, 46, 167, 53);
		getContentPane().add(lblNewLabel);
		
		JLabel Useridlbl = new JLabel("User ID");
		Useridlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Useridlbl.setBounds(190, 153, 167, 41);
		getContentPane().add(Useridlbl);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(426, 153, 367, 41);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		pwdlbl.setBounds(190, 250, 167, 41);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(426, 254, 373, 37);
		getContentPane().add(passwordField);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginbt.setBounds(229, 379, 128, 46);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registerbt.setBounds(456, 379, 128, 46);
		getContentPane().add(registerbt);
		setBackground(new Color(255, 255, 255));
		setTitle("LOGIN");
		setResizable(false);
		setBounds(100, 100, 886, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	}


