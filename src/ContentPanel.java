import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ContentPanel extends JPanel implements ActionListener {
    JComboBox<Integer> comboBoxD4;
    JComboBox<Integer> comboBoxD6;
    JComboBox<Integer> comboBoxD8;
    JComboBox<Integer> comboBoxD10;
    JComboBox<Integer> comboBoxD12;
    JComboBox<Integer> comboBoxD20;

    JButton rollButton = new JButton();
    ScoreLabel scoreLabel = new ScoreLabel();
    JLabel infoLabel = new JLabel();

    AnimationPanel animPanel;
    MyFrame frame;

    Random randomNum = new Random();

    ContentPanel(MyFrame frame){
        this.setBackground(new Color(190,192,190));
        this.frame = frame;
        this.setPreferredSize(new Dimension(500,500));

        rollButton.setText("Roll!");
        rollButton.setFont(new Font("MV Boli", Font.BOLD, 40));
        rollButton.setPreferredSize(new Dimension(250, 70));
        rollButton.addActionListener(this);

        MyLabel d4Label = new MyLabel(4);
        MyLabel d6Label = new MyLabel(6);
        MyLabel d8Label = new MyLabel(8);
        MyLabel d10Label = new MyLabel(10);
        MyLabel d12Label = new MyLabel(12);
        MyLabel d20Label = new MyLabel(20);

        Integer[] numOfDie = {0,1,2,3,4,5,6,7,8,9};
        comboBoxD4 = new JComboBox<>(numOfDie);
        comboBoxD6 = new JComboBox<>(numOfDie);
        comboBoxD8 = new JComboBox<>(numOfDie);
        comboBoxD10 = new JComboBox<>(numOfDie);
        comboBoxD12 = new JComboBox<>(numOfDie);
        comboBoxD20 = new JComboBox<>(numOfDie);

        comboBoxD4.addActionListener(this);
        comboBoxD6.addActionListener(this);
        comboBoxD8.addActionListener(this);
        comboBoxD10.addActionListener(this);
        comboBoxD12.addActionListener(this);
        comboBoxD20.addActionListener(this);


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

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BorderLayout()); // Use FlowLayout for labels
        labelPanel.add(rollButton, BorderLayout.NORTH);
        labelPanel.add(scoreLabel, BorderLayout.CENTER);
        labelPanel.add(infoLabel, BorderLayout.SOUTH);
        labelPanel.setBackground(new Color(190,192,190));

        this.add(labelPanel);


    }


    //dice roll implementation



    ArrayList<Dice> diceList = new ArrayList<>();


    String infoLabelText = "";
    public void rollDie(){
        int totalScore = 0;
        for (Dice dice : diceList) {

            int dieScore = randomNum.nextInt(dice.dieSides) + 1;
            infoLabelText += "The " + dice.dieSides + " sided die rolled a " + dieScore + "<br>";
            infoLabel.setText("<html>" + infoLabelText + "</html>");
            System.out.println("The " + dice.dieSides + " sided die rolled a " + dieScore);
            totalScore += dieScore;
        }

        scoreLabel.setText("Your total is: " + totalScore);
        System.out.println("Your total is: " + totalScore);
    }



    private int prevSelectedValueD4 = 0;
    private int prevSelectedValueD6 = 0;
    private int prevSelectedValueD8 = 0;
    private int prevSelectedValueD10 = 0;
    private int prevSelectedValueD12 = 0;
    private int prevSelectedValueD20 = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rollButton) {
            infoLabelText = "";
            if(!diceList.isEmpty()) {
                Timer timer = new Timer(5000, e1 -> rollDie());
                timer.setRepeats(false);
                timer.start();
                addAnimPanel();

            }

        } else {
            JComboBox<Integer> selectedComboBox = (JComboBox<Integer>) e.getSource();
            int selectedValue = (int) selectedComboBox.getSelectedItem();

            if (selectedComboBox == comboBoxD4) {
                handleDieSelection(4, selectedValue, prevSelectedValueD4);
                prevSelectedValueD4 = selectedValue;
            } else if (selectedComboBox == comboBoxD6) {
                handleDieSelection(6, selectedValue, prevSelectedValueD6);
                prevSelectedValueD6 = selectedValue;
            } else if (selectedComboBox == comboBoxD8) {
                handleDieSelection(8, selectedValue, prevSelectedValueD8);
                prevSelectedValueD8 = selectedValue;
            } else if (selectedComboBox == comboBoxD10) {
                handleDieSelection(10, selectedValue, prevSelectedValueD10);
                prevSelectedValueD10 = selectedValue;
            } else if (selectedComboBox == comboBoxD12) {
                handleDieSelection(12, selectedValue, prevSelectedValueD12);
                prevSelectedValueD12 = selectedValue;
            } else if (selectedComboBox == comboBoxD20) {
                handleDieSelection(20, selectedValue, prevSelectedValueD20);
                prevSelectedValueD20 = selectedValue;
            }
        }

    }

    private void handleDieSelection(int sides, int selectedValue, int prevSelectedValue){
        if (selectedValue > prevSelectedValue){
            for(int i = 0; i < selectedValue - prevSelectedValue; i++){
                double xVelocity = randomNum.nextDouble() * 10;
                double yVelocity = randomNum.nextDouble() * 10;
                Dice newDice = new Dice(sides, 0,0, xVelocity, yVelocity);
                diceList.add(newDice);

                newDice.setXPosition(0);
                newDice.setYPosition(0);

            }
            System.out.println("Added " + (selectedValue - prevSelectedValue) + " " + sides + "-sided dice to the list.");
        } else if (selectedValue < prevSelectedValue) {
            final int[] removeCount = {prevSelectedValue - selectedValue};
            diceList.removeIf(dice -> dice.getDieSides() == sides && removeCount[0]-- > 0 );
            System.out.println("Removed " + (prevSelectedValue - selectedValue) + " " + sides + "-sided dice from the list.");
        }
    }

    private void addAnimPanel(){
        this.setVisible(false);
        animPanel = new AnimationPanel(diceList);
        frame.add(animPanel);

        Timer animTimer = new Timer(5000, e -> {
            frame.remove(animPanel);
            ContentPanel.this.setVisible(true);
            frame.revalidate();
            frame.repaint();
        });
        animTimer.setRepeats(false);
        animTimer.start();

    }
}
