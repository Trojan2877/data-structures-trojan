import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.tree.TreeNode;

public class LeetCodeImpl implements LeetCode {

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

    // Candy Implementation alternative approach
    @Override
    public int candy1(int[] ratings) {
        int[] LtoR = new int[ratings.length];
        int[] RtoL = new int[ratings.length];
        int[] res = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            LtoR[i] = RtoL[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                LtoR[i] = LtoR[i + 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                RtoL[i] = RtoL[i] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            res[i] = Math.max(LtoR[i], RtoL[i]);
            sum += res[i];
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
            val.append("->");
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

    // Roman to integer
    @Override
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = getMap();
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            resList.add(romanMap.get(s.charAt(i)));
        }
        int sum = 0;
        for (int i = 0; i < resList.size(); i++) {
            try {
                if (resList.get(i) == 1 && (resList.get(i + 1) == 5 || resList.get(i + 1) == 10)) {
                    sum += (resList.get(i + 1) - resList.get(i));
                    i++;
                } else if (resList.get(i) == 10 && (resList.get(i + 1) == 50 || resList.get(i + 1) == 100)) {
                    sum += (resList.get(i + 1) - resList.get(i));
                    i++;
                } else if (resList.get(i) == 100 && (resList.get(i + 1) == 500 || resList.get(i + 1) == 1000)) {
                    sum += (resList.get(i + 1) - resList.get(i));
                    i++;
                } else
                    sum += resList.get(i);
            } catch (IndexOutOfBoundsException e) {
                sum += resList.get(i);
            }
        }
        return sum;
    }

    private Map<Character, Integer> getMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    // Length of last word of a string
    @Override
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return str[str.length - 1].length();
    }

    // Longest common prefix
    @Override
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i))
                return res.toString();
            res.append(last.charAt(i));
        }
        return res.toString();
    }

    // Needle in a haystack
    @Override
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Alternate impl
    @Override
    public int needleInHaystack(String haystack, String needle) {
        int j = 0;
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(i))
                j++;
            if (j == needle.length())
                return i;
        }
        return -1;
    }

    // Valid palindrome?
    @Override
    public boolean validPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i <= arr.length / 2 && j >= arr.length / 2; i++, j--) {
            if (arr[i] != arr[j])
                return false;
        }
        return true;
    }

    // Is Squence?
    @Override
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        if (s.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (i == s.length() - 1)
                        return true;
                    j++;
                    break;
                }
                j++;
            }
        }
        return false;
    }

    // Ransom & magzine?
    @Override
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mapRan = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++)
            mapRan.put(magazine.charAt(i), mapRan.getOrDefault(magazine.charAt(i), 0) + 1);

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!mapRan.containsKey(ransomNote.charAt(i)) || mapRan.get(ransomNote.charAt(i)) == 0) {
                return false;
            }
            mapRan.put(ransomNote.charAt(i), mapRan.get(ransomNote.charAt(i)) - 1);
        }
        return true;

    }

    // is isomprphic?
    @Override
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if (map.containsKey(sCh)) {
                if (map.get(sCh) != tCh) {
                    return false;
                }
            } else if (map.containsValue(tCh)) {
                return false;
            } else {
                map.put(sCh, tCh);
            }
        }
        return true;
    }

    // Word Pattern
    @Override
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] str = s.split(" ");
        if (str.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String string = str[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(string)) {
                    return false;
                }
            } else if (map.containsValue(string)) {
                return false;
            } else {
                map.put(c, string);
            }
        }
        return true;
    }

    // Valid Anagram
    @Override
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != 0)
                return false;
        }

        return true;
    }

    // Two Sum
    @Override
    public int[] twoSum(int[] nums, int target) {
        int numLength = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numLength; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    // Happy Number
    @Override
    public boolean isHappy(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        while (n != 1 && !map.containsKey(n)) {
            map.put(n, 0);
            n = sum(n);
        }
        return n == 1;
    }

    // Happy Number util
    private int sum(int n) {

        int sum = 0;
        while (n > 0) {
            int m = n % 10;
            sum += m * m;
            n /= 10;
        }
        return sum;
    }

    // Valida paranthesis
    @Override
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> keyStack = new Stack<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c))
                keyStack.push(c);
            if (keyStack.isEmpty() || (map.containsValue(c) && c != map.get(keyStack.pop()))) {
                return false;
            }
        }

        return keyStack.isEmpty();
    }

    // Merge 2 sorted linkedlist
    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }

    // Reverse a String in place
    @Override
    public String reverseString(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        str = new String(chars);
        return str;
    }

    // Majority element : Element more than N / 2
    @Override
    public int majorityElement1(int[] nums) {
        int max = nums.length / 2;
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > max) {
                return i;
            }
        }
        // return -1 if no such element exists
        return -1;
    }

    // Find the largest element in an integer array
    @Override
    public int LargestElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        return max;
    }

    // Find the 2nd largest element in the array
    @Override
    public int secondLargest(int[] nums) {
        if (nums.length < 2)
            return -1;
        int max = Integer.MIN_VALUE;
        int secondMax = max;
        for (int i : nums) {
            if (i > max) {
                secondMax = max;
                max = i;
            } else if (i > secondMax && i != max) {
                secondMax = i;
            }
        }
        if (secondMax == Integer.MIN_VALUE)
            return -1;
        return secondMax;
    }

    // Max subarray sum.
    @Override
    public int maxSubArray(int[] nums) {
        if (nums.length < 1)
            return 0;
        int current = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(current, max);
        }

        return max;
    }

    // Longest non recurring substring
    @Override
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int end = chars.length;
        for (int i = 0; i < end; i++) {
            int count = 0;
            int j = i;
            while (j < end) {
                if (!map.containsKey(chars[j])) {
                    count++;
                    map.put(chars[j], 1);
                } else {
                    map = new HashMap<>();
                    i = j - 1;
                    break;
                }
                j++;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    @Override
    public boolean find132pattern(int[] nums) {
        int j = nums.length;

        return false;
    }

    // Merge 2 sorted linkedLists
    @Override
    public List<Integer> mergeLists(List<Integer> sortedList1, List<Integer> sortedList2) {
        List<Integer> res = new ArrayList<>();
        for (int i : sortedList1) {
            res.add(i);
        }
        for (Integer i : sortedList2) {
            res.add(i);
        }
        // Till here timecomplexity is O(m+n)
        Collections.sort(res);
        // Time complexity : O(log(m+n))
        return res;
    }

    // Merge 2 sorted linkedlists
    @Override
    public List<Integer> mergeListsEff(List<Integer> sortedList1, List<Integer> sortedList2) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < sortedList1.size() && j < sortedList2.size()) {
            if (sortedList1.get(i) < sortedList2.get(j)) {
                res.add(sortedList1.get(i));
                i++;
            } else {
                res.add(sortedList2.get(j));
                j++;
            }
        }

        while (i < sortedList1.size()) {
            res.add(sortedList1.get(i));
            i++;
        }

        while (j < sortedList2.size()) {
            res.add(sortedList2.get(j));
            j++;
        }

        return res;
    }

    // Search and insert
    @Override
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int i = 0;
        while (nums[i] < target) {
            i++;
        }
        return i;
    }

    // Two sum
    @Override
    public int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            while (j < length) {
                if (array[i] + array[j] == targetSum)
                    return new int[] { array[i], array[j] };
                j++;
            }
        }
        return new int[0];
    }

    @Override
    public boolean classPhotos(
            List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean blueFlag = true;
        if (redShirtHeights.get(0) > blueShirtHeights.get(0))
            blueFlag = false;
        for (int i = 0; i < redShirtHeights.size(); i++) {
            if ((blueFlag && (redShirtHeights.get(i) > blueShirtHeights.get(i)))
                    || (!blueFlag && (redShirtHeights.get(i) < blueShirtHeights.get(i))))
                return false;
        }
        return true;
    }

    @Override
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        int res = 0;
        if (fastest) {
            Arrays.sort(redShirtSpeeds);
            Arrays.sort(blueShirtSpeeds);
            for (int i = 0; i < blueShirtSpeeds.length / 2; i++) {
                int temp = blueShirtSpeeds[i];
                blueShirtSpeeds[i] = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
                blueShirtSpeeds[blueShirtSpeeds.length - i - 1] = temp;
            }
        }
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            res += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }
        return res;
    }

    @Override
    public int[] findThreeLargestNumbers(int[] array) {
        int max = Integer.MIN_VALUE,
        mid = Integer.MIN_VALUE,
        min = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                min = mid;
                mid = max;
                max = array[i];
            } else if (array[i] > mid) {
                min = mid;
                mid = array[i];
            } else if (array[i] > min) {
                min = array[i];
            }
        }

        return new int[] { min, mid, max };
    }
}
