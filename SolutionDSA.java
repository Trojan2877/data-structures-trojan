public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        String[] input = {"flow", "flower", "float"};
        long startTime = System.nanoTime();
        String res = sol.longestCommonPrefix(input);
        long stopTime = System.nanoTime();   
        System.out.println(res);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}