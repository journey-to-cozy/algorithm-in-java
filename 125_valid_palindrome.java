package src;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] == chars[right]) {
                left += 1;
                right -= 1;
                continue;
            }
            return false;
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        String validStr = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        return new StringBuilder(validStr).reverse().toString().equals(validStr);
    }
}