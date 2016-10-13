//Main (driver) class for the maze-solving program

import java.util.*;
public class Main
{
    public static void main (String [] args)
    {   
    	//create new scanner object
        Scanner keyboard = new Scanner(System.in);
        //create object of MazeGame class
        MazeRecursive  mmgg = new MazeRecursive();
        //read name of file
        System.out.println("Please enter the name of the maze file: ");
        String mazeFile = keyboard.next();

        //call on MazeGame method
        //System.out.println(mmgg.rows + " " + mmgg.cols);
        mmgg.createMaze(mazeFile);
        //System.out.println(mmgg.rows + " " + mmgg.cols);
        mmgg.initializeVisitedArray();
	     
        //print results
        if(mmgg.isPath())
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
