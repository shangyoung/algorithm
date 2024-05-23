package yang.algorithm.greedy;

import java.util.Arrays;

/**
 * 是不是使用双指针进行串联
 * [1,4],[3,4],[4,6]
 * [1,2],[1,2],[1,2]
 * 集合之间的关系
 * 包含 ：i0<=j0,i1>j0, i1 >j1;
 * 相交: i0<=j0, i1>j0,i1<=j1;
 * 相离: i0<j0, i1<=j0, i1<j1;
 * <p>
 * 移除区间的最小数量
 * remove max(end-start),解决不了         int[][] integers = {{58,95},{66,98},{82,97},{95,99}};
 * 前一个的存在会影响到后面的结果，动态规划
 * 使用动态规划好像是行不通的，因为动态规划在乎的每一个元素和上个元素必然存在影响，当前问题不确定是否产生影响,而且当前的影响不一定会对后面的结果产生影响。
 * 看了答案是可以使用动态规划的，需要列出状态转移方程。
 * 最终的判断使用的是 i1<=j0
 * 难点应该是为什么用的是右边的排序。
 *
 * 关于为什么是按照区间右端点排序？
 * 官解里对这个描述的非常清楚了，这个题其实是预定会议的一个问题，给你若干时间的会议，然后去预定会议，
 * 那么能够预定的最大的会议数量是多少？核心在于我们要找到最大不重叠区间的个数。 如果我们把本题的区间看成是会议，
 * 那么按照右端点排序，我们一定能够找到一个最先结束的会议，而这个会议一定是我们需要添加到最终结果的的首个会议。
 * （这个不难贪心得到，因为这样能够给后面预留的时间更长）。
 *
 * 关于为什么是不能按照区间左端点排序？
 * 这里补充一下为什么不能按照区间左端点排序。同样地，我们把本题的区间看成是会议，如果“按照左端点排序，我们一定能够找到一个最先开始的会议”，
 * 但是最先开始的会议，不一定最先结束。。
 *
 * 作者：IamChuancey
 * 链接：https://leetcode.cn/problems/non-overlapping-intervals/solutions/1263171/tan-xin-jie-fa-qi-shi-jiu-shi-yi-ceng-ch-i63h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class Test_435_无重叠区间 {
    public static void main(String[] args) {
//        int[][] integers = {{1, 4}, {3, 4},{2,3}, {4, 6}};
//        int[][] integers = {{1,100},{11,22},{1,11},{2,12}};
//        int[][] integers = {{1,3},{2,8},{2,10},{3,4},{11,12}};
        int[][] integers = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
//        int[][] integers = {{58,95},{66,98},{82,97},{95,99}};
        /**
         * {-73,-26},
         * {-62,-49},{-40,-26},{30,47},{58,95},{95,99}
         *
         */
        int res = eraseOverlapIntervals(integers);
        System.out.println(res);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, (i, j) -> i[1] - j[1]);
        int right = intervals[0][1];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                count++;
            }
        }
        return length - count;
    }
}
