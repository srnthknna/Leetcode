// https://leetcode.com/problems/pascals-triangle-ii

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex == 0 || rowIndex > 0) {
            ans.add(1);
        }
        if (rowIndex == 1 || rowIndex > 1) {
            ans.add(1);
        }
        
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(ans.get(0));
            
            for (int j = 0; j < ans.size() - 1; j++) {
                current.add(ans.get(j) + ans.get(j + 1));
            }
            
            current.add(ans.get(ans.size() - 1));
            ans = current;
        }
        return ans;
    }
}