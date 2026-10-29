class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char a = s.charAt(left);
            char b = s.charAt(right);

            if (!Character.isLetterOrDigit(a)){
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(b)){
                right--;
                continue;
            }

            if (Character.toLowerCase(a) != Character.toLowerCase(b)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}