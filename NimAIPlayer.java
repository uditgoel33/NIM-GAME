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


/*
	NimAIPlayer.java
	
	This class is provided as a skeleton code for the tasks of 
	Sections 2.4, 2.5 and 2.6 in Project C. Add code (do NOT delete any) to it
	to finish the tasks. 

*/
public class NimAIPlayer extends NimPlayer implements Testable {
	// you may further extend a class or implement an interface
	// to accomplish the tasks.	
	
	public NimAIPlayer(String username, String given_name, String family_name) 
	{
		System.out.println("AI IS INITIALZIED");
		super(username,given_name,family_name);
		super.change_ai(1);
				
	}

public static int generateRandomIntIntRange(int min, int max) 
{
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
}
	

	public int removeStone(Scanner keyboard, NimGame game)
	{
			
			
			int stones_to_remove = 0;
			//It will calculate the move that will always guarantee victory. 
			int remainder = (game.game_details()[1] - 1)%(game.game_details()[0]+1);

			System.out.println( return_name()[2] +  "'s turn - remove how many?");
			//If no winnign move is poosible then AI will generate moves randomly. 
			if (remainder == 0)
			{
				System.out.println();
				return generateRandomIntIntRange(1,Math.min(game.game_details()[0],game.game_details()[1]));
			} 
			else
			{
				System.out.println();
				return remainder;
			}
			
	}
 
	public String advancedMove(boolean[] available, String lastMove) {
		// the implementation of the victory
		// guaranteed strategy designed by you
		String move = "";
		
		return move;
	}
}

