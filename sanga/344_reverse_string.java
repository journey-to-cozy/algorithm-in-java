package src.sanga;

class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;

//                char temp = s[left];
//                s[left] = s[right];
//                s[right] = temp;
//                left += 1;
//                right -= 1;
        }
    }
}