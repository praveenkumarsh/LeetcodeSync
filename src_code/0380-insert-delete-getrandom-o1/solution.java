class RandomizedSet {
    
    Map<Integer, Integer> map;
    ArrayList<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
           
            map.put(val, nums.size());
            nums.add(val);
            
            return true;
        }
        
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!map.containsKey(val)){
            return false;
        }
        
        int idx = map.get(val);
        map.remove(val);
        
        // if idx is not the last lement then update map and list by swaping it with the last element
        if(idx != nums.size() - 1){
            nums.set(idx, nums.get(nums.size() - 1));
            map.put(nums.get(idx), idx);
        }
        
        nums.remove(nums.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIdx = nums.size() == 0 ? 0 : getRandom(0, nums.size() - 1);
        return nums.get(randomIdx);
    }
    
    private int getRandom(int min, int max){
        return min + (int) (Math.random() * (max - min + 1));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
