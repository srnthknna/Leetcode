// https://leetcode.com/problems/find-common-characters

class Solution {
     public List<String> commonChars(String[] A) {
        
        int[] hash1, hash2;
        
        hash1 = fillArray(A[0]);
        
        for(int i=1;i<A.length;i++){
            
            hash2 = fillArray(A[i]);
            
            intersection(hash2, hash1);
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int i=0;i<26;i++){
            while(hash1[i]!=0){
                ans.add(Character.toString(i + 'a'));
                hash1[i]--;
            }
        }
        return ans;
    }
    
    int [] fillArray(String a) {
        int [] arr = new int [26];
        for (char c : a.toCharArray()) {
            arr[c-'a']++;
        }
        return arr;
    }
    void intersection(int [] f, int [] arr) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != f[i]) {
                arr[i] = Math.min(f[i], arr[i]);
            }   
        }
    }
}