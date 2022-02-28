// https://leetcode.com/problems/permutations

class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> output = new ArrayList<>();
//         List<Integer> nums_list = new ArrayList<>();
//         for (int num : nums) nums_list.add(num);
//         backtrack(nums.length, nums_list, output, 0);
//         return output;
//     }
    
//     private void backtrack(int n, List<Integer> nums_list, List<List<Integer>> output, int start) {
//         if (n == start) output.add(new ArrayList<>(nums_list));
        
//         for (int i = start; i < n; i++) {
//             if(i>0 &&nums_list.get(i-1) == nums_list.get(i)) continue;
//             Collections.swap(nums_list, start, i);
//             backtrack(n, nums_list, output, start + 1);
//             Collections.swap(nums_list, start, i);
//         }
        
//     }
    
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(list, new ArrayList<>(), nums);
       return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
       if(tempList.size() == nums.length){
          list.add(new ArrayList<>(tempList));
       } else{
          for(int i = 0; i < nums.length; i++){ 
             if(tempList.contains(nums[i])) continue; // element already exists, skip
             tempList.add(nums[i]);
             backtrack(list, tempList, nums);
             tempList.remove(tempList.size() - 1);
          }
       }
    } 
}