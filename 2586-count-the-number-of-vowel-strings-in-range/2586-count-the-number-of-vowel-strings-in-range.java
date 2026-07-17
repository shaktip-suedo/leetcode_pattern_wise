class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0 ;
        for(int i = left ; i <= right ; i++){
            String w = words[i];
             char first = w.charAt(0);
            char last = w.charAt(w.length() - 1);

            if ((first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') &&
                (last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u')) {
                count++;
            }
            
        }
        return count ;
    }
}