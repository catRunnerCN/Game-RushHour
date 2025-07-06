package RusHourG5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

public class AddtionFunc extends JPanel {
	/**
	 * The serial version UID.
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	/**
	 * An array of level names.
	 */
	String[] names = new String[]{"EASY", "MIDDLE", "DIFFICULT", "HELL"};
	/**
	 * The current level.
	 */
	int level;
	/**
	 * The panel for the top section of the panel.
	 */
	BackgroundPanel panelNorth = new BackgroundPanel(new GridLayout(15, 10, 10, 30));
	/**
	 * A label for displaying the current number of steps.
	 */
	static JLabel nowStep = new JLabel("0");
	/**
	 * A label for displaying the name of the current level.
	 */
	JLabel nowName = new JLabel("");
	/**
	 * A label for displaying the record for the level.
	 */
	JLabel record = new JLabel("****");
	/**
	 * The Restart button.
	 */
	static JButton restart = new JButton("RESET");
	/**
	 * The Back button for returning to the level selection menu.
	 */
	static JButton backButton = new JButton("Back to Level Selection");/*
	  Constructs a new AddtionFunc object with the specified level.
	  @param level The current level.
	 */

	/**
	 * Initializes an AdditionFunc object with a given level and creates a GUI.
	 *
	 * @param level an integer representing the level of difficulty.
	 */

	public AddtionFunc(int level) {

// Create a 'Help' button and add an ActionListener to show a solution frame.

		JButton answerButton = new JButton("Help");

		answerButton.addActionListener(e -> {

// Create a new frame to show the solution image.

			JFrame answerFrame = new JFrame("Solution");

			answerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			answerFrame.setSize(450, 600);

			answerFrame.setLocationRelativeTo(null);

			String imageName = ""; // Determine the file name of the solution image based on the level.

			if (level == 1) {

				imageName = "src/imageBag/Solution1.jpg";

			} else if (level == 2) {

				imageName = "src/imageBag/Solution2.jpg";

			} else if (level == 3) {

				imageName = "src/imageBag/Solution3.jpg";

			} else if (level == 4) {

				imageName = "src/imageBag/Solution4.jpg";

			}

// Load the solution image and add it to the frame.

			ImageIcon imageIcon = new ImageIcon(imageName);

			JLabel label = new JLabel(imageIcon);

			answerFrame.getContentPane().add(label);

			answerFrame.setVisible(true);

		});

// Initialize the object with the given level and create a GUI.

		this.level = level;

		this.setVisible(true);

		this.setLayout(new BorderLayout());

		panelNorth.setLayout(new GridLayout(15, 10, 10, 30));

		panelNorth.setBackgroundImage("src/imageBag/Way2.jpg");

		panelNorth.add(new JLabel("LEVEL£º"));

		panelNorth.add(nowName);

		panelNorth.add(new JLabel("STEPS£º"));

		panelNorth.add(nowStep);

		panelNorth.add(new JLabel("RECORD£º"));

		panelNorth.add(record);

		panelNorth.add(restart);

		panelNorth.add(backButton);

		panelNorth.add(answerButton);

// Add an ActionListener to the 'Back' button to dispose the current window.

		backButton.addActionListener(e -> {

			Window window = SwingUtilities.getWindowAncestor(AddtionFunc.this);

			if (window != null) {

				window.dispose();

			}

		});

// Add the panel to the GUI and initialize the object.

		this.add(panelNorth, BorderLayout.NORTH);

		initialize();

	}

//	public void setLevel(int level) {
//		this.level = level;
//		initialize();
//	}

	/**
	 * Initializes the current object by setting the text of various labels and loading the background image.
	 */

	private void initialize() {

// Set the text of the labels to their initial values.

		nowName.setText(names[level - 1] + "");

		nowStep.setText("0");

		record.setText("" + MapLibrary.getRecord(level));

// Load the background image for the panel.

		panelNorth.setBackgroundImage("src/imageBag/Way2.jpg");

	}

	/**
	 * A custom JPanel class that displays a background image and scales it to fit the panel.
	 */

	static class BackgroundPanel extends JPanel {

		private BufferedImage backgroundImage;

		public BackgroundPanel(LayoutManager layout) {

			super(layout);

		}

		/**
		 * Sets the background image of the panel.
		 *
		 * @param imagePath a String representing the path to the image file.
		 */

		public void setBackgroundImage(String imagePath) {

			try {

				backgroundImage = ImageIO.read(new File(imagePath));

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		@Override

		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			if (backgroundImage != null) {

// Scale the image to fit the panel and display it.

				int width = getWidth();

				int height = getHeight();

				Image scaledImage = backgroundImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

				g.drawImage(scaledImage, 0, 0, null);

			}

		}
	}
}


