package uNIVERSITY;


import java.awt.Color;
import java.awt.event.*;
import java.awt.Image;

import javax.swing.*;

public class Demo extends JFrame implements ActionListener{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Demo(){
        setSize(1540,850);
        ImageIcon i1=new ImageIcon(getClass().getResource("/images/8777536.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        // Create a color scheme that works well with grey background
        Color menuBarColor = new Color(60, 60, 60); // Dark grey
        Color menuTextColor = Color.WHITE;
        Color menuItemColor = new Color(80, 80, 80); // Slightly lighter grey
        Color menuItemTextColor = Color.WHITE;
        Color highlightColor = new Color(100, 100, 100); // For hover effects
        
        JMenuBar mb= new JMenuBar();
        mb.setBackground(menuBarColor);
        mb.setBorder(BorderFactory.createEmptyBorder());
        
        JMenu newInformation=new JMenu("New Information");
        newInformation.setForeground(menuTextColor);
        mb.add(newInformation);
        
        JMenuItem facultyinfo=new JMenuItem("New Faculty Information");
        facultyinfo.setBackground(menuItemColor);
        facultyinfo.setForeground(menuItemTextColor);
        facultyinfo.addActionListener(this);
        newInformation.add(facultyinfo);
        
        JMenuItem studentinfo=new JMenuItem("New Student Information");
        studentinfo.setBackground(menuItemColor);
        studentinfo.setForeground(menuItemTextColor);
        studentinfo.addActionListener(this);
        newInformation.add(studentinfo);
        
        //Details
        JMenu details=new JMenu("View Details");
        details.setForeground(menuTextColor);
        mb.add(details);
        
        JMenuItem facultydetails=new JMenuItem("view Faculty Details");
        facultydetails.setBackground(menuItemColor);
        facultydetails.setForeground(menuItemTextColor);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdetails=new JMenuItem("view Student Details");
        studentdetails.setBackground(menuItemColor);
        studentdetails.setForeground(menuItemTextColor);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(menuTextColor);
        mb.add(leave);
        
        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.setBackground(menuItemColor);
        facultyleave.setForeground(menuItemTextColor);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave=new JMenuItem("Student Leave");
        studentleave.setBackground(menuItemColor);
        studentleave.setForeground(menuItemTextColor);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        JMenu leavedetails=new JMenu("Leave Details");
        leavedetails.setForeground(menuTextColor);
        mb.add(leavedetails);
        
        JMenuItem facultyleavedetails=new JMenuItem("Faculty Leave details");
        facultyleavedetails.setBackground(menuItemColor);
        facultyleavedetails.setForeground(menuItemTextColor);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails=new JMenuItem("Student Leave details");
        studentleavedetails.setBackground(menuItemColor);
        studentleavedetails.setForeground(menuItemTextColor);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);
        
        JMenu Exam=new JMenu("Exam Details");
        Exam.setForeground(menuTextColor);
        mb.add(Exam);
        
        JMenuItem Examdetails=new JMenuItem("Exam Results");
        Examdetails.setBackground(menuItemColor);
        Examdetails.setForeground(menuItemTextColor);
        Exam.add(Examdetails);
        
        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.setBackground(menuItemColor);
        entermarks.setForeground(menuItemTextColor);
        Exam.add(entermarks);
        
        JMenu UpdateInfo=new JMenu("Update Details");
        UpdateInfo.setForeground(menuTextColor);
        mb.add(UpdateInfo);
        
        JMenuItem UpdateFacultyInfo=new JMenuItem("Update Faculty Details");
        UpdateFacultyInfo.setBackground(menuItemColor);
        UpdateFacultyInfo.setForeground(menuItemTextColor);
        UpdateInfo.add(UpdateFacultyInfo);
        
        JMenuItem UpdateStudentInfo=new JMenuItem("Update Student Details");
        UpdateStudentInfo.setBackground(menuItemColor);
        UpdateStudentInfo.setForeground(menuItemTextColor);
        UpdateInfo.add(UpdateStudentInfo);
        
        JMenu fees=new JMenu("Fees Details");
        fees.setForeground(menuTextColor);
        mb.add(fees);
        
        JMenuItem feestructure=new JMenuItem("Fees Structure");
        feestructure.setBackground(menuItemColor);
        feestructure.setForeground(menuItemTextColor);
        fees.add(feestructure);
        
        JMenuItem feeform=new JMenuItem("Fees Form");
        feeform.setBackground(menuItemColor);
        feeform.setForeground(menuItemTextColor);
        fees.add(feeform);
        
        JMenu Utility=new JMenu("Utility");
        Utility.setForeground(menuTextColor);
        mb.add(Utility);
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(menuItemColor);
        notepad.setForeground(menuItemTextColor);
        notepad.addActionListener(this);
        Utility.add(notepad);
        
        JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(menuItemColor);
        calc.setForeground(menuItemTextColor);
        calc.addActionListener(this);
        Utility.add(calc);
        
        JMenu exit=new JMenu("Exit");
        exit.setForeground(menuTextColor);
        mb.add(exit);
        
        JMenuItem Ex=new JMenuItem("Exit");
        Ex.setBackground(menuItemColor);
        Ex.setForeground(menuItemTextColor);
        Ex.addActionListener(this);
        exit.add(Ex);
        
        JMenu Attendance=new JMenu("Attendance");
        Attendance.setForeground(menuTextColor);
        mb.add(Attendance);
        
        JMenuItem MArk=new JMenuItem("MArk");
        MArk.setBackground(menuItemColor);
        MArk.setForeground(menuItemTextColor);
        MArk.addActionListener(this);
        Attendance.add(MArk);
        
        setJMenuBar(mb);
        setVisible(true);
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
        else if(msg.equals("view Faculty Details")) {
            new TeachersDetail();
        }
        else if(msg.equals("view Student Details")) {
            new StudentDetails();
        }
        else if(msg.equals("Faculty Leave")) {
            new Teacherleave();
        }
        else if(msg.equals("Student Leave")) {
            new Teacherleave();
        }
        else if(msg.equals("Faculty Leave details")) {
            new TeacherLeaveDetail();
        }
        else if(msg.equals("Student Leave details")) {
            new StudentLeaveDetail();
        }
        else if(msg.equals("MArk")) {
            new AttendanceManager();
        }
    }
    
    public static void main(String[] args) {
        new Demo();
    }
}