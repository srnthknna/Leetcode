// https://leetcode.com/problems/stone-game-vi

class Solution {
    public int stoneGameVI(int[] av, int[] bv) {
        int[][] sum = new int[av.length][3];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = new int[] {av[i] + bv[i], av[i], bv[i]};
        }
        
        Arrays.sort(sum, (a,b) -> Integer.compare(b[0], a[0]));
        
        int a = 0;
        int b = 0;
        for (int i = 0; i < av.length; i++) {
            if (i % 2 == 0) {
                a += sum[i][1];
            } else {
                b += sum[i][2];
            }
        }
        return Integer.compare(a, b);
    }
}