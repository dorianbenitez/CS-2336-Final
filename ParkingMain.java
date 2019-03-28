// Dorian Ray Benitez
// CS 2336.004
// Final Project Code
// April 17, 2018

/*
    This program was created in order to simulate a parking lot. It begins by allowing
    the user to enter a desired size for a parking lot they wish to create. The parking
    lot is then displayed to the user. The program then asks if the user would like to
    add or remove a vehicle to/from the parking lot they created. After the decision is 
    input, the user is asked which level they wish to park/remove a vehicle from. If the
    input is valid, they are then given a list of different vehicle types, and are asked
    to select one they wish to add or remove from the lot. The new parking lot is then
    printed back to the user with the added or removed vehicles chosen, and the cycle repeats 
    until the user enters an invalid input, or they purposely choose to end the program by 
    typing in the value 'x' when prompted.
*/


import java.util.Scanner; 


public class ParkingMain {

public static void main(String[] args) {

    ParkingSpot spot = new ParkingSpot();

    int levels = 5;             // For total # of levels
    int spotsLevel = 30;         // For spots per level
    int spotsRow = 10;           // For spots per row
    int level = 0;              // For level to park in
    String vType;               // For vehicle-type decision
    boolean isNum;  
    String decision;            // For add/remove decision

    Scanner input = new Scanner(System.in);  // Allows for user input


    
    // Loop prompts user to enter desired # of levels in parking lot
    do {
        System.out.print("Enter number of levels in the parking lot: ");
        
        // If user-input is an integer, stores input
        if (input.hasNextInt()) {
            isNum = true;
            levels = input.nextInt();
        } 
        
        // If user-input is not an integer, prompts invalid input
        else {
            System.out.println("Invalid input, please try again..");
            isNum = false;
            input.next();
        }

    } while (isNum == false);   // Loop will run until an integer is input


    
    // Loop to prompt user to enter desired # of spots per level
    do {      
        System.out.print("Enter number of parking spots per level: ");

        // If user-input is an integer, stores input
        if (input.hasNextInt()) {
            isNum = true;
            spotsLevel = input.nextInt();   
        } 
        
        // If user-input is not an integer, prompts invalid input
        else {
            System.out.println("Invalid input, please try again..");
            isNum = false;
            input.next();
        }

    } while (isNum == false);   // Loop will run until an integer is input
    
    
   
    // Loop to prompt user to enter desired # of spots per row
    do {
        
        System.out.print("Enter number of parking spots per row: ");

        // If user-input is an integer, stores input
        if (input.hasNextInt()) {
            isNum = true;
            spotsRow = input.nextInt();
            System.out.print("\n");
        } 
        
        // If user-input is not an integer, prompts invalid input
        else {
            System.out.println("Invalid input, please try again..");
            isNum = false;
            input.next();
        }

    } while (isNum == false);   // Loop will run until an integer is input

    
    
    // If the inputs are each positive values, they are assigned for parking lot size
    if (levels > 0 && spotsRow > 0 && spotsLevel > 0) {
        spot.setSpotsPerRow(spotsRow);
        spot.setSpotsPerLevel(spotsLevel);
        spot.setTotalLevels(levels);
    }
    
    // If the inputs are not positive values, will use default values from ParkingSpot class
    else {
        System.out.println("\nInvalid inputs, will use default values instead..");
        levels = 5;
        spotsLevel = 30;
        spotsRow = 10;
        
        spot.setSpotsPerRow(spotsRow);
        spot.setSpotsPerLevel(spotsLevel);
        spot.setTotalLevels(levels);
    }
    
    spot.setL();            // The number of large parking spots in lot is set
    spot.setC();            // The number of compact parking spots in lot is set
    spot.setM();            // The number of motorcycle parking spots in lot is set
    
    spot.createLot();          // Parking lot of particular size is created
    spot.displayLot();         // Parking lot is printed to the user

    
    
    // Loop to add or remove vehicles from the parking lot
    while (level != -1) {
        
        System.out.print("Would you like to add or remove a vehicle? ['x' to end]: ");
        decision = input.next();                // Stores user string input
        decision = decision.trim();             // Trims string to size
        decision = decision.toLowerCase();      // Converts string to lowercase

        
        // If user wishes to add a vehicle, this runs
        if(decision.charAt(0) == 'a') {
            
            // Asks user which level they would like to park in and stores input
            System.out.print("What level would you like to park in? ");
            level = input.nextInt();
            
        }
        
        // If a user wishes to remove a parked vehicle, this runs
        else if(decision.charAt(0) == 'r') { 
            
            // Asks user which level they would like to remove from and stores input
            System.out.print("What level would you like to remove from? ");
            level = input.nextInt();
            
        }
        
        // If user wishes to end the program, this runs
        else if(decision.charAt(0) == 'x') {   
            
            // User is prompted that program is ending, and prints final state of lot
            System.out.println("\nThankyou for running, program is concluding.. ");
            System.out.println("Final state:");
            spot.displayLot();
            System.exit(0);
            
        }
        
        // If user input is invalid, this runs and the program ends
        else {
            
            // Prompts user that input was invalid, displays final state of lot and exits
            System.out.println("\nInvalid input, parking failed. Final state:");
            spot.displayLot();
            System.exit(0);
            
        }

        
        // If level input value does not exist in lot, this runs
        if (level < 0 || level > (levels - 1)) {
            
            // Prompts user that input is invalid, displays final state of lot and exits
            System.out.print("\nInvalid input, parking failed. Final state: \n");
            spot.displayLot();  
            System.exit(0);
            
        }
       
        
        // Prompts user list of possible vehcile type selections
        System.out.println("\nList of vehicle types:");
        System.out.println("Bus: B");
        System.out.println("Car: C");
        System.out.println("Motorcycle: M");

        // Prompts user to input type of vehicle they wish to add/remove
        System.out.print("Please choose a vehicle type: ");

        vType = input.next();           // Stores user input for vehicle choice
        vType = vType.trim();           // Trims the input to read up until last character
        vType = vType.toLowerCase();    // Converts user-input to lower-case string

        char[][] lot = spot.getLot();
        
        
    // If user wishes to park (add) a vehcile, this runs
    if(decision.charAt(0) == 'a') {
        
        // If user wishes to park a bus, this runs
        if (vType.charAt(0) == 'b') {
            Bus b = new Bus();
            lot = b.parkBus(lot, level, spotsRow);  // Calls method from Bus class to park bus in lot
        }

        // If user wishes to park a car, this runs
        else if (vType.charAt(0) == 'c') {
            Car c = new Car();
            lot = c.parkCar(lot, level);        // Calls method from Car class to park bus in lot
        }

        // If user wishes to park a motorcycle, this runs
        else if (vType.charAt(0) == 'm') {
            Motorcycle m = new Motorcycle();
            lot = m.parkMotorcycle(lot, level); // Calls method from Motorcycle class to park bus in lot
        }
        
        // If user input does not match any vehicle type, prompts of invalid input
        else {
            System.out.print("\nInvalid vehicle type, please try again..");
        }
        
        System.out.print("\n");
        spot.setLot(lot);           // Sets the lot with newly added vehicles
        spot.displayLot();          // Prints the new lot to user

    }
    
    
    // If a user wishes to remove a vehicle from the lot, this runs
    if(decision.charAt(0) == 'r') {
        
        // If user wishes to remove a bus, this runs
        if (vType.charAt(0) == 'b') {
            Bus b = new Bus();
            lot = b.removeBus(lot, level);
        }

        // If user wishes to remove a car, this runs
        else if (vType.charAt(0) == 'c') {
            Car c = new Car();
            lot = c.removeCar(lot, level);
        }

        // If user wishes to remove a motorcycle, this runs
        else if (vType.charAt(0) == 'm') {
            Motorcycle m = new Motorcycle();
            lot = m.removeMotorcycle(lot, level);
        }
        
        // If user input does not match any vehicle types, prompts of invalid input
        else {
            System.out.print("\nInvalid vehicle type, please try again..");
        }
        
        System.out.print("\n");
        spot.setLot(lot);           // Sets the lot with newly removed vehicles
        spot.displayLot();          // Prints the new lot to user

    }
    
    
    }
    
}
}




