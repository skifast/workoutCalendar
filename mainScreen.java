package workoutCalendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class mainScreen extends JFrame{
	
	private int partialWidth = 600;
	private int partialHeight = 575; 
	private int fullWidth = 1600;
	private int fullHeight = 1000;
	private int width;
	private int height; 
	
	public JLabel month;
	
	public mainScreen() {
		//3456×2234
		width = partialWidth;
		height = partialHeight;
	}
	
	public void launchFrame() {
		setTitle("Workout Calendar");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new GridLayout());
	    //setting the bounds for the JFrame
	    setBounds(0, 0, width, height);
	    setLocationRelativeTo(null);
	    assemblePanels();
	    pack();
	    setVisible(true);
	}
	
	public void assemblePanels() {
		Container c=getContentPane();
		
		Color powderblue = new Color(168, 234, 255);
		Color barbiePink = new Color(233, 65, 150);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setPreferredSize(new Dimension(width, height));
		mainPanel.setLayout(new GridLayout(8, 1));
		c.add(mainPanel);
		
		
		int monthPanelHeight = height / 8; 
		
		JPanel monthPanel = new JPanel(); 
		mainPanel.add(monthPanel);
		monthPanel.setLayout(new FlowLayout());
		monthPanel.setBackground(barbiePink);
		monthPanel.setPreferredSize(new Dimension(width, monthPanelHeight));
		monthPanel.setBorder(new CompoundBorder(
			    BorderFactory.createMatteBorder(4, 4, 0, 4, barbiePink), 
			    BorderFactory.createMatteBorder(4, 4, 0, 4, Color.white)));
		month = new JLabel();
		month.setText("July");
		month.setFont(new Font("Brush Script MT", Font.PLAIN, 54));
		month.setPreferredSize(new Dimension(75, 50));
		month.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.white));
		month.setForeground(Color.white);
		
		//month.setBounds(width/2 - 50, 0, 200, 80);
		monthPanel.add(month);
		
		String[] daysOfWeek = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};
		JPanel dayOfWeekPanel = new JPanel(); 
		dayOfWeekPanel.setLayout(new GridLayout(1, 7));
		dayOfWeekPanel.setBackground(barbiePink);
		dayOfWeekPanel.setPreferredSize(new Dimension(width, monthPanelHeight/2));
		dayOfWeekPanel.setBorder(new CompoundBorder(
			    BorderFactory.createMatteBorder(0, 4, 4, 4, barbiePink), 
			    BorderFactory.createMatteBorder(0, 4, 4, 4, Color.white)));
		for(String day: daysOfWeek) {
			String filler = "     ";
			JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
			dayLabel.setBackground(Color.black);
			dayLabel.setPreferredSize(new Dimension(width/7 + 20, monthPanelHeight));
			//dayLabel.setText(filler + day + filler);
			dayLabel.setForeground(Color.white);
			dayOfWeekPanel.add((dayLabel));
		}
		mainPanel.add(dayOfWeekPanel);
		/*monthPanel.setBorder(new CompoundBorder(
			    BorderFactory.createMatteBorder(4, 4, 4, 4, barbiePink), 
			    BorderFactory.createMatteBorder(4, 4, 4, 4, Color.white)));*/
		
		
		JPanel[] weeks = new JPanel[6];
		JPanel[][] days = new JPanel[6][7];
		int[] dayValues = {26, 27, 28, 29, 30, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25, 26, 27, 28, 29, 30, 31, 1, 2, 3, 4, 5, 6};
		boolean dark = true; 
		
		int k = 0; 
		for(int i = 0; i < weeks.length; i++) {
			weeks[i] = new JPanel(); 
			weeks[i].setBorder(BorderFactory.createMatteBorder(
                    1, 2, 1, 2, powderblue.darker()));
			weeks[i].setPreferredSize(new Dimension(width, monthPanelHeight - 10));
			weeks[i].setBackground(powderblue);
			weeks[i].setLayout(new GridLayout(1, 7));
			for(int j = 0; j<days[i].length; j++) {
				days[i][j] = new JPanel(); 
				days[i][j].setBorder(BorderFactory.createMatteBorder(
	                    1, 2, 1, 2, powderblue.darker()));
				days[i][j].setPreferredSize(new Dimension(width/7 - 10, monthPanelHeight - 10));
				days[i][j].setBackground(powderblue);
				days[i][j].setLayout(new GridBagLayout());
				days[i][j].addMouseListener(new BoxListener());
				
				JLabel dayValue = new JLabel();
				dayValue.setText("" + dayValues[k]);
				
			
				GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
			            GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(
			                  0, 0, 0, 0), 0, 0);
				gbc.gridx = 1;
			    gbc.gridy = 0;
				days[i][j].add(dayValue, gbc);
				
				if(dayValues[k] == 1 && dark == true) {
					dark = false;
				}
				else if(dayValues[k] == 1 && dark == false) {
					dark = true; 
				}
				
				if(dark == false) {
					dayValue.setForeground(Color.gray.darker());
				}
				else {
					dayValue.setForeground(Color.gray);
				}
				
				//days[i][j].setLayout(new GridLayout(1, 7));
				weeks[i].add(days[i][j]);
				k++;
			}
			mainPanel.add(weeks[i]);
		}
		
	}
	
	
	
}
