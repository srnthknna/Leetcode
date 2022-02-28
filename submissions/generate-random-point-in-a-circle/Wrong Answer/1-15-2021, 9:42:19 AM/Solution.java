// https://leetcode.com/problems/generate-random-point-in-a-circle

class Solution {

    double r, x, y;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        double d = r * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[] {d * Math.cos(theta), d * Math.sin(theta)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */