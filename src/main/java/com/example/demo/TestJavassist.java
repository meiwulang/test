package com.example.demo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class TestJavassist {

	public static void main(String[] args) throws NotFoundException {
		// 这个是得到反编译的池

		ClassPool pool = ClassPool.getDefault();

		// 取得需要反编译的jar文件，设定路径

		pool.insertClassPath(
				"C:\\Users\\mr.shuai\\Desktop\\IKAnalyzer5.3.1.jar");

		// 取得需要反编译修改的文件，注意是完整路径

		CtClass cc1 = pool.get("org.wltea.analyzer.lucene.IKAnalyzer");

		try {

			// 取得需要修改的方法

			CtMethod method = cc1.getDeclaredMethod("createComponents");

			// 插入修改项，我们让他直接返回(注意：根据方法的具体返回值返回，因为这个方法返回值是void，所以直接return；)

			method.insertBefore(
					"System.out.println(\"-------------------------------------------\");");

			// 取得需要修改的方法

			CtMethod method2 = cc1.getDeclaredMethod("createComponents");

			// 插入修改项，我们让他直接返回(注意：根据方法的具体返回值返回，因为这个方法返回值是void，所以直接return；)

			method2.insertBefore("{if(true) return null;}");

			// 写入保存

			cc1.writeFile();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
