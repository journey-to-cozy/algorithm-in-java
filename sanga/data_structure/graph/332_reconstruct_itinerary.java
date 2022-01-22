package src.sanga.data_structure.graph;

import java.util.*;

/**
 * [from, to]로 구성된 항공권 목록을 이용해 JRK에서 출발하는 여행 일정을 구성하라.
 * 여러 일정이 있는 경우 사전 어휘 순으로 방문한다.
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> route = new ArrayList() {{
            add(Arrays.asList("MUC", "LHR"));
            add(Arrays.asList("JFK", "MUC"));
            add(Arrays.asList("SFO", "SJC"));
            add(Arrays.asList("LHR", "SFO"));
        }};

        List<List<String>> route2 = new ArrayList() {{
            add(Arrays.asList("JFK", "SFO"));
            add(Arrays.asList("JFK", "ATL"));
            add(Arrays.asList("SFO", "ATL"));
            add(Arrays.asList("ATL", "JFK"));
            add(Arrays.asList("ATL", "SFO"));
        }};

        printResult(route); // JFK-MUC-LHR-SFO-SJC
        printResult(route2); // JFK-ATL-JFK-SFO-ATL-SFO
    }

    private static void printResult(List<List<String>> route) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();

        List<String> result = reconstructItinerary.findItinerary(route);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println();
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();

        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK", flights, result);

        return result;
    }

    private void dfs(String departure, Map<String, PriorityQueue<String>> flights, LinkedList<String> result) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, result);
        }
        result.addFirst(departure);
    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        for (List<String> ticket : tickets) {
            flights.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty()) {
                stack.push(flights.get(stack.peek()).poll());
            }
            result.add(0, stack.pop());
        }
        return result;
    }
}