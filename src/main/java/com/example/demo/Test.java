package com.example.demo;

/**
 * @Description TODO
 * @author 王斌
 * @date 2017年11月7日 下午6:10:28
 * @version V1.0
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		int a = 233;
		assert a > 0 : "参数不合法";
		System.out.println(a);
		// 断言1结果为true，则继续往下执行
		assert true;
		System.out.println("断言1没有问题，Go！");

		System.out.println("\n-----------------\n");

		// 断言2结果为false,程序终止
		assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
		System.out.println("断言2没有问题，Go！");
	}
}
