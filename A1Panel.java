// package a4posted;
// A1 Panel
// Author: Trevor Stanhope
// ID: 260399515
// Date: November 25th, 2012
// Description: Defines the components and logic for a simple calculator interface.

/* Headers */
import java.awt.event.*;
import java.awt.*;
import java.math.BigInteger;
import javax.swing.*;

/* Classes */
public class A1Panel extends JPanel implements ActionListener {

    /* Declararions*/
	JTextField firstArg, secondArg; // text field for input integers
	BigInteger arg1Int, arg2Int, resultInt; // integers operate on
	JRadioButton Add, Subtract, Multiply, Divide; // radio buttons
	JButton computeButton; // compute button
	JLabel result, label1, label2; // display labels
	
	// Start all booleans as false.
	Boolean addBoolean = false;
	Boolean subtractBoolean = false;
	Boolean multiplyBoolean = false; 
	Boolean divideBoolean = false;

	/* Constructor */
	// Builds panel with components.
	public A1Panel() {
	
		// Initialize grid layout.
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints layout = new GridBagConstraints();
		this.setLayout(gridbag);
		
		// Set first label.
		JLabel label1 = new JLabel("First Argument");
		label1.setFont(new Font("Times", Font.BOLD, 16));
		label1.setBackground(Color.lightGray);
		label1.setOpaque(true);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		layout.gridx = 0;
		layout.gridy = 0;
		add(label1, layout);

		// Spawn first integer's 'textField.
		firstArg = new JTextField(25);
		firstArg.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 1;
		add(firstArg, layout);
		
		// Set first label.
		JLabel label2 = new JLabel("Second Argument");
		label2.setFont(new Font("Times", Font.BOLD, 16));
		label2.setBackground(new Color(160, 160, 160));
		label2.setOpaque(true);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		layout.gridx = 0;
		layout.gridy = 2;
		add(label2, layout);
		
		// Spawn first integer's 'textField.
		secondArg = new JTextField(25);
		secondArg.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 3;
		add(secondArg, layout);
		
		/* Radio Buttons */
		// Spawn Add radio button.
		Add = new JRadioButton("Add");
		Add.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 4;
		add(Add, layout);
		
		// Spawn Subtract radio button.
		Subtract = new JRadioButton("Subtract");
		Subtract.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 5;
		add(Subtract, layout);
		
		// Spawn Multiply radio button.
		Multiply = new JRadioButton("Multiply");
		Multiply.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 6;
		add(Multiply, layout);
		
		// Spawn Divide radio button.
		Divide = new JRadioButton("Divide");
		Divide.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 7;
		add(Divide, layout);
		
		// Spawn group of radio buttons.
		ButtonGroup myButtonGroup = new ButtonGroup();
		myButtonGroup.add(Add);
		myButtonGroup.add(Subtract);
		myButtonGroup.add(Multiply);
		myButtonGroup.add(Divide);
		
		
		// Spawn button to compute the result.
		computeButton = new JButton("Compute Result");
		computeButton.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 8;
		add(computeButton, layout);
		
		// Spawn display label for result.
		result = new JLabel("waiting for you to insert values...");
		layout.gridx = 0;
		layout.gridy = 9;
		this.add(result, layout);
	}
	
	/* Methods */
	// actionPerformed(event) //
    // Respond to actionEvents from the computeButton component.
	public void actionPerformed(ActionEvent e) {	
		if (e.getSource() == computeButton && addBoolean) {
			BigInteger arg1Int = new BigInteger(firstArg.getText());
			BigInteger arg2Int = new BigInteger(secondArg.getText());
			resultInt = arg1Int.add(arg2Int);
			result.setText("The result is: " + resultInt.toString());
		}
		else if (e.getSource() == computeButton && subtractBoolean) {
			BigInteger arg1Int = new BigInteger(firstArg.getText());
			BigInteger arg2Int = new BigInteger(secondArg.getText());
			resultInt = arg1Int.subtract(arg2Int);
			result.setText("The result is: " + resultInt.toString()); 
		}
		else if (e.getSource() == computeButton && multiplyBoolean) {
			BigInteger arg1Int = new BigInteger(firstArg.getText());
			BigInteger arg2Int = new BigInteger(secondArg.getText());
			resultInt = arg1Int.multiply(arg2Int);
			result.setText("The result is: " + resultInt.toString()); 
		}
		else if (e.getSource() == computeButton && divideBoolean) {
			BigInteger arg1Int = new BigInteger(firstArg.getText());
			BigInteger arg2Int = new BigInteger(secondArg.getText());
			resultInt = arg1Int.divide(arg2Int);
			result.setText("The result is: " + resultInt.toString()); 
		}
		else if (e.getSource() == Add) {
			addBoolean = true;
			subtractBoolean = false;
			multiplyBoolean = false;
			divideBoolean = false;
		}
		else if (e.getSource() == Subtract) {
			addBoolean = false;
			subtractBoolean = true;
			multiplyBoolean = false;
			divideBoolean = false;
		}
		else if (e.getSource() == Multiply) {
			addBoolean = false;
			subtractBoolean = false;
			multiplyBoolean = true;
			divideBoolean = false;
		}
		else if (e.getSource() == Divide) {
			addBoolean = false;
			subtractBoolean = false;
			multiplyBoolean = false;
			divideBoolean = true;
		}
	}
}
