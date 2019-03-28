
public class ParkingSpot {

    // Constant default values for parking lot size
    private int NUM_OF_LEVELS = 5;
    private int SPOTS_PER_LEVEL = 30;
    private int SPOTS_PER_ROW = 10;
    
    // Calculates total parking spots in entire lot
    private int TOTAL_SPOTS = NUM_OF_LEVELS * SPOTS_PER_LEVEL;
    private int LEVEL_TO_PARK = 0;

    private char[][] spots;

    // Sets total # of spots for each vehicle type
    public int lSpot = (int) (getSpotsPerLevel() * 0.2);
    public int cSpot = (int) (getSpotsPerLevel() * 0.6);
    public int mSpot = (int) (getSpotsPerLevel() * 0.2);

    
    ParkingSpot() {
    }

    // Function that creates desired-sized parking lot 
    public void createLot() {
        // Multi-dimensional array with assigned values for parking lot
        spots = new char[NUM_OF_LEVELS][SPOTS_PER_LEVEL];

        int motor = mSpot;
        int car = cSpot;

        // For loop to display large parking spots in each level
        for (int l = 0; l < NUM_OF_LEVELS; l++) {
            
            for (int j = 0; j < motor; j++) {
                // Will display amount of large parking spots in each row
                spots[l][j] = 'l';
            }
            
        }


        // For loop to store number of compact parking spots to be used in lot
        for (int c = 0; c < NUM_OF_LEVELS; c++) {
            
            for (int j = motor; j < car + motor; j++) {
                // Will display amount of compact parking spots in each row
                spots[c][j] = 'c';
            }

        }

        // For loop to store number of motorcycle parking spots to be used in lot
        for (int m = 0; m < NUM_OF_LEVELS; m++) {

            for (int j = car + motor; j < this.SPOTS_PER_LEVEL; j++) {
                // Will display amount of motorcycle parking spots in each row
                spots[m][j] = 'm';
            }

        }

    }   

    
    // Function that will print the created lot
    public void displayLot() {

        for (int i = 0; i < NUM_OF_LEVELS; i++) {
            
            for (int j = 0; j < SPOTS_PER_LEVEL; j++) {
                
                // Prints out each level value in parking lot
                if (j == 0) {
                    System.out.print("Level " + i + ": ");
                }

                // Seperates each row after assigned spots are made
                if (j % SPOTS_PER_ROW == 0) {
                    System.out.print(" ");
                }

            // Prints each row of parking spots
            System.out.print(spots[i][j]);

            }
            System.out.println();
        }     
        System.out.print("\n");
    }
    
    
    // When vehicle is parked, spot is displayed as being taken
    public boolean isTaken(int level, Vehicle type) {
        boolean isTaken = true;
        return isTaken;
    }
    
    
    // The number of large parking spots in the lot is set
    public void setL() {
        lSpot = (int) (SPOTS_PER_LEVEL * 0.2);
    }

    
    // The number of compact parking spots in lot is set
    public void setC() {
        cSpot = (int) (SPOTS_PER_LEVEL * 0.6);   
    }

    
    // The number of motorcycle parking spots in lot is set
    public void setM() {
        mSpot = (int) (SPOTS_PER_LEVEL * 0.2);
    }

    
    // When called, will return level of which vehicle is parked
    public int parkLevel() {
        return LEVEL_TO_PARK;
    }

    
    // When called, will return assigned value of total spots in each level of lot
    public int getSpotsPerLevel() {
        return SPOTS_PER_LEVEL;
    }
    
    
    // When function is called, will return the value of parking spots in each row
    public int getRows() {
        return SPOTS_PER_ROW;
    }

    
    // When called, will return assigned total value of levels created in lot
    public int getNumOfLevels() {
        return NUM_OF_LEVELS;
    }

    
    // When called, will return the total number of spots in entire parking lot
    public int getTotalSpots() {
        return TOTAL_SPOTS;
    }

    
    // When called, will return the current parking lot
    public char[][] getLot() {
        return spots;
    }
    
    
    // When called, will assign level that vehicle is parked as a constant
    public void setParkLevel(int parkLevel) {
        LEVEL_TO_PARK = parkLevel;
    }
    
    
// When called, will assign user-input value for spots in each row as a constant
    public void setSpotsPerRow(int spotRow) {
        SPOTS_PER_ROW = spotRow;
    }

    
    // When called, will assign user-input value of number of desired levels as a constant
    public void setTotalLevels(int levels) {
        NUM_OF_LEVELS = levels;
    }

    
    // When called, will assign user-input value of number of spots in each level as a constant
    public void setSpotsPerLevel(int spotLevel) {
        SPOTS_PER_LEVEL = spotLevel;
    }


    // When called, will be passed new parking input from user and will update the lot
    public void setLot(char[][] lot) {

        for (int i = 0; i < lot.length; i++) {

            for (int j = 0; j < lot[i].length; j++) {
                spots[i][j] = lot[i][j];
                // New lot from main function is assigned to update current lot
            }
        }
    }

}


