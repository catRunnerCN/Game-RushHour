package RusHourG5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
/**
 * The GameFrame class represents the main frame of the game.
 */
public class GameFrame extends JFrame {

    /**
     * Constructs a new GameFrame object with the specified size and title.
     * @param width The width of the frame in pixels.
     * @param height The height of the frame in pixels.
     * @param title The title of the frame.
     */
    public GameFrame(int width, int height, String title){



        this.initFrame(width, height, title);


        this.setJMenuBar(getJMenuBars());

        this.addBackgroundImage();

        this.setVisible(true);

    } /**
     * Initializes the frame style.
     * @param width The width of the frame in pixels.
     * @param height The height of the frame in pixels.
     * @param title The title of the frame.
     */

    private void initFrame(int width, int height, String title){
        this.setSize(width, height);
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/imageBag/bg.png")));
        this.setIconImage(imageIcon.getImage());
    }/**
     * Creates and returns the menu bar.
     * @return The menu bar.
     */


    private JMenuBar getJMenuBars(){
        JMenuBar jMenuBar = new JMenuBar();




        JMenu instructionMenu = new JMenu("Instruction");
        JMenuItem showImageItem = new JMenuItem("How To Play");
        instructionMenu.add(showImageItem);
        showImageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImageDialog();
            }

            private void showImageDialog() {
                ImageIcon image = new ImageIcon("src/imageBag/Instruction.jpg");
                JLabel label = new JLabel(image);

                // Pass GameFrame.this instead of this
                JOptionPane.showMessageDialog(GameFrame.this, label, "Instruction", JOptionPane.PLAIN_MESSAGE);
            }





        }); /*
          Adds the background image to the frame.
         */

        /*
          Set Background music on and off
         */
        JMenu functionMenu = new JMenu("Function");

        JMenuItem toggleSoundItem = new JMenuItem("Toggle Sound");
        functionMenu.add(toggleSoundItem);
        toggleSoundItem.addActionListener(e -> {
            if (GameWithBackgroundMusic.backgroundMusic != null && GameWithBackgroundMusic.backgroundMusic.isRunning()) {
                GameWithBackgroundMusic.stopBackgroundMusic();
            } else {
                GameWithBackgroundMusic.playBackgroundMusic();
            }
        });


        // Create three small entries in the options
        JMenuItem replayItem = new JMenuItem("Restart");

        JMenuItem closeItem = new JMenuItem("Close");
        // Add the entry to the options
        functionMenu.add(replayItem);

        functionMenu.add(closeItem);

        JMenu aboutMenu = new JMenu("About us");
        JMenuItem aboutUsItem = new JMenuItem("About us");
        aboutMenu.add(aboutUsItem);
        aboutUsItem.addActionListener(e -> {
            JFrame aboutFrame = new JFrame("About Us");
            JTextArea textArea = new JTextArea("*******************************Produced By*******************************\nBai Yitong\nLiang Jianhui\nWei MingCong\nLi Jiyuan\nWang Yihan");
            aboutFrame.getContentPane().add(textArea);
            aboutFrame.setSize(400, 300);
            aboutFrame.setLocationRelativeTo(null);
            aboutFrame.setVisible(true);
        });

        JMenuItem accountItem = new JMenuItem("contact us");
        aboutMenu.add(accountItem);

        // Add the menu to the menu bar
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);
        jMenuBar.add(instructionMenu);
        return jMenuBar;
    }

    /**
     * Realize the method add background Image
     */
    private void addBackgroundImage(){
        JLabel jLabel2 = new JLabel(new ImageIcon("imageBag/start.jpg"));
        //The position of the start key
        this.getContentPane().add(jLabel2);
        ImageIcon imageIcon = new ImageIcon("imageBag/bg.jpg");
        //The location of the background image
        JLabel jLabel1 = new JLabel(imageIcon);
        this.getContentPane().add(jLabel1);

    }
}
