class ParkingSystem {

    int[] size;
    int[] count;
    public ParkingSystem(int big, int medium, int small) {
        count = new int[3];
        size = new int[3];
        size[0] = big;
        size[1] = medium;
        size[2] = small;
        
    }
    
    public boolean addCar(int carType) {
        if (size[carType - 1] <= count[carType - 1]) return false;
        count[carType - 1]++;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */