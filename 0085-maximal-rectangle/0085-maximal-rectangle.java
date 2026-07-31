class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0)
{
    return 0;
}
int c = matrix[0].length;
int[] height = new int[c];
int maxArea = 0;

for(char[] row : matrix){
    for(int j = 0; j < c ; j++){
        if(row[j] == '1'){
            height[j] += 1;
        }else{
            height[j] = 0;
        }
    }
    maxArea = Math.max(maxArea, largRec(height));
}
return maxArea;
    }
    private int largRec(int[] height){
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = height.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : height[i];
            while (!stack.isEmpty() && currentHeight < height[stack.peek()]) {
                int h = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
                }
                stack.push(i);
        }
        return maxArea;
    }
}