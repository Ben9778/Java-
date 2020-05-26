package com.Test;
import java.awt.*;
import java.math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;

public class Calculator extends JFrame implements ActionListener {

	JButton d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;// ���ְ�ť
	JButton jia, jian, chen, chu, deng;// �������ť
	JButton empty, back, dot, fu, ce;// �˸�,��ź���հ�ť
	JTextField text;// �ı���ʾ��
	JMenuBar menueBar;// ������
	JMenu menue, menue1, menue2;// �˵��б�
	JPanel panel;
	double num[] = { 0, 0 };// �����ֵ
	int index = 0;
	char sign;// �����
	/*
	 * ��ʼ������ Date:2019/08/03/14:43 Author:Ben
	 */
	public Calculator() {
		menue = new JMenu("�鿴(V)");
		menue1 = new JMenu("�༭(E)");
		menue2 = new JMenu("����(H)");
		menueBar = new JMenuBar();
		menueBar.add(menue);
		menueBar.add(menue1);
		menueBar.add(menue2);
		this.setSize(230, 300);
		this.setLocation(200, 100);
		this.setTitle("������");
		this.setJMenuBar(menueBar);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();
	}

	public void setPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 5, 5));// ��������Ϊ�߽粼��
		// ��ʼ������
		d0 = new JButton("0");
		d1 = new JButton("1");
		d2 = new JButton("2");
		d3 = new JButton("3");
		d4 = new JButton("4");
		d5 = new JButton("5");
		d6 = new JButton("6");
		d7 = new JButton("7");
		d8 = new JButton("8");
		d9 = new JButton("9");
		jia = new JButton("+");
		jian = new JButton("-");
		chen = new JButton("*");
		chu = new JButton("/");
		deng = new JButton("=");
		empty = new JButton("C");
		back = new JButton("��");
		dot = new JButton(".");
		fu = new JButton("��");
		ce = new JButton("CE");
		// ȥ������
		d0.setFocusPainted(false);
		d1.setFocusPainted(false);
		d2.setFocusPainted(false);
		d3.setFocusPainted(false);
		d4.setFocusPainted(false);
		d5.setFocusPainted(false);
		d6.setFocusPainted(false);
		d7.setFocusPainted(false);
		d8.setFocusPainted(false);
		d9.setFocusPainted(false);
		fu.setFocusPainted(false);
		empty.setFocusPainted(false);
		dot.setFocusPainted(false);
		back.setFocusPainted(false);
		jia.setFocusPainted(false);
		jian.setFocusPainted(false);
		chen.setFocusPainted(false);
		chu.setFocusPainted(false);
		deng.setFocusPainted(false);
		ce.setFocusPainted(false);
		// ��Ӽ���
		d0.addActionListener(this);
		d1.addActionListener(this);
		d2.addActionListener(this);
		d3.addActionListener(this);
		d4.addActionListener(this);
		d5.addActionListener(this);
		d6.addActionListener(this);
		d7.addActionListener(this);
		d8.addActionListener(this);
		d9.addActionListener(this);
		fu.addActionListener(this);
		empty.addActionListener(this);
		dot.addActionListener(this);
		back.addActionListener(this);
		jia.addActionListener(this);
		jian.addActionListener(this);
		chen.addActionListener(this);
		chu.addActionListener(this);
		deng.addActionListener(this);
		ce.addActionListener(this);
		// �����ӵ�����
		panel.add(back);
		panel.add(empty);
		panel.add(ce);
		panel.add(fu);
		panel.add(d7);
		panel.add(d8);
		panel.add(d9);
		panel.add(jia);
		panel.add(d4);
		panel.add(d5);
		panel.add(d6);
		panel.add(jian);
		panel.add(d1);
		panel.add(d2);
		panel.add(d3);
		panel.add(chen);
		panel.add(d0);
		panel.add(dot);
		panel.add(deng);
		panel.add(chu);

		text = new JTextField();
		text.setBackground(Color.WHITE);
		text.setColumns(2);
		text.setEditable(false);
		text.setFocusable(false);
		text.setText(" ");
		text.setHorizontalAlignment(JTextField.RIGHT);
		this.add(text, BorderLayout.NORTH);
		this.add(panel);
	}

	// �����¼�����
	@Override
	public void actionPerformed(ActionEvent a) {
		String str = text.getText();
		Object source = a.getSource();

		// �ж�������������ջ����˸����CE��
		if (source == back && str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		} else if (source == empty || source == ce) {
			str = "";
			num[0] = 0;
			num[1] = 0;
		}
		// �ж������������ַ�
		if (source == dot || source == d0 || source == d1 || source == d2 || source == d3 || source == d4
				|| source == d5 || source == d6 || source == d7 || source == d8 || source == d9) {
			if (source == d0)
				str += "0";
			else if (source == d1)
				str += "1";
			else if (source == d2)
				str += "2";
			else if (source == d3)
				str += "3";
			else if (source == d4)
				str += "4";
			else if (source == d5)
				str += "5";
			else if (source == d6)
				str += "6";
			else if (source == d7)
				str += "7";
			else if (source == d8)
				str += "8";
			else if (source == d9)
				str += "9";
			// �ж�����������С����
			else if (source == dot) {
				if (str.indexOf(".") == -1) {
					str += ".";
				}
			}
			if (index == 0)
				num[0] = Double.parseDouble(str); // ��������ַ�ת������ֵ����������
			else
				num[1] = Double.parseDouble(str);
		}
		// �ж����������������
		if (source == jia || source == jian || source == chu || source == chen) {
			if (source == jia)
				sign = '+';
			else if (source == jian)
				sign = '-';
			else if (source == chen)
				sign = '*';
			else if (source == chu)
				sign = '/';
			index = 1;
			str = "";
		} else if (source == deng) {
			if (sign == '+' || sign == '-' || sign == '/' || sign == '*') {
				if (sign == '+') {
					num[0] += num[1];
				} else if (sign == '-') {
					num[0] -= num[1];
				} else if (sign == '/') {
					num[0] /= num[1];
				} else if (sign == '*') {
					num[0] *= num[1];
				}
				index = 0;
				num[1] = 0;
				str = Double.toString(num[index]);
			}
		}
		text.setText(str);
	}

	public static void main(String[] args) {
		Calculator a = new Calculator();
	}
}
