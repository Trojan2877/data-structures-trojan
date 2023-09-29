public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String input = "dvdf";
        int res = sol.lengthOfLongestSubstring(input);
        long stopTime = System.nanoTime();
        System.out.println(res);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}