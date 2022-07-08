package workoutCalendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoxListener extends MouseAdapter
{
	private int partialWidth = 600;
	private int partialHeight = 575; 
	private int fullWidth = 1600;
	private int fullHeight = 1000;
	private int width;
	private int height; 
	
	public void mouseClicked(MouseEvent me)
	{
		  width = partialWidth;
		  height = partialHeight;
		  
          JPanel clickedBox =(JPanel)me.getSource(); // get the reference to the box that was clicked 
          JLabel label = (JLabel)clickedBox.getComponents()[0];
          String number = label.getText();
          //label.setText("clicked!");
          //clickedBox.setBackground(Color.white);
          JFrame userInput = new JFrame();
          userInput.setTitle("Record Your Workout");
          userInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //userInput.setLayout(new GridLayout());
  	      //setting the bounds for the JFrame
          userInput.setPreferredSize(new Dimension(width, height));
          userInput.setLocationRelativeTo(null);
          userInput.pack();
          userInput.setVisible(true);
          
          try {
              File myObj = new File(number + ".txt");
              FileWriter myWriter = new FileWriter(myObj.getName());
              myWriter.write("Files in Java might be tricky, but it is fun enough!");
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
              if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
              } else {
                System.out.println("File already exists.");
              }
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
          // insert here the code defining what happens when a grid is clicked
    }
}