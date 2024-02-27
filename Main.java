import java.util.*;

public class Main {

    // Function to reverse every k elements in a list
    public List<Integer> reverseElement(List<Integer> inputList, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i += k) {
            int start = i;
            int end = Math.min(i + k, inputList.size());

            // Reverse a group of k elements
            if (end - start == k) {
                List<Integer> sublist = inputList.subList(start, end);
                Collections.reverse(sublist);
                result.addAll(sublist);
            } else {
                // Reverse the last group with fewer than k elements
                List<Integer> sublist = inputList.subList(start, end);
                Collections.reverse(sublist);
                result.addAll(sublist);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();

        List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        int k = 3;

        int[] res = main.
    }
}
