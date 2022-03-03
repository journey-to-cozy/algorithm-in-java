package src.sanga.algorithm.greedy;

import java.util.Arrays;

/**
 * 아이들에게 1개씩 쿠키를 나눠주어야 한다. 각 아이 child_i 마다 만족하는 최소 쿠키의 크기인 g[i]를 갖고 있다.
 * 각 쿠키 jar는 크기 s[j] 를 갖고 있으며, s[j]>=g[i] 이어야 아이가 만족하는 쿠키를 받는다.
 * 최대 몇 명의 아이들에게 쿠키를 줄 수 있는지 출력하라.
 * https://leetcode.com/problems/assign-cookies/
 */
class AssignCookies {
    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        assignCookies.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}); // 1
        assignCookies.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}); // 2
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < g.length && j < s.length){
            if (g[i] <= s[j]) i++;
            j++;
        }

        return i;
    }

}