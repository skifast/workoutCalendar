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
import java.util.ArrayList;
import java.util.List;

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
	private int borderThickness = 4; 
	
	private Color barbiePink = new Color(233, 65, 150);
	private Color lightPink = new Color(250, 209, 230);
	private Color powderblue = new Color(168, 234, 255);
	
	private List<JLabel> displayLabels;
	
	Font copperplateH1 = new Font("Copperplate", Font.PLAIN, 54);
	Font copperplateH2 = new Font("Copperplate", Font.PLAIN, 24);
	
	public userInput() {
		width = partialWidth;
		height = partialHeight;
		
		displayLabels = new ArrayList<>(); 
		  
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
		RenderPanels renderPanels = new RenderPanels(); 
		
		JPanel[] panels = renderPanels.renderBasePanels(c); 
		JPanel upperPanel = panels[1];
		JPanel lowerLeft = panels[3];
		panels = renderPanels.renderSecondRoundPanels(upperPanel, number, panels); 
		JPanel exerciseCategoryPanel = panels[7];
		JPanel exercisesPanel = panels[8];
		
		JLabel exerciseCategories = new JLabel();
		exerciseCategories.setBounds(width/2 - 100, 200, 400, 20);
		exerciseCategories.setFont(copperplateH2);
		exerciseCategories.setForeground(Color.white);
		exerciseCategoryPanel.add(exerciseCategories);
		
		
		List<JButton> buttons = new ArrayList<>();
		List<JComboBox<String>> selectors = new ArrayList<>(); 
		
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
        
        strengthSelectorActionListeners(buttons, selectors, lowerLeft);
        
        
        
        
        selectShoulder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				shoulderType.setVisible(false);
				selectShoulder.setVisible(false);
				
				String type = (String) shoulderType.getSelectedItem();
				JLabel shoulder = new JLabel(type);
				displayLabels.add(shoulder);
				updateDisplayLabels(exercisesPanel);

				lowerLeft.add(selectType);
				lowerLeft.add(exerciseType);
				strengthType.setVisible(true);
				selectStrength.setVisible(true);
			}
		});
        
        selectBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				backType.setVisible(false);
				selectBack.setVisible(false);
				
				String type = (String) backType.getSelectedItem();
				JLabel back = new JLabel(type);
				displayLabels.add(back);
				updateDisplayLabels(exercisesPanel);

				lowerLeft.add(selectType);
				lowerLeft.add(exerciseType);
				strengthType.setVisible(true);
				selectStrength.setVisible(true);
			}
		});
        
        selectQuads.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				quadsType.setVisible(false);
				selectQuads.setVisible(false);
				
				String type = (String) quadsType.getSelectedItem();
				JLabel quads = new JLabel(type);
				displayLabels.add(quads);
				updateDisplayLabels(exercisesPanel);

				lowerLeft.add(selectType);
				lowerLeft.add(exerciseType);
				strengthType.setVisible(true);
				selectStrength.setVisible(true);
			}
		});
        
        selectHamstrings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				hamstringType.setVisible(false);
				selectHamstrings.setVisible(false);
				
				String type = (String) hamstringType.getSelectedItem();
				JLabel hamstrings = new JLabel(type);
				displayLabels.add(hamstrings);
				updateDisplayLabels(exercisesPanel);

				lowerLeft.add(selectType);
				lowerLeft.add(exerciseType);
				strengthType.setVisible(true);
				selectStrength.setVisible(true);
			}
		});
        
        selectBiceps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				bicepType.setVisible(false);
				selectBiceps.setVisible(false);
				
				String type = (String) bicepType.getSelectedItem();
				JLabel biceps = new JLabel(type);
				displayLabels.add(biceps);
				updateDisplayLabels(exercisesPanel);

				lowerLeft.add(selectType);
				lowerLeft.add(exerciseType);
				strengthType.setVisible(true);
				selectStrength.setVisible(true);
			}
		});
        
        selectGlutes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gluteType.setVisible(false);
				selectGlutes.setVisible(false);
				
				String type = (String) gluteType.getSelectedItem();
				JLabel glutes = new JLabel(type);
				displayLabels.add(glutes);
				updateDisplayLabels(exercisesPanel);

				lowerLeft.add(selectType);
				lowerLeft.add(exerciseType);
				strengthType.setVisible(true);
				selectStrength.setVisible(true);
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
       
	}
	
	private void updateDisplayLabels(JPanel exercisesPanel) {
		//exercisesPanel.add(label);
		//exercisesPanel = new JPanel(); 
		/*exercisesPanel.setBackground(Color.red);
		exercisesPanel.setPreferredSize(new Dimension(width - borderThickness * 8, 125));
		upperPanel.add(exercisesPanel);
	
		exercisesPanel.setLayout(new GridLayout(displayLabels.size(), 1));
		*/
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
	
	private void strengthSelectorActionListeners(List<JButton> buttons, List<JComboBox<String>> selectors, JPanel lowerLeft){
		buttons.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttons.get(1).setVisible(false);
				selectors.get(1).setVisible(false);
				
				String type = (String) selectors.get(1).getSelectedItem();
				if(type.equals("Shoulders")) {
					selectors.get(3).setVisible(true);
					buttons.get(3).setVisible(true);
					lowerLeft.add(buttons.get(3));
					lowerLeft.add(selectors.get(3));
				}
				else if(type.equals("Back")) {
					selectors.get(4).setVisible(true);
					buttons.get(4).setVisible(true);
					lowerLeft.add(buttons.get(4));
					lowerLeft.add(selectors.get(4));					
				}
				else if(type.equals("Quads")) {
					selectors.get(5).setVisible(true);
					buttons.get(5).setVisible(true);
					lowerLeft.add(buttons.get(5));
					lowerLeft.add(selectors.get(5));					
				}
				else if(type.equals("Hamstrings")) {
					selectors.get(6).setVisible(true);
					buttons.get(6).setVisible(true);
					lowerLeft.add(buttons.get(6));
					lowerLeft.add(selectors.get(6));					
				}
				else if(type.equals("Biceps")){
					selectors.get(7).setVisible(true);
					buttons.get(7).setVisible(true);
					lowerLeft.add(buttons.get(7));
					lowerLeft.add(selectors.get(7));
					
				}
				else if(type.equals("Glutes")) {
					selectors.get(8).setVisible(true);
					buttons.get(8).setVisible(true);
					lowerLeft.add(buttons.get(8));
					lowerLeft.add(selectors.get(8));					
				}
						
			}
		});
	}
}
