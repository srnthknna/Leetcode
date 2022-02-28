// https://leetcode.com/problems/prefix-and-suffix-search

class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();
    //https://www.youtube.com/watch?v=X630KoSDkeQ
    public WordFilter(String[] words) {
        for(int w = 0; w < words.length; w++) 
            for(int i = 0; i <= 10 && i <= words[w].length(); i++) 
                for(int j = 0; j <= 10 && j <= words[w].length(); j++) 
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w);
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */