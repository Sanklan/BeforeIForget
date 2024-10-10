class AllOne {

    TreeSet<StringFreq> data;
    HashMap<String, StringFreq> table;
    public AllOne() {
        data = new TreeSet<StringFreq>();
        table = new HashMap<String, StringFreq>();
    }
    
    public void inc(String key) {
        StringFreq freq = get(key);
        data.add(freq.inc());        
    }
    
    public void dec(String key) {
        StringFreq freq = get(key);
        if (freq.freq == 1) table.remove(key);
        else data.add(freq.dec());
        
    }
    
    public String getMaxKey() {
        if (table.isEmpty()) return "";
        return data.last().string;
    }
    
    public String getMinKey() {
        if (table.isEmpty()) return "";        
        return data.first().string;
    }

    private StringFreq get(String key) {
        table.putIfAbsent(key, new StringFreq(key));
        return remove(table.get(key));
    }

    private StringFreq remove(StringFreq freq) {
        if (data.contains(freq)) 
            data.remove(freq);
        return freq;
    }
}

class StringFreq implements Comparable<StringFreq>{
    int freq;
    String string;

    public StringFreq(String str) {
        string = str;
        freq = 0;
    }

    public int compareTo(StringFreq that) {
        int ret = this.freq - that.freq;
        if (ret == 0)
            return this.string.compareTo(that.string);
        return ret;
    }

    public StringFreq inc() {
        freq++;
        return this;
    }

    public StringFreq dec() {
        freq--;
        return this;
    }

    public String toString() {
        return string + " " + freq;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */