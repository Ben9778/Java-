package com.Test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class TimerTest extends JFrame implements ActionListener {
	JLabel label = new JLabel(String.format("%tY年%<tm月%<td日 %<tT", new Date()));
	Timer timer = new Timer(50, this); // 创建一个定时器，并注册当前对象为监视器

	public static void main(String[] args) {
		TimerTest frm = new TimerTest("小时钟");
		frm.setBounds(100, 100, 380, 80);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}

	public TimerTest(String s) {
		setTitle(s);
		setLayout(new FlowLayout());
		label.setFont(new Font("宋体", Font.BOLD, 25)); // 设置字体
		add(label);
		timer.start(); // 定时器开始
	}

	public void actionPerformed(ActionEvent e) {
		String s = String.format("%tY年%<tm月%<td日 %<tT", new Date());
		label.setText(s);
	}
}
