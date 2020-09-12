class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
    
//     public int numSquares(int n) {
//         Queue<Integer> q = new LinkedList();
//         int step = 0;
//         Set<Integer> visited = new HashSet();
//         q.add(0);
//         visited.add(0);

//         while(!q.isEmpty()){
//             int size = q.size();
//             ++step;
//             for(int i = 0; i < size; ++i){
//                 int remian = n - q.remove();
//                 for(int j = 1; j <= Math.sqrt(remian); ++j){
//                     int v = n - remian + j * j;
//                     if(v == n) return step;
//                     if(!visited.add(v)) continue;
//                     q.add(v);
//                 }
//             }
//         }

//         return n;
//     }
}
