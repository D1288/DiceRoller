import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AnimationPanel extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image d20;
    Image d12;
    Image d10;
    Image d8;
    Image d6;
    Image d4;
    Timer animTimer;

    ArrayList<Dice> diceList;

    AnimationPanel(ArrayList<Dice> diceList){
        this.diceList = diceList;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(new Color(190,192,190));
        d20 = new ImageIcon("d20.png").getImage();
        d12 = new ImageIcon("d12.png").getImage();
        d10 = new ImageIcon("d10.png").getImage();
        d8 = new ImageIcon("d8.png").getImage();
        d6 = new ImageIcon("d6.png").getImage();
        d4 = new ImageIcon("d4.png").getImage();

        for (Dice dice : diceList){
            dice.setXPosition(0);
            dice.setYVelocity(0);
            dice.setXVelocity(Math.random() *4);
            dice.setYVelocity(Math.random() *4);
        }


        animTimer = new Timer(1, this);
        animTimer.start();


    }

    public void paint(Graphics g){


        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Dice dice : diceList){
            int xPosition = (int) dice.getXPosition();
            int yPosition = (int) dice.getYPosition();

            if(dice.getDieSides() ==4){
                g2d.drawImage(d4, (int) xPosition, (int) yPosition, null);
            } else if(dice.getDieSides() == 6){
                g2d.drawImage(d6, (int) xPosition, (int) yPosition, null);
            } else if(dice.getDieSides() == 8){
                g2d.drawImage(d8, (int) xPosition, (int) yPosition, null);
            } else if(dice.getDieSides() ==10){
                g2d.drawImage(d10, (int) xPosition, (int) yPosition, null);
            } else if(dice.getDieSides() == 12){
                g2d.drawImage(d12, (int) xPosition, (int) yPosition, null);
            } else if(dice.getDieSides() == 20){
                g2d.drawImage(d20, (int) xPosition, (int) yPosition, null);

            }
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Dice dice : diceList){
            double xPosition = dice.getXPosition();
            double xVelocity = dice.getXVelocity();
            double yPosition = dice.getYPosition();
            double yVelocity = dice.getYVelocity();

            xPosition += xVelocity;
            yPosition += yVelocity;

            // Check for collisions with the edges of the panel
            if (xPosition >= PANEL_WIDTH -50 || xPosition < 0) {
                xVelocity = -xVelocity;
                dice.setXVelocity(xVelocity);
            }
            if (yPosition >= PANEL_HEIGHT - 90 || yPosition < 0) {
                yVelocity = -yVelocity;
                dice.setYVelocity(yVelocity);
            }

            dice.setXPosition(xPosition);
            dice.setYPosition(yPosition);
            dice.setXVelocity(xVelocity);
            dice.setYVelocity(yVelocity);
        }
        repaint();
    }
}