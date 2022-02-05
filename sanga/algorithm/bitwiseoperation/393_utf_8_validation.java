package src.sanga.algorithm.bitwiseoperation;

/**
 * 입력값이 UTF-8 문자열이 맞는지 검증하라.
 * https://leetcode.com/problems/utf-8-validation/
 */
class UTF8Validation {
    public static void main(String[] args) {
        UTF8Validation utf8Validation = new UTF8Validation();
        utf8Validation.validUtf8(new int[]{197, 130, 1}); // true
        utf8Validation.validUtf8(new int[]{235, 140, 4}); // false
        utf8Validation.validUtf8(new int[]{237, 149, 156}); // true
    }

    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int d : data) {
            if (count == 0) {
                if ((d >> 5) == 0b110) count = 1;
                else if ((d >> 4) == 0b1110) count = 2;
                else if ((d >> 3) == 0b11110) count = 3;
                else if ((d >> 7) == 1) return false;
            } else {
                if ((d >> 6) != 0b10) return false;
                else count--;
            }
        }
        return count == 0;
    }

    public boolean validUtf8Solution(int[] data) {
        int start = 0;
        while (start < data.length) {
            int d = data[start];
            if ((d >> 3) == 0b11110 && checkSize(3, start, data)) {
                start += 4;
            } else if ((d >> 4) == 0b1110 && checkSize(2, start, data)) {
                start += 3;
            } else if ((d >> 5) == 0b110 && checkSize(1, start, data)) {
                start += 2;
            } else if ((d >> 7) == 0) {
                start += 1;
            } else {
                return false;
            }
        }
        return true;
    }


    private boolean checkSize(int size, int start, int[] data) {
        for (int i = start + 1; i < start + size + 1; i++) {
            if (i >= data.length || data[i] >> 6 != 0b10) {
                return false;
            }
        }
        return true;
    }


}