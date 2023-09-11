import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionDev implements SolutionInterface {

    // ====================== Start writing all the merhods for DS&A here.
    // ===========================================

    // Given a sorted array, remove the duplicates in place such that each element
    // appear only once and return the new
    // length. Do not allocate extra space for another array, you must do this in
    // place with constant memory.
    // For example, given input array A = [1,1,2], your function should return
    // length = 2, and A is now [1,2].

    @Override
    public int[] removeDuplicates(int[] nums) {
        int val = nums[0];
        int newLength = 0;
        nums[newLength] = nums[0];
        newLength++;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newLength] = nums[i];
                newLength++;
                int j = i;
                while (val == nums[j]) {
                    j++;
                }
                val = nums[j];
            }
        }
        for (int x = newLength; x < nums.length; x++) {
            nums[x] = -1;
        }
        return nums;
    }

    // Alternative method to remove duplicates from an array using Hashset

    @Override
    public Set<Integer> removeDuplicates1(int[] nums) {

        return Arrays.stream(nums).boxed().collect(Collectors.toSet());
    }

    // Method to remove element in an array using binary search
    @Override
    public int[] removeElement(int[] nums, int val) {
        while (Arrays.binarySearch(nums, val) > 0) {
            int index = Arrays.binarySearch(nums, val);
            nums[index] = -1;
        }
        return nums;
    }

    // Method to remove element using brute force.
    @Override
    public int[] removeElement1(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val)
                nums[i] = -1;
        }
        return nums;
    }

    // Method to move zeros to the end of the array in place without extra iteration
    // and extra space.
    @Override
    public int[] moveZeros(int[] nums) {
        int i = 0;
        // Overwrite if the numbers are not equal to 0.
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        // i will be pointing to the length-1 of non zero sub-array
        // fill the rest with zeros
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
        return nums;
    }

    // Candy problem :: similar to trapping rain water problem.
    // Takes a lot of time however! Not the best solution.
    @Override
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // Give one candy to each kid
        for (int i = 0; i < candies.length; i++)
            candies[i] = 1;
        int min = candies.length;
        int sum = 0;
        while (min != sum) {
            sum = min;
            // Iterate from left to right
            for (int i = 0; i < ratings.length - 1; i++) {
                if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }

            // Iterate from right to left
            for (int i = ratings.length - 1; i > 0; i--) {
                if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }
            min = Arrays.stream(candies).sum();
        }
        return sum;
    }

    // Product except self
    // Given an array of n integers where n >1, nums, return an array output such
    // that output[i] is equal to the product
    // of all the elements of nums except nums[i].
    // Solve it without division and in O(n).
    // For example, given [1,2,3,4], return [24,12,8,6].
    @Override
    public int[] productExceptSelf(int[] input) {
        int[] res = new int[input.length];
        int product = 1;
        for (int i = 0; i < input.length; i++) {
            int j = 0;
            product = 1;
            while (j < input.length) {
                if (i != j)
                    product *= input[j];
                j++;
            }
            res[i] = product;
        }
        return res;
    }

    // Given a sorted integer array without duplicates, return the summary of its
    // ranges for consecutive numbers.
    // For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
    @Override
    public List<String> summaryRanges(int[] input) {
        List<String> res = new ArrayList<>();
        StringBuilder val = new StringBuilder();
        for (int j = 0; j < input.length; j++) {
            val = new StringBuilder();
            int start = input[j];
            val.append(String.valueOf(start));
            val.append(" -> ");
            while (j < input.length - 1 && input[j] + 1 == input[j + 1]) {
                j++;
            }
            int end = input[j];
            val.append(String.valueOf(end));
            if (start != end)
                res.add(val.toString());
            else
                res.add(String.valueOf(start));
        }
        return res;
    }

    // **Reverse an Array:** Write a function to reverse the elements of an array in
    // place.
    @Override
    public int[] reverseArray(int[] input) {
        for (int i = 0, j = input.length - 1; i <= input.length / 2 && j >= input.length / 2; i++, j--) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
        return input;
    }

    // **Find the Maximum and Minimum:** Write a function to find the maximum and
    // minimum values in an array.
    @Override
    public int[] findMaxMin(int[] input) {
        Arrays.sort(input);
        int[] res = new int[2];
        res[0] = input[0];
        res[1] = input[input.length - 1];
        return res;
    }

    // Find minimum and maximum values without using the sort method.
    @Override
    public int[] findMinMax1(int[] input) {
        int min = input[0];
        int max = input[0];
        for (int i = 0; i < input.length; i++) {
            if (input[i] < min)
                min = input[i];
            if (input[i] > max)
                max = input[i];
        }
        int[] res = new int[2];
        res[0] = min;
        res[1] = max;
        return res;
    }

    // Find the majority repeating element in an arry i.e: more than n/2 times
    @Override
    public int majorityElement(int[] nums) {
        int freq = 0;
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j])
                        freq++;
                }
                visited.add(nums[i]);
            }
            if (freq >= nums.length / 2)
                return nums[i];
            freq = 0;
        }
        return -1;
    }

    // Best time to buy and sell stocks.
    @Override
    public int bestStock(int[] prices) {
        int maxProfit = 0;
        int j = 0;
        for (int i = j; i < prices.length; i++) {
            for (j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    maxProfit = Math.max(prices[j] - prices[i], maxProfit);
                }
            }
        }
        return maxProfit;
    }
}