package src.sanga.algorithm.bitwiseoperation;

/**
 * 입력값이 UTF-8 문자열이 맞는지 검증하라.
 * https://leetcode.com/problems/utf-8-validation/
 */
class UTF8Validation {
    public static void main(String[] args) {
        UTF8Validation utf8Validation = new UTF8Validation();
        utf8Validation.validUtf8(new int[]{197, 130, 1}); // 11000101, 10000010, 00000001  true, 값 두 개
        utf8Validation.validUtf8Solution(new int[]{235, 140, 4}); // 11101011, 10001100, 00000100  false
        utf8Validation.validUtf8(new int[]{237, 149, 156}); // 11101101, 10010101, 10010101  true
    }

    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int d : data) {
            // 첫 바이트 확인하여 몇 바이트인지 봄
            // count==0일 때는, int d 가 배열 data의 첫번째 값일 때. 그 다음부터는 else문으로 들어감
            // 첫번째 바이트는 이미 확인했으므로 바이트 수 -1이 카운트가 됨
            if (count == 0) {
                // 8-5 = 3
                if ((d >> 5) == 0b110) count = 1;
                // 8-4 = 4
                else if ((d >> 4) == 0b1110) count = 2;
                // 8-3 = 5
                else if ((d >> 3) == 0b11110) count = 3;
                // 8-7 = 1
                // 0이어야 하는데 1이면 바로 false, 바이트 수 1이고 d>>7==0이면 for문 탈출하여 count==0 이므로 바로 true리턴
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
            // 첫번째 풀이가 첫 바이트 확인 if문 나머지 10시작 바이트 확인은 else에서 했다면
            // checkSizedㅔ서 나머지 10시작 바이트 확인을 해버림,,
            // 만약 checkSize다 맞지 않으면 바로 반복문 더 필요도 없이 false 리턴. (두번째 예)
            if ((d >> 3) == 0b11110 && checkSize(3, start, data)) {
                start += 4; // 0b11110에 딸린 나머지 3개의 비트는 checkSized에서 확인했으므로 data에서 나머지 볼 필요가 없어져 버린 것임.. 그래서 바로 건너뛰고 data[start] 로 가버리도록.. 점프느낌
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