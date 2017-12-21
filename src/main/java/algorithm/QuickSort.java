package algorithm;

import java.util.Arrays;

/**
 * @Description 快速排序
 * @author 王斌
 * @date 2017年12月18日 下午1:26:54
 * @version V1.0
 */
public class QuickSort {
	public static void qucikSort(Integer[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			qucikSort(A, p, q - 1);
			qucikSort(A, q + 1, r);
		}
	}

	public static int partition(Integer[] A, int p, int r) {
		Integer x = A[r];
		int i = p - 1;
		for (int j = p; j < r - 1; j++) {
			if (A[j] < x) {
				i++;
				A = exchanger(A, i, j);
			}
			A = exchanger(A, i + 1, r);
		}
		return ++i;
	}

	private static Integer[] exchanger(Integer[] A, int i, int j) {
		Integer x = A[i];
		A[i] = A[j];
		A[j] = x;
		return A;
	}

	public static void main(String[] args) {
		Integer[] A = new Integer[] { 2, 4, 6, 8, 1, 4, 9, 7, 0, 5, 3 };
		System.out.println(Arrays.toString(A));
		qucikSort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
	}
}
