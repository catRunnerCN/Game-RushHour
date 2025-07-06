package RusHourG5;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Arrays;/*
  The GameRealize class represents the main game window that contains the game board and additional functions.
 */
/**
 * The GameRealize class represents the main game window that contains the game board and additional functions.
 */

public class GameRealize extends JFrame{
	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	static ImageIcon background = new ImageIcon("src/imageBag/background.png");
	static JLabel backgroundLabel = new JLabel(background);
	static MainWindow mainWindow;
	static AddtionFunc addtionFunc;
	static Container panel;//CContainedWindow

	static JLayeredPane mainPanel = new JLayeredPane();

	public int level;/**
	 * Constructs a new GameRealize object with the specified level.
	 * @param level The level of the game.
	 */
	public GameRealize(int level){
//		backgroundLabel.setBounds(0,0,900,900);
//		mainPanel.add(backgroundLabel,Integer.valueOf(0));

		this.level = level;
//		backgroundLabel.setBounds(0, 0, 600, 600);
		addtionFunc = new AddtionFunc(level);
//		addtionFunc.add(backgroundLabel);
		mainWindow = new MainWindow(level);//SetLevel
		mainWindow.setLayout(new BorderLayout());

		for (JPanel jPanel : Arrays.asList((JPanel) this.getContentPane(), new JPanel())) {
			panel = jPanel;
		}
		//		panel.add(backgroundLabel);
		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 0, 1200, 800);
		panel.add(addtionFunc,BorderLayout.EAST);
		panel.add(mainWindow,BorderLayout.CENTER);
//

		mainPanel.add(panel, BorderLayout.CENTER, 1); // Add the panel to the new Content panel
		mainPanel.setLayout(new BorderLayout());
		this.setContentPane(mainPanel); // Use the new content panel
//		this.setSize(650,650);
		this.setSize(1200,800);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("RusHour");
		this.setVisible(true);
		this.setResizable(false);
	}/**
	 * The main method that starts the game with level 1.
	 */

	public static void main(String[] args) {
		new GameRealize(1); // Create a GameRealize object with a level of 1
	}
/*
  Closes the window.
 */

}