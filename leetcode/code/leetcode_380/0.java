class RandomizedSet {
    private HashSet<Integer> set;
    private int size;
    public RandomizedSet() {
        set = new HashSet<Integer>();
        size = 0;
    }
    
    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            size++;
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        set.remove(val);
        size--;
        return true;
    }
    
    public int getRandom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, size);
        return new ArrayList<Integer>(set).get(randomNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */