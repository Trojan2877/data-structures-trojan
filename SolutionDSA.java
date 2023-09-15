public class SolutionDSA {

    static SolutionInterface sol = new SolutionDev();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] inputArray = {2,7,11,15};
        int input = 9;
        int[] res = sol.twoSum(inputArray, input);
        long stopTime = System.nanoTime();
        for (int i : res) {
            System.out.println(i);   
        }
        System.out.println("Execution Time -----> " + String.valueOf(stopTime - startTime) + "nanoS");
    }
}