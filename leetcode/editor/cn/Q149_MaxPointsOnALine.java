//Given an array of points where points[i] = [xi, yi] represents a point on the
//X-Y plane, return the maximum number of points that lie on the same straight
//line.
//
//
// Example 1:
//
//
//Input: points = [[1,1],[2,2],[3,3]]
//Output: 3
//
//
// Example 2:
//
//
//Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//Output: 4
//
//
//
// Constraints:
//
//
// 1 <= points.length <= 300
// points[i].length == 2
// -10⁴ <= xi, yi <= 10⁴
// All the points are unique.
//
//
// Related Topics 几何 数组 哈希表 数学 👍 577 👎 0

import java.util.HashMap;
import java.util.Map;

//Max Points on a Line
public class Q149_MaxPointsOnALine{
    public static void main(String[] args) {
        Solution solution = new Q149_MaxPointsOnALine().new Solution();
        // 测试用例
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(solution.maxPoints(points1)); // 输出: 3

        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(solution.maxPoints(points2)); // 输出: 4

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxPoints(int[][] points) {
            if (points == null || points.length == 0) {
                return 0;
            }
            if (points.length <= 2) {
                return points.length;
            }

            int maxPoints = 0;

            for (int i = 0; i < points.length; i++) {
                Map<String, Integer> slopeMap = new HashMap<>();
                int overlap = 0;
                int maxCurrent = 0;

                for (int j = 0; j < points.length; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        overlap++;
                    } else {
                        int dx = points[j][0] - points[i][0];
                        int dy = points[j][1] - points[i][1];
                        int gcd = gcd(dx, dy);
                        dx /= gcd;
                        dy /= gcd;

                        String slope = dy + "/" + dx;
                        slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                        maxCurrent = Math.max(maxCurrent, slopeMap.get(slope));
                    }
                }

                maxPoints = Math.max(maxPoints, maxCurrent + overlap + 1);
            }

            return maxPoints;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
