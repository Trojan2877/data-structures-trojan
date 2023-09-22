public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] inputArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        String input = "Hello";
        int res = sol.maxSubArray(inputArray);
        long stopTime = System.nanoTime();
        System.out.println(res);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}