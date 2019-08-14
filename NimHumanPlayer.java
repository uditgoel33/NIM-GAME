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
import java.util.*;

public class NimHumanPlayer extends NimPlayer
{
	
	//Constructor for the NimHumPlayer class. 
	public NimHumanPlayer(String username, String given_name, String family_name) 
	{
		super(username,given_name,family_name);
		super.change_ai(0);
				
	}
	


	public int removeStone(Scanner keyboard, NimGame game)
	{
		System.out.println( return_name()[2] +  "'s turn - remove how many?");
		
		int z = keyboard.nextInt();
		System.out.println();
		return z;
	}
}