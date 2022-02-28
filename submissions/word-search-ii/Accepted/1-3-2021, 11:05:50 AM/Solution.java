// https://leetcode.com/problems/word-search-ii

class Solution {
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (searchWords(board, word)) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean searchWords(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && validator(i, j, 0, board, word)) {
                    return true;
                } 
            }
        }
        return false;
    }
    
    private boolean validator(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) return true;
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (validator(i + 1, j, index + 1, board, word) ||
           validator(i - 1, j, index + 1, board, word) ||
           validator(i, j + 1, index + 1, board, word) ||
           validator(i, j - 1, index + 1, board, word)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}