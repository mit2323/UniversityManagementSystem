//package UNIVERSITY_MANAGEMENT;
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//import java.awt.event.*;
//import net.proteanit.sql.DbUtils;
//public class StudentDetails extends JFrame implements ActionListener{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	Choice crollno;
// JTable table;
// JButton search,print,update,cancel,add;
//	StudentDetails(){
//		getContentPane().setBackground(Color.white);
//		setLayout(null);
//		
//		JLabel heading=new JLabel("Search by roll nnumber");
//		heading.setBounds(20,20,150,20);
//		add(heading);
//		
//		crollno=new Choice();
//		crollno.setBounds(180,20,150,20);
//		add(crollno);
//		try {
//			Conn c=new Conn();
//			ResultSet rs=c.s.executeQuery("select * from student");
//			while(rs.next()) {
//				crollno.add(rs.getString("rollno"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		table=new JTable();
//		JScrollPane jsp=new JScrollPane(table);
//		jsp.setBounds(0,100,900,600);
//		add(jsp);
//		
//		try {
//			Conn c=new Conn();
//			ResultSet rs=c.s.executeQuery("select * from student");
//			table.setModel(DbUtils.resultSetToTableModel(rs));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		search=new JButton("search");
//		search.setBounds(20,70,80,20);
//		search.addActionListener(this);
//		add(search);
//		
//		print=new JButton("print");
//		print.setBounds(120,70,80,20);
//		print.addActionListener(this);
//		add(print);
//		
//		add=new JButton("add");
//		add.setBounds(220,70,80,20);
//		add.addActionListener(this);
//		add(add);
//		
//		 update=new JButton("Update");
//		update.setBounds(320,70,80,20);
//		update.addActionListener(this);
//		add(update);
//		
//		cancel=new JButton("cancel");
//		cancel.setBounds(420,70,80,20);
//		cancel.addActionListener(this);
//		add(cancel);
//		
//		setSize(900,700);
//		setLocation(300,100);
//		setVisible(true);
//	}
//	public void actionPerformed(ActionEvent ae) {
//		if(ae.getSource()==cancel) {
//			setVisible(false);
//		}
//		else if(ae.getSource()==search) {
//			String query="select * from student where rollno= '"+crollno.getSelectedItem()+"'";
//			try {
//				Conn c=new Conn();
//				ResultSet rs=c.s.executeQuery(query);
//				table.setModel(DbUtils.resultSetToTableModel(rs));
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(ae.getSource()==print) {
//			try {
//				table.print();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(ae.getSource()==add) {
//			setVisible(false);
//			new AddStudent();
//		}
//		else if(ae.getSource()==update) {
//			setVisible(false);
////			new UpdateStudent();			
//		}
//		else {
//			setVisible(false);
//		}
//	}
//public static void main(String args[]) {
//	new StudentDetails();
//}
//}
package uNIVERSITY;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    private final Color PRIMARY_COLOR = new Color(42, 53, 81);
    private final Color SECONDARY_COLOR = new Color(63, 114, 175);
    private final Color BACKGROUND_COLOR = new Color(240, 245, 249);
    private final Color TABLE_HEADER_COLOR = new Color(220, 230, 240);
    
    Choice crollno;
    JTable table;
    JButton search, print, update, cancel, add;

    StudentDetails() {
        setSize(1000, 750);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);
        setLayout(null);
        
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1000, 80);
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setLayout(null);
        add(headerPanel);
        
        JLabel heading = new JLabel("Student Details");
        heading.setBounds(20, 20, 400, 40);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(Color.WHITE);
        headerPanel.add(heading);
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(20, 100, 950, 60);
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        searchPanel.setLayout(null);
        add(searchPanel);
        
        JLabel searchLabel = new JLabel("Search by Roll Number:");
        searchLabel.setBounds(20, 20, 150, 20);
        searchLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchPanel.add(searchLabel);
        
        crollno = new Choice();
        crollno.setBounds(180, 15, 200, 30);
        crollno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchPanel.add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(TABLE_HEADER_COLOR);
        table.setRowHeight(25);
        table.setShowGrid(true);
        table.setGridColor(new Color(220, 220, 220));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(20, 180, 950, 450);
        add(jsp);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(20, 650, 950, 50);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        add(buttonPanel);
        
        search = createButton("Search", SECONDARY_COLOR);
        print = createButton("Print", SECONDARY_COLOR);
        add = createButton("Add New", SECONDARY_COLOR);
        update = createButton("Update", SECONDARY_COLOR);
        cancel = createButton("Cancel", new Color(220, 80, 80));
        
        buttonPanel.add(search);
        buttonPanel.add(print);
        buttonPanel.add(add);
        buttonPanel.add(update);
        buttonPanel.add(cancel);
        
        setVisible(true);
    }
    
    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        button.addActionListener(this);
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == cancel) {
            setVisible(false);
        }
        else if(ae.getSource() == search) {
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == print) {
            try {
                table.print();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        }
        else if(ae.getSource() == update) {
            setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        new StudentDetails();
    }
}
