public class RandomizedCollection {
    
    ArrayList<Integer> lst;
    HashMap<Integer, Set<Integer>> idx;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */

    public RandomizedCollection() {
        lst = new ArrayList<Integer>();
        idx = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!idx.containsKey(val)) 
            idx.put(val, new LinkedHashSet<Integer>());
        
        idx.get(val).add(lst.size());
        lst.add(val);
        
        return idx.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if (!idx.containsKey(val) || idx.get(val).size() == 0) 
            return false;
        
        // get index of removing element
	    int remove_idx = idx.get(val).iterator().next();
        
        //remove element from hashmap
        idx.get(val).remove(remove_idx);
        
        //now o remove element from list 
        // get last element from list
        int last = lst.get(lst.size() - 1);
        
        //set element of removing index to last element
        lst.set(remove_idx, last);
        //add entry of new index of last element which is removing element index 
        idx.get(last).add(remove_idx);
        // remove previous index of last element which is no longer correct 
        idx.get(last).remove(lst.size() - 1);

        //remove last element from list
	    lst.remove(lst.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}
