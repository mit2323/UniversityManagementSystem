package uNIVERSITY;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox<String> cbcourse, cbbranch, cbsemester;
    JLabel labeltotal;
    JButton update, pay, back;

    StudentFeeForm() {
        setTitle("Student Fee Payment");
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);

        getContentPane().setBackground(new Color(245, 248, 255)); // Soft pastel background

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font valueFont = new Font("Segoe UI", Font.PLAIN, 15);

        JLabel lblrollnumber = createStyledLabel("Select Roll No", 40, 60, labelFont, new Color(52, 73, 94));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 25);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = createStyledLabel("Name", 40, 100, labelFont, new Color(52, 73, 94));
        add(lblname);

        JLabel labelname = createValueLabel(200, 100, valueFont);
        add(labelname);

        JLabel lblfname = createStyledLabel("Father's Name", 40, 140, labelFont, new Color(52, 73, 94));
        add(lblfname);

        JLabel labelfname = createValueLabel(200, 140, valueFont);
        add(labelfname);

        updateStudentInfo(labelname, labelfname);
        crollno.addItemListener(e -> updateStudentInfo(labelname, labelfname));

        JLabel lblcourse = createStyledLabel("Course", 40, 180, labelFont, new Color(22, 160, 133));
        add(lblcourse);

        String[] course = {"BTech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = createStyledComboBox(course, 200, 180);
        add(cbcourse);

        JLabel lblbranch = createStyledLabel("Branch", 40, 220, labelFont, new Color(22, 160, 133));
        add(lblbranch);

        String[] branch = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = createStyledComboBox(branch, 200, 220);
        add(cbbranch);

        JLabel lblsemester = createStyledLabel("Semester", 40, 260, labelFont, new Color(22, 160, 133));
        add(lblsemester);

        String[] semester = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
        cbsemester = createStyledComboBox(semester, 200, 260);
        add(cbsemester);

        JLabel lbltotal = createStyledLabel("Total Payable", 40, 300, labelFont, new Color(192, 57, 43));
        add(lbltotal);

        labeltotal = createValueLabel(200, 300, valueFont);
        add(labeltotal);

        update = createStyledButton("Update", 30, 380);
        pay = createStyledButton("Pay Fee", 150, 380);
        back = createStyledButton("Back", 270, 380);

        update.addActionListener(this);
        pay.addActionListener(this);
        back.addActionListener(this);

        add(update);
        add(pay);
        add(back);

        setVisible(true);
    }

    private JLabel createStyledLabel(String text, int x, int y, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 25);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private JLabel createValueLabel(int x, int y, Font font) {
        JLabel label = new JLabel();
        label.setBounds(x, y, 180, 25);
        label.setFont(font);
        label.setForeground(new Color(33, 47, 61));
        return label;
    }

    private JComboBox<String> createStyledComboBox(String[] items, int x, int y) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, 150, 25);
        comboBox.setBackground(new Color(224, 242, 241));
        comboBox.setForeground(new Color(40, 55, 71));
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return comboBox;
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 30);
        button.setBackground(new Color(41, 128, 185));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(new Color(21, 67, 96)));
        return button;
    }

    private void updateStudentInfo(JLabel labelname, JLabel labelfname) {
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '" + course + "'");
                while (rs.next()) {
                    labeltotal.setText(rs.getString(semester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();

            try {
                Conn c = new Conn();
                String query = "insert into collegefee values('" + rollno + "', '" + course + "', '" + branch + "', '" + semester + "', '" + total + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
