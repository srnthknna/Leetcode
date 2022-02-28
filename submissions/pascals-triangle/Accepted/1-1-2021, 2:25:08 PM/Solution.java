// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        if (numRows == 0) return tri;
        List<Integer> first = new ArrayList<>(), prev, curr;
        first.add(1);
        tri.add(first);
        
        for (int i = 1; i < numRows; i++) {
            prev = tri.get(i - 1);
            curr =  new ArrayList<>();
            curr.add(1);
            
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            
            curr.add(1);
            tri.add(curr);
        }
        
        return tri;
    }
}