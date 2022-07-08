package workoutCalendar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class userInput extends JFrame{
	private int partialWidth = 600;
	private int partialHeight = 575; 
	private int fullWidth = 1600;
	private int fullHeight = 1000;
	private int width;
	private int height; 
	
	public userInput() {
		width = partialWidth;
		height = partialHeight;
		  
        setTitle("Record Your Workout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //userInput.setLayout(new GridLayout());
	      //setting the bounds for the JFrame
        setPreferredSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
	}
	
	public void userInputPanels() {
		Container c = this.getContentPane();
		assembleWindowPanes(c);
        
	}
	
	private void assembleWindowPanes(Container c) {
		Color barbiePink = new Color(233, 65, 150);
		Color lightPink = new Color(250, 209, 230);
		Color powderblue = new Color(168, 234, 255);
		
		int borderThickness = 4; 
		
        JPanel userPanel = new JPanel(); 
        userPanel.setBackground(Color.white);
        userPanel.setPreferredSize(new Dimension(width, height));
        userPanel.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, barbiePink));
        c.add(userPanel);
        
        
        JPanel upperPanel = new JPanel(); 
        upperPanel.setBackground(lightPink);
        upperPanel.setPreferredSize(new Dimension(width - borderThickness*4, height/2 - borderThickness*6));
        upperPanel.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, 0, borderThickness, Color.white));
        userPanel.add(upperPanel);
        userPanel.setLayout(new GridLayout(2, 1));
        
        JPanel lowerPanel = new JPanel(); 
        lowerPanel.setBackground(Color.white);
        lowerPanel.setPreferredSize(new Dimension(width - borderThickness * 4, height/2 - borderThickness * 4));
        lowerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        userPanel.add(lowerPanel);
        
        
        JPanel lowerRight = new JPanel();
        lowerRight.setBackground(lightPink);
        lowerRight.setPreferredSize(new Dimension(width/2 - borderThickness*4, height/2 - borderThickness*6));
        lowerRight.setBorder(BorderFactory.createMatteBorder(0, 0, borderThickness, borderThickness/2, Color.white));

        lowerPanel.add(lowerRight);
        

        String[] exerciseCategories = {"Strength", "Cardio", "Stretching"};
        JComboBox<String> exerciseType = new JComboBox<>(exerciseCategories);
        exerciseType.setBackground(powderblue);
        exerciseType.setForeground(barbiePink);
        exerciseType.setBounds(80, 50, 140, 20);
        lowerRight.add(exerciseType);
        
        JButton selectType = new JButton();
        selectType.setText("Submit Exercise Type");
        selectType.setForeground(barbiePink);
        selectType.setBackground(powderblue);
        selectType.setPreferredSize(new Dimension(200, 50));
        Border emptyBorder = BorderFactory.createEmptyBorder();
        //set border to empty
        selectType.setBorder(emptyBorder);
        selectType.setOpaque(true);
        //selectType.setContentAreaFilled(false);
        lowerRight.add(selectType);
        
        JButton next = new JButton();
        next.setText("Next");
        next.setForeground(barbiePink);
        next.setBackground(powderblue);
        next.setPreferredSize(new Dimension(200, 50));
        //set border to empty
        next.setBorder(emptyBorder);
        next.setOpaque(true);
        lowerRight.add(next);
       
        
        JPanel lowerLeft = new JPanel(); 
        lowerLeft.setBackground(lightPink);
        lowerLeft.setPreferredSize(new Dimension(width/2 - borderThickness*4, height/2 - borderThickness*6));
        lowerLeft.setBorder(BorderFactory.createMatteBorder(0, borderThickness/2, borderThickness, 0, Color.white));

        lowerPanel.add(lowerLeft);
	}
}
