package com.example.demo;

/**
 * @Description TODO
 * @author 王斌
 * @date 2017年11月6日 下午2:31:01
 * @version V1.0
 */
public class TestString {
	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		System.out.println("原始值 ");
		System.out.println(a);
		System.out.println(b);
		a = a + b;
		b = a.substring(0, a.length() - b.length());
		a = a.substring(b.length());
		System.out.println("修改值 ");
		System.out.println(a);
		System.out.println(b);

		Integer c = Integer.valueOf(3);
		Integer d = Integer.valueOf(4);
		System.out.println("c,d原始值");
		System.out.println(c);
		System.out.println(d);
		c = c ^ d;
		d = c ^ d;
		c = c ^ d;
		System.out.println("c,d修改值");
		System.out.println(c);
		System.out.println(d);
	}
}
