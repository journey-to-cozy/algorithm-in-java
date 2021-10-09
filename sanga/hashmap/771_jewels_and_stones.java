package src.sanga.hashmap;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
class JewelsAndStones{

    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        Set setJewels = new HashSet<>();

        for(char j: jewels.toCharArray()){
            setJewels.add(j);
        }

        for (char s: stones.toCharArray()){
            if(setJewels.contains(s)) result++;
        }

        return result;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        int result = 0;
        for (int i = 0 ; i < stones.length(); i ++) {
            if(jewels.indexOf(stones.charAt(i)) != -1) {
                result++;
            }
        }
        return result;
    }

}