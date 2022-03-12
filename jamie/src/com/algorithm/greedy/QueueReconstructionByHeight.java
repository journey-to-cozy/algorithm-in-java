package com.algorithm.greedy;

import java.util.*;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(i);
        }

        int[][] result = new int[people.length][2];

        for (int i = 0; i < people.length; i++) {
            int index = list.get(people[i][1]);
            result[index][0] = people[i][0];
            result[index][1] = people[i][1];
            list.remove(people[i][1]);
        }

        return result;
    }
}
