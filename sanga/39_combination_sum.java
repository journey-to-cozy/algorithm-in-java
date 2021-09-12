package src.sanga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 숫자 집합 candidates를 조합하여 합이 target이 되는 원소를 나열하라. 각 원소는 중복으로 나열 가능하다.
 * https://leetcode.com/problems/combination-sum/
 */
class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> sum = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);// {[7], [2,2,3]}
        List<List<Integer>> sum2 = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);// {[2,2,2,2], [2,3,3], [3,5]}
        for (List<Integer> integers : sum) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            tempList.add(candidates[i]);
            backtrack(list, tempList, candidates, remain-candidates[i], i); // 중복을 허용하므로 i+1이 아님
            tempList.remove(tempList.size() - 1);
        }
    }

}