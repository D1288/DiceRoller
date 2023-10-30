import javax.swing.*;

public class AnimationFrame extends JFrame {
    AnimationPanel animPanel;

    AnimationFrame() {
        ImageIcon image = new ImageIcon("d20logo.png");
        this.setIconImage(image.getImage());
        this.setTitle("D20 Dice Roller");
        animPanel = new AnimationPanel();

        Timer timer = new Timer(5000, e -> dispose());
        timer.setRepeats(false); // This ensures the timer only triggers once
        timer.start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(animPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
