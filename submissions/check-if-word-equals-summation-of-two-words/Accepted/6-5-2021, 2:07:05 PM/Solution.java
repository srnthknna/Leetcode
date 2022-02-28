// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return intVal(firstWord) + intVal(secondWord) == intVal(targetWord);
    }
    
    public int intVal(String word) {
        int result = 0;
        for (char c : word.toCharArray()) {
            result = result * 10 + (c - 'a');
        }
        return result;
    }
}