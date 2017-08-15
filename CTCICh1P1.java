import java.util.HashMap;
import java.util.ArrayList;

class CTCICh1P1 {
    public static boolean has_unique_chars(String str) {
        char[] cArray = str.toCharArray();
        ArrayList<Character> seen_chars = new ArrayList<Character>();
        for (int i = 0; i < cArray.length; i++) {
            if (!seen_chars.contains(cArray[i])) {
                seen_chars.add(cArray[i]);
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(has_unique_chars("cat"));
        System.out.println(has_unique_chars("fyguhijrtfyguhijtrfyguhi"));
    }
}