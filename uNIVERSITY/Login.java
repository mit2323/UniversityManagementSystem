package uNIVERSITY;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
/**
	 * 
	 */
	JTextField tfusername,tfPassword;
	JButton login,cancel;
	private static final long serialVersionUID = 1L;
Login(){
	getContentPane().setBackground(Color.white);
	setLayout(null);
	
	JLabel lblusername=new JLabel("Username");
	lblusername.setBounds(40,20,100,20);
	add(lblusername);
	
	 tfusername=new JTextField();
	tfusername.setBounds(150,20,150,20);
	add(tfusername);
	JLabel lblPassword=new JLabel("Password");
	lblPassword.setBounds(40,70,100,20);
	add(lblPassword);
	 tfPassword=new JPasswordField();
	tfPassword.setBounds(150,70,150,20);
	add(tfPassword);
	login =new JButton("Login");
	login.setBounds(40,140,120,30);
	login.setBackground(Color.BLACK);
	login.setForeground(Color.white);
	login.setFont(new Font("Tahoma",Font.BOLD,16));
	login.addActionListener(this);
	add(login);
	cancel =new JButton("Cancel");
	cancel.setBounds(180,140,120,30);
	cancel.setBackground(Color.BLACK);
	cancel.setForeground(Color.white);
	cancel.setFont(new Font("Tahoma",Font.BOLD,16));
	cancel.addActionListener(this);
	add(cancel);
	ImageIcon i1=new ImageIcon(getClass().getResource("/images/second.jpg"));
	Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	image.setBounds(350,0,200,200);
	add(image);
	setSize(600,300);
	setLocation(500,250);
	setVisible(true) ;
}



@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==login) {
		String username=tfusername.getText();
		String password=tfPassword.getText();
		String query="select * from login where username='"+username+"'and Password ='"+password+"'";
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next()) {
				setVisible(false);
				new Project();
				
			}else {
				JOptionPane.showInternalMessageDialog(null, "Invalid username or Password ");
				setVisible(false);
			}
			c.s.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		}
	else if(e.getSource()==cancel) {
		setVisible(false);
	}
	
}
public static void main(String[] args) {
	new Login();
}
}
