package com.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/
 * 0을 완료하기 위해서는 1을 끝내야 한다는 것을 [0, 1] 쌍으로 표현하는 n개의 코스가 있다.
 * 코스 개수 n과 이 쌍들을 입력으로 받았을 때 모든 코스가 완료 가능한지 판별하라.
 */
public class CourseSchedule {
	public static void main(String[] args) {
		CourseSchedule solution = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}};

		System.out.println(solution.canFinish(numCourses, prerequisites));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			adjList.add(i, new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		boolean[] visited = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (hasCycle(adjList, i, visited, new boolean[numCourses]))
				return false;
		}
		return true;
	}

	private boolean hasCycle(List<List<Integer>> adjList, int i, boolean[] visited, boolean[] stack) {
		if (visited[i])
			return false;

		if (stack[i])
			return true;

		stack[i] = true;

		for (Integer v: adjList.get(i)) {
			if (hasCycle(adjList, v, visited, stack))
				return true;
		}

		visited[i] = true;

		return false;
	}
}
