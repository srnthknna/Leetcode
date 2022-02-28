// https://leetcode.com/problems/online-stock-span

class StockSpanner {
    // https://www.youtube.com/watch?v=m4hvxzLoN_I&t=5393s&ab_channel=SDESkills
    Deque<Stock> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int valueLessThanOrEqualToMe = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            valueLessThanOrEqualToMe += stack.pop().valueLessThanOrEqualToMe;
        }
        stack.push(new Stock(price, valueLessThanOrEqualToMe));
        return stack.peek().valueLessThanOrEqualToMe;
    }
    
    public class Stock {
        int price;
        int valueLessThanOrEqualToMe;
        
        public Stock(int price, int valueLessThanOrEqualToMe) {
            this.price = price;
            this.valueLessThanOrEqualToMe = valueLessThanOrEqualToMe;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */