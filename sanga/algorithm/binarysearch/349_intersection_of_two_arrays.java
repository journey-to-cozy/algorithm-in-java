package src.sanga.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 두 배열의 교집합을 구하라.
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        intersectionOfTwoArrays.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}); // [2]
        intersectionOfTwoArrays.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}); // [9, 4]
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);

        for (int num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int element : set) {
            result[i++] = element;
        }

        return result;
    }

    private boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            }

            if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j += 1;
            } else if (nums1[i] < nums2[j]) {
                i += 1;
            } else {
                set.add(nums1[i]);
                i += 1;
                j += 1;
            }
        }

        int[] result = new int[set.size()];
        int k = 0;
        for (int element : set) {
            result[k++] = element;
        }

        return result;
    }

}