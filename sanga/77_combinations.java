package src.sanga;

import java.util.ArrayList;
import java.util.List;

/**
 * 전체 수 n을 입력받아 k개의 조합을 리턴하라
 * https://leetcode.com/problems/combinations/
 */
class Combinations {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> list = combinations.combine(4, 2);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            dfs(result, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}