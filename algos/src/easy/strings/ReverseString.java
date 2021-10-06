package easy.strings;

public class ReverseString {

    /*
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
     */
    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o'};
        System.out.println(new String(reserveString(s)));
    }

    public static char[] reserveString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
        return s;
    }

}
