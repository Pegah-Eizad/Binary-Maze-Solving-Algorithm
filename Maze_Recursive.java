/*This program uses recursion with stacks data structure and solves a binary maze and outputs the path it takes as well as 
 *whether or not the maze was solvable to being with. It reads the dimensions of a maze, 
 *the maze matrix and the starting and ending points from a text file. 
 */

//This code is owned by Pegah Eizadkhah and is not meant for redistribution. 

import java.io.*;
import java.util.*;

public class MazeRecursive 
{
	  int rows, cols, dim;
	  int [] dimensions = new int [2];        //stores dimensions of maze
	  int [] startingPositions = new int [2];  //stores starting positions of maze
	  int [] endingPositions = new int [2];    //stores ending positions of maze
	  int [][] maze;
	  boolean [][] visited;
	  
	  //reads and creates maze from text file, gets dimensions, values, and starting and ending positions  
	  public void createMaze(String fileName)
		{
		    // open file for reading
			Scanner inputStream = null;
			try
			{
				inputStream = new Scanner (new FileInputStream (fileName));
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Error: file not found or could not be opened!");
				System.exit(0);
			}

			String line;
			//get dimensions of the array				    
				line = inputStream.nextLine();
				dim = Integer.parseInt(line);
				rows = (dim/10);
				cols = (dim%10);
				
			maze= new int [rows][cols];
		
			//assign values to matrix coordinates

			int size = (rows * cols);
			int p = 0;
			int j=0;
			
			while(inputStream.hasNextLine())
			{   //read line by line
				line = inputStream.nextLine();
				System.out.println();
				
				//assign each line to a string
				String s = line;
				int k=0;

				  for (char c : s.toCharArray())
				  {
					  if (p >= size)
						 break;
					  int value = Integer.parseInt(String.valueOf(c));
					  maze[j][k] = value;
					  //CHECKPOINT: parses each digit: PASS
					  p++;
					  k++;
				  }
				j++;
				if (j == rows )
					break;
			}
	
			//parse starting positions 
			int kk =0;
			while(inputStream.hasNextLine())
			{
				line =inputStream.nextLine();
				
				String s = line;			
				for (char c : s.toCharArray())
				  {
					  int value = Integer.parseInt(String.valueOf(c));
					  startingPositions[kk] = value;
					  kk++;
					  
					  if(kk==2)
				          break;				  			 
				}
				
				if(kk==2)
			        break;
			}
			
			//parse ending positions
					int pp =0;
					while(inputStream.hasNextLine())
					{
						line =inputStream.nextLine();
						
						String s = line;			
						for (char c : s.toCharArray())
						  {
							  int value = Integer.parseInt(String.valueOf(c));
							  endingPositions[pp] = value;
							  pp++;
							  
							  if(pp==2)
						          break;				  			 
						}
						
						if(pp==2)
					      break;
					}
					
			inputStream.close();
		}
	  
	  public void  initializeVisitedArray()
	  {
	  visited = new boolean [rows][cols];
	  }
	  
	  //marks current location as visited
	  public boolean visited(int x, int y, boolean [][] visited)
	  {       System.out.print("(" + x +"," + y + ")");
		       return (visited[x][y]);
	  }
	  
	  //decides whether there is path from starting to ending positions
	  public boolean isPath()
	  {
		  return isPath(startingPositions[0], startingPositions[1]);
	  }
	  
	  private boolean isPath(int x, int y)
	  {
		  //current location is outside the maze
		  if ( x<0 || x>= rows || y <0 || y >= cols )
			  return false;
		  else if (maze[x][y] == 1)
			  return false;
		  else if (visited [x][y] == true)  
			  return false;
		  
		  //current location is exit
		  else if (x== endingPositions[0] && y == endingPositions[1] )
		  {   
			  System.out.print("(" + x +"," + y + ")");
			  return true;
		  }
		  
		  else
		  {  
		     visited[x][y] = true;
			  System.out.print("(" + x +"," + y + ")");	     
		     //if there is a path from one of the neighbors then there 
		     //is a path from current location
		     if (isPath(x-1,y) || isPath(x+1, y) || isPath(x, y-1) || isPath(x, y+1))
		    	 return true;
		     else
		    return false;
		  }
	  }
}
