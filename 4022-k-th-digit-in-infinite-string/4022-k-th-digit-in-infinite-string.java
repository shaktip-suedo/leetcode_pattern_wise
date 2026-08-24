class Solution {
    public int kthDigit(long k) {
        if(k<=9) return (int) k;
        k-=9;

        long len = 2,count=9,start=1;
        while(k>count * 10 *len){
            k-= count*10*len;
            len++;
            count *= 10;
            start *= 10;
        }
        long b= start +(k-1)/(10*len);
        long rem = (k-1) %(10*len);

        long numIdx = rem/len;
        long num = (b %2==0)?(b*10+numIdx):(b*10+9-numIdx);
        return String.valueOf(num).charAt((int)(rem%len)) - '0';
    }
}