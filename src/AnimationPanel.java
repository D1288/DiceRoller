import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image d20;
    Image backgroundImage;
    Timer animTimer;
    double xVel = 3;
    double yVel = 5;
    double xPosition = 0;
    double yPosition = 0;






    AnimationPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        d20 = new ImageIcon("d20.png").getImage();
        animTimer = new Timer(1, this);
        backgroundImage = new ImageIcon("background.jpg").getImage();
        animTimer.start();


    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage, 0,0,null);
        g2d.drawImage(d20, (int) xPosition, (int) yPosition,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(xPosition >= PANEL_WIDTH - d20.getWidth(null) || xPosition < 0){
            xVel = -xVel *.9;
        }
        if(yPosition >= PANEL_HEIGHT - d20.getHeight(null) || yPosition < 0){
            yVel = -yVel *.9;
        }
        yPosition += yVel;
        xPosition += xVel;
        repaint();
    }
}