package com.prep.search;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // low = 1
        // high = max pile size
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // try to find a smallest feasible speed
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            // ceiling of a/b = (a+ b -1) / b
            hours += (pile + (long) speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h)); // 4
    }
}
