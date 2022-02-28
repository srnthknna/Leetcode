// https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0, n = words.length;
        
        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                else {
                    totalChars += 1 + words[last].length();
                    last++;
                }
            }
            
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            
            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                int space = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    
                    for (int j = 0; j < space + (i - index < rest ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[last - 1]);
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}