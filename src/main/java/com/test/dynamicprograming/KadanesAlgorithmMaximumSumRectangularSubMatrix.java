package com.test.dynamicprograming;

public class KadanesAlgorithmMaximumSumRectangularSubMatrix {

	static class Result {
		int maxSum;
		int topLeft;
		int bottomLeft;
		int topRight;
		int bottomright;

		public Result(int maxSum, int topLeft, int bottomLeft, int topRight, int bottomright) {
			super();
			this.maxSum = maxSum;
			this.topLeft = topLeft;
			this.bottomLeft = bottomLeft;
			this.topRight = topRight;
			this.bottomright = bottomright;
		}

		public int getMaxSum() {
			return maxSum;
		}

		public void setMaxSum(int maxSum) {
			this.maxSum = maxSum;
		}

		public int getTopLeft() {
			return topLeft;
		}

		public void setTopLeft(int topLeft) {
			this.topLeft = topLeft;
		}

		public int getBottomLeft() {
			return bottomLeft;
		}

		public void setBottomLeft(int bottomLeft) {
			this.bottomLeft = bottomLeft;
		}

		public int getTopRight() {
			return topRight;
		}

		public void setTopRight(int topRight) {
			this.topRight = topRight;
		}

		public int getBottomright() {
			return bottomright;
		}

		public void setBottomright(int bottomright) {
			this.bottomright = bottomright;
		}

		@Override
		public String toString() {
			return "Result [maxSum=" + maxSum + ", topLeft=" + topLeft + ", bottomLeft=" + bottomLeft + ", topRight="
					+ topRight + ", bottomright=" + bottomright + "]";
		}
	}

	private static Result calculateMaxSumRectangularSubMatrix(int[][] arr) {
		int L, R;
		Result result = new Result(0, 0, 0, 0, 0);

		for (int left = 0; left < arr[0].length; left++) {
			L = left;
			int[] temp = new int[arr.length];
			for (int j = left; j < arr[0].length; j++) {
				R = j;
				for (int i = 0; i < arr.length; i++) {
					temp[i] += arr[i][j];
				}

				KanadeResult kresult = kadaneAlgorithm(temp);
				if (kresult.getMaxSum() > result.maxSum) {
					result.setMaxSum(kresult.getMaxSum());
					result.setTopLeft(L);
					result.setTopRight(R);
					result.setBottomLeft(kresult.getStart());
					result.setBottomright(kresult.getEnd());
				}
			}
		}
		return result;
	}

	static class KanadeResult {
		int maxSum;
		int start;
		int end;

		public KanadeResult(int maxSum, int start, int end) {
			super();
			this.maxSum = maxSum;
			this.start = start;
			this.end = end;
		}

		public int getMaxSum() {
			return maxSum;
		}

		public void setMaxSum(int maxSum) {
			this.maxSum = maxSum;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
	}

	private static KanadeResult kadaneAlgorithm(int[] a) {
		int currentStartIndx = 0;
		int maxStartIdx = 0;
		int maxEndIndex = 0;

		int maxSum = 0;
		int maxSumEndingHere = 0;

		for (int i = 0; i < a.length; i++) {
			maxSumEndingHere = maxSumEndingHere + a[i];
			if (maxSumEndingHere < 0) {
				maxSumEndingHere = 0;
				currentStartIndx = i + 1;
			}

			if (maxSumEndingHere > maxSum) {
				maxSum = maxSumEndingHere;
				maxStartIdx = currentStartIndx;
				maxEndIndex = i;
			}
		}

		return new KanadeResult(maxSum, maxStartIdx, maxEndIndex);
	}

	public static void main(String[] args) {
		// int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// kadaneAlgorithm(a);
		int[][] arr = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4, -5 }, { -3, 3, 1, 0, 3 } };
		Result result = calculateMaxSumRectangularSubMatrix(arr);
		System.out.println(result.toString());
	}

}
