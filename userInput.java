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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class userInput extends JFrame{
	private int partialWidth = 600;
	private int partialHeight = 575; 
	private int fullWidth = 1600;
	private int fullHeight = 1000;
	private int width;
	private int height; 
	private int borderThickness = 4; 
	
	private int current = 12;
	private int min = 0;
	private int max = 25;
	private int step = 1;
	
	private Color barbiePink = new Color(233, 65, 150);
	private Color lightPink = new Color(250, 209, 230);
	private Color powderblue = new Color(168, 234, 255);
	
	Font copperplateH1 = new Font("Copperplate", Font.PLAIN, 54);
	Font copperplateH2 = new Font("Copperplate", Font.PLAIN, 24);
	
   
	
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
		List<JLabel> displayLabels = new ArrayList<>(); 
		
		JLabel exerciseCategories = new JLabel();
		JPanel[] panels = setupPanels(displayLabels, c, number, exerciseCategories);
		JPanel lowerLeft = panels[3];
		JPanel lowerRight = panels[4];
		JPanel exercisesPanel = panels[8];
		
        JSpinner reps_number_spinner = new JSpinner(new SpinnerNumberModel(current, min, max, step));
		
		ButtonsAndSelectors buttonsAndSelectors = new ButtonsAndSelectors(); 
		
		List<JButton> buttons = new ArrayList<>();
		buttons = buttonsAndSelectors.createButtons(buttons, lowerLeft, lowerRight);
        
		List<JComboBox<String>> selectors = new ArrayList<>(); 
	    selectors =  buttonsAndSelectors.createSelectors (selectors, lowerLeft);
	    
	    buttonsAndSelectors.addActionListeners(buttons, selectors, lowerLeft, lowerRight, displayLabels,
	    		exercisesPanel, exerciseCategories, reps_number_spinner);        
        
        
        strengthSelectorActionListeners(buttons, selectors, lowerLeft, lowerRight);     
	}
	
	
	
	private JPanel[] setupPanels(List<JLabel> displayLabels, Container c, String number, JLabel exerciseCategories){
		RenderPanels renderPanels = new RenderPanels(); 
		JPanel[] panels = renderPanels.renderBasePanels(c); 
		JPanel upperPanel = panels[1];
		panels = renderPanels.renderSecondRoundPanels(upperPanel, number, panels);
		JPanel exerciseCategoryPanel = panels[7];
		
		exerciseCategories.setBounds(width/2 - 100, 200, 400, 20);
		exerciseCategories.setFont(copperplateH2);
		exerciseCategories.setForeground(Color.white);
		exerciseCategoryPanel.add(exerciseCategories);
		
		JPanel exercisesPanel = new JPanel(); 
		exercisesPanel.setBackground(Color.white);
		exercisesPanel.setPreferredSize(new Dimension(width - borderThickness * 8, 125));
		exercisesPanel.setLayout(new GridLayout(displayLabels.size(), 1));
		upperPanel.add(exercisesPanel);
		panels[8] = exercisesPanel; 
		
		return panels;
	}
	
	private void strengthSelectorActionListeners(List<JButton> buttons, 
			List<JComboBox<String>> selectors, JPanel lowerLeft, JPanel lowerRight){
		buttons.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttons.get(1).setVisible(false);
				selectors.get(1).setVisible(false);
				
				String type = (String) selectors.get(1).getSelectedItem();
				if(type.equals("Shoulders")) {
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 3);
				}
				else if(type.equals("Back")) {
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 4);			
				}
				else if(type.equals("Quads")) {
					strengthSelectorActionListenerHelper( buttons, selectors, lowerLeft, lowerRight, 5);				
				}
				else if(type.equals("Hamstrings")) {
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 6);				
				}
				else if(type.equals("Biceps")){
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 7);
				}
				else if(type.equals("Glutes")) {
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 8);				
				}
				else if(type.equals("Chest")) {
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 9);				
				}
				else if(type.equals("Tricep")) {
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 10);				
				}
				else if(type.equals("Lat")) {
					strengthSelectorActionListenerHelper(buttons, selectors, lowerLeft, lowerRight, 11);			
				}
				
						
			}
		});
	}
	
	private void strengthSelectorActionListenerHelper(
			List<JButton> buttons, List<JComboBox<String>> selectors, JPanel lowerLeft, JPanel lowerRight, int num) {
		selectors.get(num).setVisible(true);
		buttons.get(num).setVisible(true);
		
		lowerLeft.add(buttons.get(num));
		lowerLeft.add(selectors.get(num));
		
	}
}
