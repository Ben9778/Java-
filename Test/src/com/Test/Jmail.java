package com.Test;

import java.io.IOException;

public class Jmail {
	public void runner() throws InterruptedException{
		threa a=new threa("notepad");
		Thread thread=new Thread(a);
		thread.start();
		thread.join();
	}
	public static void main(String[] args) throws InterruptedException {
		Jmail jmail=new Jmail();
		jmail.runner();
		threa b=new threa("calc");
		Thread thread=new Thread(b);
		thread.start();
	}
}

class threa implements Runnable{
	String str="";
	public threa(String str) {
		this.str=str;
	}
	@Override
	public void run() {
		while(true) {
		try {
			Process process=Runtime.getRuntime().exec(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}
}

