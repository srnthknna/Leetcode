// https://leetcode.com/problems/distribute-candies

class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> uniqueCandy = new HashSet<>(candyType.length);
        for (int candy : candyType) uniqueCandy.add(candy);
        return Math.min(uniqueCandy.size(), candyType.length / 2);
    }
}