// https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket

class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;
        for (int a : arr) {
            sum += a;
            if (sum > 5000) {
                break;
            }
            count++;
        }
        return count;
    }
}