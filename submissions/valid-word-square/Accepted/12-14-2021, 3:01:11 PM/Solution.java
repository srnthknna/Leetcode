// https://leetcode.com/problems/valid-word-square

class Solution {
    public boolean validWordSquare(List<String> words){
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (!check(i, j, words)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(int i, int j, List<String> words) {
        char c1 = ' ';
        char c2 = ' ';
        
        try {
            c1 = words.get(i).charAt(j);
        } catch (Exception e) {
            
        }
        
        try {
            c2 = words.get(j).charAt(i);
        } catch (Exception e) {
            
        }
        
        return c1 == c2;
    }
}