// https://leetcode.com/problems/build-an-array-with-stack-operations

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int input = 1;
        
        for (int i : target) {
            while (input < i) {
                res.add("Push");
                res.add("Pop");
                input++;
            }
            res.add("Push");
            input++;
        }
        return res;
    }
}