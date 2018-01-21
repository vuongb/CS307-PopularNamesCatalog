/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	
	public static final int QUIT = 8;
	
	// main method. Driver for the whole program
	public static void main(String[] args) {
		try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    System.out.println("Opening GUI to choose file with names data.");
	        Scanner fileScanner = new Scanner( getFile() );
			Names n = new Names(fileScanner);
			int choice;
			Scanner keyboard = new Scanner(System.in);
			fileScanner.close();
			do{
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				else
					System.out.println("\n\nGoodbye.");

			}while( choice != QUIT);
		}
		catch(FileNotFoundException e){
			System.out.println("Problem reading the data file. Exiting the program.");
		}
	}

	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {

	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {

	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {

	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data		
	private static void search(Names n, Scanner keyboard) {

	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}
	
	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt){
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		// CS307 students fill in other options
		
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */ 
    public static File getFile(){
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}
