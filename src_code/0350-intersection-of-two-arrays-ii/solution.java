class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         if(nums1.length<nums2.length){
//             return intersect(nums2,nums1);
//         }
//         HashMap<Integer,Integer> map = new HashMap<>();
//         ArrayList<Integer> arr = new ArrayList<>();
//         for(int val : nums1){
//             map.put(val,map.getOrDefault(val,0)+1);
            
//         }
        
//         for(int val:nums2){
//             if(map.containsKey(val)){
//                 int x  = map.get(val);
//                 if(x>0){
//                     arr.add(val);
//                     map.put(val,map.getOrDefault(val,0)-1);
//                 }else{
//                     map.put(val,map.getOrDefault(val,0)-1);
//                 }
//             }
//         }
        
//         int[] arr1 = new int[arr.size()];
//         for(int i=0;i<arr.size();i++){
//             arr1[i] = arr.get(i);
//         }
        
//         return arr1;
//     }
    
    
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0)
            return nums1;
        if(nums2.length==0)
            return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j] )
                i++;
            else if(nums2[j]<nums1[i])
                j++;
            else if(nums1[i]==nums2[j]){
                nums1[k++]=nums1[i];
                i++;            
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
