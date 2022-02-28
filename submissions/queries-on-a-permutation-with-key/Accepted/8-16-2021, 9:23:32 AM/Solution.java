// https://leetcode.com/problems/queries-on-a-permutation-with-key

class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for (int i = 1; i <= m; i++)
            list.add(i);
        
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int ind = list.indexOf(q);
            
            list.remove(ind);
            list.addFirst(q);
            
            queries[i] = ind;
        }
        return queries;
    }
}