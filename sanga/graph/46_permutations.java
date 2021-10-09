package src.sanga.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 서로 다른 정수를 입력받아 가능한 모든 순열을 리턴하라
 * https://leetcode.com/problems/permutations/
 */
class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> list = permutations.permute(new int[]{1, 2, 3});
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        dfs(result, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) continue;
            tempList.add(num);
            dfs(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }


    private void dfs2(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <= list.size(); i++) {
            list.add(i, nums[list.size()]);
            dfs2(result, list, nums);
            list.remove(i);
        }
    }

}