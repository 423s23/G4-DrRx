import java.awt.*;
import javax.swing.*;

public class Questions extends JFrame {
    public static void main() {
        JFrame frame = new JFrame("Frame");
        frame.setLayout(new GridLayout(3, 2));

        JPanel button_panel = new JPanel(new GridLayout(1,5));
        JPanel text_panel = new JPanel(new GridLayout(2,0));
        JPanel next_button_panel = new JPanel();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel jlabel = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        //jlabel.setFont(new Font("Verdana",1,15));
        jlabel.setHorizontalAlignment(SwingConstants.LEFT);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton option1 = new JRadioButton("Option 1");
        JRadioButton option2 = new JRadioButton("Option 2");
        JRadioButton option3 = new JRadioButton("Option 3");
        JRadioButton option4 = new JRadioButton("Option 4");
        JRadioButton option5 = new JRadioButton("Option 5");

        JButton exit = new JButton("NEXT");
        exit.setPreferredSize(new Dimension(100,50));

        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);
        buttonGroup.add(option5);

        button_panel.add(option1);
        button_panel.add(option2);
        button_panel.add(option3);
        button_panel.add(option4);
        button_panel.add(option5);

        text_panel.add(jlabel);
        next_button_panel.add(exit);

        frame.add(text_panel);
        frame.add(button_panel);
        frame.add(next_button_panel);

        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}