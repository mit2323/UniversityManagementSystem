//package UNIVERSITY_MANAGEMENT;
//import java.awt.*;
//
//import java.sql.ResultSet;
//import java.sql.*;
//import javax.swing.*;
//import java.awt.event.*;
//import com.toedter.calendar.JDateChooser;
//
//
//public class Teacherleave extends JFrame implements ActionListener{
///**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	Choice cempid,ctime;
//	JDateChooser dcdate;
//	JButton submit,cancel;
//Teacherleave(){
//	setSize(500,550);
//	setLocation(550,100);
//	getContentPane().setBackground(Color.WHITE);
//	setVisible(true);
//	
//	JLabel heading=new JLabel("Apply Leave (Teacher)");
//	setLayout(null);
//	heading.setBounds(40,50,300,30);
//	heading.setFont(new Font("Tahoma",Font.BOLD,20));
//	add(heading);
//	
//
//	JLabel lblempid=new JLabel("Search by Employee Id");
//	
//	lblempid.setBounds(60,100,250,20);
//	lblempid.setFont(new Font("Tahoma",Font.PLAIN,20));
//	add(lblempid);
//	
//	cempid=new Choice();
//	cempid.setBounds(60,130,220,20);
//	add(cempid);
//	try {
//		Conn c=new Conn();
//		ResultSet rs=c.s.executeQuery("select * from teacher");
//		while(rs.next()) {
//			cempid.add(rs.getString("empid"));
//		}
//	}catch(Exception e) {
//		e.printStackTrace();
//	}
//	JLabel lbldate=new JLabel("Date");
//	lbldate.setBounds(60,180,250,20);
//	lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
//	add(lbldate);
//	
//	dcdate = new JDateChooser();
//	dcdate.setBounds(60,210,200,25);
//	add(dcdate);
//	
//	JLabel lbltime=new JLabel("Time Duration");
//	lbltime.setBounds(60,260,200,20);
//	lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
//	add(lbltime);
//	
//	ctime=new Choice();
//	ctime.setBounds(60,290,200,20);
//	ctime.add("Full Day");
//	ctime.add("Half Day");
//	add(ctime);
//	
//	submit=new JButton("Submit");
//	submit.setBounds(60,350,100,25);
//	submit.setBackground(Color.black);
//	submit.setForeground(Color.white);
//	submit.addActionListener(this);
//	submit.setFont(new Font("Tahoma",Font.BOLD,15));
//	add(submit);
//	
//	cancel=new JButton("Cancel");
//	cancel.setBounds(200,350,100,25);
//	cancel.setBackground(Color.black);
//	cancel.setForeground(Color.white);
//	cancel.addActionListener(this);
//	cancel.setFont(new Font("Tahoma",Font.BOLD,15));
//	add(cancel);
//	
//	setVisible(true);
//}
//public void actionPerformed(ActionEvent ae) {
//	if(ae.getSource()==submit) {
//		String empid=cempid.getSelectedItem();
//		String date=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
//		String duration=ctime.getSelectedItem();
//		String query="insert into Teacherleave values('"+empid+"','"+date+"','"+duration+"')";
//		
//		try {
//			Conn c=new Conn();
//			c.s.executeUpdate(query);
//			JOptionPane.showMessageDialog(null, "Leave Confirmed");
//			setVisible(false);
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	else if(ae.getSource()==cancel) {
//		setVisible(false);
//	}
//}
//	public static void main(String[] args) {
//		new Teacherleave();
//	}
//	
//}
package uNIVERSITY;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Teacherleave extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    private final Color PRIMARY_COLOR = new Color(42, 53, 81);
    private final Color SECONDARY_COLOR = new Color(63, 114, 175);
    private final Color BACKGROUND_COLOR = new Color(230, 240, 250); // Lighter blue background
    private final Color PANEL_COLOR = new Color(255, 255, 255);
    
    Choice cempid, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;

    Teacherleave() {
        setSize(600, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);
        setLayout(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(50, 50, 500, 480);
        mainPanel.setBackground(PANEL_COLOR);
        mainPanel.setLayout(null);
        mainPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(mainPanel);
        
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(0, 30, 500, 40);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setForeground(PRIMARY_COLOR);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(heading);
        
        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(50, 100, 400, 25);
        lblempid.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        mainPanel.add(lblempid);
        
        cempid = new Choice();
        cempid.setBounds(50, 130, 400, 30);
        cempid.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mainPanel.add(cempid);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cempid.add(rs.getString("empid"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Leave Date");
        lbldate.setBounds(50, 180, 400, 25);
        lbldate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        mainPanel.add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(50, 210, 400, 30);
        dcdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dcdate.getCalendarButton().setBackground(SECONDARY_COLOR);
        dcdate.getCalendarButton().setForeground(Color.WHITE);
        mainPanel.add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(50, 260, 400, 25);
        lbltime.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        mainPanel.add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(50, 290, 400, 30);
        ctime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        ctime.add("Full Day");
        ctime.add("Half Day");
        mainPanel.add(ctime);
        
        // Button panel for centered alignment
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(50, 350, 400, 60);
        buttonPanel.setBackground(PANEL_COLOR);
        buttonPanel.setLayout(new GridLayout(1, 2, 30, 0));
        mainPanel.add(buttonPanel);
        
        submit = createButton("Submit", SECONDARY_COLOR);
        buttonPanel.add(submit);
        
        cancel = createButton("Cancel", new Color(220, 80, 80));
        buttonPanel.add(cancel);
        
        setVisible(true);
    }
    
    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
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
        if(ae.getSource() == submit) {
            String empid = cempid.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String query = "insert into Teacherleave values('"+empid+"','"+date+"','"+duration+"')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if(ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Teacherleave();
    }
}