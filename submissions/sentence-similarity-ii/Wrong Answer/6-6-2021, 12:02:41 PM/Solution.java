// https://leetcode.com/problems/sentence-similarity-ii

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        
        Map<String, Integer> words = new HashMap<>();
        int index = 0;
        for (List<String> pairs : similarPairs) {
            if (!words.containsKey(pairs.get(0))) 
                words.put(pairs.get(0), index++);
            if (!words.containsKey(pairs.get(1))) 
                words.put(pairs.get(1), index++);
        }
        UF uf = new UF(words.size());
        
        for (List<String> pairs : similarPairs) {
            uf.union(words.get(pairs.get(0)), words.get(pairs.get(1)));
        }
        
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (!words.containsKey(sentence1[i])) return false;
            if (!words.containsKey(sentence2[i])) return false;
            if (!uf.isConnected(words.get(sentence1[i]), words.get(sentence2[i])));
        }
        return true;
    }
    
    class UF {
        int count;
        int[] root;
        int[] size;
        
        public UF (int n) {
            count = n;
            root = new int[n];
            size = new int[n];
            
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        
        public int count () {
            return count;
        }
        
        public int find (int p) {
            if (p != root[p]) {
                return find(root[p]);
            }
            return p;
        }
        
        public boolean isConnected (int p, int q) {
            return find(p) == find(q);
        }
        
        public void union (int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            if (rootP == rootQ) return;
            
            if (size[rootP] < size[rootQ]) {
                root[rootP] = rootQ;
                size[rootP] += size[rootQ];
            } else {
                root[rootQ] = rootP;
                size[rootQ] += size[rootP];
            }
        }
    }
}