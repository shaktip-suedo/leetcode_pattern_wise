class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }else if(ch == '['){
                countStack.push(k);
                stringStack.push(currentString);

                k=0;
                currentString = new StringBuilder();
            }else if(ch == ']'){
                int repeatedK = countStack.pop();
                StringBuilder decodeString = stringStack.pop();
                decodeString.append(currentString.toString().repeat(repeatedK));
                currentString = decodeString;
            }else{
                currentString.append(ch);
            }
            
        }
        return currentString.toString();
    }
}