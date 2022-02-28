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
    
    // But instead of getting them as string
    // we use 0 1 as decimal first
    // for 2 bit we use 00 -> 0 and  01 -> 1 directly
    // for next 11, and 10 we add 2^(n - 1) which is 2 to prev answer 2, 3
    public List<Integer> grayCode(int n) {  
        if (n == 1) {
            return Arrays.asList(0, 1);
        }
        
        List<Integer> pres = grayCode(n - 1);
        List<Integer> mres = new ArrayList<>();
        
        for (int i = 0; i < pres.size(); i++) {
            mres.add(pres.get(i));
        }
        
        int powerVal = (int)Math.pow(2, n - 1);
        for (int i = pres.size() - 1; i >= 0; i--) {
            mres.add(pres.get(i) + powerVal);
        }
        return mres;
    }
}