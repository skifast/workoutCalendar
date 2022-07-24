package workoutCalendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.Border;

public class ButtonsAndSelectors {
	private Color barbiePink = new Color(233, 65, 150);
	private Color powderblue = new Color(168, 234, 255);
	
	public ButtonsAndSelectors() {
		
	}
	
	public List<JButton> createButtons(List<JButton> buttons, JPanel lowerLeft, JPanel lowerRight){
	 	JButton selectType = new JButton();
	    renderButton(selectType, "Submit Exercise Type", true, lowerLeft);
	    buttons.add(selectType);
	    
	    JButton selectStrength = new JButton();
	    renderButton(selectStrength, "Submit Strength Type", false, lowerLeft);
	    buttons.add(selectStrength);
	    
	    JButton selectCardio = new JButton();
	    renderButton(selectCardio, "Submit Cardio Type", false, lowerLeft); 
	    buttons.add(selectCardio);
	    
	    //by muscle group
	    JButton selectShoulder = new JButton(); 
	    renderButton(selectShoulder, "Select Shoulder Exercise", false, lowerLeft); 
	    buttons.add(selectShoulder);
	    
	    JButton selectBack = new JButton(); 
	    renderButton(selectBack, "Select Back Exercise", false, lowerLeft); 
	    buttons.add(selectBack);
	    
	    JButton selectQuads = new JButton(); 
	    renderButton(selectQuads, "Select Quad Exercise", false, lowerLeft); 
	    buttons.add(selectQuads);
	    
	    JButton selectHamstrings = new JButton(); 
	    renderButton(selectHamstrings, "Select Hamstrings Exercise", false, lowerLeft);
	    buttons.add(selectHamstrings);
	    
	    JButton selectBiceps = new JButton(); 
	    renderButton(selectBiceps, "Select Bicep Exercise", false, lowerLeft);
	    buttons.add(selectBiceps);
	    
	    JButton selectGlutes = new JButton(); 
	    renderButton(selectGlutes, "Select Glute Exercise", false, lowerLeft);
	    buttons.add(selectGlutes);
	    
	    JButton selectChest = new JButton(); 
	    renderButton(selectChest, "Select Chest Exercise", false, lowerLeft);
	    buttons.add(selectChest);
	    
	    JButton selectTriceps = new JButton(); 
	    renderButton(selectTriceps, "Select Tricep Exercise", false, lowerLeft);
	    buttons.add(selectTriceps);
	    
	    JButton selectLats = new JButton(); 
	    renderButton(selectLats, "Select Lats Exercise", false, lowerLeft);
	    buttons.add(selectLats);
	    
	    JButton selectRep = new JButton(); 
	    renderButton(selectRep, "Select Reps", false, lowerRight);
	    buttons.add(selectRep);
	    
	    return buttons;
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
	
	public List<JComboBox<String>> createSelectors (List<JComboBox<String>> selectors, JPanel lowerLeft){
		//drop down boxes 
        String[] exerciseGroup = {"Strength", "Cardio", "Stretching"};
        JComboBox<String> exerciseType = new JComboBox<>(exerciseGroup);
        renderComboBox(exerciseType, true, lowerLeft); 
        selectors.add(exerciseType);
        
        String[] strengthCategories = getStrengthCategories();
        JComboBox<String> strengthType = new JComboBox<>(strengthCategories);
        renderComboBox(strengthType, false, lowerLeft);
        selectors.add(strengthType);
        
        String[] cardioCategories = getCardioCategories();
        JComboBox<String> cardioType = new JComboBox<>(cardioCategories);
        renderComboBox(cardioType, false, lowerLeft);
        selectors.add(cardioType);
        
        String[] shoulderCategories = getShoulderCategories();
        JComboBox<String> shoulderType = new JComboBox<>(shoulderCategories);
        renderComboBox(shoulderType, false, lowerLeft);
        selectors.add(shoulderType);
        
        String[] backCategories = getBackCategories();
        JComboBox<String> backType = new JComboBox<>(backCategories);
        renderComboBox(backType, false, lowerLeft);
        selectors.add(backType);
        
        String[] quadsCategories = getQuadCategories();
        JComboBox<String> quadsType = new JComboBox<>(quadsCategories);
        renderComboBox(quadsType, false, lowerLeft);
        selectors.add(quadsType);
        
        String[] hamstringCategories = getHamstringCategories();
        JComboBox<String> hamstringType = new JComboBox<>(hamstringCategories);
        renderComboBox(hamstringType, false, lowerLeft);
        selectors.add(hamstringType);
        
        String[] bicepCategories = getBicepCategories();
        JComboBox<String> bicepType = new JComboBox<>(bicepCategories);
        renderComboBox(bicepType, false, lowerLeft);
        selectors.add(bicepType);
        
        String[] gluteCategories = getGluteCategories();
        JComboBox<String> gluteType = new JComboBox<>(gluteCategories);
        renderComboBox(gluteType, false, lowerLeft);
        selectors.add(gluteType);
        
        String[] chestCategories = getChestCategories();
        JComboBox<String> chestType = new JComboBox<>(chestCategories);
        renderComboBox(chestType, false, lowerLeft);
        selectors.add(chestType);
        
        String[] tricepCategories = getTricepCategories();
        JComboBox<String> tricepType = new JComboBox<>(tricepCategories);
        renderComboBox(tricepType, false, lowerLeft);
        selectors.add(tricepType);
        
        String[] latCategories = getLatCategories();
        JComboBox<String> latType = new JComboBox<>(latCategories);
        renderComboBox(latType, false, lowerLeft);
        selectors.add(latType);
        
        return selectors;
	} 
	
	private void renderComboBox(JComboBox comboBox, boolean addToPage, JPanel addToPanel) {
		comboBox.setBackground(powderblue);
		comboBox.setForeground(barbiePink);
		//comboBox.setBounds(80, 50, 140, 20);
		comboBox.setPreferredSize(new Dimension(200, 50));
		if(addToPage)
			addToPanel.add(comboBox);
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
		String[] shoulderCategories = {"Shoulder Press", "Front Raises", "Lateral Raises", "Overhand Barbell Row",
				"Dumbbell Chest Fly", "Standing Cable Chest Fly", "Decline Barbell Press", "Front Cable Raise",
				"Dumbbell Upright Row", "Straight Bar Upright Row", "Rear Deltoid Fly"};
		return shoulderCategories;
	}
	
	private String[] getBackCategories() {
		String[] backCategories = {"Pull-Up", "Rear Deltoid Fly", "Rear Deltoid Fly", "Seated Low Row", "Good Mornings"};
		return backCategories;
	}
	
	private String[] getQuadCategories() {
		String[] quadCategories = {"Dumbbell Lunges", "Sumo Squat", "Goblet Squat", "Barbell Squats", "Step-Ups",
				"Dumbbell Front Squats", "Reverse Lunge", "Side Lunges", "Leg Press", "Leg Extension"};
		return quadCategories; 
	}
	
	private String[] getHamstringCategories() {
		String[] hamstringCategories = {"Barbell Deadlift", "Barbell Squats", "Good Mornings", "Hamstring Curl",
				"Side Lunges"};
		return hamstringCategories;
	}
	
	private String[] getBicepCategories() {
		String[] bicepCategories = {"Overhand Barbell Row", "Barbell Curl", "Pull-up", "Seated Low Row", "Biceps Curl",
				"Hammer Curl"};
		return bicepCategories;
	}
	
	private String[] getGluteCategories() {
		String[] gluteCategories = {"Dumbbell Lunges", "Sumo Squat", "Barbell Squats", "Step-Ups", "Dumbbell Front Squats",
				"Good Mornings", "Hamstring Curl", "Reverse Lunge", "Side Lunges"};
		return gluteCategories; 
	}
	
	private String[] getChestCategories() {
		String[] chestCategories = {"Dumbbell Chest Press", "Barbell Chest Press", "Dumbell Chest Fly", "Standing Cable Chest Fly",
				"Decline Barbell Press", "Push-Up", "Dumbbell Pullover"};
		return chestCategories; 
	}
	
	private String[] getTricepCategories() {
		String[] tricepCategories = {"Dumbbell Chest Press", "Barbell Chest Press", "Decline Barbell Press", "Push-Up",
				"Dumbbell Pullover", "Triceps Kickback", "Triceps Dip"};
		return tricepCategories;
	}
	
	private String[] getLatCategories() {
		String[] latCategories = {"Lat Pulldown", "Pull-Up", "Dumbbell Pullover", "Seated Low Row"};
		return latCategories;
	}
	
	public void addActionListeners(List<JButton> buttons, List<JComboBox<String>> selectors, JPanel lowerLeft, JPanel lowerRight,
		List<JLabel> displayLabels, JPanel exercisesPanel, JLabel exerciseCategories, JSpinner reps_number_spinner){
		JButton selectType = buttons.get(0);
		JButton selectStrength = buttons.get(1);
        JButton selectCardio = buttons.get(2);
        JButton selectShoulder = buttons.get(3);
        JButton selectBack = buttons.get(4);
        JButton selectQuads = buttons.get(5);
        JButton selectHamstrings = buttons.get(6);
        JButton selectBiceps = buttons.get(7);
        JButton selectGlutes = buttons.get(8);
        JButton selectChest = buttons.get(9);
        JButton selectTriceps = buttons.get(10);
        JButton selectLats = buttons.get(11);
        JButton selectRep = buttons.get(12);
        
        JComboBox<String> exerciseType = selectors.get(0);
        JComboBox<String> strengthType = selectors.get(1);
        JComboBox<String> cardioType = selectors.get(2);
        JComboBox<String> shoulderType = selectors.get(3);
        JComboBox<String> backType = selectors.get(4);
        JComboBox<String> quadsType = selectors.get(5);
        JComboBox<String> hamstringType = selectors.get(6);
        JComboBox<String> bicepType = selectors.get(7);
        JComboBox<String> gluteType = selectors.get(8);
        JComboBox<String> chestType = selectors.get(9);
        JComboBox<String> tricepType = selectors.get(10);
        JComboBox<String> latType = selectors.get(11);
        
        
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
        
        selectRep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reps_number_spinner.setVisible(false);
				selectRep.setVisible(false);
				
				int value = (int) reps_number_spinner.getValue();
				System.out.println(value);
				/*
				if(type.equals("Cardio")) {
					lowerLeft.add(cardioType);
					lowerLeft.add(selectCardio);
				}*/
			}
		});
        
		selectShoulder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, shoulderType, selectShoulder, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
			}
		});
        
        selectBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, backType, selectBack, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
			}
		});
        
        selectQuads.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, quadsType, selectQuads, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
			}
		});
        
        selectHamstrings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, hamstringType, selectHamstrings, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
			}
		});
        
        selectBiceps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, bicepType, selectBiceps, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
			}
		});
        
        selectGlutes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, gluteType, selectGlutes, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
			}
		});
     
        selectChest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, chestType, selectChest, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
				}
		});
        
        selectTriceps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, tricepType, selectTriceps, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
				}
		});
        
        selectLats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPartHelper(reps_number_spinner, latType, selectLats, exerciseType, selectType, strengthType,
						selectStrength, displayLabels, lowerLeft, lowerRight, exercisesPanel, selectRep);
				}
		});
	}
	
	private void selectPartHelper(JSpinner reps_number_spinner, JComboBox<String> partType, JButton selectPart, JComboBox<String> exerciseType, 
			JButton selectType, JComboBox<String> strengthType, JButton selectStrength, List<JLabel> displayLabels,
			JPanel lowerLeft, JPanel lowerRight, JPanel exercisesPanel, JButton selectRep) {
		partType.setVisible(false);
		selectPart.setVisible(false);
		
		String type = (String) partType.getSelectedItem();
		JLabel newLabel = new JLabel(type);
		displayLabels.add(newLabel);
		updateDisplayLabels(exercisesPanel, displayLabels);

		lowerLeft.add(selectType);
		lowerLeft.add(exerciseType);
		
		selectRep.setVisible(true);
		lowerRight.add(selectRep);
		

		reps_number_spinner.setVisible(true);
		lowerRight.add(reps_number_spinner);
		
		strengthType.setVisible(true);
		selectStrength.setVisible(true);
	}
	
	private void updateDisplayLabels(JPanel exercisesPanel, List<JLabel> displayLabels) {
		if(displayLabels.size() < 2) {
			exercisesPanel.setLayout(new GridLayout(displayLabels.size(), 1));
		}
		else if(displayLabels.size() > 2) {
			exercisesPanel.setLayout(new GridLayout(displayLabels.size() / 2, 2));
		}
		else if(displayLabels.size() > 6) {
			exercisesPanel.setLayout(new GridLayout(displayLabels.size() / 3, 3));
		}
		
		for(int i = 0; i < displayLabels.size(); i++) {
			exercisesPanel.add(displayLabels.get(i));
		}
	}
}