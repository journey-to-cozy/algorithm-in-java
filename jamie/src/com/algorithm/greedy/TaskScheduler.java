package com.algorithm.greedy;

/**
 * https://leetcode.com/problems/task-scheduler/
 * 모든 태스크를 실행하기 위한 최소 간격 출력
 */
public class TaskScheduler {

    public static void main(String[] args) {

    }

    /**
     * 같은 task가 실행될 때는 n만큼 쉬어줘야 한다
     * 쉬는 동안에는 다른 작업을 수행하거나 idle을 수행할 수 있다
     */
    public int leastInterval(char[] tasks, int n) {

        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;

        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A'])
                maxCount++;

            else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
