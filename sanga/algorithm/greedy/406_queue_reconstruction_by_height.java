package src.sanga.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 여러 명의 사람들이 줄을 서 있다. 각각의 사람은 (h, k) 의 두 정수 쌍을 갖는데,
 * h는 그 사람의 키, k는 앞에 줄 서 있는 사람들 중 자신의 키 이상인 사람들의 수를 뜻한다.
 * 이 값이 올바르도록 줄을 재정렬하는 알고리즘을 작성하라.
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
class QueueReconstructionByHeight {

    public static void main(String[] args) {
        QueueReconstructionByHeight reconstruction = new QueueReconstructionByHeight();
        reconstruction.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});// [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    }

    public int[][] reconstructQueue(int[][] people) {
        // 키대로 내림차순, 키가 같을 경우 k 순대로 오름차순
        // [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> list = new ArrayList<>();

        // 각 person의 index는 k=person[1]과 같다.
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[list.size()][]);
    }
}