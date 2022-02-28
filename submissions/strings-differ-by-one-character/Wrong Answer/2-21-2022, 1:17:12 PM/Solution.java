// https://leetcode.com/problems/strings-differ-by-one-character

class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String word : dict) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = '*';
                String currWord = String.valueOf(arr);
                if (set.contains(currWord)) return true;
                set.add(currWord);
            }
        }
        return false;
    }
}