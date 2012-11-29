// package a4posted;

/* Headers */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

/* Classes */
public class A3Panel extends JPanel implements ActionListener {

    String allPrefixesString = "";
    String prefixString = "";
    String dictName = "";
    ArrayList<String> allPrefixesList = new ArrayList<String>();
    JLabel prefixLabel, wordsLabel;
    JTextField prefix;
    JTextArea wordsList = new JTextArea(10,10);
    JScrollPane wordsPane;

    /* Constructor */
	public A3Panel(String fileName) {	
	
		// Initialize grid layout.
		dictName = fileName;
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridbag);

		// Spawn prefixLabel.
		JLabel prefixLabel = new JLabel("Enter the prefix (and hit return): ");
		prefixLabel.setFont(new Font("Times", Font.BOLD, 16));
		prefixLabel.setBackground(new Color(000, 200, 000));
		prefixLabel.setOpaque(true);
		prefixLabel.setHorizontalAlignment(SwingConstants.LEFT);
		c.gridx = 0;
		c.gridy = 0;
		this.add(prefixLabel, c);

		// Catch prefix from textField.
		prefix = new JTextField(25);
		prefix.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		prefix.addActionListener(this);
		this.add(prefix, c);

		// Spawn wordsLabel.
		JLabel wordsLabel = new JLabel("All the words with that prefix: ");
		wordsLabel.setFont(new Font("Times", Font.BOLD, 16));
		wordsLabel.setBackground(new Color(000, 200, 000));
		wordsLabel.setOpaque(true);
		wordsLabel.setHorizontalAlignment(SwingConstants.CENTER );
		c.gridx = 0;
		c.gridy = 2;
		this.add(wordsLabel, c);
		
		// Spawn wordsList into wordsPane.
		JScrollPane wordsPane = new JScrollPane(wordsList);
		c.gridx = 0;
		c.gridy = 3;
		this.add(wordsPane, c);
	}
	
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == prefix) {
			ArrayList<String> list = new ArrayList<String>();
			list = readWordsFromFile(dictName);
			Trie trie = new Trie();
			trie.loadKeys(list);
			
			prefixString = prefix.getText();
			allPrefixesList = trie.getAllPrefixMatches(prefixString);

            allPrefixesString = "";
            for(int i = 0; i < allPrefixesList.size(); i++) {
                allPrefixesString = allPrefixesString + allPrefixesList.get(i) + "\n";
			}
			wordsList.setText(allPrefixesString);
		}
		else {
			return;
		}
	}
	
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
