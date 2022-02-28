// https://leetcode.com/problems/largest-number

class Solution {
    public String largestNumber(int[] nums) {
        String[] sortedNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(sortedNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        
        if (sortedNums[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String num : sortedNums)
            sb.append(num);
        return sb.toString();
    }
}