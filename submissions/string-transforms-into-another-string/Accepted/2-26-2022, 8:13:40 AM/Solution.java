// https://leetcode.com/problems/string-transforms-into-another-string

class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        
        Map<Character, Character> conversionMapping = new HashMap<>();
        Set<Character> uniqueInStr2 = new HashSet<>();
        
        for (int i = 0; i < str1.length(); i++) {
            if (!conversionMapping.containsKey(str1.charAt(i))) {
                conversionMapping.put(str1.charAt(i), str2.charAt(i));
                uniqueInStr2.add(str2.charAt(i));
            } else if (conversionMapping.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            }
        }
        if (uniqueInStr2.size() < 26)
            return true;
        return false;
    }
}