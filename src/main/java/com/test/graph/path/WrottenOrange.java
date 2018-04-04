package com.test.graph.path;

import java.util.LinkedList;
import java.util.Queue;

public class WrottenOrange {

	public static class AxisInfo {
		private int x;
		private int y;

		AxisInfo(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	private static boolean isValid(int i, int j, int n, int m) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}

	private static boolean isDelim(AxisInfo axisInfo) {
		return axisInfo.getX() == -1 && axisInfo.getY() == -1;
	}

	private static boolean isNotWrotten(int[][] arr, int i, int j) {
		return arr[i][j] == 1;
	}

	private static boolean checkAll(int arr[][], int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	private static int rotOranges(int[][] arr) {
		int pass = 0;
		int n = arr.length;
		int m = arr[0].length;
		boolean flag = false;

		Queue<AxisInfo> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 2) {
					queue.add(new AxisInfo(i, j));
				}
			}
		}
		queue.add(new AxisInfo(-1, -1));

		while (!queue.isEmpty()) {
			AxisInfo axisInfo = queue.poll();
			if (!isDelim(axisInfo)) {
				if (isValid(axisInfo.getX() + 1, axisInfo.getY(), n, m)) {
					if (isNotWrotten(arr, axisInfo.getX() + 1, axisInfo.getY())) {
						arr[axisInfo.getX() + 1][axisInfo.getY()] = 2;
						queue.add(new AxisInfo(axisInfo.getX() + 1, axisInfo.getY()));
						flag = true;
					}
				}

				if (isValid(axisInfo.getX() - 1, axisInfo.getY(), n, m)) {
					if (isNotWrotten(arr, axisInfo.getX() - 1, axisInfo.getY())) {
						arr[axisInfo.getX() - 1][axisInfo.getY()] = 2;
						queue.add(new AxisInfo(axisInfo.getX() - 1, axisInfo.getY()));
						flag = true;
					}
				}

				if (isValid(axisInfo.getX(), axisInfo.getY() + 1, n, m)) {
					if (isNotWrotten(arr, axisInfo.getX(), axisInfo.getY() + 1)) {
						arr[axisInfo.getX()][axisInfo.getY() + 1] = 2;
						queue.add(new AxisInfo(axisInfo.getX(), axisInfo.getY() + 1));
						flag = true;
					}
				}

				if (isValid(axisInfo.getX(), axisInfo.getY() - 1, n, m)) {
					if (isNotWrotten(arr, axisInfo.getX(), axisInfo.getY() - 1)) {
						arr[axisInfo.getX()][axisInfo.getY() - 1] = 2;
						queue.add(new AxisInfo(axisInfo.getX(), axisInfo.getY() - 1));
						flag = true;
					}
				}
			}
			if (isDelim(axisInfo)) {
				pass++;
				if (flag) {
					queue.add(new AxisInfo(-1, -1));
					flag = false;
				}
			}
		}

		return checkAll(arr, n, m) ? -1 : pass - 1;
	}

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr);
		if (ans == -1) {
			System.out.println("All oranges cannot rot");
		} else {
			System.out.println("Time required for all oranges to rot = " + ans);
		}
	}
}