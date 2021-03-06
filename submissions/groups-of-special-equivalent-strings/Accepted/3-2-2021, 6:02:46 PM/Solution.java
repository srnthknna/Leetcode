// https://leetcode.com/problems/groups-of-special-equivalent-strings

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String S : A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            set.add(Arrays.toString(count));
        }
        return set.size();
    }
}