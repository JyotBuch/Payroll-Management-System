package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class DepartmentsPage extends JFrame {

	private JPanel contentPane;
	private JTextField deptname;
	private JTextField deptid;
	//private JTable table;
	//DefaultTableModel model = new DefaultTableModel(new String[]{"Department ID", "Department Name"}, 0);
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentsPage frame = new DepartmentsPage();
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
	public DepartmentsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Department Name");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(86, 475, 130, 19);
		contentPane.add(lblNewLabel);

		deptname = new JTextField();
		deptname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		deptname.setBounds(247, 473, 130, 25);
		contentPane.add(deptname);
		deptname.setColumns(10);

		JButton btnOk = new JButton("Add");
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					PreparedStatement ps = Database.conn.prepareStatement("insert into department(dept_name,orgid) values (?,?)");
					//System.out.println("Hello 1");
					ps.setString(1, deptname.getText().toString());
					//System.out.println("Hello 2");
					ps.setInt(2, LoginPage.orgid);
					//System.out.println("Hello 3");
					int x=ps.executeUpdate();
					dispose();
					DepartmentsPage dept = new DepartmentsPage();
					dept.show();
					//System.out.println("Hello 4");
					//ps.execute();
					//if(x==1)
						//System.out.print("Done");
					//else
						//System.out.print("Not done");
				}catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnOk.setBounds(172, 511, 90, 19);
		contentPane.add(btnOk);

		JLabel lblDepartmentId = new JLabel("Department ID");
		lblDepartmentId.setForeground(Color.BLACK);
		lblDepartmentId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDepartmentId.setBounds(650, 471, 142, 22);
		contentPane.add(lblDepartmentId);

		deptid = new JTextField();
		deptid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		deptid.setColumns(10);
		deptid.setBounds(804, 470, 136, 25);
		contentPane.add(deptid);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					PreparedStatement ps = Database.conn.prepareStatement("delete from department where deptid=?");
					//System.out.println("Hello 1");
					ps.setInt(1, Integer.valueOf(deptid.getText().toString()));
					//System.out.println("Hello 2");
					//ps.setInt(2, LoginPage.orgid);
					//System.out.println("Hello 3");
					int x=ps.executeUpdate();
					dispose();
					DepartmentsPage dept = new DepartmentsPage();
					dept.show();
					//System.out.println("Hello 4");
					//ps.execute();
					//if(x==1)
						//System.out.print("Done");
					//else
						//System.out.print("Not done");
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(718, 508, 116, 25);
		contentPane.add(btnDelete);
		
		JLabel lblAddDepartment = new JLabel("Add Department");
		lblAddDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDepartment.setForeground(Color.BLACK);
		lblAddDepartment.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddDepartment.setBounds(135, 443, 153, 19);
		contentPane.add(lblAddDepartment);
		
		JLabel lblDeleteDepartment = new JLabel("Delete Department");
		lblDeleteDepartment.setForeground(Color.BLACK);
		lblDeleteDepartment.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDeleteDepartment.setBounds(713, 439, 153, 19);
		contentPane.add(lblDeleteDepartment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 134, 1043, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//table.setModel(model);
		
		try {
			PreparedStatement ps = Database.conn.prepareStatement("select * from department where orgid=?");
			ps.setInt(1, LoginPage.orgid);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnHome = new JButton("Back");
			btnHome.setForeground(Color.BLACK);
			btnHome.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					AdministratorHome ah = new AdministratorHome();
					ah.show();
				}
			});
			btnHome.setBounds(925, 663, 142, 33);
			contentPane.add(btnHome);
			
		}
		catch(Exception e3)
		{
			JOptionPane.showMessageDialog(null, "No Departments");

			e3.printStackTrace();
		}
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(12, 13, 1064, 47);
		contentPane.add(label);
		
		label.setText(LoginPage.orgname);
		
	}
}
