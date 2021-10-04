package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui extends JFrame{
	JTextField t1, t2;
	JTextArea area;
	JButton cal,reset;
	JComboBox<String> cb;
	
	public gui() {
		setTitle("�� ���� ���ϱ�");
		setLayout(new BorderLayout(10,10));
		showNorth();
		showCenter();
		showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(2,0));
		
		JLabel l1 = new JLabel("���� ������");
		JLabel l2 = new JLabel("���� ����");
		
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t2.setEnabled(false);
		
		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		panel.add(p1);
		panel.add(p2);
		
		add(panel,BorderLayout.NORTH);
	}
	void showCenter() {
		JPanel panel = new JPanel();
		
		area = new JTextArea(30,20);
		area.setText("���� ���̸� ����մϴ�.");
		area.setEditable(false);
		area.setForeground(Color.RED);
		panel.add(area);
		
		add(panel,BorderLayout.CENTER);
	}
	void showSouth() {
		String[] color = {"red", "blue",};
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
		
		JButton cal = new JButton("���");
		cal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().isEmpty()==true) {
					System.out.println("�������� �Է��ϼ���.");
					
				}
				else {
					String s = t1.getText();
					double radius = Double.parseDouble(s);
					double result = radius*radius*3.14;
					t2.setText(""+result);
					area.setText(radius + "*" + radius + "* 3.14 = " + result);
					
				}}
		});
		
		cb = new JComboBox<>(color);
		reset = new JButton("����");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				area.setText("");
			}
		});
		
		panel.add(cal);
		panel.add(cb);
		panel.add(reset);
		
		add(panel,BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		new gui();
	}
}
