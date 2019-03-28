public class Bus extends Vehicle {

    private char name = 'B';        
    private int numOfBus = 0;     // For bus count
    private int spots = 5;        // For # of spaces bus takes up
    boolean taken = true;

    ParkingSpot s = new ParkingSpot();

    Bus() {
        super();        // Calls the "Vehicle" super class to incrememnt vehicle count
        numOfBus++;     // Increments number of bus count for each bus added into lot

    }

    // When called, will return the number of buses that have been parked
    public int getNumOfBus() {
        return numOfBus;
    }

    // When called, will place parked bus in desired lot level
    public char[][] parkBus(char[][] lot, int level, int row) {

        for (int i = 0; i < lot[0].length; i++) {

            if (i + 5 <= lot[0].length) { 

                if (row >= 5) {
                    // If there are 5 consecutive large spots available, this will run
                    if (lot[level][i] == 'l' && lot[level][i + 1] == 'l' && lot[level][i + 2] == 'l'
&& lot[level][i + 3] == 'l' && lot[level][i + 4] == 'l') {

                        taken = false;          // If spaces for bus are not taken, the bus can be parked
                        
                        // Will replace each spot with 'B' to show spots are taken by a bus
                        lot[level][i] = name;       
                        lot[level][i + 1] = name;
                        lot[level][i + 2] = name;
                        lot[level][i + 3] = name;
                        lot[level][i + 4] = name;

                        return lot;
                        // returns the new lot with parked bus

                    }

                }               

            }

        }

        // If the spots to park the bus are taken, this runs
        if (taken == true) {
            // Prompts user that not enough spaces are available to park a bus
            System.out.println("\nError: Not enough spaces available for a bus");
            return lot;
        }

        return lot;

    }

    // Function to remove a bus from the parking lot
    public char[][] removeBus(char[][] lot, int level) {

        for (int i = 0; i < lot[0].length; i++) {

            // If there is a bus parked in 5 consecutive spaces, this will run
            if (lot[level][i] == name && lot[level][i + 1] == name && lot[level][i + 2] == name
            && lot[level][i + 3] == name && lot[level][i + 4] == name) {

                taken = true;   // Shows that the spots are currently taken           

                // Reverts 5 large spots in a row back to being available in the lot
                lot[level][i] = 'l';        
                lot[level][i + 1] = 'l';
                lot[level][i + 2] = 'l';
                lot[level][i + 3] = 'l';
                lot[level][i + 4] = 'l';

                return lot;

            }

        }       

        taken = false;  // Sets the spots to no longer being taken

        // If there is no bus found in the level chosen, this runs
        if (taken == false) {
            // User is prompted that there are no buses in the chosen level
            System.out.println("\nError: There are no buses to remove.");
        }

        return lot;
    }

}


