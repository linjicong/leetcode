//There are n children standing in a line. Each child is assigned a rating
//value given in the integer array ratings.
//
// You are giving candies to these children subjected to the following
//requirements:
//
//
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
//
//
// Return the minimum number of candies you need to have to distribute the
//candies to the children.
//
//
// Example 1:
//
//
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1,
//2 candies respectively.
//
//
// Example 2:
//
//
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2,
//1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
//
//
//
// Constraints:
//
//
// n == ratings.length
// 1 <= n <= 2 * 10⁴
// 0 <= ratings[i] <= 2 * 10⁴
//
//
// Related Topics 贪心 数组 👍 1597 👎 0

//Candy
public class Q135_Candy{
    public static void main(String[] args) {
        Solution solution = new Q135_Candy().new Solution();
        // 测试用例
        System.out.println(solution.candy(new int[]{1, 0, 2})); // 输出: 5
        System.out.println(solution.candy(new int[]{1, 2, 2})); // 输出: 4

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            candies[0] = 1;

            // 从左到右遍历
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                } else {
                    candies[i] = 1;
                }
            }

            // 从右到左遍历
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }

            // 计算总糖果数
            int totalCandies = 0;
            for (int candy : candies) {
                totalCandies += candy;
            }

            return totalCandies;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
