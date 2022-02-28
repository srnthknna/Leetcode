// https://leetcode.com/problems/satisfiability-of-equality-equations

// I had to revise the UF from this example problem here https://leetcode.com/problems/number-of-provinces/submissions/

class Solution {
    // Union Find with path compression and rank to balance the search
    
    class UnionFind {
        int parent[], rank[];
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                } else if (rank[py] > rank[px]) {
                    parent[px] = py;
                } else {
                    parent[py] = px;
                    rank[px]++;
                }
            }
        }
    }
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        // if equal then union them
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                uf.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }
        
        // if not equal then if they are connect its a collision so cannot satisfy the equation
        for (String eq : equations) {
            if (eq.charAt(1) != '=') {
                int px = uf.find(eq.charAt(0) - 'a');
                int py = uf.find(eq.charAt(3) - 'a');
                if (px == py)
                    return false;
            }
        }
        return true;
    }
}