// https://leetcode.com/problems/count-items-matching-a-rule

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int iter;
        if (ruleKey.equals("type")) {
            iter = 0;
        } else if (ruleKey.equals("color")) {
            iter = 1;
        } else {
            iter = 2;
        }
        for (List<String> item : items) {
            if (item.get(iter).equals(ruleValue)) count++;
        }
        return count;
    }
}