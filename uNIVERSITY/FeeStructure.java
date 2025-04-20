package uNIVERSITY;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {

    FeeStructure() {
        setTitle("Fee Structure");
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        getContentPane().setBackground(new Color(240, 248, 255)); // Alice Blue
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 40);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 36));
        heading.setForeground(new Color(44, 62, 80));
        add(heading);

        JTable table = new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(28);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        table.getTableHeader().setBackground(new Color(0, 123, 255));
        table.getTableHeader().setForeground(Color.WHITE);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            TableColumnModel columnModel = table.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                String columnName = columnModel.getColumn(i).getHeaderValue().toString().toLowerCase();
                if (columnName.contains("course")) {
                    columnModel.getColumn(i).setCellRenderer(new CustomColorRenderer(new Color(255, 249, 196))); // Yellow
                } else if (columnName.contains("sem")) {
                    columnModel.getColumn(i).setCellRenderer(new CustomColorRenderer(new Color(204, 255, 229))); // Light green
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 70, 900, 500);
        add(jsp);

        JButton back = new JButton("Back");
        back.setBounds(820, 600, 130, 40);
        back.setFocusPainted(false);
        back.setFont(new Font("Segoe UI", Font.BOLD, 16));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(52, 152, 219));
        back.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        back.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                back.setBackground(new Color(41, 128, 185));
            }

            public void mouseExited(MouseEvent evt) {
                back.setBackground(new Color(52, 152, 219));
            }
        });

        back.addActionListener(e -> setVisible(false));
        add(back);

        setVisible(true);
    }

    class CustomColorRenderer extends DefaultTableCellRenderer {
        Color bgColor;

        CustomColorRenderer(Color bgColor) {
            this.bgColor = bgColor;
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(isSelected ? table.getSelectionBackground() : bgColor);
            c.setForeground(Color.BLACK);
            return c;
        }
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}

