public class Car extends Vehicle {

    private char name = 'C';
    private int numOfCar = 0;       // For car count
    private int spots = 1;          // # of spots vehicle takes
    boolean taken = true;

    ParkingSpot s = new ParkingSpot();

// Every time a car is added, numOfCar is incremented.

    Car() {
        super();          // Calls the "Vehicle" super class to incrememnt total vehicle count
        numOfCar++;       // Increments number of car count for each car added into lot

    }

    // When called, will return the number of cars that have been parked
    public int getNumOfCar() {
        return numOfCar;
    }

    public char[][] parkCar(char[][] lot, int level) {
        
        for (int i = 0; i < lot[0].length; i++) {

            // If the parking spots are shown as not taken, this will run
            if (lot[level][i] == 'c' || lot[level][i] == 'l') {

                taken = false;          // The spots are shown as not taken      
                lot[level][i] = name;   // Parking spot is changed to 'C' for newly parked car
                    
                return lot;         // New lot is returned to user
            }
        }

        // If all spots are taken and car cannot be parked in desired level, this runs
        if (taken == true) {
            // User is prompted that there are no spaces to park a car in the desired level
            System.out.println("\nError: Not enough available spaces for a car");
            return lot;
        }

        return lot;
    }

    // Function to remove a car from the parking lot
    public char[][] removeCar(char[][] lot, int level) {

        int l = (int) (lot[0].length * 0.2);    // For large parking spots in level
        int c = (int) (lot[0].length * 0.6);    // For compact parking spots in level
        int m = (int) (lot[0].length * 0.2);    // For motorcycle parking spots in level

        for (int i = 0; i < lot[0].length; i++) {

            // If the spot being viewed is taken by a car already, this runs
            if (lot[level][i] == name) {
                taken = true;

                // If the car is parked in a large spot, this runs
                if (i < m) {
                    // Spot with car parked is reverted back to an empty large spot
                    lot[level][i] = 'l';
                    return lot;
                }

                // If the car is parked in a compact spot, this runs
                if (i >= m && i < c + m) {
                    // Spot with parked in is reverted back to an empty compact parking spot
                    lot[level][i] = 'c';
                    return lot;
                }

            }

        }

        taken = false;     // The spot will no longer be shown as taken

        // If the parking level removing a car is already empty, this runs
        if (taken == false) {
            // User is prompted that there is no car parked in the level they chose
            System.out.println("\nError: There are currently no cars to remove.");
        }

        return lot;

    }

}