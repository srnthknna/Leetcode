// https://leetcode.com/problems/perfect-squares

class Solution {
  Set<Integer> square_nums = new HashSet<Integer>();

  protected boolean is_divided_by(int n, int count) {
    if (count == 1) {
      return square_nums.contains(n);
    }

    for (Integer square : square_nums) {
      if (is_divided_by(n - square, count - 1)) {
        return true;
      }
    }
    return false;
  }

  public int numSquares(int n) {
//     this.square_nums.clear();

//     for (int i = 1; i * i <= n; ++i) {
//       this.square_nums.add(i * i);
//     }

//     int count = 1;
//     for (; count <= n; ++count) {
//       if (is_divided_by(n, count))
//         return count;
//     }
//     return count;
      
      // four-square and three-square theorems.
    while (n % 4 == 0)
      n /= 4;
    if (n % 8 == 7)
      return 4;

    if (this.isSquare(n))
      return 1;
    // enumeration to check if the number can be decomposed into sum of two squares.
    for (int i = 1; i * i <= n; ++i) {
      if (this.isSquare(n - i * i))
        return 2;
    }
    // bottom case of three-square theorem.
    return 3;
  }
    
  protected boolean isSquare(int n) {
    int sq = (int) Math.sqrt(n);
    return n == sq * sq;
  }
}