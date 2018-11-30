package Server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;


public class WriteToFile
	{
      private File file;
      FileOutputStream fileOut;
      FileInputStream fileIn;
      PrintWriter write;
      Scanner input ;
      public WriteToFile()
      {
    	 try
			{
				fileOut = new FileOutputStream("TicTacToe.txt") ;
				fileIn = new FileInputStream("TicTacToe.txt") ;
				input = new Scanner(fileIn);
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 
    	 write = new PrintWriter(fileOut);
      }
      
		
      public void writeLine(String line)
      {
    	  write.println(line);
      }
      public List<String> getAllLines()
      {
    	  List<String>ticTacToeMoves =
			null;
    	  
    	while(input.hasNext())
    		{
    			ticTacToeMoves.add(input.nextLine());
    		}
		return null;
    	  
      }
	}
