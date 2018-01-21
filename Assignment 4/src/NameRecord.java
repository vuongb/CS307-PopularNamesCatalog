import java.util.ArrayList;
import java.util.Scanner;

public class NameRecord {
	
	// Fields
	private String name;
	private ArrayList<Integer> rank = new ArrayList<Integer>();
	
	
	// Constructors
	public NameRecord(String input)
	{	
		Scanner scan = new Scanner(input);
		name = scan.next();
		for(int i = 0; i < 11; i++)
			rank.add(i,scan.nextInt());
	}
	
	
	// Methods
	
	// method that returns name for this NameRecord
	// pre: null
	// post: returns String
	public String getName()
	{
		return this.name;
	}
	
	//method that returns this NameRecords rank for a given decade
	public int getRank(int date)
	{
		assert(date >= 1900 && date <= 2000): 
			"Violation of Pre-Condition. The date must be from " +
			"1900 to 2000. You gave: " + date;
		
		int index = 0;
		switch(date)
		{
			case 1900: index = 0; break;
			case 1910: index = 1; break;
			case 1920: index = 2; break;
			case 1930: index = 3; break;
			case 1940: index = 4; break;
			case 1950: index = 5; break;
			case 1960: index = 6; break;
			case 1970: index = 7; break;
			case 1980: index = 8; break;
			case 1990: index = 9; break;
			case 2000: index = 10; break;
		}
		return rank.get(index);
	}
	
	// method that returns the decade for this NameRecords best decade
	// The Best decade is the decade with the lowest # (Highest Rank)
	// pre: null
	// post: returns a decade(int) with the best rank
	public int bestDecade()
	{
		int best = Integer.MAX_VALUE;
		int bestIndex = 0;
		int date = 0;
		for(int i = 0; i < rank.size(); i++)
		{
			if(rank.get(i) <= best && rank.get(i) != 0)
			{
				best = rank.get(i);
				bestIndex = i;
			}
		}
		switch(bestIndex)
		{
			case 0: date = 1900; break;
			case 1: date = 1910; break;
			case 2: date = 1920; break;
			case 3: date = 1930; break;
			case 4: date = 1940; break;
			case 5: date = 1950; break;
			case 6: date = 1960; break;
			case 7: date = 1970; break;
			case 8: date = 1980; break;
			case 9: date = 1990; break;
			case 10: date = 2000; break;
		}
		return date;
	}
	
	// method that returns the number of decades this name has been ranked.
	// pre: null
	// post: returns the amount of decades the name has been ranked
	public int rankedDecades()
	{
		int count = 0;
		for(int i = 0; i < rank.size(); i++)
		{
			if(rank.get(i) > 0)
				count++;
		}
		return count;
	}
	
	// method that returns true if this name has been ranked in every decade
	// 0 indicates unranked
	// pre: null
	// post: returns boolean if it was ranked all 11 decades
	public boolean allRanked()
	{
		boolean bool = true;
		for(int i = 0; i < rank.size(); i++)
			bool = bool && rank.get(i) > 0;
		return bool;
	}
	
	// method that returns true if this name has been ranked in only one decade
	// pre: null
	// post: returns boolean if it was ranked in 1 decade
	public boolean oneDecade()
	{
		int count = 0;
		for(int i = 0; i < rank.size(); i++)
		{
			if(rank.get(i) > 0)
				count++;
		}
		return (count == 1) ? true: false;
	}
	
	// method that returns true if this name has been getting more popular every decade in the time period covered
	// pre: null
	// post: returns boolean if it has increased in popularity
	public boolean morePopular()
	{
		int diff = 0;
		boolean bool = true;
		for(int i = 0; i < rank.size() -1; i++)
		{
			diff = rank.get(i) - rank.get(i+1);
			bool = bool && (diff > 0);
			if(rank.get(i) == 0 && diff <0 && i == 0)
				bool = true;
		}
		return bool;
	}
	
	// method that returns true if this name has been getting less popular every decade in the time period covered.
	// pre: null
	// post: returns boolean if  the name has decreased in popularity
	public boolean lessPopular()
	{
		boolean bool = true;
		for(int i = 0; i < rank.size()-1; i++)
		{
			if(rank.get(i)<rank.get(i+1))
				bool = bool & true;
			else if(rank.get(i+1) == 0 && i+1 == rank.size()-1)
				bool = bool & true;
			else
				bool = bool & false;
		}
		return bool;
	}
	
}
