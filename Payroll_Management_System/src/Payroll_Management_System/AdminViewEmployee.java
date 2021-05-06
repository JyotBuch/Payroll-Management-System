package Payroll_Management_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class AdminViewEmployee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField city;
	private JTextField jobtitle;
	private JTextField pgname;
	private JTextField sfrom;
	private JTextField sto;
	private JTextField empid;
	public static String querystart = "select * from employee natural join paygrade where orgid=? and ";
	public static String queryend = ";";
	public static String querymid = "";
	public static int count = 0;
	private JTextField editpgid;
	public static String querynew = "";
	public static String curremp;
	private JTextField x;
	//public static int er;
	public static Integer enteredempid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViewEmployee frame = new AdminViewEmployee();
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
	public AdminViewEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel edit = new JLabel("");
		edit.setBounds(616, 280, 135, 16);
		contentPane.add(edit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int i= table.getSelectedRow();
				TableModel model= table.getModel();
				edit.setText(model.getValueAt(i, 3).toString());
				JOptionPane.showMessageDialog(null, "You selected Employee ID: "+model.getValueAt(i, 3).toString());
			}
		});
		scrollPane.setBounds(12, 366, 1055, 301);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		name = new JTextField();
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Times New Roman", Font.BOLD, 15));
		name.setBounds(193, 77, 116, 22);
		contentPane.add(name);
		name.setColumns(10);

		city = new JTextField();
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Times New Roman", Font.BOLD, 15));
		city.setBounds(193, 147, 116, 22);
		contentPane.add(city);
		city.setColumns(10);

		jobtitle = new JTextField();
		jobtitle.setForeground(Color.BLACK);
		jobtitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jobtitle.setBounds(193, 222, 116, 22);
		contentPane.add(jobtitle);
		jobtitle.setColumns(10);

		pgname = new JTextField();
		pgname.setForeground(Color.BLACK);
		pgname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pgname.setBounds(193, 112, 116, 22);
		contentPane.add(pgname);
		pgname.setColumns(10);

		sfrom = new JTextField();
		sfrom.setForeground(Color.BLACK);
		sfrom.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sfrom.setBounds(193, 187, 116, 22);
		contentPane.add(sfrom);
		sfrom.setColumns(10);

		sto = new JTextField();
		sto.setForeground(Color.BLACK);
		sto.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sto.setBounds(337, 187, 116, 22);
		contentPane.add(sto);
		sto.setColumns(10);

		empid = new JTextField();
		empid.setForeground(Color.BLACK);
		empid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		empid.setBounds(193, 268, 131, 22);
		contentPane.add(empid);
		empid.setColumns(10);

		JLabel label_1 = new JLabel("-");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setBounds(321, 190, 14, 16);
		contentPane.add(label_1);

		JCheckBox chckbxName = new JCheckBox("Name");
		chckbxName.setBackground(Color.GRAY);
		chckbxName.setForeground(Color.BLACK);
		chckbxName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxName.setBounds(48, 76, 113, 25);
		contentPane.add(chckbxName);

		JCheckBox chckbxCity = new JCheckBox("City");
		chckbxCity.setBackground(Color.GRAY);
		chckbxCity.setForeground(Color.BLACK);
		chckbxCity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxCity.setBounds(48, 146, 69, 25);
		contentPane.add(chckbxCity);

		JCheckBox chckbxJobTitle = new JCheckBox("Job Title");
		chckbxJobTitle.setBackground(Color.GRAY);
		chckbxJobTitle.setForeground(Color.BLACK);
		chckbxJobTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxJobTitle.setBounds(49, 228, 101, 25);
		contentPane.add(chckbxJobTitle);

		JCheckBox chckbxPaygradeName = new JCheckBox("Paygrade Name");
		chckbxPaygradeName.setBackground(Color.GRAY);
		chckbxPaygradeName.setForeground(Color.BLACK);
		chckbxPaygradeName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxPaygradeName.setBounds(48, 108, 131, 25);
		contentPane.add(chckbxPaygradeName);

		JCheckBox chckbxSalaryRange = new JCheckBox("Salary Range");
		chckbxSalaryRange.setBackground(Color.GRAY);
		chckbxSalaryRange.setForeground(Color.BLACK);
		chckbxSalaryRange.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxSalaryRange.setBounds(49, 186, 113, 25);
		contentPane.add(chckbxSalaryRange);

		JCheckBox chckbxEmployeeId = new JCheckBox("Employee ID");
		chckbxEmployeeId.setBackground(Color.GRAY);
		chckbxEmployeeId.setForeground(Color.BLACK);
		chckbxEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxEmployeeId.setBounds(49, 267, 136, 25);
		contentPane.add(chckbxEmployeeId);


		try {
			PreparedStatement ps2 = Database.conn.prepareStatement("select * from employee natural join paygrade where orgid=?;");
			ps2.setInt(1, LoginPage.orgid);
			ResultSet rs2=ps2.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton btnFind = new JButton("Find");
		btnFind.setForeground(Color.BLACK);
		btnFind.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (chckbxName.isSelected()) {
						String querynew1 = "concat(f_name,m_name,l_name) like" + "'%" + name.getText().toString() + "%' ";
						if (count == 0)
							querymid = querynew1;
						else
							querymid += "and" + querynew1;
						count++;
					}
					if (chckbxCity.isSelected()) {
						String querynew2 = "city=" + "'" + city.getText().toString() + "'" + " ";
						if (count == 0)
							querymid = querynew2;
						else
							querymid += " and " + querynew2;
						count++;
					}
					if (chckbxJobTitle.isSelected()) {
						String querynew3 = "jobtitle=" + "'" + jobtitle.getText().toString() + "'" + " ";
						if (count == 0)
							querymid = querynew3;
						else
							querymid += " and " + querynew3;
						count++;
					}
					if (chckbxPaygradeName.isSelected()) {
						String querynew4 = "paygradeid=" + pgname.getText().toString() + " ";
						if (count == 0)
							querymid = querynew4;
						else
							querymid += " and " + querynew4;
						count++;
					}
					if (chckbxSalaryRange.isSelected()) {
						String querynew5 = "base_salary between " + sfrom.getText().toString() + " and "+ sto.getText().toString();
						if (count == 0)
							querymid = querynew5;
						else
							querymid += " and " + querynew5;
						count++;
					}
					if (chckbxEmployeeId.isSelected()) {
						String querynew6 = "empid=" + empid.getText().toString() + " ";
						if (count == 0)
							querymid = querynew6;
						else
							querymid += " and " + querynew6;
						count++;
					}

					if(!chckbxName.isSelected() && !chckbxCity.isSelected() && !chckbxName.isSelected() && !chckbxJobTitle.isSelected() && !chckbxPaygradeName.isSelected() && !chckbxSalaryRange.isSelected() && !chckbxEmployeeId.isSelected())
					{
						PreparedStatement ps = Database.conn.prepareStatement("select * from employee natural join paygrade where orgid=?");
						ps.setInt(1 ,LoginPage.orgid);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}

					else{
						PreparedStatement ps = Database.conn.prepareStatement(querystart + querymid + queryend);
						count = 0;
						//System.out.println(ps);
						//ps.setInt(1, Integer.valueOf(editpgid.getText().toString()));
						ps.setInt(1 ,LoginPage.orgid);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));}

					// System.out.println(ps);
					/*dispose();
					AdminViewEmployee pg = new AdminViewEmployee();
					pg.show();*/
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		btnFind.setBounds(149, 305, 97, 25);
		contentPane.add(btnFind);



		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredempid=Integer.valueOf(x.getText().toString());
				dispose();
				AdminEditEmployee a= new AdminEditEmployee();
				a.show();
			}
		});
		btnEdit.setBounds(659, 111, 97, 25);
		contentPane.add(btnEdit);

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
		btnHome.setBounds(970, 684, 97, 25);
		contentPane.add(btnHome);

		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID");
		lblEnterEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterEmployeeId.setBounds(659, 80, 135, 19);
		contentPane.add(lblEnterEmployeeId);

		x = new JTextField();
		x.setForeground(Color.BLACK);
		x.setFont(new Font("Times New Roman", Font.BOLD, 15));
		x.setBounds(821, 77, 116, 22);
		contentPane.add(x);
		x.setColumns(10);

		JButton btnViewSalaryHistory = new JButton("View Salary History");
		btnViewSalaryHistory.setForeground(Color.BLACK);
		btnViewSalaryHistory.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewSalaryHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredempid=Integer.valueOf(x.getText().toString());
				dispose();
				SalaryHistory sh = new SalaryHistory();
				sh.show();
			}
		});
		btnViewSalaryHistory.setBounds(659, 181, 164, 25);
		contentPane.add(btnViewSalaryHistory);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps = Database.conn.prepareStatement("delete from employee where empid=?");
					ps.setInt(1, Integer.valueOf(x.getText().toString()));
					ps.executeUpdate();
					dispose();
					AdminViewEmployee p = new AdminViewEmployee();
					p.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnDelete.setBounds(659, 146, 101, 25);
		contentPane.add(btnDelete);

		JButton btnViewDependenets = new JButton("View Dependents");
		btnViewDependenets.setForeground(Color.BLACK);
		btnViewDependenets.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewDependenets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredempid=Integer.valueOf(x.getText().toString());
				dispose();
				ViewDependents a = new ViewDependents();
				a.show();
			}
		});
		btnViewDependenets.setBounds(659, 221, 175, 25);
		contentPane.add(btnViewDependenets);

		JButton btnViewAccounts = new JButton("View Accounts");
		btnViewAccounts.setForeground(Color.BLACK);
		btnViewAccounts.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredempid=Integer.valueOf(x.getText().toString());
				dispose();
				ViewAccounts v = new ViewAccounts();
				v.show();
			}
		});
		btnViewAccounts.setBounds(659, 259, 146, 25);
		contentPane.add(btnViewAccounts);
		
		JLabel label = new JLabel((String) null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(3, 0, 1064, 47);
		contentPane.add(label);
		label.setText(LoginPage.orgname);
	}
}
