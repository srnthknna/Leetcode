// https://leetcode.com/problems/design-a-leaderboard

class Leaderboard {
    Map<Integer, Integer> scores;
    TreeMap<Integer, Integer> sortedScores;

    public Leaderboard() {
        scores = new HashMap<>();
        sortedScores = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, score);
            sortedScores.put(score, sortedScores.getOrDefault(score, 0) + 1);
        } else {
            int prevScore = scores.get(playerId);
            int prevCount = sortedScores.get(prevScore);
            
            if (prevCount == 1) {
                sortedScores.remove(prevScore);
            } else {
                sortedScores.put(prevScore, prevCount - 1);
            }
            
            int currentScore = prevScore + score;
            scores.put(playerId, currentScore);
            sortedScores.put(currentScore, sortedScores.getOrDefault(currentScore, 0) + 1);
        }
    }
    
    public int top(int k) {
        int count = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : sortedScores.entrySet()) {
            int numOfOccurence = entry.getValue();
            int score = entry.getKey();
            
            while (numOfOccurence > 0) {
                numOfOccurence--;
                count++;
                sum += score;
                
                if (count == k) {
                    return sum;
                }
            }
            
            if (count == k) {
                return sum;
            }
            
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int prevScore = scores.get(playerId);
        int playerCount = sortedScores.get(prevScore);
        if (playerCount == 1) {
            sortedScores.remove(prevScore);
        } else {
            sortedScores.put(prevScore, playerCount - 1);
        }
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */