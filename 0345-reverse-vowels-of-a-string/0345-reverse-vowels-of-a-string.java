class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i<j){
            while(i<j && !isVowel(chars[i])){
                i++;
            }
            while(i < j && !isVowel(chars[j])){
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }
        return new String(chars);
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}