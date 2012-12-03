// package a4posted;
// A3 Panel
// Author: Trevor Stanhope
// ID: 260399515
// Date: November 25th, 2012
// Description: Defines the components and logic for an auto-complete java interface.

/* Headers */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
//import a3.*; // requires type TrieNode and method getAllPrefixMatches(prefix)

/* Classes */
public class A3Panel extends JPanel implements ActionListener {

    /* Declarations */
    String allPrefixesString = ""; // the long string for the word matches
    String prefixString = ""; // the input prefix text as a string
    String dictName = ""; // the dictionary file location as a string 
    ArrayList<String> allPrefixesList = new ArrayList<String>();
    JLabel prefixLabel, wordsLabel; // the labels for the text 
    JTextField prefix; // the input field for text
    JTextArea wordsList = new JTextArea(10,10); // the display area for word matches
    JScrollPane wordsPane; // the scrolling pane for the word matches

    /* Constructor */
    // Builds panel with components.
	public A3Panel(String fileName) {	
	
		// Initialize grid layout.
		dictName = fileName; // #HACK; had to store the fileName as a different variable
		GridBagLayout gridbag = new GridBagLayout(); // layout grid as gridBag
		GridBagConstraints layout = new GridBagConstraints(); // dimensions of grid
		setLayout(gridbag); 

		// Spawn prefixLabel.
		JLabel prefixLabel = new JLabel("Enter Prefix (then press ENTER):");
		prefixLabel.setFont(new Font("Monospace", Font.ITALIC, 13));
		prefixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		layout.gridx = 0;
		layout.gridy = 0;
		this.add(prefixLabel, layout);

		// Catch prefix from textField.
		prefix = new JTextField(24);
		prefix.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 1;
		prefix.addActionListener(this);
		this.add(prefix, layout);

		// Spawn wordsLabel.
		JLabel wordsLabel = new JLabel("Prefix Matches:");
		wordsLabel.setFont(new Font("Monospace", Font.ITALIC, 13));
		wordsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		layout.gridx = 0;
		layout.gridy = 2;
		this.add(wordsLabel, layout);
		
		// Spawn wordsList into wordsPane.
		JScrollPane wordsPane = new JScrollPane(wordsList);
		layout.gridx = 0;
		layout.gridy = 3;
		this.add(wordsPane, layout);
	}
	
	/* Methods */
	// ActionPerformed(event) //
	// Respond to actions from the textField component.
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == prefix) {
			ArrayList<String> list = new ArrayList<String>();
			list = readWordsFromFile(dictName); // get dictionary keys from file
			Trie dictionary = new Trie(); // #HACK; load dictionary each time prefix is entered
			dictionary.loadKeys(list); // fill Trie dictionary with valid keys 
			
			prefixString = prefix.getText(); // get string from textField
			allPrefixesList = dictionary.getAllPrefixMatches(prefixString); // find matches in dictionary
            
            allPrefixesString = ""; // clear previous matches
            for(int i = 0; i < allPrefixesList.size(); i++) {
                allPrefixesString = allPrefixesString + allPrefixesList.get(i) + "\n"; // compile matches into one string
			}
			wordsList.setText(allPrefixesString); // display all matches in textArea
		}
		else {
			return;
		}
	}
	
	// readWordsFromFile(filename)
	// Method to read all words from a dictionary text file into an String ArrayList (Borrowed from a3.AutoComplete).
	public static ArrayList<String> readWordsFromFile(String filename) {
		ArrayList<String> words = new ArrayList<String>();
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			// Strip non-alphanumeric \\W
			scanner.useDelimiter("\\W+"); 
			while (scanner.hasNext())
			{
				words.add(scanner.next());
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return words;
	}
}
