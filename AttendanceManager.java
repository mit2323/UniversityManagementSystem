package UNIVERSITY_MANAGEMENT;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class AttendanceManager extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel model;
    private Connection conn;
    private JTextField rollnoField, attendanceField;
    private JButton editButton, submitButton;

    public AttendanceManager() {
        setTitle("Student Attendance Manager");
        setSize(900, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240)); 

        connectDatabase();

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        topPanel.setBackground(new Color(200, 220, 240));  
        inputPanel.setBackground(new Color(230, 230, 230)); 
        buttonPanel.setBackground(new Color(200, 220, 240));

        // Table Setup
        model = new DefaultTableModel(new String[]{"Roll No", "Name", "Attendance"}, 0);
        table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setBackground(Color.WHITE);
        table.setGridColor(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        rollnoField = new JTextField();
        attendanceField = new JTextField();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        rollnoField.setBorder(border);
        attendanceField.setBorder(border);
        
        JLabel roll=new JLabel("Rollno");
        roll.setFont(new Font("Tahoma",Font.PLAIN,18));
        inputPanel.add(roll);
        
        inputPanel.add(rollnoField);
        JLabel attenField=new JLabel("Attendance");
        attenField.setFont(new Font("Tahoma",Font.PLAIN,18));
        inputPanel.add(attenField);
        inputPanel.add(attendanceField);
        // Buttons with Customization
        editButton = new JButton("Edit Attendance");
        submitButton = new JButton("Submit Attendance");

        editButton.setBackground(new Color(70, 130, 180)); 
        editButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(34, 139, 34)); 
        submitButton.setForeground(Color.WHITE);

        editButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Hover Effect for Buttons
        editButton.addMouseListener(new ButtonHoverEffect(editButton));
        submitButton.addMouseListener(new ButtonHoverEffect(submitButton));

        editButton.addActionListener(new EditAttendanceAction());
        submitButton.addActionListener(new SubmitAttendanceAction());

        buttonPanel.add(editButton);
        buttonPanel.add(submitButton);

        JPanel graphPanel = createGraphPanel();
        graphPanel.setBackground(new Color(240, 240, 240));

        topPanel.add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(graphPanel, BorderLayout.EAST);

        fetchData();
        setVisible(true);
    }

    private void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Connection Failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fetchData() {
        model.setRowCount(0);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT rollno, name, attendance FROM student");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("rollno"), rs.getString("name"), rs.getInt("attendance")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JPanel createGraphPanel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, attendance FROM student");
            while (rs.next()) {
                dataset.setValue(rs.getInt("attendance"), "Attendance", rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JFreeChart chart = ChartFactory.createBarChart("Student Attendance", "Student", "Attendance", dataset);
        return new ChartPanel(chart);
    }

    // Edit Attendance Action
    private class EditAttendanceAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Please select a student to edit.");
                return;
            }
            rollnoField.setText(String.valueOf(table.getValueAt(row, 0)));
            attendanceField.setText(String.valueOf(table.getValueAt(row, 2)));
        }
    }

    private class SubmitAttendanceAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int rollno = Integer.parseInt(rollnoField.getText());
                int newAttendance = Integer.parseInt(attendanceField.getText());
                updateAttendance(rollno, newAttendance);
                fetchData(); 
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input! Enter valid numbers.");
            }
        }
    }

    private void updateAttendance(int rollno, int newAttendance) {
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE student SET attendance = ? WHERE rollno = ?");
            pst.setInt(1, newAttendance);
            pst.setInt(2, rollno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Attendance Updated Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class ButtonHoverEffect extends MouseAdapter {
        private JButton button;
        private Color originalColor;

        public ButtonHoverEffect(JButton button) {
            this.button = button;
            this.originalColor = button.getBackground();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(button.getBackground().darker());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(originalColor);
        }
    }

    public static void main(String[] args) {
        new AttendanceManager();
    }
}


