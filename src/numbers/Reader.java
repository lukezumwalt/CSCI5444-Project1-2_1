package numbers;

import java.util.Scanner;
import java.util.ArrayList;

public class Reader {
    public void loopForInput( ArrayList<Integer> numbers ) {

        Scanner input = new Scanner( System.in );
        boolean stillRunning = true;

        while( stillRunning ) {
            System.out.print("Enter Number: ");

            // Get Input from User
            String command = input.nextLine();

            // Exit Case
            if( command == "" )
            {
                System.out.println( "\nProcessing...\n" );
                break;
            }

            // Argument Type Validation
            try
            {
                Integer.parseInt( command );
            }
            catch( NumberFormatException e )
            {
                System.out.println("Invalid Input: entry must be a real integer.");
                continue;
            }

            // Valid Entry
            numbers.add( Integer.parseInt( command ) );
            System.out.println("\nCurrently: " + numbers);
        }
    }
}
