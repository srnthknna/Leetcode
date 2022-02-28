// https://leetcode.com/problems/logger-rate-limiter

class Logger {

    Map<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Logger() {
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        
        Integer oldTimestamp = map.get(message);
        
        if (oldTimestamp + 10 > timestamp) {
            return false;
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */