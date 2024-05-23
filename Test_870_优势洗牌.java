package yang.algorithm.greedy;

import java.util.Arrays;

public class Test_870_优势洗牌 {

    public static void main(String[] args) {
        int[] nums1 = {12,24,8,32}, nums2 = {13, 25, 32, 11};
        int[] ints = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 分别排序nums1和nums2，使用数组记住坐标
     */
        public static int[] advantageCount(int[] nums1, int[] nums2) {
            int length = nums1.length;
            Integer[] idx1 = new Integer[length];
            Integer[] idx2 = new Integer[length];
            int[] res = new int[length];
            //设置默认值
            for (int i = 0; i < length; i++) {
                idx1[i] = i;
                idx2[i] = i;
            }
            //排序
            Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
            Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);
            int left = 0, right = length - 1;

            for (int i = 0; i < length; i++) {
                if (nums1[idx1[i]] > nums2[idx2[left]]) {
                    res[idx2[left]] = nums1[idx1[i]];
                    left++;
                } else {
                    res[idx2[right]] = nums1[idx1[i]];
                    right--;
                }
            }
            return res;
        }


}
