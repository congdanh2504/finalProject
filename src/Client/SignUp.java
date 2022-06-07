package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Helper.DBService;
import model.User;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JTextField passwordTF;
	private DBService dbService;
	private String serviceName = "rmi://localhost:6789/test";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		
		try {
			dbService = (DBService) Naming.lookup(serviceName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(73, 81, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(73, 124, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(226, 78, 86, 20);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(226, 121, 86, 20);
		contentPane.add(passwordTF);
		passwordTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sign up");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(170, 11, 100, 46);
		contentPane.add(lblNewLabel_2);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTF.getText();
				String pass = passwordTF.getText();
				if (username.isBlank() || pass.isBlank()) {
					JOptionPane.showMessageDialog(null, "Vui long nhap du thong tin");
					return;
				} 
				User user = new User(username, pass);
				try {
					dbService.signUp(user);
					JOptionPane.showMessageDialog(null, "Dang ki thanh cong");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Dang ki that bai");
					e2.printStackTrace();
				}
				
				
			}
		});
		okBtn.setBounds(223, 187, 89, 23);
		contentPane.add(okBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		cancelBtn.setBounds(49, 187, 89, 23);
		contentPane.add(cancelBtn);
	}

}
