package view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Panel extends JFrame {

	private static final long serialVersionUID = 1L;
	private StudentView stuView = new StudentView();
	
	public Panel() {
		Container container = getContentPane();
//		JTextArea ta = new JTextArea(500,500);
//		ta.setText("select * from student");
		JPanel p = new JPanel();
//		p.add(ta);
		container.add(p);
		setTitle("学生管理系统");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] arg) {
		Panel p = new Panel();
	}
	
}
