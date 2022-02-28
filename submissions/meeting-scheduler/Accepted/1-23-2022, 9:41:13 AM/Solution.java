// https://leetcode.com/problems/meeting-scheduler

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((slot1, slot2) -> (slot1[0] - slot2[0]));
        
        for (int[] slot1 : slots1) {
            if (slot1[1] - slot1[0] >= duration)
            queue.offer(slot1);
        }
        
        for (int[] slot2 : slots2) {
            if (slot2[1] - slot2[0] >= duration)
            queue.offer(slot2);
        }
        
        while (queue.size() > 1) {
            int[] slot1 = queue.poll();
            int[] slot2 = queue.peek();
            
            if (slot1[1] >= slot2[0] + duration) {
                return new ArrayList<>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<>();
    }
}