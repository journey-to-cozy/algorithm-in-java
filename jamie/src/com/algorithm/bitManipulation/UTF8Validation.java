package com.algorithm.bitManipulation;

/**
 * https://leetcode.com/problems/utf-8-validation/
 * 입력값이 UTF-8 문자열이 맞는지 검증하라.
 */
public class UTF8Validation {

    private final int[] masks = {128, 64, 32, 16, 8};

    public boolean validUtf8(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int current = data[i];
            int type = getType(current);
            if (type == 0)
                continue;
            
            else if (type > 1 && i + type <= len) {
                while (type-- > 1) {
                    if (getType(data[++i]) != 1)
                        return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private int getType(int num) {
        for (int i = 0; i < 5; i++) {
            if ((masks[i] & num) == 0)
                return i;
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int[] data = {197, 130, 1};
        int[] data2 = {235, 140, 4};
        UTF8Validation solution = new UTF8Validation();
        
        System.out.println("solution.validUtf8(data) = " + solution.validUtf8(data));
        System.out.println("solution.validUtf8(data2) = " + solution.validUtf8(data2));
    }
}
