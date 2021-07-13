


import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Clock extends JFrame implements ActionListener {

	
	private JLabel amPm;
	private JLabel times[];

	private final static Color[] colours = { Color.red, Color.green, Color.yellow, };

	// Setting font to our text in our gridLayout
	public void setFont(Font f) {

	}

	Font f1 = new Font("Serif", Font.ITALIC, 36);

	public Clock() {

		// set layout for 2 rows and 1 column
		setLayout(new GridLayout(2, 1));
		// set layout for 1 row and 3 column on top
		JPanel display = new JPanel(new GridLayout(1, 3));
		add(display);
		// compare current state of AM/PM a
		amPm = new JLabel("", JLabel.CENTER);
		amPm.setBackground(Color.WHITE);
		amPm.setOpaque(true);
		amPm.setFont(new Font("Arial", Font.BOLD, 26));
		add(amPm);

		// CONSTRUCT label for time given
		// set color, visibility and font (f1) b
		times = new JLabel[3];
		for (int i = 0; i < times.length; i++) {

			times[i] = new JLabel("", JLabel.CENTER);
			times[i].setBackground(colours[i]);
			times[i].setOpaque(true);
			times[i].setFont(f1); 
			times[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 20));
			display.add(times[i]);
		}

		CurrentDate.start();

	}

	// UPDATE TIME DYNAMICALLY
	Timer CurrentDate = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar c1 = Calendar.getInstance();

			times[0].setText(String.valueOf(c1.get(Calendar.HOUR)));
			times[1].setText(String.valueOf(c1.get(Calendar.MINUTE)));
			times[2].setText(String.valueOf(c1.get(Calendar.SECOND)));
			if (c1.get(Calendar.AM_PM) == Calendar.AM) {
				amPm.setText("AM");
			} else {
				amPm.setText("PM");
			}
		}
	});

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

