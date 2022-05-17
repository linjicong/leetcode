//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1242 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18_FourSum{
  public static void main(String[] args) {
       Solution solution = new Q18_FourSum().new Solution();
       int[] nums = {-2,-1,-1,1,1,2,2};
       List<List<Integer>> result=solution.fourSum(nums, 0);
       System.out.println(result);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) return result;
        int length = nums.length;
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                int h = j + 1;
                int k = length - 1;
                while (h < k){
                    int sum = nums[i] + nums[j] + nums[h] + nums[k];
                    if (sum < target){
                        h++;
//                        while (h < k && nums[h] == nums[h + 1]) h++;
                    }else if(sum>target){
                        k--;
//                        while (h < k && nums[k] == nums[k - 1]) k--;
                    }else{
                        boolean exist = false;
                        for (List<Integer> integers : result) {
                            if (integers.get(0).equals(nums[i]) && integers.get(1).equals(nums[j]) && integers.get(2).equals(nums[h]) && integers.get(3).equals(nums[k])) {
                                exist = true;
                                break;
                            }
                        }
                        if(!exist) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[h], nums[k]));
                        }
                        k--;
                        h++;
//                        while (h < k && nums[h] == nums[h + 1]) h++;
//                        while (h < k && nums[k] == nums[k - 1]) k--;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}