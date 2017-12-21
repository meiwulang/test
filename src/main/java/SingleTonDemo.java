
/**
 * @Description TODO
 * @author 王斌
 * @date 2017年11月15日 下午2:43:32
 * @version V1.0
 */
public class SingleTonDemo {
	private SingleTonDemo() {
	}

	public enum InstanceEnum {
		Instanse;
		private SingleTonDemo INSTANCE;

		private InstanceEnum() {
			INSTANCE = new SingleTonDemo();
		}

	}

	static public SingleTonDemo getInstance() {
		return SingleTonDemo.InstanceEnum.Instanse.INSTANCE;
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 23; i++) {
				System.out.println(SingleTonDemo.getInstance().hashCode());
			}
		}
	}

	public static void main(String[] args) {
		MyThread tr = new MyThread();
		tr.start();
	}
}
