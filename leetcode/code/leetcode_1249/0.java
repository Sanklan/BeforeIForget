class SnapshotArray {

    //private HashMap<Integer, TreeMap<Integer, Integer>> data;
    private HashMap<Integer, HashMap<Integer, Integer>> history;
    //private int[] current;
    private int currentVersion;
    public SnapshotArray(int length) {
        //current = new int[length];

        history = new HashMap<Integer, HashMap<Integer, Integer>>();
        /*
        data = new HashMap<Integer, TreeMap<Integer, Integer>>();
        IntStream.range(0, length).
        forEach( index -> {
            TreeMap<Integer, Integer> entry = new TreeMap<Integer, Integer>();
            entry.put(0, 0);
            data.put(index, entry);
        }); */

        currentVersion = 0;
    }
    
    public void set(int index, int val) {
        history.putIfAbsent(currentVersion, new HashMap<Integer, Integer>());
        history.get(currentVersion).put(index, val);
        /*int key = data.get(index).floorEntry(currentVersion).getKey();
        data.get(index).put(key, val);*/
    }
    
    public int snap() {
        //history.put(currentVersion, current.clone());
        currentVersion++;
        return currentVersion - 1;
       /* final int newVersion = currentVersion + 1;
        data.keySet().stream().
        forEach( key -> {
            data.get(key)
            .put(newVersion, get(key, currentVersion));
        });

        currentVersion = newVersion;

        return currentVersion - 1;*/
    }
    
    public int get(int index, int snap_id) {
        int version = snap_id; 
        while(version >= 0) {
            if (history.containsKey(version)) {
                if (history.get(version).containsKey(index)) {
                    return history.get(version).get(index);
                }
            }
            version--;
        }

        return 0;
        //return data.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */