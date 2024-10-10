class Skiplist {
    private ArrayList<Integer> storage;
    private int size;

    public Skiplist() {
        storage = new ArrayList<Integer>();
        size = 0;
    }
    private void printList() {
        System.out.println();
        storage.stream().forEach(x -> System.out.print(" " + x));
        
    }
    
    private int findIndex(int target) {
        int low = 0;
        int high = size - 1;
        int mid = mid = (low + high)/2;
        while(low <= high) {
            mid = (low + high)/2;
            int num = storage.get(mid);
            if (num == target) return mid;
            else if (num > target) high = mid - 1;
            else low = mid + 1;
        }
        
        return mid;
    }
    
    public boolean search(int target) {
        int index = findIndex(target);
        return storage.get(index) == target;
    }
    
    public void add(int num) {
        int index = findIndex(num);
        if (index >= size) {
            storage.add(num);
        } else if (storage.get(index) >= num) {
            storage.add(index, num);            
        } else if (index + 1 < size){
            storage.add(index + 1, num);
        } else {
          storage.add(num);
        }
        size++;
      //  printList();
    }
    
    public boolean erase(int num) {
        int index = findIndex(num);
        if (storage.get(index) == num) {
            storage.remove(index);
            size--;
         //   printList();
            return true;
        }
        
        return false;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */