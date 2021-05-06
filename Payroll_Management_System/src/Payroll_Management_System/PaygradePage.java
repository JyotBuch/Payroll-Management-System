package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PaygradePage extends JFrame {

	private JPanel contentPane;
	private JTextField paygradename;
	private JTextField basesalary;
	private JTextField benefits;
	private JTextField taxpercent;
	private JTextField leaveredper;
	private JTextField leavespermitted;
	private JTextField paygradeid;
	private JTextField newpaygrade;
	private JTextField newbasesalary;
	private JTextField newbenefits;
	private JTextField newtaxb;
	private JTextField newleaveredper;
	private JTextField newleaveper;
	public static String querystart = "update paygrade set ";
	public static String queryend = "where paygradeid=?";
	public static String querymid = "";
	public static int count = 0;
	private JTextField editpgid;
	public static String querynew = "";
	private JTable table;
	public static int paygradevalue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaygradePage frame = new PaygradePage();
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
	public PaygradePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddPaygrade = new JLabel("Add paygrade");
		lblAddPaygrade.setForeground(Color.BLACK);
		lblAddPaygrade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddPaygrade.setBounds(42, 231, 142, 16);
		contentPane.add(lblAddPaygrade);

		JLabel lblPaygradeName = new JLabel("Paygrade Name");
		lblPaygradeName.setForeground(Color.BLACK);
		lblPaygradeName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPaygradeName.setBounds(42, 317, 124, 16);
		contentPane.add(lblPaygradeName);

		paygradename = new JTextField();
		paygradename.setForeground(Color.BLACK);
		paygradename.setFont(new Font("Times New Roman", Font.BOLD, 15));
		paygradename.setToolTipText("");
		paygradename.setBounds(211, 314, 116, 22);
		contentPane.add(paygradename);
		paygradename.setColumns(10);

		JLabel lblBaseSalary = new JLabel("Base Salary");
		lblBaseSalary.setForeground(Color.BLACK);
		lblBaseSalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBaseSalary.setBounds(42, 352, 92, 16);
		contentPane.add(lblBaseSalary);

		basesalary = new JTextField();
		basesalary.setForeground(Color.BLACK);
		basesalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		basesalary.setBounds(211, 349, 116, 22);
		contentPane.add(basesalary);
		basesalary.setColumns(10);

		JLabel lblBenefits = new JLabel("Benefits");
		lblBenefits.setForeground(Color.BLACK);
		lblBenefits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBenefits.setBounds(42, 394, 56, 16);
		contentPane.add(lblBenefits);

		benefits = new JTextField();
		benefits.setForeground(Color.BLACK);
		benefits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		benefits.setBounds(211, 391, 116, 22);
		contentPane.add(benefits);
		benefits.setColumns(10);

		JLabel lblTaxPercent = new JLabel("Tax Percent");
		lblTaxPercent.setForeground(Color.BLACK);
		lblTaxPercent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTaxPercent.setBounds(42, 433, 83, 16);
		contentPane.add(lblTaxPercent);

		taxpercent = new JTextField();
		taxpercent.setForeground(Color.BLACK);
		taxpercent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		taxpercent.setBounds(211, 430, 116, 22);
		contentPane.add(taxpercent);
		taxpercent.setColumns(10);

		JLabel lblLeaveReduction = new JLabel("Leave Reduction %");
		lblLeaveReduction.setForeground(Color.BLACK);
		lblLeaveReduction.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLeaveReduction.setBounds(42, 478, 142, 16);
		contentPane.add(lblLeaveReduction);

		leaveredper = new JTextField();
		leaveredper.setForeground(Color.BLACK);
		leaveredper.setFont(new Font("Times New Roman", Font.BOLD, 15));
		leaveredper.setBounds(211, 475, 116, 22);
		contentPane.add(leaveredper);
		leaveredper.setColumns(10);

		JLabel lblLeavesPermitted = new JLabel("Leaves permitted");
		lblLeavesPermitted.setForeground(Color.BLACK);
		lblLeavesPermitted.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLeavesPermitted.setBounds(42, 510, 130, 22);
		contentPane.add(lblLeavesPermitted);

		leavespermitted = new JTextField();
		leavespermitted.setForeground(Color.BLACK);
		leavespermitted.setFont(new Font("Times New Roman", Font.BOLD, 15));
		leavespermitted.setBounds(211, 513, 116, 22);
		contentPane.add(leavespermitted);
		leavespermitted.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PreparedStatement ps=Database.conn.prepareStatement("insert into paygrade(orgid,paygrade_name,base_salary,benefits,tax_percent,leave_reduction_percent,leaves_permitted) values(?,?,?,?,?,?,?)");
					ps.setInt(1, LoginPage.orgid);
					ps.setString(2,paygradename.getText().toString());
					ps.setFloat(3, Float.parseFloat(basesalary.getText().toString()));
					ps.setFloat(4, Float.parseFloat(benefits.getText().toString()));
					ps.setFloat(5,Float.parseFloat(taxpercent.getText().toString()));
					ps.setFloat(6, Float.parseFloat(leaveredper.getText().toString()));
					ps.setInt(7, Integer.valueOf(leavespermitted.getText().toString()));
					if(ps.executeUpdate()==1)
					{
						dispose();
						PaygradePage pg = new PaygradePage();
						pg.show();
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnOk.setBounds(120, 576, 97, 25);
		contentPane.add(btnOk);

		JLabel lblDeletePaygrade = new JLabel("Delete Paygrade");
		lblDeletePaygrade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDeletePaygrade.setBounds(445, 231, 108, 16);
		contentPane.add(lblDeletePaygrade);

		paygradeid = new JTextField();
		paygradeid.setBounds(546, 314, 69, 22);
		contentPane.add(paygradeid);
		paygradeid.setColumns(10);

		JButton button = new JButton("OK");
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*try {
					PreparedStatement ps = Database.conn.prepareStatement("select empid from employee where paygradeid=?");
					ps.setInt(1, Integer.valueOf(paygradeid.getText().toString()));
					ResultSet rs = ps.executeQuery();
					if(rs.next()==false)
					{
						PreparedStatement ps2 = Database.conn.prepareStatement("update paygrade set status='deleted' where paygradeid=?");
						ps2.setInt(1, Integer.valueOf(paygradeid.getText().toString()));
						ps2.executeUpdate();
						JOptionPane.showMessageDialog(null, "Paygrade Deleted");
						dispose();
						PaygradePage pg = new PaygradePage();
						pg.show();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Update Paygrade to assign Employees with existing paygrade");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				paygradevalue= Integer.valueOf(paygradeid.getText().toString());
				dispose();
				DeletePaygrade dp=new DeletePaygrade();
				dp.show();
			}
		});
		button.setBounds(456, 369, 97, 25);
		contentPane.add(button);

		JLabel lblEditPaygrade = new JLabel("Edit Paygrade");
		lblEditPaygrade.setForeground(Color.BLACK);
		lblEditPaygrade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEditPaygrade.setBackground(Color.WHITE);
		lblEditPaygrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditPaygrade.setBounds(687, 231, 285, 16);
		contentPane.add(lblEditPaygrade);

		JLabel lblEnterPaygradeId = new JLabel("Enter paygrade id");
		lblEnterPaygradeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterPaygradeId.setBounds(377, 314, 124, 22);
		contentPane.add(lblEnterPaygradeId);

		JCheckBox chckbxPaygradeName = new JCheckBox("Paygrade Name");
		chckbxPaygradeName.setBackground(Color.GRAY);
		chckbxPaygradeName.setForeground(Color.BLACK);
		chckbxPaygradeName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxPaygradeName.setBounds(682, 272, 158, 25);
		contentPane.add(chckbxPaygradeName);

		JCheckBox chckbxBaseSalary = new JCheckBox("Base salary");
		chckbxBaseSalary.setBackground(Color.GRAY);
		chckbxBaseSalary.setForeground(Color.BLACK);
		chckbxBaseSalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxBaseSalary.setBounds(682, 316, 158, 19);
		contentPane.add(chckbxBaseSalary);

		JCheckBox chckbxBenefits = new JCheckBox("Benefits");
		chckbxBenefits.setBackground(Color.GRAY);
		chckbxBenefits.setForeground(Color.BLACK);
		chckbxBenefits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxBenefits.setBounds(682, 348, 113, 25);
		contentPane.add(chckbxBenefits);

		JCheckBox chckbxTaxBenefits = new JCheckBox("Tax Benefits");
		chckbxTaxBenefits.setBackground(Color.GRAY);
		chckbxTaxBenefits.setForeground(Color.BLACK);
		chckbxTaxBenefits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxTaxBenefits.setBounds(682, 390, 113, 25);
		contentPane.add(chckbxTaxBenefits);

		JCheckBox chckbxLeaveReductions = new JCheckBox("Leave Reductions %");
		chckbxLeaveReductions.setBackground(Color.GRAY);
		chckbxLeaveReductions.setForeground(Color.BLACK);
		chckbxLeaveReductions.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxLeaveReductions.setBounds(682, 433, 180, 25);
		contentPane.add(chckbxLeaveReductions);

		JCheckBox chckbxLeavesPermitted = new JCheckBox("Leaves Permitted");
		chckbxLeavesPermitted.setBackground(Color.GRAY);
		chckbxLeavesPermitted.setForeground(Color.BLACK);
		chckbxLeavesPermitted.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxLeavesPermitted.setBounds(682, 474, 158, 25);
		contentPane.add(chckbxLeavesPermitted);

		JButton button_1 = new JButton("OK");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (chckbxPaygradeName.isSelected()) {
						String querynew1 = "paygrade_name=" + "'" + newpaygrade.getText().toString() + "' ";
						if (count == 0)
							querymid = querynew1;
						else
							querymid += "," + querynew1;
						count++;
					}
					if (chckbxBaseSalary.isSelected()) {
						String querynew2 = "base_salary=" + newbasesalary.getText().toString() + " ";
						if (count == 0)
							querymid = querynew2;
						else
							querymid += "," + querynew2;
						count++;
					}
					if (chckbxBenefits.isSelected()) {
						String querynew3 = "benefits=" + newbenefits.getText().toString() + " ";
						if (count == 0)
							querymid = querynew3;
						else
							querymid += "," + querynew3;
						count++;
					}
					if (chckbxTaxBenefits.isSelected()) {
						String querynew4 = "tax_percent=" + newtaxb.getText().toString() + " ";
						if (count == 0)
							querymid = querynew4;
						else
							querymid += "," + querynew4;
						count++;
					}
					if (chckbxLeaveReductions.isSelected()) {
						String querynew5 = "leave_reduction_percent=" + newleaveredper.getText().toString() + " ";
						if (count == 0)
							querymid = querynew5;
						else
							querymid += "," + querynew5;
						count++;
					}
					if (chckbxLeavesPermitted.isSelected()) {
						String querynew6 = "leaves_permitted=" + newleaveper.getText().toString() + " ";
						if (count == 0)
							querymid = querynew6;
						else
							querymid += "," + querynew6;
						count++;
					}
					PreparedStatement ps = Database.conn.prepareStatement(querystart + querymid + queryend);
					count = 0;
					ps.setInt(1, Integer.valueOf(editpgid.getText().toString()));
					ps.executeUpdate();
					// System.out.println(ps);
					dispose();
					PaygradePage pg = new PaygradePage();
					pg.show();
				} catch (Exception e1) {
					System.out.println("Error baba");
				}
			}
		});
		button_1.setBounds(818, 576, 97, 25);
		contentPane.add(button_1);

		newpaygrade = new JTextField();
		newpaygrade.setForeground(Color.BLACK);
		newpaygrade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newpaygrade.setBounds(880, 275, 92, 22);
		contentPane.add(newpaygrade);
		newpaygrade.setColumns(10);

		newbasesalary = new JTextField();
		newbasesalary.setForeground(Color.BLACK);
		newbasesalary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newbasesalary.setBounds(880, 314, 92, 22);
		contentPane.add(newbasesalary);
		newbasesalary.setColumns(10);

		newbenefits = new JTextField();
		newbenefits.setForeground(Color.BLACK);
		newbenefits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newbenefits.setBounds(880, 391, 92, 22);
		contentPane.add(newbenefits);
		newbenefits.setColumns(10);

		newtaxb = new JTextField();
		newtaxb.setForeground(Color.BLACK);
		newtaxb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newtaxb.setBounds(880, 349, 92, 22);
		contentPane.add(newtaxb);
		newtaxb.setColumns(10);

		newleaveredper = new JTextField();
		newleaveredper.setForeground(Color.BLACK);
		newleaveredper.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newleaveredper.setBounds(880, 430, 92, 22);
		contentPane.add(newleaveredper);
		newleaveredper.setColumns(10);

		newleaveper = new JTextField();
		newleaveper.setForeground(Color.BLACK);
		newleaveper.setFont(new Font("Times New Roman", Font.BOLD, 15));
		newleaveper.setBounds(880, 475, 92, 22);
		contentPane.add(newleaveper);
		newleaveper.setColumns(10);

		JLabel lblEnterPaygradeId_1 = new JLabel("Enter Paygrade id");
		lblEnterPaygradeId_1.setForeground(Color.BLACK);
		lblEnterPaygradeId_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterPaygradeId_1.setBounds(687, 516, 130, 16);
		contentPane.add(lblEnterPaygradeId_1);

		editpgid = new JTextField();
		editpgid.setForeground(Color.BLACK);
		editpgid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		editpgid.setBounds(880, 513, 116, 22);
		contentPane.add(editpgid);
		editpgid.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 101, 1037, 107);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		try {
			PreparedStatement ps = Database.conn.prepareStatement("select * from paygrade where orgid=?");
			ps.setInt(1, LoginPage.orgid);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "No Departments");

			e3.printStackTrace();
		}
		
		
		JButton btnShowUpdatedPaygrades = new JButton("Show Updated/Deleted Paygrades");
		btnShowUpdatedPaygrades.setForeground(Color.BLACK);
		btnShowUpdatedPaygrades.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnShowUpdatedPaygrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps;
				try {
					ps = Database.conn.prepareStatement("select * from updated_and_deleted_paygrade where orgid=?");
					ps.setInt(1, LoginPage.orgid);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowUpdatedPaygrades.setBounds(372, 576, 261, 25);
		contentPane.add(btnShowUpdatedPaygrades);
		
		JButton btnHome = new JButton("Back");
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHome.setForeground(Color.BLACK);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdministratorHome ah = new AdministratorHome();
				ah.show();
			}
		});
		btnHome.setBounds(955, 684, 97, 25);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(12, 13, 1064, 47);
		contentPane.add(label);
		
		label.setText(LoginPage.orgname);
	}
}
