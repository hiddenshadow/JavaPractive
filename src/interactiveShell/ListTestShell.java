package interactiveShell;

import java.util.Scanner;

public class ListTestShell {

	// Take input and operator, Modify the list, Print current list.
	
	public static void testScan(){
		
		Scanner sc = new Scanner(System.in);		
		String inp = sc.next();
		
		while( !inp.equalsIgnoreCase("quit") ){
			inp = sc.nextLine();
			System.out.println("inp - "+inp);
		}
		
		
		
		
		
	}
	
	
    public static void test() {

        System.out.println("Testing the main:");
        System.out.print("Enter input");
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter input: 1 to continue, 2 to quit");
            String input = sc.next();
            int serviceOptionNum = 0;

            try {
                serviceOptionNum = Integer.parseInt(input);

                boolean exit = false;

                switch (serviceOptionNum) {
                    case 1: {
                        System.out.println("1. Register Cabs  chosen");
                        System.out.println("Sample input: 1,IDLE,CHE,,2,ON_TRIP,UNDEFINED");

                        String cabString = sc.next();
                        String[] indCabStringArr = cabString.split(",,");

                        System.out.println("indCabStringArr - " + indCabStringArr);
                        break;
                    }
                    case 2: {
                        exit = true;
                        break;
                    }
                    default: {
                        System.out.println("No choice present.");
                        break;
                    }
                }


                if (exit) {
                    break; // Break only if exit is true. else continue;
                }

            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, continue");
            }
        }

    }

	
}
