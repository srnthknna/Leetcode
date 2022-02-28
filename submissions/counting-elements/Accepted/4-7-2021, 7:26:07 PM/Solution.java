// https://leetcode.com/problems/counting-elements

class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) 
            set.add(n);
        int res = 0;
        for (int n : arr) 
            if (set.contains(n + 1)) 
                res++;
        return res;
    }
}