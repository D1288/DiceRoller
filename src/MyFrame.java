import javax.swing.*;
import java.awt.*;



public class MyFrame extends JFrame {


    ContentPanel contentPanel;

    MyFrame(){
        this.setSize(500,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("D20 Dice Roller");

        ImageIcon image = new ImageIcon("d20logo.png");
        this.setIconImage(image.getImage());

        this.getContentPane().setBackground(new Color(190,192,190));

        contentPanel = new ContentPanel(this);
        this.add(contentPanel);
        this.setVisible(true);
    }
}
