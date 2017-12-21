package gc;

/**
 * @Description TODO
 * @author 王斌
 * @date 2017年12月21日 上午9:28:18
 * @version V1.0
 */
public class TestGC1 {
	/**
	 * @Description: hotspot
	 *               jvm中，为了节省栈帧空间，局部变量表得slot是可重用的，方法体中定义的变量，其作用域并不一定覆盖整个方法体
	 *               如果当前字节码PC计数器的值已经超过了某个变量的作用域，那么这个变量对应的slot就会交给其他变量使用，副作用是会影响垃圾回收行为
	 *               运行添加 jvm参数 -verbose:gc查看内存回收过程
	 * @author 王斌
	 * @date 2017年12月21日 上午9:29:35
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("64M=" + 64 * 1024 + "k");
		// byte[] placeholder = new byte[64 * 1024 * 1024];
		// System.gc();
		// 打印结果 64M=65536k
		// [GC (System.gc()) 68198K->66224K(125952K), 0.0062589 secs]
		// [Full GC (System.gc()) 66224K->66128K(125952K), 0.0124576 secs]
		// 结果分析：64M没有回收，正常

		// {
		// byte[] placeholder = new byte[64 * 1024 * 1024];
		// }
		// System.gc();
		// 打印结果 64M=65536k
		// [GC (System.gc()) 68198K->66224K(125952K), 0.0011151 secs]
		// [Full GC (System.gc()) 66224K->66128K(125952K), 0.0049637 secs]
		// 结果分析：64M没有回收，但是已经超过了作用域，不正常

		{
			byte[] placeholder = new byte[64 * 1024 * 1024];
		}
		int a = 0;
		System.gc();
		// 打印结果 64M=65536k
		// [GC (System.gc()) 68198K->66224K(125952K), 0.0011499 secs]
		// [Full GC (System.gc()) 66224K->592K(125952K), 0.0044994 secs]
		// 结果分析：64M已回收回收，正常
		
		//总结：对象占用内存大，方法的栈帧长时间不能回收、方法调用次数达不到JIT的编译条件时，GC Roots依然保持和局部变量表中该变量的关系，故没有回收
	}
}
