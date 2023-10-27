import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    MyLabel(int num){
        this.setText("D" + num);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("MV Boli", Font.BOLD, 20));
    }
}
