class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
//     public boolean isHappy(int n) {
//         //Store values from loop
//         Set<Integer> inLoop = new HashSet<Integer>();
        
//         //Ex-> 19 --->   1^2 + 9^2 = 82
//         // squareSum = 1^2 or 9^2  
//         // remain    = 1 or 9
//         int squareSum = 0,remain;
        
//         while(inLoop.add(n)){
//         // while (n!=1) {
            
//             squareSum = 0;
            
//             while (n > 0) {
//                 remain = n%10;
                
//                 squareSum += remain*remain;
                
//                 n /= 10;
//             }
//             if (squareSum == 1)
//                 return true;
//             else
//                 n = squareSum;

//         }
//         return false;
//     }
}
