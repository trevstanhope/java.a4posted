// package a4posted;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Assignment 4"); 
		frame.setLayout( new GridLayout(1,3));
		
		JPanel panel = new A1Panel();
		frame.add(panel);

		panel = new A2Panel();
		frame.add(panel);

	    //  You will need to change the following since it is the path on Prof's computer.
		String fileName = "/home/trevor/local/git/trevstanhope/java.a4posted/inputFile.txt";
		panel = new A3Panel(fileName);
		frame.add( panel);
	
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
}

