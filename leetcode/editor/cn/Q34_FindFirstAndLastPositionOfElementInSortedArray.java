//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 👍 1687 👎 0

public class Q34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //数组有序，二分查找
            int[] res = new int[]{-1, -1};
            if (nums.length <=0 ) {
                return res;
            }
            int min = 0;
            int max = nums.length - 1;
            int mid = 0;

            while (min <= max) {
                mid = (min + max)/2;
                if (nums[mid] == target) {
                    int i = mid;
                    int j = mid;
                    while (i>=0 && nums[i] == target) { i--; } //往下找是否还有相同元素
                    while (j<nums.length && nums[j] == target) { j++; } //往上找是否还有相同元素
                    res[0] = i+1; //因为上面执行了i-- 所有要加回去
                    res[1] = j-1;
                    return res;
                } else if (nums[mid] > target) {
                    max = mid-1;
                } else if (nums[mid] < target) {
                    min = mid+1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
