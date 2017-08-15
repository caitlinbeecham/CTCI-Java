import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class CTCICh1P2 {
    public static boolean a_is_perm_of_b(String a, String b) {
        char[] aCharList = a.toCharArray();
        int lena = aCharList.length;
        ArrayList<Character> seen_a = new ArrayList<Character>();
        char[] bCharList = b.toCharArray();
        int lenb = bCharList.length;
        ArrayList<Character> seen_b = new ArrayList<Character>();
        if (lena != lenb) {
            return false;
        }
        HashMap<Character, Integer> char_to_first_idx_a = new HashMap<Character, Integer>();
        HashMap<Integer, Integer> first_idx_to_count_a = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> char_to_first_idx_b = new HashMap<Character, Integer>();
        HashMap<Integer, Integer> first_idx_to_count_b = new HashMap<Integer, Integer>();
        int[] count_of_char_by_first_idx_a = new int[lena];
        int[] count_of_char_by_first_idx_b = new int[lenb];
        for (int i = 0; i < lena; i++) {
            if (!seen_a.contains(aCharList[i])) {
                seen_a.add(aCharList[i]);
                char_to_first_idx_a.put(aCharList[i], i);
                first_idx_to_count_a.put(i,1);
            }
            else {
                first_idx_to_count_a.put(char_to_first_idx_a.get(aCharList[i]), first_idx_to_count_a.get(char_to_first_idx_a.get(aCharList[i])) + 1);
            }
            
        }
        for (int i = 0; i < lenb; i++) {
            if (!seen_b.contains(bCharList[i])) {
                seen_b.add(bCharList[i]);
                char_to_first_idx_b.put(bCharList[i], i);
                first_idx_to_count_b.put(i,1);
            }
            else {
                first_idx_to_count_b.put(char_to_first_idx_b.get(bCharList[i]), first_idx_to_count_b.get(char_to_first_idx_b.get(bCharList[i])) + 1);
            }
            
        }
        HashMap<Character, Integer> char_to_count_a = new HashMap<Character,Integer>();
        Set<Character> key_set_a = char_to_first_idx_a.keySet();
        HashMap<Character, Integer> char_to_count_b = new HashMap<Character,Integer>();
        Set<Character> key_set_b = char_to_first_idx_b.keySet();
        for (char key : key_set_a) {
            char_to_count_a.put(key, first_idx_to_count_a.get(char_to_first_idx_a.get(key)));
        }
        for (char key : key_set_b) {
            char_to_count_b.put(key, first_idx_to_count_b.get(char_to_first_idx_b.get(key)));
        }
        if (key_set_a.size() != key_set_b.size()) {
            return false;
        }
        for (char key : key_set_a) {
            if (!key_set_b.contains(key)) {
                return false;
            }
            else if (char_to_count_a.get(key) != char_to_count_b.get(key)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(a_is_perm_of_b("cat","no"));
        System.out.println(a_is_perm_of_b("cato","taco"));
    }
}