package com.Test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Chess extends JFrame {
	JMenuBar menuBar;
	JMenu level,help;
	JMenuItem menuItem,menuItem2,menuItem3,menuItem4;//���� �м� �߼�
	int[][] position=new int[15][15];//���ӵ�λ��
	int x,y;
	boolean winner;//��ʤ��־
	checkerBoard checkerboard=null;
	FiveChess fiveChess=null;
	public Chess() {
		menuBar=new JMenuBar();
		level=new JMenu("ѡ��");
		help=new JMenu("����");
		menuItem=new JMenuItem("����");
		menuItem2=new JMenuItem("�м�");
		menuItem3=new JMenuItem("�߼�");
		menuItem4=new JMenuItem("��Ϸ����");
		help.add(menuItem4);
		level.add(menuItem);
		level.add(menuItem2);
		level.add(menuItem3);
		menuItem.setSelected(true);
		menuBar.add(level);
		menuBar.add(help);
		this.setTitle("Chess");
		this.setSize(600, 600);
		this.setLocation(200, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setJMenuBar(menuBar);
		checkerboard=new checkerBoard();
		fiveChess=new FiveChess();
		this.add(fiveChess);
		this.add(checkerboard);
		
	}
	//����
	public void setChess() {
		
	}
	
	//������
	public static void main(String args[]) {
		Chess chess=new Chess();
	}
}
//������
class checkerBoard extends JPanel{
	public void paint(Graphics g) {
		int row=15;
		int y=600/row;
		super.paint(g);
		g.setColor(new Color(249, 214, 91));
		g.fill3DRect(0, 0, 600, 600, true);
		g.setColor(Color.black);
		g.drawLine(0, 0, 600,0);
		g.drawLine(0, 0, 0,600);
		for(int i=0;i<row;i++) {
			g.drawLine(0, i*y, 600,i*y);
			g.drawLine(i*y, 0, i*y,600);
		}
		g.fillOval(25,25,30,30);
	
	}
}
//������
class FiveChess extends JPanel{
	public void paint(Graphics g) {
		int position=600;
		int row=15;
		super.paint(g);
		//����
		g.setColor(Color.white);
		g.fillOval(2*(position/row), 2*(position/row), 20, 20);
	}
}