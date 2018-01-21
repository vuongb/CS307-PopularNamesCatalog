/*  Student information for assignment:
 *
 *  On my honor, Bryan Vuong, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: BKV85
 *  email address: vuong.bryan@gmail.com
 *  Grader name:
 *  Number of slip days I am using: 0
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Neat Searches
// The only month names that are ranked are april, may, june, august
// April is only popular in the last half century
// May is only popular in the first half of the century
// June is popular for about 75% of the century
// August was always popular the entire century 

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int FIRST_LETTER = 7;
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
				else if( choice == MORE_POPULAR)
					morePopular(n);
				else if( choice == LESS_POPULAR)
					lessPopular(n);
				else if( choice == FIRST_LETTER)
					firstLetter(n, keyboard);
				else
					System.out.println("\n\nGoodbye.");

			}while( choice != QUIT);
		}
		catch(FileNotFoundException e){
			System.out.println("Problem reading the data file. Exiting the program.");
		}
		
		
		// Test Cases
		
//		Test 1
//		Test accessors and constructors
//		String s = "A 83 140 228 286 426 612 486 577 836 0 0";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct name is: A");
//		System.out.println("The correct ranks should be: 83 140 228 286 426 612 486 577 836 0 0");
//		System.out.println("NameRecord's name is: " + n.getName());
//		System.out.println("Your rankings are: ");
//		for(int i = 1900; i <=2000; i+=10)
//			System.out.print(" " + n.getRank(i));
//		
//		Test 2
//		Test accessors and constructors
//		String s = "Loran 0 919 0 926 914 0 0 0 0 0 0";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct name is: Loran");
//		System.out.println("The correct ranks should be: 0 919 0 926 914 0 0 0 0 0 0");
//		System.out.println("NameRecord's name is: " + n.getName());
//		System.out.println("Your rankings are: ");
//		for(int i = 1900; i <=2000; i+=10)
//			System.out.print(" " + n.getRank(i));
//		
// 		Test 3
//		Test bestDecade
//		String s = "Louis 21 22 30 43 55 80 108 143 161 217 275";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The Best Decade is: 1900");
//		System.out.println("Your answer is: " + n.bestDecade());
//		
//		Test 4
//		Test rankedDecades
//		String s = "Merrill 402 382 390 399 528 661 907 0 0 0 0";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The Number of ranked decades is: 7");
//		System.out.println("Your answer is: " + n.rankedDecades());
//		
//		Test 5
//		Test allRanked
//		String s = "Mercedes 336 290 299 305 403 520 683 724 495 187 286";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: True");
//		System.out.println("Your answer is: " + n.allRanked());
//		
//		Test 6
//		Test allRanked
//		String s = "Merilyn 0 0 0 933 0 0 0 0 0 0 0";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: False");
//		System.out.println("Your answer is: " + n.allRanked());
//		
//		Test 7
//		Test oneDecade
//		String s = "Merilyn 0 0 0 933 0 0 0 0 0 0 0";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: True");
//		System.out.println("Your answer is: " + n.oneDecade());
//		
//		Test 8
//		Test oneDecade
//		String s = "Mckinley 558 791 585 686 707 756 0 0 0 0 0";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: False");
//		System.out.println("Your answer is: " + n.oneDecade());
//		
//		Test 9
//		Test morePopular
//		String s = "Eduardo 592 585 538 433 430 349 301 226 194 121 116";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: True");
//		System.out.println("Your answer is: " + n.morePopular());
//		
//		Test 10
//		Test morePopular
//		String s = "Elaine 364 190 84 52 47 82 143 267 349 454 566";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: False");
//		System.out.println("Your answer is: " + n.morePopular());
//		
//		Test 11
//		Test lessPopular
//		String s = "Albert 16 18 21 32 48 76 103 123 147 211 282";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: True");
//		System.out.println("Your answer is: " + n.lessPopular());
//		
//		Test 12
//		Test lessPopular
//		String s = "Cecil 70 71 87 116 154 219 300 431 489 778 0";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: True");
//		System.out.println("Your answer is: " + n.lessPopular());
//		
//		Test 13
//		Test lessPopular
//		String s = "Chance 0 0 0 0 0 0 0 657 379 221 212";
//		NameRecord n = new NameRecord(s);
//		System.out.println("The correct answer is: False");
//		System.out.println("Your answer is: " + n.lessPopular());
		
	}

	// method that shows names that have gained in popularity every decade
	// pre: n!=null
	// post: print out names that have gained in popularity ever decade
	private static void morePopular(Names n)
	{
		ArrayList<String> output = n.morePopular();
		System.out.println(output.size() + " names are more popular in every decade.");
		for(int i = 0; i < output.size(); i++)
			System.out.println(output.get(i));
	}
	
	// method that shows names that have decreased in popularity every decade
	// pre: n!=null
	// post: print out names that have decreased in popularity ever decade
	private static void lessPopular(Names n)
	{
		ArrayList<String> output = n.lessPopular();
		System.out.println(output.size() + " names are less popular in every decade.");
		for(int i = 0; i < output.size(); i++)
			System.out.println(output.get(i));
	}
	
	// method that shows ranked names that begin with a letter
	// pre: letter can be uppercase or lowercase but can't be anything other
	// post: print out names that begin with the letter
	private static void firstLetter(Names n, Scanner keyboard)
	{
		NameRecord temp;
		System.out.println("Please Enter Desired Name: ");
		String inputLetter = keyboard.nextLine();
		while(inputLetter.length() != 1)
		{
			System.out.println("That was not a letter.");
			inputLetter = keyboard.next();
		}
		ArrayList<Object> output = n.firstLetter(inputLetter.toLowerCase());
		if(output == null)
			System.out.println("There are no ranked names beginning with " + inputLetter);
		else
		{
			System.out.println("There are " + output.size() + " names beginning with " + inputLetter + ".\n");
			for(int i = 0; i< output.size(); i++)
			{
				temp = (NameRecord) output.get(i);
				System.out.print(temp.getName() + ":");
				for(int j = 1900; j <=2000; j+=10)
					System.out.print(" " + temp.getRank(i));
				System.out.println("");
			}

		}
	}
	
	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n)
	{
		ArrayList<String> output = n.allRanked();
		System.out.println(output.size() + " names appear in all decades. The names are: ");
		for(int i = 0; i < output.size(); i++)
			System.out.println(output.get(i));
	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n)
	{
		ArrayList<String> output = n.oneDecade();
		System.out.println(output.size() + " names appear in exactly one decade. The names are: ");
		for(int i = 0; i < output.size(); i++)
			System.out.println(output.get(i));
	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard)
	{
		System.out.println("Please Enter Desired Name: ");
		String inputName = keyboard.nextLine();
		NameRecord output = n.nameSearch(inputName);
		if(output == null)
			System.out.println(inputName + " does not appear in any decade.");
		else
		{
			System.out.print(output.getName() + ":");
			for(int i = 1900; i <=2000; i+=10)
				System.out.print(" " + output.getRank(i));
			System.out.println("");
			System.out.println("1900: " + output.getRank(1900));
			System.out.println("1910: " + output.getRank(1910));
			System.out.println("1920: " + output.getRank(1920));
			System.out.println("1930: " + output.getRank(1930));
			System.out.println("1940: " + output.getRank(1940));
			System.out.println("1950: " + output.getRank(1950));
			System.out.println("1960: " + output.getRank(1960));
			System.out.println("1970: " + output.getRank(1970));
			System.out.println("1980: " + output.getRank(1980));
			System.out.println("1990: " + output.getRank(1990));
			System.out.println("2000: " + output.getRank(2000));			
		}
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data		
	private static void search(Names n, Scanner keyboard)
	{
		System.out.println("Please Enter Desired Name: ");
		String sub = keyboard.nextLine();
		ArrayList<Object> output = n.substringSearch(sub);
		System.out.println("There are: " + output.size() + " choices for " + sub + ".\n");
		System.out.println("The matches with their highest ranking decade are: ");
		NameRecord temp;
		for(int i = 0; i < output.size(); i++)
		{
			temp = (NameRecord) output.get(i);
			System.out.println(temp.getName() + ":" + temp.bestDecade());
		}
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
		System.out.println("Enter " + MORE_POPULAR + " to display all names that get more popular every decade");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that get less popular every decade.");
		System.out.println("Enter " + FIRST_LETTER + " to display all names that begin with a user-specified letter.");
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
