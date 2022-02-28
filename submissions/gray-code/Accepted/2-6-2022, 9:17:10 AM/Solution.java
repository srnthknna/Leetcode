// https://leetcode.com/problems/gray-code

class SolutionFirst {
    // https://www.youtube.com/watch?v=KOD2BFauQbA&list=PL-Jc9J83PIiE-181crLG1xSIWhTGKFiMY&index=44&ab_channel=Pepcoding
    // 0, 1 for n = 1
    // 00, 01 from above 0
    // 11, 10 from above 1 reverse and add
    public List<Integer> grayCode(int n) {  
        List<String> pres = grayCodeAsString(n);
        List<Integer> res = new ArrayList<>();
        for (String val : pres)
            res.add(Integer.parseInt(val, 2));
        return res;
    }
    
    private List<String> grayCodeAsString(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1");
        }
        
        List<String> pres = grayCodeAsString(n - 1);
        List<String> mres = new ArrayList<>();
        
        for (int i = 0; i < pres.size(); i++) {
            mres.add("0" + pres.get(i));
        }
        
        for (int i = pres.size() - 1; i >= 0; i--) {
            mres.add("1" + pres.get(i));
        }
        return mres;
    }
}
class Solution {
    // https://www.youtube.com/watch?v=KOD2BFauQbA&list=PL-Jc9J83PIiE-181crLG1xSIWhTGKFiMY&index=44&ab_channel=Pepcoding
    // 0, 1 for n = 1
    // 00, 01 from above 0
    // 11, 10 from above 1 reverse and add
    public List<Integer> grayCode(int n) {  
        if (n == 1) {
            return Arrays.asList(0, 1);
        }
        
        List<Integer> pres = grayCode(n - 1);
        List<Integer> mres = new ArrayList<>();
        
        for (int i = 0; i < pres.size(); i++) {
            mres.add(pres.get(i));
        }
        
        for (int i = pres.size() - 1; i >= 0; i--) {
            mres.add(pres.get(i) | (1 << n - 1));
        }
        return mres;
    }
}