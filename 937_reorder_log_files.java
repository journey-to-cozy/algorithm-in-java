package src;

import java.util.ArrayList;
import java.util.List;

class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        // 문자로그와 숫자로그를 구분
        List<String> letters = new ArrayList();
        List<String> digits = new ArrayList();

        for (String s : logs) {
            String[] split = s.split(" ", 2);
            if (Character.isDigit(split[1].charAt(0))) {
                digits.add(s);
            } else {
                letters.add(s);
            }
        }

        letters.sort((log1, log2) -> {
            String[] splitLog1 = log1.split(" ", 2);
            String[] splitLog2 = log2.split(" ", 2);

            // 문자가 동일할 경우 식별자 순으로 한다.
            if (splitLog1[1].equals(splitLog2[1])) {
                return splitLog1[0].compareTo(splitLog2[0]);
            } else {
                return splitLog1[1].compareTo(splitLog2[1]);
            }
        });

        letters.addAll(digits);

        return letters.toArray(new String[logs.length]);
    }

}