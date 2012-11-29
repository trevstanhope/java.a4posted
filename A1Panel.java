// A1 Panel
// Author: Trevor Stanhope
// `
// Date: November 25th, 2012

/*HEADER*/
// package a4posted;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*CLASSES*/
public class A1Panel extends JPanel implements ActionListener { 

    // Initialize variables.
	String result; // the result string to be displayed
	String firstString; // the first value as a string
	String secondString; // the second value as a string
	String sumString = "sum"; // string command for sum
	String differenceString = "difference"; // string command for difference
	String productString = "product"; // string command for product
	String quotientString = "quotient"; // string command for quotient
	int firstInteger = 0; // the first value
	int secondInteger = 0; // the second value
	JTextField firstField; // the first Field object
	JTextField secondField; // the second Field object
	JButton computeButton; // action button to calculate value
	JLabel display; // label to display results
	JRadioButton sumRadio; // radio button for sum(a,b)
    JRadioButton differenceRadio; // radio button for difference(a,b)
    JRadioButton productRadio; // radio button for product(a,b)
    JRadioButton quotientRadio; // radio button for quotient(a,b)
	ButtonGroup group; // group of radio buttons

    // Clean execution.
	A1Panel(){
		makeComponents();
		makeLayout();
	}
	
	// Generate objects.
	private void makeComponents(){
	    // Spawn two entry fields.
		firstField = new JTextField("0", 10);
		// firstField.addActionListener(this);
		secondField = new JTextField("0", 10);
		// secondField.addActionListener(this);
		
		// Spawn radio buttons as group.
		// Sum button.
		ButtonGroup group = new ButtonGroup();
        JRadioButton sumRadio = new JRadioButton(sumString);
        sumRadio.setSelected(true);
        sumRadio.setActionCommand(sumString);
        sumRadio.addActionListener(this);
        group.add(sumRadio);
        
        // Difference button.
        JRadioButton differenceRadio = new JRadioButton(differenceString);
        differenceRadio.setSelected(true);
        differenceRadio.setActionCommand(differenceString);
        differenceRadio.addActionListener(this);
        group.add(differenceRadio);
        
        // Product button.
        JRadioButton productRadio = new JRadioButton(productString);
        productRadio.setSelected(true);
        productRadio.setActionCommand(productString);
        productRadio.addActionListener(this);
        group.add(productRadio);
        
        // Quotient button.
        JRadioButton quotientRadio = new JRadioButton(quotientString);
        quotientRadio.setSelected(true);
        quotientRadio.setActionCommand(quotientString);
        quotientRadio.addActionListener(this);
        group.add(quotientRadio);
        
		// Spawn calculate button.
		computeButton = new JButton("SUM");
		computeButton.addActionListener(this);
		
		// Set display attributes.
		display = new JLabel();
		display.setFont(new Font("Times", Font.BOLD, 16));
		display.setBackground(new Color(160, 160, 160));
		display.setOpaque(true);
		display.setHorizontalAlignment(SwingConstants.CENTER);
	}

    // Generate layout.
	private void makeLayout(){
	    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		setLayout(new GridLayout(2,3));
        radioPanel.add(sumRadio);
        radioPanel.add(differenceRadio);
        radioPanel.add(productRadio);
        radioPanel.add(quotientRadio);
        add(radioPanel);
		add(firstField);
		add(secondField);	
		add(computeButton);
		add(display); 
	}

    // Respond to action.
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == computeButton){
		
		    // Catch input from fields.
		    firstString = firstField.getText();
		    secondString = secondField.getText();
		    firstInteger = Integer.parseInt(firstString);
		    secondInteger = Integer.parseInt(secondString);
		    
		    // Determine operation from radio button selection.
		    if (e.getActionCommand() == sumString) {
			    result = Integer.toString(firstInteger + secondInteger);
			}
			else if (e.getActionCommand() == differenceString) {
			    result = Integer.toString(firstInteger + secondInteger);
			}
			else if (e.getActionCommand() == productString) {
			    result = Integer.toString(firstInteger + secondInteger);
			}
			else if (e.getActionCommand() == quotientString) {
			    result = Integer.toString(firstInteger + secondInteger);
			}
			// Display result.
			display.setText(result);
		}
	}
}

