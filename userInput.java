package workoutCalendar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
	
	private Color barbiePink = new Color(233, 65, 150);
	private Color lightPink = new Color(250, 209, 230);
	private Color powderblue = new Color(168, 234, 255);
	
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
	
	public void userInputPanels(String number) {
		Container c = this.getContentPane();
		assembleWindowPanes(c, number);
        
	}
	
	private void assembleWindowPanes(Container c, String number) {
		int borderThickness = 4; 
		JPanel[] panels = renderBasePanels(c); 
		JPanel lowerLeft = panels[3];
		JPanel upperPanel = panels[1];
		Font copperplateH1 = new Font("Copperplate", Font.PLAIN, 54);
		Font copperplateH2 = new Font("Copperplate", Font.PLAIN, 24);
		
		
		JPanel titlePanel = new JPanel(); 
		titlePanel.setBackground(Color.white);
		titlePanel.setPreferredSize(new Dimension(width - borderThickness * 8, 55));
		//titlePanel.setLayout(new GridLayout(2, 1));
		upperPanel.add(titlePanel);
		
		JLabel title = new JLabel();
		title.setText("Valerie's Workout");
		title.setBounds(width/2 - title.getWidth()/2, 20, title.getWidth(), title.getHeight());
		title.setFont(copperplateH1);
		title.setForeground(barbiePink);
		titlePanel.add(title);
		
		
		JPanel datePanel = new JPanel(); 
		datePanel.setBackground(powderblue);
		datePanel.setPreferredSize(new Dimension(width/2, 30));
		datePanel.setLayout(new FlowLayout());
		upperPanel.add(datePanel);
		
		
		JLabel date = new JLabel(); 
		date.setText("July " + number);
		date.setBounds(width/2 - title.getWidth()/2, 50, title.getWidth(), title.getHeight());
		date.setFont(copperplateH2);
		date.setForeground(Color.white);
		datePanel.add(date);
		
		 
		JPanel exerciseCategoryPanel = new JPanel(); 
		exerciseCategoryPanel.setBackground(powderblue);
		exerciseCategoryPanel.setPreferredSize(new Dimension(width/2, 30));
		exerciseCategoryPanel.setLayout(new FlowLayout());
		upperPanel.add(exerciseCategoryPanel);
		
		JLabel exerciseCategories = new JLabel();
		exerciseCategories.setBounds(width/2 - title.getWidth()/2, 200, title.getWidth(), title.getHeight());
		exerciseCategories.setFont(copperplateH2);
		exerciseCategories.setForeground(Color.white);
		exerciseCategoryPanel.add(exerciseCategories);
		
		JPanel exercisesPanel = new JPanel(); 
		exercisesPanel.setBackground(Color.white);
		exercisesPanel.setPreferredSize(new Dimension(width - borderThickness * 8, 125));
		//exercisesPanel.setBounds(50, 50, 100, 100);
		//exercisesPanel.setPreferredSize(new Dimension(width - borderThickness * 8, 75));
		upperPanel.add(exercisesPanel);
        
        JButton selectType = new JButton();
        renderButton(selectType, "Submit Exercise Type", true, lowerLeft);
        
        JButton selectStrength = new JButton();
        renderButton(selectStrength, "Submit Strength Type", false, lowerLeft);
        
        JButton selectCardio = new JButton();
        renderButton(selectCardio, "Submit Cardio Type", false, lowerLeft); 
        
        //by muscle group
        JButton selectShoulder = new JButton(); 
        renderButton(selectShoulder, "Select Shoulder Exercise", false, lowerLeft); 
        
        JButton selectBack = new JButton(); 
        renderButton(selectBack, "Select Back Exercise", false, lowerLeft); 
        
        JButton selectQuads = new JButton(); 
        renderButton(selectQuads, "Select Quad Exercise", false, lowerLeft); 
        
        JButton selectHamstrings = new JButton(); 
        renderButton(selectHamstrings, "Select Hamstrings Exercise", false, lowerLeft);
        
        JButton selectBiceps = new JButton(); 
        renderButton(selectBiceps, "Select Bicep Exercise", false, lowerLeft);
        
        JButton selectGlutes = new JButton(); 
        renderButton(selectGlutes, "Select Glute Exercise", false, lowerLeft);
        
        
       //drop down boxes 
        String[] exerciseGroup = {"Strength", "Cardio", "Stretching"};
        JComboBox<String> exerciseType = new JComboBox<>(exerciseGroup);
        renderComboBox(exerciseType, true, lowerLeft); 
        
        String[] strengthCategories = getStrengthCategories();
        JComboBox<String> strengthType = new JComboBox<>(strengthCategories);
        renderComboBox(strengthType, false, lowerLeft);
        
        String[] cardioCategories = getCardioCategories();
        JComboBox<String> cardioType = new JComboBox<>(cardioCategories);
        renderComboBox(cardioType, false, lowerLeft);
        
        String[] shoulderCategories = getShoulderCategories();
        JComboBox<String> shoulderType = new JComboBox<>(shoulderCategories);
        renderComboBox(shoulderType, false, lowerLeft);
        
        String[] backCategories = getBackCategories();
        JComboBox<String> backType = new JComboBox<>(backCategories);
        renderComboBox(backType, false, lowerLeft);
        
        String[] quadsCategories = getShoulderCategories();
        JComboBox<String> quadsType = new JComboBox<>(quadsCategories);
        renderComboBox(quadsType, false, lowerLeft);
        
        String[] hamstringCategories = getShoulderCategories();
        JComboBox<String> hamstringType = new JComboBox<>(hamstringCategories);
        renderComboBox(hamstringType, false, lowerLeft);
        
        String[] bicepCategories = getShoulderCategories();
        JComboBox<String> bicepType = new JComboBox<>(bicepCategories);
        renderComboBox(bicepType, false, lowerLeft);
        
        String[] gluteCategories = getShoulderCategories();
        JComboBox<String> gluteType = new JComboBox<>(gluteCategories);
        renderComboBox(gluteType, false, lowerLeft);
        
        selectType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exerciseType.setVisible(false);
				selectType.setVisible(false);
				
				String type = (String) exerciseType.getSelectedItem();
				if(type.equals("Strength")) {
					strengthType.setVisible(true);
					selectStrength.setVisible(true);
					lowerLeft.add(selectStrength);
					lowerLeft.add(strengthType);
				}
				else if(type.equals("Cardio")) {
					cardioType.setVisible(true);
					selectCardio.setVisible(true);
					lowerLeft.add(selectCardio);
					lowerLeft.add(cardioType);
				}
				exerciseCategories.setText(type);
			}
		});
        
        selectStrength.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectStrength.setVisible(false);
				strengthType.setVisible(false);
				
				String type = (String) strengthType.getSelectedItem();
				if(type.equals("Shoulders")) {
					shoulderType.setVisible(true);
					selectShoulder.setVisible(true);
					lowerLeft.add(selectShoulder);
					lowerLeft.add(shoulderType);
				}
				else if(type.equals("Back")) {
					lowerLeft.add(selectBack);
					lowerLeft.add(backType);					
				}
				else if(type.equals("Quads")) {
					lowerLeft.add(selectQuads);
					lowerLeft.add(quadsType);					
				}
				else if(type.equals("Hamstrings")) {
					lowerLeft.add(selectHamstrings);
					lowerLeft.add(hamstringType);					
				}
				else if(type.equals("Biceps")){
					lowerLeft.add(selectBiceps);
					lowerLeft.add(bicepType);
					
				}
				else if(type.equals("Glutes")) {
					lowerLeft.add(selectGlutes);
					lowerLeft.add(gluteType);					
				}
						
			}
		});
        
        
        selectShoulder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("heeelp");
				
				shoulderType.setVisible(false);
				selectShoulder.setVisible(false);
				
				String type = (String) shoulderType.getSelectedItem();
				JLabel shoulder = new JLabel(type);
				exercisesPanel.add(shoulder);

				
				lowerLeft.add(exerciseType);
				lowerLeft.add(selectType);
				exerciseType.setVisible(true);
				selectType.setVisible(true);
			}
		});
        
        cardioType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exerciseType.setVisible(false);
				selectType.setVisible(false);
				
				String type = (String) exerciseType.getSelectedItem();
				if(type.equals("Cardio")) {
					lowerLeft.add(cardioType);
					lowerLeft.add(selectCardio);
				}
			}
		});
        
        
        /*
        
        String[] stretchingCategories = {}; */
       
        
        /*
        JButton next = new JButton();
        next.setText("Next");
        next.setForeground(barbiePink);
        next.setBackground(powderblue);
        next.setPreferredSize(new Dimension(200, 50));
        //set border to empty
        next.setBorder(emptyBorder);
        next.setOpaque(true);
        lowerRight.add(next);*/
       
	}
	
	private JPanel[] renderBasePanels(Container c) {
		int borderThickness = 4; 
		JPanel[] panels = new JPanel[5];
		
		JPanel userPanel = new JPanel(); 
        userPanel.setBackground(Color.white);
        userPanel.setPreferredSize(new Dimension(width, height));
        userPanel.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, barbiePink));
        c.add(userPanel);
        panels[0] = userPanel;
        
        JPanel upperPanel = new JPanel(); 
        upperPanel.setBackground(lightPink);
        upperPanel.setPreferredSize(new Dimension(width - borderThickness*4, height/2 - borderThickness*6));
        upperPanel.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, 0, borderThickness, Color.white));
        userPanel.add(upperPanel);
        userPanel.setLayout(new GridLayout(2, 1));
        panels[1] = upperPanel;
        
        JPanel lowerPanel = new JPanel(); 
        lowerPanel.setBackground(Color.white);
        lowerPanel.setPreferredSize(new Dimension(width - borderThickness * 4, height/2 - borderThickness * 4));
        lowerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        userPanel.add(lowerPanel);
        panels[2] = lowerPanel;
        
        
        JPanel lowerLeft = new JPanel();
        lowerLeft.setBackground(lightPink);
        lowerLeft.setPreferredSize(new Dimension(width/2 - borderThickness*4, height/2 - borderThickness*6));
        lowerLeft.setBorder(BorderFactory.createMatteBorder(0, 0, borderThickness, borderThickness/2, Color.white));
        lowerPanel.add(lowerLeft);
        panels[3] = lowerLeft;
        
        JPanel lowerRight = new JPanel(); 
        lowerRight.setBackground(lightPink);
        lowerRight.setPreferredSize(new Dimension(width/2 - borderThickness*4, height/2 - borderThickness*6));
        lowerRight.setBorder(BorderFactory.createMatteBorder(0, borderThickness/2, borderThickness, 0, Color.white));
        lowerPanel.add(lowerRight);
        panels[4] = lowerRight;
        
        return panels;
	}
	
	private String[] getStrengthCategories() {
		String[] strengthCategories = {"Shoulders", "Back", "Quads", "Hamstrings", "Biceps", "Glutes"};
		return strengthCategories;
	}
	
	private String[] getCardioCategories() {
		String[] strengthCategories = {"Walk", "Run", "Bike", "Ski", "Golf"};
		return strengthCategories;
	}
	
	private String[] getShoulderCategories() {
		String[] shoulderCategories = {"Shoulder Press", "Front Raises", "Lateral Raises", "Overhand Barbell Row"};
		return shoulderCategories;
	}
	
	private String[] getBackCategories() {
		String[] backCategories = {};
		return backCategories;
	}
	
	private String[] getQuadCategories() {
		String[] quadCategories = {"Dumbell Lunges", "Sumo Squat", "Goblet Squat", "Barbell Squats", "Step-Ups"};
		return quadCategories; 
	}
	
	private String[] getHamstringCategories() {
		String[] hamstringCategories = {"Barbell Deadlift", "Barbell Squats"};
		return hamstringCategories;
	}
	
	private String[] getBicepCategories() {
		String[] bicepCategories = {"Overhand Barbell Row", "Barbell Curl"};
		return bicepCategories;
	}
	
	private String[] getGluteCategories() {
		String[] gluteCategories = {"Dumbell Lunges", "Sumo Squat", "Barbell Squats", "Step-Ups"};
		return gluteCategories; 
	}
	
	private void renderButton(JButton button, String buttonText, boolean addToPage, JPanel addToPanel) {
		button.setText(buttonText);
        button.setForeground(barbiePink);
        button.setBackground(powderblue);
        button.setPreferredSize(new Dimension(200, 50));
        Border emptyBorder = BorderFactory.createEmptyBorder();
        //set border to empty
        button.setBorder(emptyBorder);
        button.setOpaque(true);
        //selectType.setContentAreaFilled(false);
        if(addToPage)
        	addToPanel.add(button);
	}
	
	private void renderComboBox(JComboBox comboBox, boolean addToPage, JPanel addToPanel) {
		comboBox.setBackground(powderblue);
		comboBox.setForeground(barbiePink);
		//comboBox.setBounds(80, 50, 140, 20);
		comboBox.setPreferredSize(new Dimension(200, 50));
		if(addToPage)
			addToPanel.add(comboBox);
	}
}
