package com.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class reflect {
	//测试反射机制
	public static void main(String[] args) throws Exception {
		Class c=null;
		c=Class.forName("com.Test.junitTest");
		System.out.println("该类的名称是:"+c.getName());
		System.out.println("------这是华丽的分割线-----------");
		//Method
		Method[] methods=c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}
		System.out.println("------这是华丽的分割线-----------");
		//Field
		Field[] fields=c.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("------这是华丽的分割线-----------");
		//costructor
		Constructor[] constructor=c.getConstructors();
		for (Constructor constructor2 : constructor) {
			System.out.println(constructor2);
		}
		System.out.println("------这是华丽的分割线-----------");
		//获取注释
		Annotation[] annotation=c.getAnnotations();
		for (Annotation annotation2 : annotation) {
			System.out.println("该类的注释为:"+annotation2);
		}
		System.out.println("------这是华丽的分割线-----------");
		
	}

}
