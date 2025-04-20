//package uNIVERSITY;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.event.*;
//import java.awt.Image;
//
//import javax.swing.*;
//
//public class Project extends JFrame implements ActionListener{
///**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//Project(){
//	setSize(1540,850);
//	ImageIcon i1=new ImageIcon(getClass().getResource("/images/8777536.jpg"));
//	Image i2 =i1.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
//	ImageIcon i3=new ImageIcon(i2);
//	JLabel image=new JLabel(i3);
//	add(image);
//	JMenuBar mb= new JMenuBar();
//	mb.setBackground(Color.GRAY);
//	mb.setPreferredSize(new Dimension(1540, 35));
//	JMenu newInformation=new JMenu("New Information");
//	newInformation.setForeground(Color.white);
//	mb.add(newInformation);
//	setJMenuBar(mb);
//	JMenuItem facultyinfo=new JMenuItem("New Faculty Information");
//	facultyinfo.setBackground(Color.white);
//	facultyinfo.addActionListener(this);
//	newInformation.add(facultyinfo);
//	JMenuItem studentinfo=new JMenuItem("New Student Information");
//	studentinfo.setBackground(Color.white);
//	studentinfo.addActionListener(this);
// newInformation.add(studentinfo);
// //Details
// JMenu details=new JMenu("View Details");
//	details.setForeground(Color.red);
//	mb.add(details);
//	
//	
//	JMenuItem facultydetails=new JMenuItem("view Faculty Details");
//	facultydetails.setBackground(Color.white);
//	facultydetails.addActionListener(this);
//	details.add(facultydetails);
//	
//	JMenuItem studentdetails=new JMenuItem("view Student Details");
//	studentdetails.setBackground(Color.white);
//	studentdetails.addActionListener(this);
//details.add(studentdetails);
//setJMenuBar(mb);
//JMenu leave=new JMenu("Apply Leave");
//	leave.setForeground(Color.green);
//	mb.add(leave);
//	
//	
//	JMenuItem facultyleave=new JMenuItem("Faculty Leave");
//	facultyleave.setBackground(Color.white);
//	facultyleave.addActionListener(this);
//	leave.add(facultyleave);
//	
//	JMenuItem studentleave=new JMenuItem("Student Leave");
//	studentleave.setBackground(Color.white);
//	studentleave.addActionListener(this);
//leave.add(studentleave);
//setJMenuBar(mb);
//
//JMenu leavedetails=new JMenu("Leave Details");
//leavedetails.setForeground(Color.green);
//mb.add(leavedetails);
//
//
//JMenuItem facultyleavedetails=new JMenuItem("Faculty Leave details");
//facultyleavedetails.setBackground(Color.white);
//facultyleavedetails.addActionListener(this);
//leavedetails.add(facultyleavedetails);
//
//JMenuItem studentleavedetails=new JMenuItem("Student Leave details");
//studentleavedetails.setBackground(Color.white);
//studentleavedetails.addActionListener(this);
//leavedetails.add(studentleavedetails);
//
//setJMenuBar(mb);
//
//JMenu Exam=new JMenu("Exam Details");
//Exam.setForeground(Color.blue);
//mb.add(Exam);
//
//
//JMenuItem Examdetails=new JMenuItem("Exam Results");
//Examdetails.setBackground(Color.white);
//Examdetails.addActionListener(this);
//Exam.add(Examdetails);
//
//JMenuItem entermarks=new JMenuItem("Enter Marks");
//entermarks.setBackground(Color.white);
//entermarks.addActionListener(this);
//Exam.add(entermarks);
//
//JMenu UpdateInfo=new JMenu("Update Details");
//UpdateInfo.setForeground(Color.red);
//mb.add(UpdateInfo);
//
//
//JMenuItem UpdateFacultyInfo=new JMenuItem("Update Faculty Details");
//UpdateFacultyInfo.setBackground(Color.white);
//UpdateInfo.add(UpdateFacultyInfo);
//
//JMenuItem UpdateStudentInfo=new JMenuItem("Update Student Details");
//UpdateStudentInfo.setBackground(Color.white);
//UpdateInfo.add(UpdateStudentInfo);
//
//JMenu fees=new JMenu("Fees Details");
//fees.setForeground(Color.red);
//mb.add(fees);
//
//
//JMenuItem feestructure=new JMenuItem("Fees Structure");
//feestructure.setBackground(Color.white);
//feestructure.addActionListener(this);
//fees.add(feestructure);
//
//JMenuItem feeform=new JMenuItem("Fees Form");
//feeform.setBackground(Color.white);
//feeform.addActionListener(this);
//fees.add(feeform);
//
//setJMenuBar(mb);
//
//JMenu Utility=new JMenu("Utility");
//Utility.setForeground(Color.red);
//mb.add(Utility);
//
//
//JMenuItem notepad=new JMenuItem("Notepad");
//notepad.setBackground(Color.white);
//notepad.addActionListener(this);
//Utility.add(notepad);
//
//JMenuItem calc=new JMenuItem("Calculator");
//feeform.setBackground(Color.white);
//calc.addActionListener(this);
//Utility.add(calc);
//
//setJMenuBar(mb);
//
//JMenu exit=new JMenu("Exit");
//exit.setForeground(Color.blue);
//mb.add(exit);
//
//
//JMenuItem Ex=new JMenuItem("Exit");
//Ex.setBackground(Color.white);
//Ex.addActionListener(this);
//exit.add(Ex);
//
//JMenu Attendance=new JMenu("Attendance");
//Attendance.setForeground(Color.red);
//mb.add(Attendance);
//
//JMenuItem MArk=new JMenuItem("MArk");
//MArk.setBackground(Color.white);
//MArk.addActionListener(this);
//Attendance.add(MArk);
//
//setJMenuBar(mb);
//	setVisible(true);
//}
//public void actionPerformed(ActionEvent ae) {
//	String msg=ae.getActionCommand();
//	if(msg.equals("Exit")) {
//		setVisible(false);
//	}
//	else if(msg.equals("Calculator")) {
//		try {
//		Runtime.getRuntime().exec("calc.exe");
//		}
//		catch(Exception e) {
//			
//		}
//	}
//	else if(msg.equals("New Faculty Information")) {
//		new AddTeacher();
//	}
//	else if(msg.equals("New Student Information")) {
//		new AddStudent();
//	}
//	else if(msg.equals("view Faculty Details")) {
//		new TeachersDetail();
//	}
//	else if(msg.equals("view Student Details")) {
//		new StudentDetails();
//	}
//	else if(msg.equals("Faculty Leave")) {
//		new Teacherleave();
//	}
//	else if(msg.equals("Student Leave")) {
//		new Teacherleave();
//	}
//	else if(msg.equals("Faculty Leave details")) {
//		new TeacherLeaveDetail();
//	}
//	else if(msg.equals("Student Leave details")) {
//		new StudentLeaveDetail();
//	}
//	else if(msg.equals("Mark")) {
//		new AttendanceManager();
//	}
//	else if(msg.equals("Enter Marks")) {
//		new EnterMarks();
//	}
//	else if(msg.equals("Exam Results")) {
//		new Marks("");
//	}
//	else if(msg.equals("Fees Form")) {
//		new StudentFeeForm();
//	}
//	else if(msg.equals("Fees Structure")) {
//		new FeeStructure();
//	}
//}

//public static void main(String[] args) {
//	new Project();
//}
//
//}
package uNIVERSITY;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    Project() {
        setSize(1540, 850);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/8777536.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        mb.setBackground(Color.GRAY); 
        mb.setPreferredSize(new Dimension(1540, 35));

        Font menuFont = new Font("Arial", Font.BOLD, 16);

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.WHITE);
        newInformation.setFont(menuFont);
        mb.add(newInformation);

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.WHITE);
        details.setFont(menuFont);
        mb.add(details);

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.WHITE);
        leave.setFont(menuFont);
        mb.add(leave);

        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.WHITE);
        leavedetails.setFont(menuFont);
        mb.add(leavedetails);

        JMenu Exam = new JMenu("Exam Details");
        Exam.setForeground(Color.WHITE);
        Exam.setFont(menuFont);
        mb.add(Exam);

        JMenu UpdateInfo = new JMenu("Update Details");
        UpdateInfo.setForeground(Color.WHITE);
        UpdateInfo.setFont(menuFont);
        mb.add(UpdateInfo);

        JMenu fees = new JMenu("Fees Details");
        fees.setForeground(Color.WHITE);
        fees.setFont(menuFont);
        mb.add(fees);

        JMenu Utility = new JMenu("Utility");
        Utility.setForeground(Color.WHITE);
        Utility.setFont(menuFont);
        mb.add(Utility);

        JMenu Attendance = new JMenu("Attendance");
        Attendance.setForeground(Color.WHITE);
        Attendance.setFont(menuFont);
        mb.add(Attendance);
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.WHITE);
        exit.setFont(menuFont);
        mb.add(exit);

        // Menu Items with Background & Text Color
        addMenuItem(newInformation, "New Faculty Information");
        addMenuItem(newInformation, "New Student Information");

        addMenuItem(details, "View Faculty Details");
        addMenuItem(details, "View Student Details");

        addMenuItem(leave, "Faculty Leave");
        addMenuItem(leave, "Student Leave");

        addMenuItem(leavedetails, "Faculty Leave Details");
        addMenuItem(leavedetails, "Student Leave Details");

        addMenuItem(Exam, "Exam Results");
        addMenuItem(Exam, "Enter Marks");

        addMenuItem(UpdateInfo, "Update Faculty Details");
        addMenuItem(UpdateInfo, "Update Student Details");

        addMenuItem(fees, "Fees Structure");
        addMenuItem(fees, "Fees Form");

        addMenuItem(Utility, "Notepad");
        addMenuItem(Utility, "Calculator");

        addMenuItem(Attendance, "Mark Attendance");

        // Exit menu item
        JMenuItem Ex = new JMenuItem("Exit");
        Ex.setFont(menuFont);
        Ex.setBackground(Color.LIGHT_GRAY);
        Ex.setForeground(Color.BLACK);
        Ex.addActionListener(this);
        exit.add(Ex);

        setJMenuBar(mb);
        setVisible(true);
    }

    private void addMenuItem(JMenu menu, String itemName) {
        JMenuItem item = new JMenuItem(itemName);
        item.setFont(new Font("Arial", Font.BOLD, 16));
        item.setBackground(Color.LIGHT_GRAY);
        item.setForeground(Color.BLACK);
        item.addActionListener(this);
        menu.add(item);
    }


    public void actionPerformed(ActionEvent ae) {
    	String msg=ae.getActionCommand();
    	if(msg.equals("Exit")) {
    		setVisible(false);
    	}
    	else if(msg.equals("Calculator")) {
    		try {
    		Runtime.getRuntime().exec("calc.exe");
    		}
    		catch(Exception e) {
    			
    		}
    	}
    	else if(msg.equals("New Faculty Information")) {
    		new AddTeacher();
    	}
    	else if(msg.equals("New Student Information")) {
    		new AddStudent();
    	}
    	else if(msg.equals("View Faculty Details")) {
    		new TeachersDetail();
    	}
    	else if(msg.equals("View Student Details")) {
    		new StudentDetails();
    	}
    	else if(msg.equals("Faculty Leave")) {
    		new Teacherleave();
    	}
    	else if(msg.equals("Student Leave")) {
    		new Teacherleave();
    	}
    	else if(msg.equals("Faculty Leave Details")) {
    		new TeacherLeaveDetail();
    	}
    	else if(msg.equals("Student Leave Details")) {
    		new StudentLeaveDetail();
    	}
    	else if(msg.equals("Mark Attendance")) {
    		new AttendanceManager();
    	}
    	else if(msg.equals("Enter Marks")) {
    		new EnterMarks();
    	}
    	else if(msg.equals("Exam Results")) {
    		new ExaminationDetails();
    	}
    	else if(msg.equals("Fees Form")) {
    		new StudentFeeForm();
    	}
    	else if(msg.equals("Fees Structure")) {
    		new FeeStructure();
    	}
    	else if(msg.equals("Update Student Details")) {
    		new UpdateStudent();
    	}
    	else if(msg.equals("Update Faculty Details")) {
    		new UpdateTeacher();
    	}
    }


    public static void main(String[] args) {
        new Project();
    }
}

