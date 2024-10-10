class LRUCache {

    private int capacity, size;

    private LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
    
        cache = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if (!this.cache.containsKey(key)) return -1;
        int ret = this.cache.get(key);
        this.cache.remove(key);
        this.cache.put(key, ret);
        return ret;
    }
    
    public void put(int key, int value) {
        boolean isUpdate = this.cache.containsKey(key);
        int keyToRemove = (isUpdate) ? key : getFirstKey();

        if (isUpdate || this.capacity == this.size) {
            this.cache.remove(keyToRemove);
            this.size--;
        }
        
        this.cache.put(key, value);
        this.size++;
    }

    private int getFirstKey() {
        return this.cache.keySet().stream().findFirst().orElse( -1 );
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */