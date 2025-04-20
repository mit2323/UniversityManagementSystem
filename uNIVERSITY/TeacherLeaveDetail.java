package uNIVERSITY;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class TeacherLeaveDetail extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice cempid;
 JTable table;
 JButton search,print,cancel;
 TeacherLeaveDetail(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading=new JLabel("Search by Employee Id");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		cempid=new Choice();
		cempid.setBounds(180,20,150,20);
		add(cempid);
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from teacher");
			while(rs.next()) {
				cempid.add(rs.getString("empid"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		table=new JTable();
		
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from teacherleave");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,100,900,600);
		add(jsp);
		
		search=new JButton("search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		print=new JButton("print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		
		cancel=new JButton("cancel");
		cancel.setBounds(220,70,80,20);
		cancel.addActionListener(this);
		add(cancel);
		
		setSize(900,700);
		setLocation(300,100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==cancel) {
			setVisible(false);
		}
		else if(ae.getSource()==search) {
			String query="select * from teacherleave where empid= '"+cempid.getSelectedItem()+"'";
			try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==print) {
			try {
				table.print();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else {
			setVisible(false);
		}
	}
public static void main(String args[]) {
	new TeacherLeaveDetail();
}
}