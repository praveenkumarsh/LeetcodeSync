class Solution {
    public int numberOfMatches(int n) {
        int ans = 0;
        while(n!=1){
            if(n%2==0){//even
                ans+=n/2;
                n=n/2;
            }else{//odd
                ans+=n/2;
                n = n/2+1;
            }
        }
        return ans;
        
    }
}
