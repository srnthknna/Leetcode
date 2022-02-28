// https://leetcode.com/problems/graph-valid-tree

class Solution {
    class UF {
        int count;
        int[] root;
        int[] size;
        
        public UF(int n) {
            count = n;
            root = new int[n];
            size = new int[n];
            
            for (int i = 0; i < n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        
        public int count() {
            return count;
        }
        
        public int find(int p) {
            if (root[p] != p) {
                return find(root[p]);
            }
            return p;
        }
        
        public boolean isConntected(int p, int q) {
            return find(p) == find(q);
        }
        
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            if (rootP == rootQ) return false;
            
            if (size[rootP] > size[rootQ]) {
                root[rootP] = rootQ;
                size[rootP] += size[rootQ];
            } else{
                root[rootQ] = rootP;
                size[rootQ] += size[rootP];
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) return false;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                return false;
        }
        return true;
    }
}