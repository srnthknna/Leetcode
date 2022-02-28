// https://leetcode.com/problems/goat-latin

class Solution {
    public String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<>() {
            {
                add('a');
                add('A');
                add('e');
                add('E');
                add('i');
                add('I');
                add('o');
                add('O');
                add('u');
                add('U');
            }
        };
        
        String suff = "";
        StringBuilder sb = new StringBuilder();
        
        for (String word : S.split(" ")) {
            
            suff += "a";
            
            if (!vowels.contains(word.charAt(0))) {
                word = word.substring(1) + word.charAt(0);
            }
            
            sb.append(word).append("ma").append(suff).append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}