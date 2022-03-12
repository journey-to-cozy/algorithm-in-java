package com.algorithm.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 * https://earth-95.tistory.com/22
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        for (int i = 0; i < g.length && i < s.length; i++) {
            if (g[count] <= s[i])
                count++;
        }

        return count;
    }
}
