public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean res = sol.wordPattern("abba","dog cat cat dog");
        long stopTime = System.nanoTime();
        System.out.println(res);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}