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
// import a3.Trie; // requires method getAllPrefixMatches(prefix)
// import a3.TrieNode; // requires TrieNode type

/* Classes */
public class A3Panel extends JPanel implements ActionListener {

    /* Declarations */
    String allPrefixesString = ""; // the long string for the word matches
    String prefixString = ""; // the input prefix text as a string
    String dictName = ""; // the diction file location as a string 
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
		JLabel prefixLabel = new JLabel("Enter prefix and hit return for matches: ");
		prefixLabel.setFont(new Font("Times", Font.BOLD, 16));
		prefixLabel.setHorizontalAlignment(SwingConstants.LEFT);
		layout.gridx = 0;
		layout.gridy = 0;
		this.add(prefixLabel, layout);

		// Catch prefix from textField.
		prefix = new JTextField(25);
		prefix.addActionListener(this);
		layout.fill = GridBagConstraints.HORIZONTAL;
		layout.gridx = 0;
		layout.gridy = 1;
		prefix.addActionListener(this);
		this.add(prefix, layout);

		// Spawn wordsLabel.
		JLabel wordsLabel = new JLabel("All the words with that prefix: ");
		wordsLabel.setFont(new Font("Times", Font.BOLD, 16));
		wordsLabel.setHorizontalAlignment(SwingConstants.CENTER );
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
			list = readWordsFromFile(dictName);
			Trie dictionary = new Trie(); // #HACK; load dictionary each time prefix is entered
			dictionary.loadKeys(list); 
			
			prefixString = prefix.getText(); // get string from textField
			allPrefixesList = dictionary.getAllPrefixMatches(prefixString); // find matches in dictionary
            
            allPrefixesString = ""; // clear previous matches
            for(int i = 0; i < allPrefixesList.size(); i++) {
                allPrefixesString = allPrefixesString + allPrefixesList.get(i) + "\n"; // compile matches into one string
			}
			wordsList.setText(allPrefixesString); // display all matches
		}
		else {
			return;
		}
	}
	
	// readWordsFromFile(filename) //
	// Method from AutoComplete.java to read the words from a dictionary text file.
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
