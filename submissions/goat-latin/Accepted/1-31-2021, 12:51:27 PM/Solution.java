// https://leetcode.com/problems/goat-latin

class Solution {
    private static Set<Character> vowels = new HashSet<>() {
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
    public String toGoatLatin(String S) {
        
        StringBuilder suff = new StringBuilder();
        suff.append("a");
        StringBuilder sb = new StringBuilder();
        
        for (String word : S.split(" ")) {
                        
            if (!vowels.contains(word.charAt(0))) {
                word = word.substring(1) + word.charAt(0);
            }
            
            sb.append(word).append("ma").append(suff.toString()).append(" ");
            suff.append("a");
        }
        
        return sb.toString().trim();
    }
}