package com.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class reflect {
	//���Է������
	public static void main(String[] args) throws Exception {
		Class c=null;
		c=Class.forName("com.Test.junitTest");
		System.out.println("�����������:"+c.getName());
		System.out.println("------���ǻ����ķָ���-----------");
		//Method
		Method[] methods=c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}
		System.out.println("------���ǻ����ķָ���-----------");
		//Field
		Field[] fields=c.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("------���ǻ����ķָ���-----------");
		//costructor
		Constructor[] constructor=c.getConstructors();
		for (Constructor constructor2 : constructor) {
			System.out.println(constructor2);
		}
		System.out.println("------���ǻ����ķָ���-----------");
		//��ȡע��
		Annotation[] annotation=c.getAnnotations();
		for (Annotation annotation2 : annotation) {
			System.out.println("�����ע��Ϊ:"+annotation2);
		}
		System.out.println("------���ǻ����ķָ���-----------");
		
	}

}
