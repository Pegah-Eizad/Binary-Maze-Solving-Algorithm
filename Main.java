/*
*This program uses recursion and solves a binary maze given by a user-input text file 
*(for formatting see the file input.txt) and outputs whether or not the maze is 
*solvable and if it is, it outputs the path it took to solve the maze.
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
            System.out.println("Maze could not be solved. No path from starting to ending position.");
        }       
    }
}
