// https://leetcode.com/problems/maximum-69-number

class Solution {
public int maximum69Number (int num) {
    Stack<Integer> stack = new Stack<>();
    int res = 0, cnt = 0;
    while(num > 0){
        stack.push(num%10);
        num/=10;
    }
    while(!stack.isEmpty()){
        int cur = stack.pop();
        if(cur == 6 && cnt == 0){
            cur = 9;
            cnt++;
        }
        res = res * 10 + cur;
    }
    return res;
}
}