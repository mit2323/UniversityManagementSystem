//package UNIVERSITY_MANAGEMENT;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import com.toedter.calendar.JDateChooser;
//import javax.swing.*;
//import java.util.*;
//public class AddStudent extends JFrame implements ActionListener{
//	/**
//	 * 
//	 */
//	JTextField tfname,tffname,tffaddress,tfphone,tfemail,tfx,tfxi,tfadhar;
//	JLabel labelrollno;
//	JDateChooser dcdob;
//	JComboBox cbcourse,cbbranch;
//	JButton submit,cancel;
//	private static final long serialVersionUID = 1L;
//	Random ran=new Random();
//	long first4=Math.abs((ran.nextLong()%9000L)+1000L);
//	AddStudent(){
//		setSize(900,700);
//		setLocation(350,50);
//		setLayout(null);
//		
//		JLabel heading =new JLabel("New Student Detail");
//		heading.setBounds(310,30,500,50);
//		heading.setFont(new Font("serif",Font.BOLD,30));
//		add(heading);
//		
//		JLabel lblname =new JLabel("Name");
//		lblname.setBounds(50,150,100,30);
//		lblname.setFont(new Font("serif",Font.BOLD,30));
//		add(lblname);
//		
//		tfname=new JTextField();
//		tfname.setBounds(200,150,150,30);
//		add(tfname);
//		
//		JLabel lblfname =new JLabel("Father's Name");
//		lblfname.setBounds(400,150,200,30);
//		lblfname.setFont(new Font("serif",Font.BOLD,30));
//		add(lblfname);
//		
//		tffname=new JTextField();
//		tffname.setBounds(600,150,150,30);
//		add(tffname);
//		
//		JLabel lblrollno =new JLabel("Roll Number");
//		lblrollno.setBounds(50,200,200,30);
//		lblrollno.setFont(new Font("serif",Font.BOLD,30));
//		add(lblrollno);
//		
//		labelrollno =new JLabel("4250"+first4);
//		labelrollno.setBounds(250,200,200,30);
//		labelrollno.setFont(new Font("serif",Font.BOLD,30));
//		add(labelrollno);
//		
//		JLabel lbldob =new JLabel("Date of Birth");
//		lbldob.setBounds(400,200,200,30);
//		lbldob.setFont(new Font("serif",Font.BOLD,30));
//		add(lbldob);
//		dcdob = new JDateChooser();
//		dcdob.setBounds(600,200,150,30);
//		add(dcdob);
//		
//		JLabel lbladdress =new JLabel("Address");
//		lbladdress.setBounds(50,250,200,30);
//		lbladdress.setFont(new Font("serif",Font.BOLD,30));
//		add(lbladdress);
//		
//		tffaddress=new JTextField();
//		tffaddress.setBounds(200,250,150,30);
//		add(tffaddress);
//		
//		JLabel lblphone =new JLabel("Phone");
//		lblphone.setBounds(400,250,200,30);
//		lblphone.setFont(new Font("serif",Font.BOLD,30));
//		add(lblphone);
//		
//		tfphone=new JTextField();
//		tfphone.setBounds(600,250,150,30);
//		add(tfphone);
//		
//		JLabel lblemail =new JLabel("Email id");
//		lblemail.setBounds(50,300,200,30);
//		lblemail.setFont(new Font("serif",Font.BOLD,30));
//		add(lblemail);
//		
//		tfemail=new JTextField();
//		tfemail.setBounds(200,300,150,30);
//		add(tfemail);
//		
//		JLabel lblx =new JLabel("Class 10 (%)");
//		lblx.setBounds(400,300,200,30);
//		lblx.setFont(new Font("serif",Font.BOLD,30));
//		add(lblx);
//		
//		tfx=new JTextField();
//		tfx.setBounds(600,300,150,30);
//		add(tfx);
//		
//		JLabel lblxi =new JLabel("Class 12 (%)");
//		lblxi.setBounds(50,350,200,30);
//		lblxi.setFont(new Font("serif",Font.BOLD,30));
//		add(lblxi);
//		
//		tfxi=new JTextField();
//		tfxi.setBounds(200,350,150,30);
//		add(tfxi);
//		
//		JLabel lbladhar =new JLabel("Adhar Number");
//		lbladhar.setBounds(400,350,200,30);
//		lbladhar.setFont(new Font("serif",Font.BOLD,30));
//		add(lbladhar);
//		
//		tfadhar=new JTextField();
//		tfadhar.setBounds(600,350,150,30);
//		add(tfadhar);
//		
//		JLabel lbcourse =new JLabel("Couses");
//		lbcourse.setBounds(50,400,200,30);
//		lbcourse.setFont(new Font("serif",Font.BOLD,30));
//		add(lbcourse);
//		
//		String course[]={"Btech","BBa","BCA","MBA","Bsc","Msc","MCA","Mcom","MA"};
//		cbcourse=new JComboBox(course);
//		cbcourse.setBounds(200,400,150,30);
//		cbcourse.setBackground(Color.white);
//		add(cbcourse);
//		
//		JLabel lblbranch =new JLabel("Branch");
//		lblbranch.setBounds(400,400,200,30);
//		lblbranch.setFont(new Font("serif",Font.BOLD,30));
//		add(lblbranch);
//		
//		String branch[]={"C.S","Civil","Mechanical","Bussiness","Electronics","LAW","Electrical","IT"};
//		cbbranch=new JComboBox(branch);
//		cbbranch.setBounds(550,400,150,30);
//		cbbranch.setBackground(Color.white);
//		add(cbbranch);
//	    
//		submit=new JButton("Submit");
//		submit.setBounds(250,550,120,30);
//		submit.setBackground(Color.black);
//		submit.setForeground(Color.white);
//		submit.addActionListener(this);
//		submit.setFont(new Font("Tahoma",Font.BOLD,15));
//		add(submit);
//		
//		cancel=new JButton("Cancel");
//		cancel.setBounds(450,550,120,30);
//		cancel.setBackground(Color.black);
//		cancel.setForeground(Color.white);
//		cancel.addActionListener(this);
//		cancel.setFont(new Font("Tahoma",Font.BOLD,15));
//		add(cancel);
//		
//		setVisible(true);
//	}
//	public void actionPerformed(ActionEvent ae) {
//		if(ae.getSource()==submit) {
//			String name=tfname.getText();
//			String fname=tffname.getText();
//			String rollno=labelrollno.getText();
//			String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
//			String address=tffaddress.getText();
//			String phone=tfphone.getText();
//			String email=tfemail.getText();
//			String x=tfx.getText();
//			String xi=tfxi.getText();
//			String adhar=tfadhar.getText();
//			String Course=((String)cbcourse.getSelectedItem());
//			String branch =(String) cbbranch.getSelectedItem();
//			try {
//				String query="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xi+"','"+adhar+"','"+Course+"','"+branch+"')";
//			Conn con=new Conn();
//			con.s.executeUpdate(query);
//			JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
//			setVisible(false);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		}
//		else {
//			setVisible(false);
//		}
//	}
//	public static void main(String[] args) {
//		new AddStudent();
//	}
//}
package UNIVERSITY_MANAGEMENT;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    // Color scheme
    private final Color PRIMARY_COLOR = new Color(42, 53, 81);
    private final Color SECONDARY_COLOR = new Color(63, 114, 175);
    private final Color ACCENT_COLOR = new Color(255, 204, 0);
    private final Color BACKGROUND_COLOR = new Color(240, 245, 249);
    private final Color TEXT_COLOR = new Color(60, 60, 60);
    
    JTextField tfname, tffname, tffaddress, tfphone, tfemail, tfx, tfxi, tfadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        setSize(900, 750);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);
        setLayout(null);
        
        // Main heading
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(0, 20, 900, 50);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 32));
        heading.setForeground(PRIMARY_COLOR);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);
        
        // Left panel for personal details
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(50, 100, 380, 550);
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(null);
        leftPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(leftPanel);
        
        // Right panel for academic details
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(470, 100, 380, 550);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(null);
        rightPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(rightPanel);
        
        // Left Panel Components
        addLabelAndField(leftPanel, "Name", 20, 30, tfname = new JTextField(), 150, 30, 150);
        addLabelAndField(leftPanel, "Father's Name", 20, 80, tffname = new JTextField(), 150, 30, 150);
        
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(20, 130, 150, 30);
        lblrollno.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        leftPanel.add(lblrollno);
        
        labelrollno = new JLabel("4250" + first4);
        labelrollno.setBounds(180, 130, 150, 30);
        labelrollno.setFont(new Font("Segoe UI", Font.BOLD, 16));
        leftPanel.add(labelrollno);
        
        addLabelAndField(leftPanel, "Date of Birth", 20, 180, dcdob = new JDateChooser(), 150, 30, 150);
        dcdob.getCalendarButton().setBackground(SECONDARY_COLOR);
        dcdob.getCalendarButton().setForeground(Color.WHITE);
        
        addLabelAndField(leftPanel, "Address", 20, 230, tffaddress = new JTextField(), 150, 30, 150);
        addLabelAndField(leftPanel, "Phone", 20, 280, tfphone = new JTextField(), 150, 30, 150);
        
        // Right Panel Components
        addLabelAndField(rightPanel, "Email ID", 20, 30, tfemail = new JTextField(), 150, 30, 150);
        addLabelAndField(rightPanel, "Class 10 (%)", 20, 80, tfx = new JTextField(), 150, 30, 150);
        addLabelAndField(rightPanel, "Class 12 (%)", 20, 130, tfxi = new JTextField(), 150, 30, 150);
        addLabelAndField(rightPanel, "Aadhar Number", 20, 180, tfadhar = new JTextField(), 150, 30, 150);
        
        // Course ComboBox
        JLabel lbcourse = new JLabel("Course");
        lbcourse.setBounds(20, 230, 150, 30);
        lbcourse.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rightPanel.add(lbcourse);
        
        String course[] = {"B.Tech", "BBA", "BCA", "MBA", "BSc", "MSc", "MCA", "MCom", "MA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(180, 230, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rightPanel.add(cbcourse);
        
        // Branch ComboBox
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(20, 280, 150, 30);
        lblbranch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rightPanel.add(lblbranch);
        
        String branch[] = {"C.S", "Civil", "Mechanical", "Business", "Electronics", "LAW", "Electrical", "IT"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(180, 280, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        cbbranch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rightPanel.add(cbbranch);
        
        // Buttons
        submit = createButton("Submit", 300, 670, 120, 40);
        cancel = createButton("Cancel", 480, 670, 120, 40);
        
        add(submit);
        add(cancel);
        
        setVisible(true);
    }
    
    private void addLabelAndField(JPanel panel, String labelText, int x, int y, JComponent field, int fieldWidth, int fieldHeight, int fieldX) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, 150, 30);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(label);
        
        if (field instanceof JTextField) {
            ((JTextField) field).setBounds(fieldX, y, fieldWidth, fieldHeight);
            field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            panel.add(field);
        } else if (field instanceof JDateChooser) {
            ((JDateChooser) field).setBounds(fieldX, y, fieldWidth, fieldHeight);
            panel.add(field);
        }
    }
    
    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(SECONDARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.addActionListener(this);
        
        // Hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(SECONDARY_COLOR);
            }
        });
        
        return button;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tffaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xi = tfxi.getText();
            String adhar = tfadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            try {
                String query = "INSERT INTO student VALUES('" + name + "','" + fname + "','" + rollno + 
                               "','" + dob + "','" + address + "','" + phone + "','" + email + 
                               "','" + x + "','" + xi + "','" + adhar + "','" + course + "','" + branch + "')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddStudent();
    }
}

