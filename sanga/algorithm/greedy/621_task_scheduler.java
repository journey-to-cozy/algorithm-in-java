package src.sanga.algorithm.greedy;

/**
 * A에서 Z로 표현된 태스크가 있다. 각 간격마다 CPU는 한 번의 태스크만 실행할 수 있고,
 * n번의 간격 내에는 동일한 태스크를 실행할 수 없다.
 * 더 이상 태스크를 실행할 수 없는 경우 idle 상태가 된다.
 * 모든 태스크를 실행하기 위한 최소 간격을 출력하라.
 * https://leetcode.com/problems/task-scheduler/
 */
class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2); // ABiABiAB, 8
        taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'C', 'C'}, 1); // ABCABCA, 7
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        // 첫번째 문제에서 max =3, maxCount = 2 (3번 나오는 값 2개임)
        // 두번째 문제에서 max =3, maxCount = 1 (3번 나오는 값 A 1개임)
        int max = 0, maxCount = 0;

        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }

}