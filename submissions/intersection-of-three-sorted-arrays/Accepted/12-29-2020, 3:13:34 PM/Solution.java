// https://leetcode.com/problems/intersection-of-three-sorted-arrays

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int l1 = 0, l2 = 0, l3 = 0;
        List<Integer> ret = new ArrayList<>();
        while (l1 < arr1.length && l2 < arr2.length && l3 < arr3.length) {
            if (arr1[l1] == arr2[l2] && arr2[l2] == arr3[l3]) {
                ret.add(arr1[l1]);
                l1++;l2++;l3++;
            } else {
                if (arr1[l1] < arr2[l2]) l1++;
                else if (arr2[l2] < arr3[l3]) l2++;
                else l3++;
            }
        }
        return ret;
    }
}