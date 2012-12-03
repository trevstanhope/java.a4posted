// package a4posted;
// A1 Panel
// Author: Trevor Stanhope
// ID: 260399515
// Date: December 2nd, 2012
// Description: Defines the components and logic for a simple calculator interface.

/* Headers */
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.math.*;
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
	
		// Initialize grid layout as a GridBag
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints layout = new GridBagConstraints();
		this.setLayout(gridbag);
		
		// Set first label.
		JLabel label1 = new JLabel("First Integer: ");
		label1.setFont(new Font("Monospace", Font.ITALIC, 13));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		layout.gridx = 0;
		layout.gridy = 0;
		add(label1, layout);

		// Spawn first integer's textField.
		firstArg = new JTextField(24);
		firstArg.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 1;
		add(firstArg, layout);
		
		// Set second label.
		JLabel label2 = new JLabel("Second Integer: ");
		label2.setFont(new Font("Monospace", Font.ITALIC, 13));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		layout.gridx = 0;
		layout.gridy = 2;
		add(label2, layout);
		
		// Spawn second integer's textField.
		secondArg = new JTextField(24);
		secondArg.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 3;
		add(secondArg, layout);
		
		/* Radio Buttons */
		// Spawn Add radio button.
		Add = new JRadioButton("Add");
		Add.setFont(new Font("Monospace", Font.PLAIN, 13));
		Add.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 4;
		add(Add, layout);
		
		// Spawn Subtract radio button.
		Subtract = new JRadioButton("Subtract");
		Subtract.setFont(new Font("Monospace", Font.PLAIN, 13));
		Subtract.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 5;
		add(Subtract, layout);
		
		// Spawn Multiply radio button.
		Multiply = new JRadioButton("Multiply");
		Multiply.setFont(new Font("Monospace", Font.PLAIN, 13));
		Multiply.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 6;
		add(Multiply, layout);
		
		// Spawn Divide radio button.
		Divide = new JRadioButton("Divide");
		Divide.setFont(new Font("Monospace", Font.PLAIN, 13));
		Divide.addActionListener(this);
		layout.gridx = 0;
		layout.gridy = 7;
		add(Divide, layout);
		
		// Groups radio buttons so that there is only one selected at a time.
		ButtonGroup myButtonGroup = new ButtonGroup();
		myButtonGroup.add(Add);
		myButtonGroup.add(Subtract);
		myButtonGroup.add(Multiply);
		myButtonGroup.add(Divide);
		
		// Spawn button to compute the result.
		computeButton = new JButton("Compute Result");
		computeButton.setFont(new Font("Monospace", Font.BOLD, 13));
		computeButton.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 8;
		add(computeButton, layout);
		
		// Spawn display label for result.
		result = new JLabel(" ");
		result.setBackground(Color.white);
		result.setOpaque(true);
		layout.gridx = 0;
		layout.gridy = 9;
		this.add(result, layout);
	}
	
	/* Methods */
	// actionPerformed(event) //
    // Respond to actionEvents from the computeButton component.
	public void actionPerformed(ActionEvent e) {
	
	    // Check if inputs are integers, and calculate if so, otherwise return error.
	    if (tryParse(firstArg.getText()) && tryParse(secondArg.getText())) {
	        
	        // Catch arguments from the input textFields.
	        BigInteger arg1Int = new BigInteger(firstArg.getText());
		   	BigInteger arg2Int = new BigInteger(secondArg.getText());
	        
	        // Compute result for selected operator boolean.
	        if (e.getSource() == computeButton && addBoolean) {
			    resultInt = arg1Int.add(arg2Int);
			    result.setText(resultInt.toString());
		    }
		    else if (e.getSource() == computeButton && subtractBoolean) {
		    	resultInt = arg1Int.subtract(arg2Int);
		    	result.setText(resultInt.toString()); 
		    }
		    else if (e.getSource() == computeButton && multiplyBoolean) {
		    	resultInt = arg1Int.multiply(arg2Int);
		    	result.setText(resultInt.toString()); 
		    }
		    else if (e.getSource() == computeButton && divideBoolean) {
			    resultInt = arg1Int.divide(arg2Int);
			    result.setText(resultInt.toString()); 
		    }
		    // If all booleans are still false when computeButton is clicked, throw error.
		    else if (e.getSource() == computeButton && !(divideBoolean || multiplyBoolean || subtractBoolean || addBoolean)) {
                result.setText("Error: Select an operator"); 
		    }
		}
		// Otherwise throw BadInput error.
		else {
	        result.setText("Error: Not all inputs are integers");
	    }
	        
	    // Set boolean for operator chosen via the radioButtons.
        if (e.getSource() == Add) {
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
		else {
		    return;
		}
	} 
	
	// tryParseBigInteger(string)
	// Attempts to parse a string as a BigInteger, returns true if string is an integer value.
	public static Boolean tryParse(String text) {
        try {
            BigInteger i = new BigInteger(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
