package javaGamev4;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;
public class javaGamev4 {

	public static void main(String[] args)throws IOException {
		//Declare and initialize variables
				String name = " ", mainMenu = " ";
				int accumulator = 0, mainMenuInt = 0,  highscore = 0, counter = 0; 
					
				
				
					
				//Prompt user for name
				name = JOptionPane.showInputDialog("Enter your name: ");
						
				//Display intro
				JOptionPane.showMessageDialog(null, "Welcome to the Impossible Quiz " + name + "!\n\t\tGood luck!" );

						
				//Main Loop
				
				{
				do
				{	//Display main menu and prompt user for main menu choice
					mainMenu = JOptionPane.showInputDialog("Pick from the following menu:\n" + 
					"1)\tSee Rules\n" + "2)\tPlay Game\n" + "3)\tExit\n");  //Display main menu catalog in one dialog + input
					mainMenuInt = Integer.parseInt(mainMenu);

					
				
					
					if (mainMenuInt == 1)
						//display rules
						JOptionPane.showMessageDialog(null, "You will be asked JAVA related questions to test your knowledge about the language. "
								+ "You must enter either A, B, C or D to answer the questions and recieve credit."); 
				
					else if (mainMenuInt == 2)
					{ 
						String question = " ", answer1 = " ", answer2 = " ", answer3 = " ", answer4 = " ", answer = " ", correctAnswer = " ", points = " ";    
						int pointsInt = 0, answerInt = 0;
						
							//read file 
						//declare a File object
						File filein = new File("questions.txt"); //attempt to open "names.txt"
						//Declare a scanner object
						Scanner fileInput = new Scanner(filein);
						
						while(fileInput.hasNext()) //while there is data in the file
						{
							
							//variables to each line
							question = fileInput.nextLine();
							answer1 = fileInput.nextLine(); 
							answer2 = fileInput.nextLine();
							answer3 = fileInput.nextLine();
							answer4 = fileInput.nextLine();
							correctAnswer = fileInput.nextLine();
							points = fileInput.nextLine(); 
							pointsInt = Integer.parseInt(points);
							
							do
							{
							counter = 0; 
							//display questions
							answer = JOptionPane.showInputDialog(question + "\n" + 
																answer1 + "\n" + 
																answer2 + "\n" + 
																answer3 + "\n" + 
																answer4 + "\n" + 
																"Score: " + accumulator + 
																"\nPlease select the correct answer");
							
							if (answer.equalsIgnoreCase(correctAnswer)) 
							{
								JOptionPane.showMessageDialog(null, "Correct Answer!\nPoints earned: " + pointsInt); 
								accumulator += pointsInt; 
							}
							
							else if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("c") || answer.equalsIgnoreCase("d"))
								JOptionPane.showMessageDialog(null, "Wrong Answer\nPoints earned: 0");
								
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid answer");
								counter = 1; 
							}
							} while (counter == 1); 
						}
						 JOptionPane.showMessageDialog(null, "Congratulations you have earned: " + accumulator + " points");
						 fileInput.close();
						 accumulator = 0; 
						 highscore = accumulator;
						 FileWriter appendfile = new FileWriter("highscores.txt", true); //if the file already exists, this will append the 
							//data in the file.  If it does not yet exist, the file will be created.
							//write to highscore.txt
						 
						 PrintWriter outfile = new PrintWriter(appendfile); //if the file already exists, this will overwrite the 
							//data in the file.  If it does not yet exist, the file will be created.
						 
							if (highscore > 0)
							outfile.println( name + "\t" + highscore);
							
							
							outfile.close();
							
					}	
						
						else if (mainMenuInt == 3)
							
					    JOptionPane.showMessageDialog(null, "Thanks for playing, Goodbye!");//exit and display farewell message
							
				
						else 
						{
							JOptionPane.showMessageDialog(null, "Error: Select from 1-3.");
						}
							
				
						
				}
					while (mainMenuInt != 3);
            
             
			}
       
		}

	public static int readInHighScore() throws IOException
	
	{
		//declare a File object
				File filein = new File("highscores.txt"); //attempt to open "employees.txt
				
			    //Declare a scanner object
				Scanner fileInput = new Scanner(filein);		
	
			  //declare variables
		      int highscore = 0;
		      while(fileInput.hasNext()) //while there is data in the file
		    	  
		      //read in a line
		      highscore = fileInput.nextInt();
		    
		      //close file
		      fileInput.close();
		      
			return highscore;
			
	}
			public static void compareScore(int highScore, int userScore)
			{
				
			}
				
	}
	

