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
import java.util.Scanner ;
import java.util.StringTokenizer; 
import java.util.Arrays; 
import java.util.Comparator;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FileInputStream;




public class Nimsys
{
	
	//Declaring variables that will store all the players's data
	private NimPlayer [] player_names = new NimPlayer[100];
	private int totalNumberOfPlayers = 0;

	
	//Method to check if the number of arguments are correct or not.
	public static boolean checking_number_of_arguments(StringTokenizer arguments,int ideal_arguments)
	{
		 
		if (arguments.countTokens() < ideal_arguments)
		{
			
			try
			{
				throw new  Exception("Incorrect number of arguments supplied to command.");
			}
			catch(Exception e)
			{
				String message = e.getMessage();
				System.out.println(message);
				System.out.println();
			}
			return false;
		}
		
		return true;
	}

	
	//Method to return an array of NimPlayer objects. 
	public NimPlayer [] playernames()
	{
		return player_names;
	}

	
	//Method to sort the players in descending order. 
	public void sort_player_names_desc()
	{

		float [] winning_ratio = new float[totalNumberOfPlayers];
		int j=0,i=0;
		

		for (i=0; i<totalNumberOfPlayers;i++)
		{
				
			if (player_names[i].return_stats()[0] == 0)
			{
				winning_ratio[i] = 0;
			}
			else
			{
				winning_ratio[i] = (float)player_names[i].return_stats()[1]/(float)player_names[i].return_stats()[0] ;
			}
			
		}
		

		for (i = 0; i<totalNumberOfPlayers-1; i++)
		{
				
			NimPlayer temp1;

			for( j=i+1;j<totalNumberOfPlayers;j++)
			{
							
				if(winning_ratio[i] < winning_ratio[j])
			    {
			               
					temp1 = player_names[i];
				    player_names[i] = player_names[j];
					player_names[j] = temp1;
			        
			     }
			     
			  	 
			  	 if (winning_ratio[i] == winning_ratio[j])
			   	 {
			     	if((player_names[i].return_name()[0]).compareTo(player_names[j].return_name()[0]) > 0)
			     	{
				    	temp1 = player_names[i];
				        player_names[i] = player_names[j];
				        player_names[j] = temp1;
			     	}
			    
			    }
			     
			}
		
		}
		
	}

	
	//Method to sort the players in ascending order.
	public void sort_player_names_aesc()
	{
		
		
		float [] winning_ratio = new float[totalNumberOfPlayers];
		int j=0,i=0;
		

		for (i=0; i<totalNumberOfPlayers;i++)
		{
				
			if (player_names[i].return_stats()[0] == 0)
			{
				winning_ratio[i] = 0;
			}
			else
			{
				winning_ratio[i] = (float)player_names[i].return_stats()[1]/(float)player_names[i].return_stats()[0] ;
			}
			
		}
		
		
		for (i = 0; i<totalNumberOfPlayers; i++)
		{
				
			NimPlayer temp2;

			for( j=i+1;j<totalNumberOfPlayers;j++)
			{
							
				
				if(winning_ratio[i] > winning_ratio[j])
			    {
			            
					temp2 = player_names[i];
				    player_names[i] = player_names[j];
					player_names[j] = temp2;
			       
			        
			     }
			     
			  	  if (winning_ratio[i] == winning_ratio[j])
			   	  {
			           if((player_names[i].return_name()[0]).compareTo(player_names[j].return_name()[0]) > 0)
			     	   {
				    	
				    		temp2 = player_names[i];
				        	player_names[i] = player_names[j];
				        	player_names[j] = temp2;
			     		}
			   
			   	   }
			     
			}
			
		}

			   	
	}
			


	//This method will add new players to the data by creating objects of NimHummanPlayer class. 
	public void addplayers(String username, String name, String familyname)
	{
		
		int check =0;
		
		if (totalNumberOfPlayers == 0)
		{
			NimPlayer new_player = new NimHumanPlayer(username,name,familyname);
			player_names[totalNumberOfPlayers] = new_player;
			totalNumberOfPlayers = totalNumberOfPlayers+1;
			System.out.println();
		}
		
		else
		
		{
			for(int i=0;i<totalNumberOfPlayers;i++)
			{
				
				if (username.equals(player_names[i].return_name()[0]))
				{
					System.out.println("The player already exists.");
					System.out.println();
					check =1;				
				}
			}

			if (check == 0)
			{
				
				NimPlayer new_player = new NimHumanPlayer(username,name,familyname);
				player_names[totalNumberOfPlayers] = new_player;
				totalNumberOfPlayers = totalNumberOfPlayers+1; 
				System.out.println();	
			}		
		
		}
		
	}


	//Method that adds pew AI players to the data by creating instance NimAiPLayer. 
	public void addaiplayers(String username, String name, String family_name)
	{
		int check =0;
		
		if (totalNumberOfPlayers == 0)
		{
			NimPlayer new_player = new NimAIPlayer(username,name,family_name);
			player_names[totalNumberOfPlayers] = new_player;
			totalNumberOfPlayers = totalNumberOfPlayers+1;
			System.out.println();
		}
		
		else
		
		{
			for(int i=0;i<totalNumberOfPlayers;i++)
			{
				
				if (username.equals(player_names[i].return_name()[0]))
				{
					System.out.println("The player already exists.");
					System.out.println();
					check =1;				
				}
			}

			if (check == 0)
			{
				
				NimPlayer new_player = new NimAIPlayer(username,name,family_name);
				player_names[totalNumberOfPlayers] = new_player;
				totalNumberOfPlayers = totalNumberOfPlayers+1; 
				System.out.println();	
			}		
		
		}
	}

	

	public void change_totalplayers(int new_playercount)
	{
		totalNumberOfPlayers = new_playercount;

	}


	
	public int totalplayers()
	{
			return totalNumberOfPlayers;
	}


	
	//Method that will display the statistics and details of all or a particular player 
	public void displayplayer(String name)
		{
			int index = match_index(name, totalNumberOfPlayers);
			if(index == -1)
			{
				System.out.println("The player does not exist.");
				System.out.println();
			}
			else
			{
				
				System.out.println(player_names[index].return_name()[0] + "," + player_names[index].return_name()[1] + "," + player_names[index].return_name()[2] + "," + player_names[index].return_stats()[0] + " games" + "," + player_names[index].return_stats()[1] + " wins");
				System.out.println();
			}
			
		}
	

	
	public void displayplayer()
	{
		 
		
		sort_player_names_desc();
		for(int i=0;i<totalNumberOfPlayers;i++)
		{
			System.out.println(player_names[i].return_name()[0] + "," + player_names[i].return_name()[2] + "," + player_names[i].return_name()[1] + "," + player_names[i].return_stats()[0] + " games" + "," + player_names[i].return_stats()[1] + " wins");
		}
		System.out.println();

		
	}


	
	//Method that will reset the statistics of all or a particular player
	public void resetstats()
	{
		for (int i=0; i<totalNumberOfPlayers;i++)
		{
			player_names[i].change_stats(0,0);
		}
	}		
				

	
	public void resetstats(String username)
	{
		int index = match_index(username, totalNumberOfPlayers);
		if (index >= 0)
		{
			player_names[index].change_stats(0,0);
		}
		else
		{
			System.out.println("The player does not exist.");
			System.out.println();
		}
	}


	
	//Mthod to return the index of a player having a particular username 
	public int match_index(String name, int players_added)
	{
		int index = -1;
		totalNumberOfPlayers = totalplayers();
		for(int i=0; i<players_added;i++)
		{

			if(name.equals(player_names[i].return_name()[0]))
			{
				
					index = i;	
					
			}

		
		}
		
		return index;
	}


	
	//Method that removes players from the game, if thet already exist in the data. 
	public void removeplayers(String playerRemove)
	{
		int remove_index = match_index(playerRemove, totalNumberOfPlayers);
		
		if(remove_index > -1)
		{
			int j=0;
			totalNumberOfPlayers = totalNumberOfPlayers - 1;
			for (int i=0;i<totalNumberOfPlayers;i++)
			{
				if(i != remove_index)
				{
					player_names[i] = player_names[j];
					j = j+1;
				}
				else
				{
					
					j = j+1;
					player_names[i] = player_names[j];
				}
			}
			
			System.out.println();			
		}
		else
			{
				
				System.out.println("The player does not exist.");
				System.out.println();
			}
		
		
	}



	public void removeplayers()
	{
		NimPlayer [] new_table = new NimPlayer[100];
		totalNumberOfPlayers=0;
		player_names = Arrays.copyOf(new_table,100);
	}

	

	//Method to display the rankings of all the players that are currently playing the game. 
	public void rankings(String args)
	{
		
		if (args.equals("desc") || args.equals(""))
		{
			
			sort_player_names_desc();
			for(int i =0;i<totalNumberOfPlayers;i++)
			{
				if (player_names[i].return_stats()[0] == 0)
				{
					System.out.printf("0%%   | 00 games | %s\n", player_names[i].return_name()[2] + " " + player_names[i].return_name()[1]);		
				}
				else
				{
					float ratio = ( ((float) player_names[i].return_stats()[1])/player_names[i].return_stats()[0])*100 ;
					int dummy = Math.round(ratio);
					String percentage = (Integer.toString(dummy));
					System.out.printf("%-5s| %02d games | %s\n",percentage+"%",player_names[i].return_stats()[0],player_names[i].return_name()[2] + " " + player_names[i].return_name()[1]);	
				}
			}

			System.out.println();
		}
		else if (args.equals("asc"))
		{
			
			for(int i=0;i<totalNumberOfPlayers;i++)
			{
				sort_player_names_aesc();
			}
			for(int i =0;i<totalNumberOfPlayers;i++)
			{
						
				if (player_names[i].return_stats()[0] == 0)
				{
							
						System.out.printf("0%%   | 00 games | %s\n", player_names[i].return_name()[2] + " " + player_names[i].return_name()[1]);	
				}
				else
				{
							
					float ratio = ( ((float) player_names[i].return_stats()[1])/player_names[i].return_stats()[0])*100 ;
					int dummy = Math.round(ratio);
					String percentage = Integer.toString(dummy); 
					System.out.printf("%-5s| %02d games | %s\n",percentage+"%",player_names[i].return_stats()[0],player_names[i].return_name()[2] + " " + player_names[i].return_name()[1]);
				}
				 
			}
				 
			System.out.println();	

		}
				
	}
	

	
	//Method that will edit the player details. 
	public void editplayers(String username, String new_family_name, String new_given_name)
	{
		int index = match_index(username, totalNumberOfPlayers);
		if(index == -1)
		{
			System.out.println("The player does not exist.");
			System.out.println();
		}
		else
		{
			
			player_names[index].change_names(new_given_name, new_family_name);
			System.out.println();
		}

		
	}	



	public static void main(String[] args)
	{
			
			PrintWriter outputStreamName = null;
			Scanner inputStreamName = null;
			
			
			try
			{
				
				outputStreamName = new PrintWriter(new FileOutputStream("players.txt",true));
				inputStreamName = new Scanner(new FileInputStream("players.txt"));
				
			}	
			catch(FileNotFoundException e)
			{
				System.out.println("Problem opening files.");
				System.out.println();
			}


			
			Scanner keyboard = new Scanner(System.in);
			int players_added = 0; 
			Nimsys game = new Nimsys();
			game.change_totalplayers(players_added);
			NimPlayer [] names_table = new NimPlayer[100];
			//int [][] stats_table = new int[100][2];
			NimGame started = new NimGame();
			

			while(inputStreamName.hasNextLine())
			{
				
				
				String [] names_array = new String[3];
				int is_ai;
				is_ai = Integer.parseInt(inputStreamName.nextLine());
				
				names_array[0] = inputStreamName.nextLine();
				names_array[1] = inputStreamName.nextLine();
				names_array[2] = inputStreamName.nextLine(); 
				

				//If the player is an AI. Then, it will create a NimHumanPlayer instance. 
				if(is_ai == 0)
				{
					NimPlayer existing_players = new NimHumanPlayer(names_array[0], names_array[1], names_array[2]);
					existing_players.change_stats(Integer.parseInt(inputStreamName.nextLine()), Integer.parseInt(inputStreamName.nextLine()));
					game.playernames()[players_added] = existing_players;
				}
				//Else it will createn an instance of NimAiPlayer. 
				else
				{
					NimPlayer existing_players = new NimAIPlayer(names_array[0], names_array[1], names_array[2]);
					existing_players.change_stats(Integer.parseInt(inputStreamName.nextLine()), Integer.parseInt(inputStreamName.nextLine()));
					game.playernames()[players_added] = existing_players;
				}
				
				
				players_added = players_added+1;	
				game.change_totalplayers(players_added);

			}	
			inputStreamName.close();

			//Starting game
			System.out.println("Welcome to Nim");
			System.out.println(); 

			
			String response = "";
		
			
			while(true)
			{

				//Taking string input from the user. 
				System.out.print("$");
				response = keyboard.nextLine();

				

				//Running the game till user inputs "exit"
				if (!response.equals("exit"))
				{

					String delimeters = " "; 
					String arguments = "";
					StringTokenizer splitResponse = new StringTokenizer(response, delimeters);
					String methods = "";
					

					if (splitResponse.countTokens() > 0)
					{
						methods = splitResponse.nextToken();
					}
					
					
					if (splitResponse.countTokens() > 0)  
					{
						arguments =  splitResponse.nextToken();
					}

					
					
					StringTokenizer splitArgument = new StringTokenizer(arguments, ",");
					
					//Defining different methods that should run when different input is gathered from the user. 
					if (methods.equals("addplayer"))
					{
						

						//Checking if the number of arguments are correct or not. 
						if(checking_number_of_arguments(splitArgument,3))
						{
						
						
							String usernames = splitArgument.nextToken();
							String name = splitArgument.nextToken();
							String family_name = splitArgument.nextToken();
							game.addplayers(usernames, name, family_name);
							players_added = game.totalplayers();
						
						}
					}

					else if (methods.equals("startgame"))
					{

						
						//Checking if the number of arguments are correct or not.
						if(checking_number_of_arguments(splitArgument,4))
						{
							String stone = splitArgument.nextToken();
							int stone_int =  Integer.parseInt(stone);
							String bound = splitArgument.nextToken();
							int bound_int =  Integer.parseInt(bound);
							String user1 = splitArgument.nextToken();
							String user2 = splitArgument.nextToken();
							

							int index1 = game.match_index(user1,players_added);
							int index2 = game.match_index(user2, players_added);
							
							started.stonecount_set(stone_int);
							started.upperbound_set(bound_int);
							
							if (index1 > -1 && index2 > -1)
							{
								NimPlayer player1 = game.playernames()[index1];
								NimPlayer player2 = game.playernames()[index2];
								started.startgame(user1,user2,keyboard, player1, player2);
								keyboard.nextLine();
							}
							else
							{
								System.out.println("One of the players does not exist");
								System.out.println();
							}	
						
						}	
						
					}
				
					else if (methods.equals("addaiplayer"))
					{
						

						//Checking if the number of arguments are correct or not.
						if(checking_number_of_arguments(splitArgument,3))
						{
						
						
							String usernames = splitArgument.nextToken();
							String name = splitArgument.nextToken();
							String family_name = splitArgument.nextToken();
							game.addaiplayers(usernames, name, family_name);
							players_added = game.totalplayers();
						
						}
					}
							
					else if (methods.equals("removeplayer"))
					{	

						
						
							if (arguments == "")
							{
								System.out.println("Are you sure you want to remove all players? (y/n)");
								System.out.println();

								if(keyboard.nextLine().equals("y"))
								{

									game.removeplayers();
									players_added = game.totalplayers();
								}	
							}
							else
							{
								game.removeplayers(arguments);
							}
					
					}
					
					else if (methods.equals("editplayer"))
					{
						
						//Checking if the number of arguments are correct or not.
						if(checking_number_of_arguments(splitArgument,3))
						{
							String user = splitArgument.nextToken();
							String new_family_name = splitArgument.nextToken();
							String new_given_name = splitArgument.nextToken();
							game.editplayers(user,new_family_name,new_given_name);
						}
							
					}

					else if (methods.equals("resetstats"))
					{
						
						
						if (arguments != "")
						{
							game.resetstats(arguments);
						}
						

						else
						{
							

							System.out.println("Are you sure you want to reset all player statistics? (y/n)");
							System.out.println();
							

							if(keyboard.nextLine().equals("y"))
							{
								game.resetstats();
							}
						}
					}
					

					else if (methods.equals("displayplayer"))
					{
						
						if (arguments == "")
						{
							game.displayplayer();
						}
						else
						{
							game.displayplayer(arguments);
						}
					}	
				

					else if (methods.equals("rankings"))
					{
						
						game.rankings(arguments);
						
					}
				
					else
					{
						try
						{
							throw new Exception( "'" + methods+ "'" + " is not a valid command.");

						}
						catch(Exception e)
						{
							String message = e.getMessage();
							System.out.println(message);
							System.out.println();
						}
					}
				}
					
				else 
				{
				
					
					try
					{
						outputStreamName = new PrintWriter(new FileOutputStream("players.txt"));
					}
					catch(FileNotFoundException e)
					{
						System.out.println("File Not Found");
					}

					for(int i =0;i<players_added;i++)
				    {
							
						
						//This will print obejct attributes to the file line by line. 
						outputStreamName.println(game.playernames()[i].return_stats()[2]);
						outputStreamName.println(game.playernames()[i].return_name()[0]);
						outputStreamName.println(game.playernames()[i].return_name()[1]);
						outputStreamName.println(game.playernames()[i].return_name()[2]);
						outputStreamName.println(game.playernames()[i].return_stats()[0]);
						outputStreamName.println(game.playernames()[i].return_stats()[1]);
						
					
					}
					outputStreamName.close();
					System.out.println();
					System.exit(0);
				}	
		
			}	

		}	

	}	

