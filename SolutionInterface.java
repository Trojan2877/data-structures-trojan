import java.util.List;
import java.util.Set;

public interface SolutionInterface {
    
    public int[] removeDuplicates(int[] nums);

    public Set<Integer> removeDuplicates1(int[] nums);

    public int[] removeElement(int[] nums, int val);
    
    public int[] removeElement1(int[] nums, int val);

    public int[] moveZeros(int[] nums);

    public int candy(int[] ratings);

    public int[] productExceptSelf(int[] input);

    public List<String> summaryRanges(int[] input);

    public int[] reverseArray(int[] input);

    public int[] findMaxMin(int[] input);

    public int[] findMinMax1(int[] input);

    public int majorityElement(int[] input);

    public int bestStock(int[] prices);

    public int romanToInt(String s);

    public int lengthOfLastWord(String s);

    public String longestCommonPrefix(String[] strs);

    public int strStr(String haystack, String needle);

    public int needleInHaystack(String haystack, String needle);

    public int candy1(int[] ratings);

    public boolean validPalindrome(String s);

    public boolean isSubsequence(String s, String t);

    public boolean canConstruct(String ransomNote, String magazine);

    public boolean isIsomorphic(String s, String t);

    public boolean wordPattern(String pattern, String s);

    public boolean isAnagram(String s, String t);

    public int[] twoSum(int[] nums, int target);

    public boolean isHappy(int n);

    public boolean isValid(String s);

    public ListNode mergeTwoLists(ListNode list1, ListNode list2);

    public String reverseString(String str);

    public int majorityElement1(int[] arr);

    public int LargestElement(int[] nums);

    public int secondLargest(int[] nums);

    public int maxSubArray(int[] nums);

    public int lengthOfLongestSubstring(String s);
}