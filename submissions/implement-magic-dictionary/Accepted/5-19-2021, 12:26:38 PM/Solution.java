// https://leetcode.com/problems/implement-magic-dictionary

class MagicDictionary {
    Set<String> dict;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        dict = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word: dictionary)
            dict.add(word);
    }
    
    public boolean search(String searchWord) {
        for (String word : dict) {
            if (canMake(searchWord, word)) return true;
        }
        return false;
    }
    
    private boolean canMake(String searchWord, String wordInDict) {
        if (searchWord.length() != wordInDict.length()) return false;
        int count = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            if (searchWord.charAt(i) != wordInDict.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */