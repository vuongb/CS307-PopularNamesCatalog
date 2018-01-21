import java.util.ArrayList;
import java.util.Scanner;


public class Names
{
	
	// Fields
	private ArrayList<Object> array = new ArrayList<Object>();
	
	
	// Constructor
	public Names(Scanner scan)
	{
		String s;
		NameRecord temp;
		while(scan.hasNextLine())
		{
			s = scan.nextLine();
			temp = new NameRecord(s);
			array.add(temp);
		}
	}
	
	
	// Methods
	
	
	// method that returns an ArrayList of NameRecord objects that contain a given substring, ignoring case.  
	// pre: null
	// post: return an ArrayList with NameRecords containing String
	public ArrayList<Object> substringSearch(String str)
	{
		str = str.toLowerCase();
		ArrayList<Object> output = new ArrayList<Object>();
		String nameT;
		NameRecord temp;
		for(int i = 0; i < array.size(); i++)
		{
			temp = (NameRecord) array.get(i);
			nameT = temp.getName().toLowerCase();
			if(nameT.contains(str))
				output.add(temp);
		}
		return output;
	}
	
	// method that returns the NameRecord whose name is equal to a given String ignoring case. If there is no NameRecord that completely matches the given String return null
	// pre: null
	// post: return the NameRecord for that name
	public NameRecord nameSearch(String name)
	{
		name = name.toLowerCase();
		NameRecord output;
		NameRecord out = null;
		for(int i = 0; i < array.size(); i++)
		{
			//NEED IF STATEMENT WITH INSTANCE OF?
			output =(NameRecord) array.get(i);
			if(name.equals(output.getName().toLowerCase()))
				return output;
		}
		return out;
	}
	
	// method that returns an ArrayList of Strings of names that have been ranked in every decade.
	// pre: null
	// post: return a String ArrayList with all the names that have always been ranked
	public ArrayList<String> allRanked()
	{
		ArrayList<String> output = new ArrayList<String>();
		NameRecord temp;
		for(int i = 0; i < array.size(); i++)
		{
			temp = (NameRecord) array.get(i);
			if(temp.allRanked())
				output.add(temp.getName());
		}
		return output;
	}
	
	// method that returns an ArrayList of Strings of names that have been ranked in only one decade.
	// pre: null
	// post: return a String ArrayList for names that have been ranked only once
	public ArrayList<String> oneDecade()
	{
		ArrayList<String> output = new ArrayList<String>();
		NameRecord temp;
		for(int i = 0; i < array.size(); i++)
		{
			temp = (NameRecord) array.get(i);
			if(temp.rankedDecades() == 1)
				output.add(temp.getName());
		}
		return output;
	}
	
	// method that returns an ArrayList of Strings of names that have been getting more popular every decade
	// pre: null
	// post: return a String ArrayList of names that have gained in popularity every decade
	public ArrayList<String> morePopular()
	{
		ArrayList<String> output = new ArrayList<String>();
		NameRecord temp;
		for(int i = 0; i < array.size(); i++)
		{
			temp = (NameRecord) array.get(i);
			if(temp.morePopular())
				output.add(temp.getName());
		}
		return output;
	}
	
	// method that returns an ArrayList of Strings of names that have been getting less popular every decade.
	// pre: null
	// post: returns a String ArrayList of names that have loss popularity every decade
	public ArrayList<String> lessPopular()
	{
		ArrayList<String> output = new ArrayList<String>();
		NameRecord temp;
		for(int i = 0; i < array.size(); i++)
		{
			temp = (NameRecord) array.get(i);
			if(temp.lessPopular())
				output.add(temp.getName());
		}
		return output;
	}
	
	// Method that returns an Arraylist of names that begin with a specified letter
	// pre: null
	// post: returns an ArrayList String of names beginning with that letter
	public ArrayList<Object> firstLetter(String input)
	{
		ArrayList<Object> output = new ArrayList<Object>();
		ArrayList<Object> empty = null;
		NameRecord temp;
		String s;
		for(int i = 0; i < array.size(); i++)
		{
			temp = (NameRecord) array.get(i);
			s = temp.getName().toLowerCase();
			if(s.charAt(0) == input.charAt(0))
				output.add(temp);
		}
		if(output.size() == 0)
			return empty;
		else
			return output;
	}
	
}
