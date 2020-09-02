class Solution {
    
    
    private int mt =  -1;
    
    public String largestTimeFromDigits(int[] A) {
        mt  = -1;
        permutate(A,0);
        if(mt==-1){
            return "";
        }else{
            return String.format("%02d:%02d",mt/60,mt%60);
        }
    }
    
    
    void permutate(int[] arr, int start){
        if(start==arr.length){
            timecreate(arr);
        }
        
        for(int i=start;i<arr.length;i++){
            swap(arr,i,start);
            permutate(arr,start+1);
            swap(arr,i,start);
        }
    }
    
    void timecreate(int[] arr){
        int h = arr[0]*10+arr[1];
        int m = arr[2]*10+arr[3];
        if(h<24&&m<60){
            mt = Math.max(mt,h*60+m);
        }
    }
    
    
    void swap(int[] arr, int i,int j){
        if(i!=j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
