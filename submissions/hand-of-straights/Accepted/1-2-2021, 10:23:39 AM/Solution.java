// https://leetcode.com/problems/hand-of-straights

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> cards_map = new TreeMap<>();
        
        for (int card : hand) {
            if (!cards_map.containsKey(card)) {
                cards_map.put(card, 1);
            } else {
                cards_map.put(card, cards_map.get(card) + 1);
            }
        }
        
        while(cards_map.size() > 0) {
            int card = cards_map.firstKey();
            
            for (int i = card; i < card + W; i++) {
                if (!cards_map.containsKey(i)) return false;
                int count = cards_map.get(i);
                if (count == 1) {
                    cards_map.remove(i);
                } else {
                    cards_map.put(i, count - 1);
                }
            }
        }
        
        return true;
    }
}