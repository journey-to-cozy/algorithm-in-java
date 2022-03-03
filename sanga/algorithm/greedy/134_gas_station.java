package src.sanga.algorithm.greedy;

/**
 * 원형으로 경로가 연결된 주유소 목록이 있다. 각 주유소는 gas[i] 만큼의 기름을 갖고 있으며,
 * 다음 주유소로 이동하는데 cost[i]가 필요하다. 기름이 부족하면 이동할 수 없다고 할 때,
 * 모든 주유소를 방문할 수 있는 출발점의 인덱스를 출력하라.
 * 출발점이 존재하지 않을 경우 -1을 리턴하며, 출발점은 유일하다.
 * https://leetcode.com/problems/gas-station/
 */
class GasStation {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}); // 3
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;

        int start = 0;
        int fuel = 0;

        for (int i = 0; i < gas.length; i++) {
            fuel += gas[i] - cost[i];
            if (fuel < 0) {
                start = i + 1;
                fuel = 0;
            }
        }

        return start;
    }
}