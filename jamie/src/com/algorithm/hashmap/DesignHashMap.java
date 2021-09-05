package com.algorithm.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-hashmap
 * put(key, value): 키, 값을 해시맵에 삽입. 이미 존재하는 키라면 업데이트
 * get(key): 키에 해당하는 값 조회. 키가 존재하지 않는다면 -1 리턴
 * remove(key): 키에 해당하는 키, 값을 해시맵에서 삭제
 */
public class DesignHashMap {
}

class MyHashMap {
	Map<Integer, Integer> map;

	/** Initialize your data structure here. */
	public MyHashMap() {
		map = new HashMap<>();
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		map.put(key, value);
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		return map.get(key);
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		map.remove(key);
	}
}

/**
 * 배열로 구현
 */
class MyHashMap2 {
	int[] map;

	public MyHashMap2() {
		map = new int[1000001];
		Arrays.fill(map, -1);
	}

	public void put(int key, int value) {
		map[key] = value;
	}

	public int get(int key) {
		return map[key];
	}

	public void remove(int key) {
		map[key] = -1;
	}
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */