package de.mathisneunzig.buchhaltung;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtAccName;
	private JTextField textField;

	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setVisible(true);
	}
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Buchen auf Konten");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl1.setBounds(10, 11, 175, 32);
		contentPane.add(lbl1);
		
		JComboBox cbAccounts = new JComboBox();
		cbAccounts.setBounds(10, 163, 136, 22);
		contentPane.add(cbAccounts);
		
		JButton btnNewAccount = new JButton("Konto er\u00F6ffnen");
		btnNewAccount.setBounds(652, 71, 129, 23);
		contentPane.add(btnNewAccount);
		
		txtAccName = new JTextField();
		txtAccName.setBounds(652, 19, 129, 20);
		contentPane.add(txtAccName);
		txtAccName.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(652, 40, 129, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(597, 19, 45, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNummer = new JLabel("Nummer");
		lblNummer.setBounds(597, 40, 45, 14);
		contentPane.add(lblNummer);
	}
}
