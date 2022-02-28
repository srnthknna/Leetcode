// https://leetcode.com/problems/redundant-connection-ii

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        for (int[] edge : edges) {
            if (uf.isConntected(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }
    
    class UF {
        int count;
        int[] root;
        
        public UF(int n) {
            count = n;
            root = new int[n];
            
            for (int i = 0; i < n; i++) {
                root[i] = i;
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
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            root[rootP] = rootQ;

        }
    }
}