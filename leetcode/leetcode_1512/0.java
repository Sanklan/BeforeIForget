class UndergroundSystem {

    //station 1 to station 2 -> list of entries 
    HashMap<String, HashMap<String, List<Integer>>> entries;
    // station 1 to user id -> open Entry
    HashMap<Integer, HashMap<String, Integer>> openEntries;
    public UndergroundSystem() {
        entries = new HashMap<String, HashMap<String, List<Integer>>>();
        openEntries = new HashMap<Integer, HashMap<String, Integer>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        HashMap<String, Integer> entry = new HashMap<String, Integer>();
        entry.put(stationName, t);
        openEntries.put(id, entry);
    }
    
    public void checkOut(int id, String stationName, int t) {
        HashMap<String, Integer> openEntry = openEntries.get(id);
        String name = null;
        Integer startTime = -1;
        for(Map.Entry<String, Integer> entry: openEntry.entrySet()) {
            name = entry.getKey();
            startTime = entry.getValue();
        }

        if (!entries.containsKey(name)) entries.put(name, new HashMap<String, List<Integer>>());
        if (!entries.get(name).containsKey(stationName)) entries.get(name).put(stationName, new ArrayList<Integer>());

        entries.get(name).get(stationName).add(Math.abs(t-startTime));
        openEntries.get(id).clear();

    }
    
    public double getAverageTime(String startStation, String endStation) {
        Integer sum = 0;
        for(Integer s:entries.get(startStation).get(endStation)) sum += s;
        return (double)sum / entries.get(startStation).get(endStation).size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */