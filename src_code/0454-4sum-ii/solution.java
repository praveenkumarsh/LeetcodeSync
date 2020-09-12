class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        //Store sum vs no of encouencountered
        
        for(int a : A){
            for(int b : B){
                int s = a+b;
                map.put( s, map.getOrDefault(s, 0)+1 ); 
            }
        }
        
        int result=0;
        for(int c : C){
            for(int d : D){
                int s = -c-d;
                result += map.getOrDefault(s, 0);
                // if there is a new sum which is equal to previous sum
                // then sum the no of encountered to result
            }
        }
        return result; 
    }
}
