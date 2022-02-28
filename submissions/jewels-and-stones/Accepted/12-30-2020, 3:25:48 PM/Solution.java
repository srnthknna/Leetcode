// https://leetcode.com/problems/jewels-and-stones

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            jewelsSet.add(j);
        }
        
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewelsSet.contains(s)) count++;
        }
        return count;
    }
}