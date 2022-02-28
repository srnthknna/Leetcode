// https://leetcode.com/problems/reveal-cards-in-increasing-order

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> queue = new LinkedList();
        int N = deck.length;
        for (int i = 0; i < N; i++)
            queue.add(i);
        int[] ans = new int[N];
        for (int card : deck) {
            ans[queue.pollFirst()] = card;
            if (!queue.isEmpty()) {
                queue.add(queue.pollFirst());
            }
        }
        return ans;
    }
}