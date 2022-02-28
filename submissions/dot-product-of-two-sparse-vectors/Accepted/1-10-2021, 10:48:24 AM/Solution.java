// https://leetcode.com/problems/dot-product-of-two-sparse-vectors

class SparseVector {
    
    Map<Integer, Integer> map;
    
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) 
            if (nums[i] != 0)
                map.put(i, nums[i]);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (Integer i : vec.map.keySet()) {
            if (this.map.containsKey(i))
                res += this.map.get(i) * vec.map.get(i);
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);