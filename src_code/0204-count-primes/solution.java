class Solution {

    public int countPrimes(int n) {
        
        if(n<=2){
            return 0;
        }
        
        int count = 0;
        
        boolean[] Prime = new boolean[n];
        
        Prime[0] = Prime[1] = true;
        
        for (int i = 2; i*i < n; i++) {
            
            if (Prime[i] == false) {
                
                for (int j = i*i; j < n; j+=i) {
                    Prime[j] = true;
                }
            }
        }
        
        for(boolean val : Prime){
            if(!val){
                count++;
            }
        }
        
        return count;
        
        
    }
}
