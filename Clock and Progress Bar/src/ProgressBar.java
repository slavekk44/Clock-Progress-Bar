


import java.awt.Color;

import java.awt.GridLayout;

import java.util.Scanner;

import javax.swing.*;

public class ProgressBar extends JFrame {

	static Scanner scanner = new Scanner(System.in); // Create a Scanner object

	private static JLabel p1[];
	static int counter = 0;
	static int percent = 0;

	public ProgressBar() {

		setLayout(new GridLayout(1, 1));

		JPanel display = new JPanel(new GridLayout(11, 1));
		add(display);

		p1 = new JLabel[11];

		for (int i = 0; i < p1.length; i++) {

			p1[i] = new JLabel("", JLabel.CENTER);
			p1[i].setBackground(Color.RED);
			p1[i].setOpaque(true);

			display.add(p1[i]);
		}
		p1[10].setBackground(Color.yellow);
		p1[10].setText(percent + " %");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Press Enter start progress");

		JFrame clock = new ProgressBar();
		clock.setSize(400, 220);
		clock.setTitle("o'clock");
		clock.setVisible(true);
		clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 12; i++) {
			String inputUser = scanner.nextLine();
			System.out.println(inputUser);
			if (inputUser == "") {

				p1[counter].setBackground(Color.GREEN);

				counter++;
				if (percent == 100) {
					percent = -10;

				}
				percent = percent + 10;
				p1[10].setText(percent + " %");

				if (counter == 11) {
					i = 0;
					counter = 0;
					for (int i1 = 0; i1 < p1.length; i1++) {

						p1[i1].setBackground(Color.RED);
						p1[10].setBackground(Color.yellow);
					}
				}
			}

		}
	}

}