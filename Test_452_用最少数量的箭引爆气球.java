package yang.algorithm.greedy;

import java.util.Arrays;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * <p>
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 */
public class Test_452_用最少数量的箭引爆气球 {

    public static void main(String[] args) {
//        int[][] arr = {{1, 2}, {1, 2}, {1, 2}, {1, 12}};
        int[][] arr = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        int minArrowShots = findMinArrowShots(arr);
        System.out.println(minArrowShots);

        System.out.println(2147483646>-2147483645);
    }

    public static int findMinArrowShots(int[][] points) {
        int length = points.length;
        Arrays.sort(points, (i, j) -> i[1] > j[1] ? 1 : -1);
        int right = points[0][1];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (points[i][0] > right) {
                right = points[i][1];
                count++;
            }
        }
        return count;
    }
}
