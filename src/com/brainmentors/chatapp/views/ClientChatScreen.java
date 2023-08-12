package com.brainmentors.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.network.Client;
import com.brainmentors.chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
    private Client client ;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					try {
						ClientChatScreen frame = new ClientChatScreen();
						frame.setVisible(true);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}

	/** 
	 * Create the frame.
	 */
	
	private void  SendIt() {
		String message = textField.getText();
		try {
			client.SendMessage(UserInfo.USER_NAME+"-"+message);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public ClientChatScreen() throws UnknownHostException, IOException {
		 textArea = new JTextArea();
		 client = new Client(textArea);
		setTitle("Let's Chat");
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 958, 479);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(31, 61, 927, 376);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(10, 510, 831, 66);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton SendIt = new JButton("Send Message");
		SendIt.setHorizontalAlignment(SwingConstants.LEFT);
		SendIt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SendIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendIt();
			}
		});
		SendIt.setBounds(851, 512, 114, 55);
		contentPane.add(SendIt);
		
		setVisible(true);
	}
}
