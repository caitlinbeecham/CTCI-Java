class CTCICh1P6 {
    public static String string_compression(String str) {
        char[] cArray = str.toCharArray();
        String space = " ";
        char prev = space.charAt(0);
        int prev_idx = -1;
        int[] count_at_first_idx_chain = new int[cArray.length];
        for (int i = 0; i < cArray.length; i++) {
            count_at_first_idx_chain[i] = 0;
        }
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] != prev) {
                //update prev
                //update prev_idx
                prev_idx = i;
                prev = cArray[i];
                count_at_first_idx_chain[prev_idx] = 1;
            }
            else {
                count_at_first_idx_chain[prev_idx] = count_at_first_idx_chain[prev_idx]  + 1;
            }
        }
        String ret = "";
        for (int i = 0; i < cArray.length; i++) {
            if (count_at_first_idx_chain[i] != 0) {
                ret = ret + cArray[i];
                ret = ret + String.valueOf(count_at_first_idx_chain[i]);
            }
        }
        //check which one is shorter before returning anything
        char[] retCharArray = ret.toCharArray();
        if (retCharArray.length > cArray.length) {
            return str;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(string_compression("aabcccccaaa"));
    }
}