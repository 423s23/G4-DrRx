import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questionnaire_Application {

    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame frame = new JFrame("Patient Lookup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define new Search Field
        JTextField search_bar = new JTextField(30);
        search_bar.setHorizontalAlignment(JTextField.CENTER);
        JButton search_button = new JButton("Search");
        JLabel jlabel = new JLabel("Enter Patient Name For Results:");
        jlabel.setFont(new Font("Verdana", Font.BOLD,26));
        search_bar.setFont(new Font("Verdana", Font.BOLD,26));
        JTextArea introduction = new JTextArea("This is the patient lookup area! Please type in the name of whoever you are \nlooking up and a new window will appear with their information. \n(If you input incorrect information nothing will appear.)");

        introduction.setFont(new Font("Verdana", Font.PLAIN,26));
        introduction.setLineWrap(true);
        introduction.setSize(1050,550);
        introduction.setBackground(Color.PINK);

        // Define a panel to hold the Search Field
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(jlabel);
        searchPanel.add(search_bar);
        searchPanel.add(search_button);

        JPanel textPanel = new JPanel();
        textPanel.add(introduction);

        // Create Enough Labels for the Patient Information
        int labelAmt = 11; // EQUAL TO THE NUMBER OF FIELDS THAT WILL BE RETURNED BY CHECK_DATA
        ArrayList<JLabel> labels = new ArrayList<>();
        for (int i = 0; i < labelAmt; i++) {
            JLabel label = new JLabel("",SwingConstants.CENTER);
            label.setFont(new Font("Verdana", Font.BOLD,17));
            labels.add(label);
        }


        // Activate search when button pressed
        search_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                display(search_bar,labels);
            }
        });

        search_bar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                display(search_bar,labels);
            }
        });

        // Define a panel to hold the recommendations
        JPanel recommendations = new JPanel();
        GridLayout layout = new GridLayout(0,2, 0, 3); // Rows is zero so the number becomes flexible
        recommendations.setLayout(layout);
        Border empty = BorderFactory.createEmptyBorder(0,20, 70, 50);
        recommendations.setBorder(empty);

        // labels for patient recommendation, have to be added to be able to display
        for (JLabel label : labels) {
            recommendations.add(label);
        }

        // Set the window to be visible as the default to be false
        // Wrapper holds all panels so formatting is easier
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS)); // Adds new panels underneath the last
        wrapper.add(searchPanel);
        wrapper.add(textPanel);
        wrapper.add(recommendations);
        frame.add(wrapper);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    public static void display(JTextField search_bar, ArrayList<JLabel> labels){
        JFrame frame = new JFrame("Patient Panel");

        String patient_name_dirty = search_bar.getText();
        String patient_name = Check_Data.Clean(patient_name_dirty);
        try {
            String line;
            Scanner sc = new Scanner(new File("Project\\testData\\sampleinput.csv"));
            sc.useDelimiter(",");   //sets the delimiter pattern
            while (sc.hasNext())  //returns a boolean value
            {
                line = sc.nextLine();
                if (line.toLowerCase().contains(patient_name.toLowerCase())) {
                    String[] result = Check_Data.main(line);

                    int iterval = 0;

                    for (JLabel label : labels) {
                        label.setText(result[iterval]);
                        if(result[iterval].contains("Get immediate help"))
                        {
                            label.setForeground(Color.RED);
                        } else {
                            label.setForeground(Color.BLACK);
                        }
                        iterval++;
                    }
                    break;
                }
            }
            sc.close();
        } catch (FileNotFoundException ignored) {
        }

        JPanel recommendations = new JPanel();
        GridLayout layout = new GridLayout(0,2, 0, 1); // Rows is zero so the number becomes flexible
        recommendations.setLayout(layout);
        Border empty = BorderFactory.createEmptyBorder(0,20, 70, 50);
        recommendations.setBorder(empty);

        // labels for patient recommendation, have to be added to be able to display
        for (JLabel label : labels) {
            recommendations.add(label);
        }

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS)); // Adds new panels underneath the last
        wrapper.add(recommendations);
        frame.add(wrapper);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
