// https://leetcode.com/problems/count-items-matching-a-rule

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int iter = getItemKeyNo(ruleKey);
        for (List<String> item : items) {
            if (item.get(iter).equals(ruleValue)) count++;
        }
        return count;
    }

    private int getItemKeyNo(String ruleKey) {
        if (ruleKey.equals("type")) {
            return 0;
        } else if (ruleKey.equals("color")) {
            return 1;
        } else {
            return 2;
        }
    }
}