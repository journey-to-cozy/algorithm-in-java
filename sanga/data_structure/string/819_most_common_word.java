package src.sanga.data_structure.string;

import java.util.*;

class MostCommonWord {

    public String mostCommonWord(String str, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] words = str.replaceAll("\\W", "").toLowerCase().split("\\s");

        for (String word : words) {
            if (!ban.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        String res = null;
        for (String word : map.keySet()){
            if (res == null || map.get(word) > map.get(res))
                res = word;
        }

        return res;
    }
}
