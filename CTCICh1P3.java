class CTCICh1P3 {
    public static String URLify(String str) {
        String ret = "";
        char[] cArray = str.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            String space = " ";
            char space_char = space.charAt(0);
            if (cArray[i] == space_char) {
                ret = ret + "%20";
            }
            else {
                ret = ret + cArray[i];
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith"));
    }
}