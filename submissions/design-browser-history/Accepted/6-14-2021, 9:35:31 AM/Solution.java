// https://leetcode.com/problems/design-browser-history

class BrowserHistory {

    Stack<String> back;
    Stack<String> forward;
    public BrowserHistory(String homepage) {
        back = new Stack<>();
        forward = new Stack<>();
        back.add(homepage);
    }
    
    public void visit(String url) {
        forward.clear();
        back.add(url);
    }
    
    public String back(int steps) {
        while (back.size() > 1 && steps > 0) {
            forward.push(back.peek());
            back.pop();
            steps--;
        }
        return back.peek();
    }
    
    public String forward(int steps) {
        while (forward.size() > 0 && steps > 0) {
            back.push(forward.peek());
            forward.pop();
            steps--;
        }
        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */