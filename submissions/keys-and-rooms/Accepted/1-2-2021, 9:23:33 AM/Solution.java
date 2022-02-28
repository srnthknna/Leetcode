// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isRoomsSeen = new boolean[rooms.size()];
        
        isRoomsSeen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.add(0);
        
        while (!stack.isEmpty()) {
            int key = stack.pop();
            for (int new_key : rooms.get(key)) {
                if (!isRoomsSeen[new_key]) {
                    stack.add(new_key);
                    isRoomsSeen[new_key] = true;
                }
            }
        }
        
        for (boolean isRoomSeen : isRoomsSeen) {
            if (!isRoomSeen) {
                return false;
            }
        }
        return true;
    }
}