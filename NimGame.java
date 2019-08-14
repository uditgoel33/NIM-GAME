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


public class NimGame
{
	
	//Describing the attribute of the current game. 
	public int stoneCount;
	public int upperBound; 
	private NimPlayer player1;
	private NimPlayer player2;
	private Nimsys data = new Nimsys();
	private Object [] names = data.playernames();
	
	//Method that will return the current stone count of the game. 
	public void stonecount_set(int number)
	{
		stoneCount = number;

	}

	//Methos that returns the upper bound of stone removal of the game. 
	public int [] game_details()
	{
		int [] details = new int[2];
		details[0] = upperBound;
		details[1] = stoneCount;
		return details;
	}
	public void upperbound_set(int number)
	{
		upperBound = number;
	}
	
	//Method that will start and display the while game while returning the index of the array of the player who wins the game. 
	public void startgame(String username1, String username2, Scanner keyboard, NimPlayer player1, NimPlayer player2)
	{
			
		
		int winner_index = -1;
		Nimsys game = new Nimsys();
		

		//Starting the game which is using 2 NimPlayer objects. 
		System.out.println();
		System.out.println("Initial stone count: " + stoneCount);
		System.out.println("Maximum stone removal: "+ upperBound);
		System.out.println("Player 1: " + player1.fullname());
		System.out.println("Player 2: " + player2.fullname());
		System.out.println();						
			
		for(int i=0;;i++)
		{
				
			int x = stoneCount;

			if(x >= 1)
			{
				int stones=0; 
				winner_index = -1;
					
				//Printing stones left line. 	
				player1.printingStones(stoneCount);
					
				//Printing remove how many line. 
				stones = player1.removeStone(keyboard,this); 
				
				while(stones < 1 || stones > stoneCount || stones > upperBound)
				{  
					try
					{
						throw new Exception("Invalid move. You must remove between 1 and " + Math.min(stoneCount,upperBound) + " stones.");
					}
					catch(Exception e)
					{
						String message = e.getMessage();
						System.out.println(message);
						System.out.println();
					}
					player1.printingStones(stoneCount);
					stones = player1.removeStone(keyboard,this);								
				}
				
				stoneCount = stoneCount - stones; 				 
					
				//Checking if we have reached game's end or not
				if (player2.checkingStonesLeft(stoneCount)==1)
				{
					player2.change_stats(player2.return_stats()[0]+1, player2.return_stats()[1]+1);
					player1.change_stats(player1.return_stats()[0]+1,player1.return_stats()[1]);
					break;
				}
					
				player2.printingStones(stoneCount);
					
				stones = player2.removeStone(keyboard,this); 
				while(stones < 1 || stones > stoneCount || stones > upperBound)
				{  
					try
					{
						throw new Exception("Invalid move. You must remove between 1 and " + Math.min(stoneCount,upperBound) + " stones.");
					}
					catch(Exception e)
					{
						String message = e.getMessage();
						System.out.println(message);
						System.out.println();
					}
					player2.printingStones(stoneCount);
					
					stones = player2.removeStone(keyboard,this);
				}
					
		
				//Checking if we have reached game's end or not 
				stoneCount = stoneCount - stones; 
				

				//player1.checkingStonesLeft(stoneCount);	
				if (player1.checkingStonesLeft(stoneCount)==1)
				{
					player2.change_stats(player2.return_stats()[0]+1, player2.return_stats()[1]);
					player1.change_stats(player1.return_stats()[0]+1, player1.return_stats()[1]+1);
					break;
				}
					
			}	
			
			else
			{
				
				break;
			}
			
		}
			
		 
	
		
	}
	
}


	
		
	

	

	






	




	





	






	






	







	
	








	






	
	
	
	

	

	






	
