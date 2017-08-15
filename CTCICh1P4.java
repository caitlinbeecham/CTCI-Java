import java.util.HashMap;


class CTCICh1P4 {
    public static String remove_spaces(String str) {
        char[] cArray = str.toCharArray();
        String space = " ";
        String ret = "";
        char space_char = space.charAt(0);
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] == space_char) {
            }
            else {
                ret = ret + cArray[i];
            }
        }
        return ret;
    }
    public static HashMap<Character,Integer> count_chars(String str) {
        char[] cArray = str.toCharArray();
        HashMap<Character,Integer> char_to_count = new HashMap<Character, Integer>();
        for (int i = 0; i < cArray.length; i++) {
            if (!char_to_count.keySet().contains(cArray[i])) {
                char_to_count.put(cArray[i], 1);
            }
            else {
                char_to_count.put(cArray[i], char_to_count.get(cArray[i]) + 1);
            }
        }
        return char_to_count;
    }
    public static boolean is_palindrome_permutation(String str) {
        String new_str = remove_spaces(str);
        HashMap<Character, Integer> char_to_count = count_chars(new_str);
        int num_odd_vals = 0;
        for (char key : char_to_count.keySet()) {
            if (char_to_count.get(key) % 2 == 1) {
                num_odd_vals = num_odd_vals + 1;
            }
        }
        if (num_odd_vals > 1) {
            return false;
        }
        else {
            return true;
        }
    }
    public static void main(String[] args) {
        System.out.println(is_palindrome_permutation("tact coa"));
        System.out.println(is_palindrome_permutation("aaabbb"));
    }
}