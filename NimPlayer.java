/* *****************************************************************************
 *  Name:    Udit Goel 
 *  EmailId:   ugoel@student.unimelb.edu.au 
 *  
 *
 *  Description:  This code is written for the COMP90041 project and is the third in a series of three, with the ultimate objective of designing and implementing
 *			  	  a simple variant of the game of Nim
 *
 *  Written:       30/05/2019
 *  
 *
 **************************************************************************** */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.util.Arrays;
public  abstract class NimPlayer
{
	
	//Declaring the attributes of the players that will play the game
	private String userName; 
	private String givenName; 
	private String familyName;
	private int gamesPlayed; 
	private int gamesWon;
	private int is_ai; 
	
	//Constructor
	public void change_ai(int i)
	{
		is_ai = i;
	}
	
	public NimPlayer(String user, String name, String family_name)
	{
		userName =  user;
		givenName = name;
		familyName = family_name;
		gamesPlayed = 0;
		gamesWon = 0;
		
	}
	public String [] return_name()
	{
		String [] names = new String[3];
		names[0] = userName;
		names[2] = familyName;
		names[1] = givenName;
		return names;
	}

	public int [] return_stats()
	{
		int [] stats = new int[3];
		stats[0] = gamesPlayed;
		stats[1] = gamesWon;
		stats[2] = is_ai;
		return stats;
	}


	
	public void change_names(String new_given_name, String new_family_name)
	{
		givenName = new_given_name;
		familyName = new_family_name;
	}

	public void change_stats(int new_games_played, int new_games_won)
	{
		gamesPlayed = new_games_played ;
		gamesWon = new_games_won;
	}
	
	//Method to return the fullname of the player
	public String fullname ()
	{
		return (familyName + " " + givenName);
	}

	
	//Method that will return an array containg the detials of the player that is to be added. 
	public static String [] addplayer(String user, String name, String family)
	{
		String [] record = new String[3];
		record[0] = user;
		record[1] = family;
		record[2] = name; 
		return record;
	}

	
	//Method that will print the number of stones that are left as the game progresses. 
	public void printingStones(int initial)
	{
		int x = 0;
		System.out.print(initial + " stones left:");
		while(x < initial)
		{
			System.out.print(" *");
			x++;
		}
		System.out.println();
	}

	
	//Method that checks whether we have reached the end of the game of not. 
	public int checkingStonesLeft(int check)
	{
		if (check == 0 )
		{
			System.out.println("Game Over");
			System.out.println(familyName + " " + givenName + " wins!");
			System.out.println();
			
			return 1;
		}
		else
		{
			return 0;
		}	
	}

	
	public abstract int removeStone(Scanner keyboard, NimGame game);
	

}

