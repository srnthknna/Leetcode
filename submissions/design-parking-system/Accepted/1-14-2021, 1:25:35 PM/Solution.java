// https://leetcode.com/problems/design-parking-system

class ParkingSystem {
    
    int[] parking;

    public ParkingSystem(int big, int medium, int small) {
        parking = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        int index = carType - 1;
        if (parking[index] > 0) {
            parking[index]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */