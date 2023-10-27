import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JComboBox comboBoxD4;
    JComboBox comboBoxD6;
    JComboBox comboBoxD8;
    JComboBox comboBoxD10;
    JComboBox comboBoxD12;
    JComboBox comboBoxD20;

    JButton rollButton = new JButton();


    MyFrame(){

        rollButton.setText("Roll!");
        rollButton.setFont(new Font("MV Boli", Font.BOLD, 40));

        MyLabel d4Label = new MyLabel(4);
        MyLabel d6Label = new MyLabel(6);
        MyLabel d8Label = new MyLabel(8);
        MyLabel d10Label = new MyLabel(10);
        MyLabel d12Label = new MyLabel(12);
        MyLabel d20Label = new MyLabel(20);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500,500);
        this.setTitle("D20 Dice Roller");

        Integer[] numOfDie = {0,1,2,3,4,5,6,7,8,9};
        comboBoxD4 = new JComboBox(numOfDie);
        comboBoxD6 = new JComboBox(numOfDie);
        comboBoxD8 = new JComboBox(numOfDie);
        comboBoxD10 = new JComboBox(numOfDie);
        comboBoxD12 = new JComboBox(numOfDie);
        comboBoxD20 = new JComboBox(numOfDie);



        ImageIcon image = new ImageIcon("img.png");
        this.setIconImage(image.getImage());



        this.add(comboBoxD4);
        this.add(d4Label);
        this.add(comboBoxD6);
        this.add(d6Label);
        this.add(comboBoxD8);
        this.add(d8Label);
        this.add(comboBoxD10);
        this.add(d10Label);
        this.add(comboBoxD12);
        this.add(d12Label);
        this.add(comboBoxD20);
        this.add(d20Label);

        this.add(rollButton);

        this.getContentPane().setBackground(new Color(190,192,190));
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
