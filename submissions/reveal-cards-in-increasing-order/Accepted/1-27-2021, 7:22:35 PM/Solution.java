// https://leetcode.com/problems/reveal-cards-in-increasing-order

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; ++i)
            queue.add(i);
        for (int card : deck) {
            ans[queue.pollFirst()] = card;
            if (!queue.isEmpty())
                queue.add(queue.pollFirst());
        }
        
        return ans;
    }
}