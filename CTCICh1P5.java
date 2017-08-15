class CTCICh1P5 {
    public static boolean a_is_b_with_char_inserted_at_idx_k(String a, String b,int k) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        int lena = aCharArray.length;
        int lenb = bCharArray.length;
        if (lena != lenb + 1) {
            return false;
        }
        for (int i = 0; i < k; i++) {
            if (aCharArray[i] != bCharArray[i]) {
                return false;
            }
        }
        for (int i = k+1; i < lena; i++) {
            if (aCharArray[i] != bCharArray[i-1]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean a_is_b_with_char_inserted(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        int lena = aCharArray.length;
        int lenb = bCharArray.length;
        if (lena != lenb + 1) {
            return false;
        }
        for (int i = 0; i < lena; i++) {
            if (a_is_b_with_char_inserted_at_idx_k(a,b,i)) {
                return true;
            }
        }
        return false; 
    }

    public static boolean a_is_b_with_char_replaced_at_idx_k(String a, String b,int k) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        int lena = aCharArray.length;
        int lenb = bCharArray.length;
        if (lena != lenb) {
            return false;
        }
        for (int i = 0; i < k; i++) {
            if (aCharArray[i] != bCharArray[i]) {
                return false;
            }
        }
        for (int i = k+1; i < lena; i++) {
            if (aCharArray[i] != bCharArray[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean a_is_b_with_char_replaced(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        int lena = aCharArray.length;
        int lenb = bCharArray.length;
        if (lena != lenb) {
            return false;
        }
        for (int i = 0; i < lena; i++) {
            if (a_is_b_with_char_replaced_at_idx_k(a,b,i)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean are_one_away(String a, String b) {
        //checks if strings are one away
        //there are one away iff:
        //one is the other with a char deleted
        //one is the other with a char inserted
        //or one is the other with a char replaced with a different one
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        int lena = aCharArray.length;
        int lenb = bCharArray.length;
        if ((a_is_b_with_char_inserted(a,b) | a_is_b_with_char_inserted(b,a)) | a_is_b_with_char_replaced(a, b)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(are_one_away("pale","ple"));
        System.out.println(are_one_away("pales","pale"));
        System.out.println(are_one_away("pale","bale"));
        System.out.println(are_one_away("pale","bake"));
    }
}