import javax.swing.*;
import java.awt.*;
import java.awt.font.ImageGraphicAttribute;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500,500);
        this.setTitle("D20 Dice Roller");

        ImageIcon image = new ImageIcon("img.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(50,82,80));

        this.setVisible(true);
    }


}
