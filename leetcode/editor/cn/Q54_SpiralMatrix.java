//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟 👍 1102 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new Q54_SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            List<Integer> list=new ArrayList<>();
            int h=0;
            int l=0;
            while (m-l>1)
            {
                //第一个黑色模块，收录
                for(int i=l;i<n-1;i++)
                    list.add(matrix[h][i]);
                h++;
                m=m-1;
                //第二个红色模块收录
                for(int y=h-1;y<m;y++)
                    list.add(matrix[y][n-1]);
                l++;
                n--;
                //第三个绿色模块收录
                for(int i=n;i>=l;i--)
                    list.add(matrix[m][i]);
                //第四个蓝色模块收录
                for(int y=m;y>=h;y--)
                {
                    list.add(matrix[y][l-1]);
                    //特殊情况，跳出
                    if(list.size()==matrix[0].length*matrix.length)
                        break;
                }
                if(list.size()==matrix[0].length*matrix.length)
                    break;

            }
            //如图一，剩下一行没有收录，收录数据
            if(list.size()!=matrix[0].length*matrix.length)
                for(int i=l;i<=n-1;i++)
                    list.add(matrix[h][i]);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
