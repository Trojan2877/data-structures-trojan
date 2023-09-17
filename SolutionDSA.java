public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] inputArray = {2,7,11,15};
        String input = "((";
        boolean res = sol.isValid(input);
        long stopTime = System.nanoTime();
        System.out.println(res);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}