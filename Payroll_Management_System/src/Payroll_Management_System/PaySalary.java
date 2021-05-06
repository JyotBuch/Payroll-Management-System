package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PaySalary extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField leaves;
	private JTextField bonus;
	public static int x;
	private JButton btnBack;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaySalary frame = new PaySalary();
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
	public PaySalary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 88, 1055, 440);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID");
		lblEnterEmployeeId.setForeground(Color.BLACK);
		lblEnterEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterEmployeeId.setBounds(25, 577, 133, 16);
		contentPane.add(lblEnterEmployeeId);
		
		JLabel lblEnterLeavesTaken = new JLabel("Enter Leaves taken");
		lblEnterLeavesTaken.setForeground(Color.BLACK);
		lblEnterLeavesTaken.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterLeavesTaken.setBounds(425, 577, 133, 16);
		contentPane.add(lblEnterLeavesTaken);
		
		JLabel lblEnterBonus = new JLabel("Enter Bonus");
		lblEnterBonus.setForeground(Color.BLACK);
		lblEnterBonus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterBonus.setBounds(809, 577, 104, 16);
		contentPane.add(lblEnterBonus);
		
		id = new JTextField();
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Times New Roman", Font.BOLD, 15));
		id.setBounds(170, 574, 116, 22);
		contentPane.add(id);
		id.setColumns(10);
		
		leaves = new JTextField();
		leaves.setForeground(Color.BLACK);
		leaves.setFont(new Font("Times New Roman", Font.BOLD, 15));
		leaves.setBounds(587, 574, 116, 22);
		contentPane.add(leaves);
		leaves.setColumns(10);
		
		bonus = new JTextField();
		bonus.setForeground(Color.BLACK);
		bonus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bonus.setBounds(935, 574, 116, 22);
		contentPane.add(bonus);
		bonus.setColumns(10);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select * from payable_employees where orgid=?;");
			ps.setInt(1, LoginPage.orgid);
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnPayEmployee = new JButton("Pay Employee");
		btnPayEmployee.setForeground(Color.BLACK);
		btnPayEmployee.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPayEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x=Integer.valueOf(id.getText().toString());
					PreparedStatement ps = Database.conn.prepareStatement("{call pay_salary(?,?,?)}");
					ps.setInt(1, Integer.valueOf(id.getText().toString()));
					ps.setFloat(2, Float.parseFloat(bonus.getText().toString()));
					ps.setInt(3, Integer.valueOf(leaves.getText().toString()));
					ps.execute();
					InvoicePage ip = new InvoicePage();
					ip.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPayEmployee.setBounds(425, 606, 150, 25);
		contentPane.add(btnPayEmployee);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AdministratorHome x =new AdministratorHome();
				x.show();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(970, 671, 97, 25);
		contentPane.add(btnBack);
		
		label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(12, 13, 1064, 47);
		contentPane.add(label);
		
		label.setText(LoginPage.orgname);
	}

}
