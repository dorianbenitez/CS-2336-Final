
public class Motorcycle extends Vehicle {

    private char name = 'M';
    private int numOfMotorcycle = 0;        // For motorcycle count
    private int spots = 1;                  // # of spots each motorcycle takes up
    boolean taken = true;

    ParkingSpot s = new ParkingSpot();

    Motorcycle() {
        super();                // Calls the "Vehicle" super class to incrememnt total vehicle count
        numOfMotorcycle++;      // Increments number of motorcycle count for each added into lot

    }

    // When called, will return the number of motorcycles that have been parked
    public int getNumOfMotorcycle() {
        return numOfMotorcycle;
    }

    
    public char[][] parkMotorcycle(char[][] lot, int level) {

        for (int i = 0; i < lot[0].length; i++) {

            // If any parking spots in the level are shown as not taken, this will run
            if (lot[level][i] == 'l' || lot[level][i] == 'c' || lot[level][i] == 'm') {
                
                taken = false;         // The spot found is shown as not taken
                lot[level][i] = name;   // // Parking spot is changed to 'M' for newly parked motorcycle
                return lot;
            }
        }

        // If every parking spot in the level is taken, this runs
        if (taken == true) {
            // User is prompted that there are no parking spaces available for a motorcycle in desired level
            System.out.println("\nError: Not enough available spaces for a motorcycle");
            return lot;
        }
        return lot;
    }


    // Function to remove a motorcycle from the parking lot
    public char[][] removeMotorcycle(char[][] lot, int level) {

        int l = (int) (lot[0].length * 0.2);    // For large parking spots in level
        int c  = (int) (lot[0].length * 0.6);    // For compact parking spots in level
        int m = (int) (lot[0].length * 0.2);    // For motorcycle parking spots in level

        for (int i = 0; i < lot[0].length; i++) {

            // If a spot in the chosen level has a motorcycle, this runs
            if (lot[level][i] == name) {
                taken = true;       // A parking spot is taken by a motorcycle
                
                // If motorcycle found in a large spot, reverts spot back to being empty
                if (i < m) {        
                    lot[level][i] = 'l';
                    return lot;
                }

                // If found in a compact spot, reverts spot back to being empty
                if (i >= m && i < c + m) {
                    lot[level][i] = 'c';
                    return lot;
                }

                // If found in a motorcycle spot, reverts spot back to being empty
                if (i >= c + m && i < lot.length) {
                    lot[level][i] = 'm';
                    return lot;
                }
            }
        }

        taken = false; 

        // If no motorcycle is found in the desired level, this runs
        if (taken == false) {
            // User is prompted that no motorcycle was found in the desired level
            System.out.println("\nError: There are currently no motorcycles to remove.");
        }
        return lot;
    }

}