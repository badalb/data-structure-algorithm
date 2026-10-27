public class PreviousGreaterElement {

    public static ArrayList<Integer> preGreaterEle(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                result.set(i, st.peek());
            }
            st.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12};
        ArrayList<Integer> pge = preGreaterEle(arr);

        for (int x : pge) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
