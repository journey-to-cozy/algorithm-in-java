package com.algorithm.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/gas-station/
 * gas[i]만큼의 기름을 가지고 있고 다음 주유소로 이동하는데 cost[i]가 필요함
 */
public class GasStation {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 모든 주유소 방문 가능 여부 판별
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int start = 0, fuel = 0;

        for (int i = 0; i < gas.length; i++) {
            // 출발점이 안 되는 지점 판별
            if (gas[i] + fuel < cost[i]) {
                start = i + 1;
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }

        return start;
    }
}
