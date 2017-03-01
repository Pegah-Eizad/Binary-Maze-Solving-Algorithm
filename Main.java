/*This program uses recursion and solves a binary maze and outputs the path it takes as well as 
 *whether or not the maze was solvable to begin with. It reads the dimensions of a maze, 
 *the maze matrix and the starting and ending points from a text file. 
 */

//This code is owned by Pegah Eizadkhah and is not meant for redistribution. 
//Main (driver) class for the maze-solving program

import java.util.*;
public class Main
{
    public static void main (String [] args)
    {   
    	//create new scanner object
        Scanner keyboard = new Scanner(System.in);
        //create object of MazeGame class
        MazeRecursive maze = new MazeRecursive();
        //read name of file
        System.out.println("Please enter the name of the maze file: ");
        String mazeFile = keyboard.next();

        //input the text file containing the maze to be solved 
        //and initialize the visited array 
        maze.createMaze(mazeFile);
        maze.initializeVisitedArray();
	     
        //call the recursive method to solve the maze and print the results
        if(maze.isPath())
        {
            System.out.println();
            System.out.println("Maze was solved!");
        }
        else
        {
            System.out.println();
            System.out.println("Maze could not be solved.");
        }       
    }
}
