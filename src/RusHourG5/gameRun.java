package RusHourG5;

import javax.swing.*;
import java.awt.*;

public class gameRun {
    public static void main(String[] args) {

        //Music
        new GameWithBackgroundMusic();
        GameWithBackgroundMusic.playBackgroundMusic();


        JFrame jf=new JFrame("RusHour");
        //1. Add the image to the label (set the size of the label to the same size as the image) and place the label at the bottom of the layer panel;
        ImageIcon bg=new ImageIcon("src/imageBag/bg.png");
        JLabel label=new JLabel(bg);
        label.setSize(485,690);//bg.getIconHeight()
        jf.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));

        //2. Set the window panel as the content panel and set it to a transparent, fluid layout.
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        //3.Then add the component and panel to the window panel；
        JButton btn=new JButton("");
        ImageIcon start_bg=new ImageIcon("src/imageBag/start.jpg");
        start_bg.setImage(start_bg.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
        btn.setBounds(100,400,300, 100);
        btn.setIcon(start_bg);
        btn.setBorderPainted(true); // ERASE BORDER
        btn.setContentAreaFilled(false);
        pan.add(btn);
        jf.setSize(500,700);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);

        btn.addActionListener(e -> {
            GameFrame g=new GameFrame(900,900,"RusHour");
            g.setVisible(true);
            jf.setVisible(false);
            g.setLayout(new FlowLayout());


            JButton yxan=new JButton("");
            ImageIcon twelve=new ImageIcon("src/imageBag/12.png");
            twelve.setImage(twelve.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
            yxan.setBounds(0,0,400,300);
            yxan.setIcon(twelve);

            JButton yxane=new JButton("");
            ImageIcon thirteen=new ImageIcon("src/imageBag/13.png");
            thirteen.setImage(thirteen.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
            yxane.setBounds(300,0,400,300);
            yxane.setIcon(thirteen);


            JButton yxans=new JButton("");
            ImageIcon fourteen=new ImageIcon("src/imageBag/14.png");
            fourteen.setImage(fourteen.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT ) );
            yxans.setBounds(0,400,400,300);
            yxans.setIcon(fourteen);


            JButton yxanw=new JButton("");
            ImageIcon fifteen=new ImageIcon("src/imageBag/15.png");
            fifteen.setImage(fifteen.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT));
            yxanw.setBounds(300,400,400,300);
            yxanw.setIcon(fifteen);

            g.add(yxan);
            yxan.addActionListener(e1 -> {
                //Create an instance of GameRealize and pass in 1 as the level parameter
                GameRealize g01 = new GameRealize(1);
                g01.setVisible(true);

            });
            g.add(yxane);
            yxane.addActionListener(e12 -> {
                GameRealize g1 = new GameRealize(2); // Second level
                g1.setVisible(true);
            });
            g.add(yxans);
            yxans.addActionListener(e13 -> {
                GameRealize g12 = new GameRealize(3); // third
                g12.setVisible(true);
            });
            g.add(yxanw);
            yxanw.addActionListener(e14 -> {
                GameRealize g13 = new GameRealize(4); // forth
                g13.setVisible(true);
            });
        });








        //set visible
        jf.setVisible(true);
    }
}