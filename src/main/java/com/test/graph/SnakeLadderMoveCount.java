package com.test.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderMoveCount {

	public static class DistanceInfo {

		private int distance;
		private int vertex;

		public DistanceInfo() {
			distance = Integer.MAX_VALUE;
			vertex = -1;
		}

		public int getDistance() {
			return distance;
		}

		public int getVertex() {
			return vertex;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public void setVertex(int lastVertex) {
			this.vertex = lastVertex;
		}
	}

	public static void main(String[] args) {
		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++) {
			moves[i] = -1;
		}
		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
	}

	private static int getMinDiceThrows(int[] moves, int n) {
		int visited[] = new int[n];
		Queue<DistanceInfo> queue = new LinkedList<>();
		visited[0] = 1;
		DistanceInfo dInfo = new DistanceInfo();
		dInfo.setDistance(0);
		dInfo.setVertex(0);

		queue.add(dInfo);

		while (!queue.isEmpty()) {
			dInfo = queue.remove();
			int v = dInfo.getVertex();
			if (v == n - 1) {
				break;
			}

			for (int j = v + 1; j <= (v + 6) && j < n; ++j) {
				if (visited[j] == 0) {

					DistanceInfo info = new DistanceInfo();
					info.setDistance(1 + dInfo.getDistance());
					if (moves[j] != -1) {
						info.setVertex(moves[j]);
					} else {
						info.setVertex(j);
					}
					visited[j] = 1;
					queue.add(info);
				}

			}

		}

		return dInfo.getDistance();
	}

}
