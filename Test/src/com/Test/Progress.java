package com.Test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.ProgressMonitorInputStream;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Progress extends JFrame implements ActionListener,Runnable{
	JButton button=null;
	JProgressBar progressBar;
	public Progress() throws FileNotFoundException {
		this.down();
		this.setTitle("进度测试");
		this.setVisible(true);
		this.setSize(200, 200);
		this.setLocation(100, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void down() throws FileNotFoundException {
		button=new JButton("开始");
		button.addActionListener(this);
		progressBar=new JProgressBar();
		progressBar.setBackground(Color.white);
		progressBar.setName("下载进度");
		progressBar.setStringPainted(true);
		this.add(button);	
	}
	public void run(){
		//传电影
		try {
			InputStream in=new FileInputStream("E:\\xfmovie\\jj.rmvb");	
			in.read(new byte[1024]);
			ProgressMonitorInputStream a=new ProgressMonitorInputStream(this,"下载电影",in);
			OutputStream out=new FileOutputStream("E:\\PS\\AV.rmvb");
			progressBar.setValue(a.available());
			int r;
			while((r=in.read())!=-1) {
				a.read(new byte[1024]);
				out.write(new byte[1024]);
			}
			out.flush();
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//主程序
	public static void main(String[] args) throws FileNotFoundException {
		new Progress();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			Thread a=new Thread(this);
			a.start();
		}
	}

}
