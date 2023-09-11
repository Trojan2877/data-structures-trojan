public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        long startTime = System.nanoTime();
        int res = sol.bestStock(input);
        long stopTime = System.nanoTime();   
        System.out.println(res);
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoSeconds");
    }
}