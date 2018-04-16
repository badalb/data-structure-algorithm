package com.test.dynamicprograming;

import java.util.Arrays;

public class BoxStacking {

	static class Box implements Comparable<Box> {

		int h, w, d;

		public Box(int h, int w, int d) {
			this.h = h;
			this.w = w;
			this.d = d;
		}

		public int getArea() {
			return w * d;
		}

		@Override
		public int compareTo(Box o) {
			return o.getArea() - this.getArea();
		}
	}

	private static Box[] rotateBox(Box[] arr) {
		Box[] rotatedBox = new Box[arr.length * 3];

		for (int i = 0; i < arr.length; i++) {
			Box box = arr[i];

			rotatedBox[3 * i] = new Box(box.h, Math.max(box.w, box.d), Math.min(box.w, box.d));

			rotatedBox[3 * i + 1] = new Box(box.w, Math.max(box.h, box.d), Math.min(box.h, box.d));

			rotatedBox[3 * i + 2] = new Box(box.d, Math.max(box.w, box.h), Math.min(box.w, box.h));
		}
		return rotatedBox;
	}

	private static int calcMaxHeight(Box[] arr) {
		Box[] totalBoxes = rotateBox(arr);
		Arrays.sort(totalBoxes);
		int[] T = new int[3 * arr.length];
		for (int i = 0; i < totalBoxes.length; i++) {
			T[i] = totalBoxes[i].h;
		}

		int max = 0;
		for (int i = 1; i < totalBoxes.length; i++) {
			Box box = totalBoxes[i];
			T[i] = 0;
			int val = 0;
			for (int j = 0; j < i; j++) {
				Box prevBox = totalBoxes[j];
				if (box.w < prevBox.w && box.d < prevBox.d) {
					val = Math.max(val, T[j]);
				}
			}
			T[i] = val + box.h;
			max = Math.max(max, T[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Box[] arr = new Box[4];
		arr[0] = new Box(4, 6, 7);
		arr[1] = new Box(1, 2, 3);
		arr[2] = new Box(4, 5, 6);
		arr[3] = new Box(10, 12, 32);

		System.out.println("Max height :" + calcMaxHeight(arr));
	}

}
