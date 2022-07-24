package workoutCalendar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RenderPanels {
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
	
	Container c; 
	
	public RenderPanels() {
		width = partialWidth;
		height = partialHeight;
	}
	
	public JPanel[] renderBasePanels(Container c) {
		int borderThickness = 4; 
		JPanel[] panels = new JPanel[9];
		
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
	
	public JPanel[] renderSecondRoundPanels(JPanel upperPanel, String number, JPanel[] panels) {
		JPanel titlePanel = new JPanel(); 
		titlePanel.setBackground(Color.white);
		titlePanel.setPreferredSize(new Dimension(width - borderThickness * 8, 55));
		//titlePanel.setLayout(new GridLayout(2, 1));
		upperPanel.add(titlePanel);
		panels[5] = titlePanel;
		
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
		panels[6] = datePanel;
		
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
		panels[7] = exerciseCategoryPanel; 
		
		
		return panels;
	}
	
}
