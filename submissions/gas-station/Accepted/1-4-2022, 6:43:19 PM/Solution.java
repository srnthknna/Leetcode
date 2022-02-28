// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0;
        int curr_tank = 0;
        int starting_point = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int temp_cost = gas[i] - cost[i];
            total_tank += temp_cost;
            curr_tank += temp_cost;
            
            if (curr_tank < 0) {
                starting_point = i + 1;
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_point : -1;
    }
}