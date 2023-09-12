public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String s = "race a car";
        boolean res = sol.validPalindrome(s);
        long stopTime = System.nanoTime();
        System.out.println(res);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}