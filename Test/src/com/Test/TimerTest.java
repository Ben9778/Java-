package com.Test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class TimerTest extends JFrame implements ActionListener {
	JLabel label = new JLabel(String.format("%tY��%<tm��%<td�� %<tT", new Date()));
	Timer timer = new Timer(50, this); // ����һ����ʱ������ע�ᵱǰ����Ϊ������

	public static void main(String[] args) {
		TimerTest frm = new TimerTest("Сʱ��");
		frm.setBounds(100, 100, 380, 80);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}

	public TimerTest(String s) {
		setTitle(s);
		setLayout(new FlowLayout());
		label.setFont(new Font("����", Font.BOLD, 25)); // ��������
		add(label);
		timer.start(); // ��ʱ����ʼ
	}

	public void actionPerformed(ActionEvent e) {
		String s = String.format("%tY��%<tm��%<td�� %<tT", new Date());
		label.setText(s);
	}
}
