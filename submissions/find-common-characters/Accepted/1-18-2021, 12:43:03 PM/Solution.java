// https://leetcode.com/problems/find-common-characters

class Solution {
     public List<String> commonChars(String[] A) {
         int[] hash1, hash2;
         
         hash1 = fillArray(A[0]);
         
         for (int i = 1; i < A.length; i++) {
             hash2 = fillArray(A[i]);
             intersection(hash1, hash2);
         }
         
         List<String> result = new ArrayList<>();
         
         for (int i = 0; i < hash1.length; i++) {
             while (hash1[i] > 0) {
                 result.add((char) (i + 'a') + "");
                 hash1[i]--;
             }
         }
         return result;
    }
    
    private int[] fillArray(String word) {
        int[] charCount = new int[26];
        for (char c : word.toCharArray()) {
            charCount[c - 'a']++;
        }
        return charCount;
    }
    
    private void intersection(int[] hash1, int[] hash2) {
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] != hash2[i]) hash1[i] = Math.min(hash1[i], hash2[i]);
        }
    }

}