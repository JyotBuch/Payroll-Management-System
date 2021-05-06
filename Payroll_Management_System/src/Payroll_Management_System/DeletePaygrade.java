package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DeletePaygrade extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField newpg;
	private JButton btnUpdateAndDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePaygrade frame = new DeletePaygrade();
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
	public DeletePaygrade() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 142, 1035, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblChangeThePaygrade = new JLabel("Change the paygrade for these employees to");
		lblChangeThePaygrade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblChangeThePaygrade.setBounds(137, 488, 338, 22);
		contentPane.add(lblChangeThePaygrade);
		
		newpg = new JTextField();
		newpg.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newpg.setBounds(522, 488, 169, 22);
		contentPane.add(newpg);
		newpg.setColumns(10);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select empid from employee where paygradeid=?");
			ps.setInt(1, PaygradePage.paygradevalue);
			ResultSet rs=ps.executeQuery();
			if(rs==null)
			{
				table.setValueAt("No Employees", 1, 1);
			}
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btnUpdateAndDelete = new JButton("Update and Delete");
		btnUpdateAndDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdateAndDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!newpg.getText().toString().isEmpty())
				{
					try {
						PreparedStatement ps = Database.conn.prepareStatement("update employee set paygradeid=? where paygradeid=?");
						ps.setInt(1, Integer.valueOf(newpg.getText().toString()));
						ps.setInt(2, PaygradePage.paygradevalue);
						ps.execute();
						PreparedStatement ps2 = Database.conn.prepareStatement("delete from paygrade where paygradeid=?");
						ps2.setInt(1, PaygradePage.paygradevalue);
						ps2.execute();
						JOptionPane.showMessageDialog(null,"Paygrade Deleted");
						dispose();
						PaygradePage pgp = new PaygradePage();
						pgp.show();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				else
				{
					JOptionPane.showMessageDialog(null,"Update paygrade before Deleting");
				}
			}
		});
		btnUpdateAndDelete.setBounds(743, 484, 178, 31);
		contentPane.add(btnUpdateAndDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PaygradePage pgp = new PaygradePage();
				pgp.show();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(970, 671, 97, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(3, 13, 1064, 47);
		contentPane.add(label);
		
		label.setText(LoginPage.orgname);
	}
}
