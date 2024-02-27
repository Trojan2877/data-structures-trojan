public class SolutionDSA {

    static LeetCode sol = new LeetCodeImpl();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long stopTime = System.nanoTime();
        int[] blueArray = {5, 5, 3, 9, 2};
        int[] redArray = {3, 6, 7, 2, 1, -12, 1324, 6, 567,-1324};
        int[] res = sol.findThreeLargestNumbers(redArray);
        for(int i : res)
            System.out.println(i);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}