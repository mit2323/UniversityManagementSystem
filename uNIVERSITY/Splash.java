package uNIVERSITY;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
	static final long serialVersionUID = 1L;
Thread t;
Splash() {
	ImageIcon i1=new ImageIcon(getClass().getResource("/images/first.jpg"));
	Image i2 =i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	add(image);
	t=new Thread(this);
	t.start();
	setVisible(true);
	int x=1;
	for(int i=2;i<=600;i+=4,x+=1) {
	setLocation(600-((i+x)/2),350-(i/2));
	setSize(i+3*x,i+x/2);
	try {
		Thread.sleep(10);
	}
	catch(Exception e){}
	}
}
public void run() {
		try {
			Thread.sleep(6000);
			setVisible(false);
			//NExt Frame
			new Login();
		}
		catch(Exception e) {}
	}


public static void main(String[] args) {
	new Splash();
}
}
