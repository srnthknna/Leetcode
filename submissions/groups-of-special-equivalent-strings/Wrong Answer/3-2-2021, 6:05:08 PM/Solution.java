// https://leetcode.com/problems/groups-of-special-equivalent-strings

class Solution {
   public int numSpecialEquivGroups(String[] A) {
        Set<Integer> set = new HashSet<>();
        for (String s : A) {
            set.add(hashStr(s));
        }
        return set.size();
    }
    
    private int hashStr(String str) {
        int evenHash = 6;
        int oddHash = 19;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evenHash *= arr[i];
            } else {
                oddHash *= arr[i];
            }
        }
        return evenHash + oddHash;
    }
}