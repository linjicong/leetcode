//Suppose an array of length n sorted in ascending order is rotated between 1
//and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//
// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
//
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
// Given the sorted rotated array nums of unique elements, return the minimum
//element of this array.
//
// You must write an algorithm that runs in O(log n) time.
//
//
// Example 1:
//
//
//Input: nums = [3,4,5,1,2]
//Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.
//
//
// Example 2:
//
//
//Input: nums = [4,5,6,7,0,1,2]
//Output: 0
//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4
//times.
//
//
// Example 3:
//
//
//Input: nums = [11,13,15,17]
//Output: 11
//Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
//
//
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// All the integers of nums are unique.
// nums is sorted and rotated between 1 and n times.
//
//
// Related Topics 数组 二分查找 👍 1182 👎 0

//Find Minimum in Rotated Sorted Array
public class Q153_FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new Q153_FindMinimumInRotatedSortedArray().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("Input array is invalid");
            }

            int left = 0;
            int right = nums.length - 1;

            // 如果数组没有旋转，直接返回第一个元素
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            while (left < right) {
                int mid = left + (right - left) / 2;

                // 如果中间元素大于右边界元素，说明最小值在右半部分
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    // 否则，最小值在左半部分或就是中间元素
                    right = mid;
                }
            }

            // 最终 left 和 right 相遇，指向最小元素
            return nums[left];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
