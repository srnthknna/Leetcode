// https://leetcode.com/problems/number-of-provinces

class Solution1 {
    // Quick union is needed to assign the same parent root value to all the nodes in a set
    class UnionFind {
        int root[];
        
        public UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int find(int x) {
            return root[x];
        }
        
        public void union(int x, int y) {
            int findx = find(x);
            int findy = find(y);
            if (findx != findy) {
                for (int i = 0; i < root.length; i++)
                    if (root[i] == findy)
                        root[i] = findx;
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        UnionFind sets = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    sets.union(i, j);
                }
            }
        }
        
        Set<Integer> answer = new HashSet();
        for (int i : sets.root)
            answer.add(i);
        return answer.size();
    }
}
class Solution {
    // Union find with path compression
    class UnionFind {
        int root[];
        int rank[];
        int count = 0;
        
        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            count = n;
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int findx = find(x);
            int findy = find(y);
            if (findx != findy) {
                if (rank[findx] > rank[findy]) {
                    root[findy] = findx;
                } else if (rank[findx] < rank[findy]) {
                    root[findx] = findy;
                } else {
                    root[findy] = findx;
                    rank[findx] += 1;
                }
                count--;
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        UnionFind sets = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    sets.union(i, j);
                }
            }
        }
        
        return sets.count;
    }
}