import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Questionnaire_Application {

    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame frame = new JFrame("Patient Lookup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Help button for documentation
        JButton help_button = new JButton("How to Use");

        // Define new Search Field
        JTextField search_bar = new JTextField(30);
        search_bar.setHorizontalAlignment(JTextField.CENTER);
        JButton search_button = new JButton("Search");
        JLabel jlabel = new JLabel("Enter Patient Name For Results:");
        jlabel.setFont(new Font("Verdana", Font.BOLD,26));
        search_bar.setFont(new Font("Verdana", Font.BOLD,26));
        JTextArea introduction = new JTextArea("This is the patient lookup area! " +
                "Please type in the last name of whoever you are looking up and a new window will appear " +
                "with their information. \n\n(If you input incorrect information nothing will appear.)");
        introduction.setEditable(false);

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

        Border empty = BorderFactory.createEmptyBorder(70,0, 0, 0);
        searchPanel.setBorder(empty);

        JPanel textPanel = new JPanel();
        textPanel.add(introduction);

        JPanel helpPanel = new JPanel();
        helpPanel.add(help_button);

        // Create Enough Labels for the Patient Information
        ArrayList<JLabel> labels = buildLabels(11);

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

        help_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/423s23/G4-DrRx/blob/main/README.md"));
                }
                catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        // Define a panel to hold the recommendations
        JPanel recommendations = new JPanel();
        GridLayout layout = new GridLayout(0,2, 0, 3); // Rows is zero so the number becomes flexible
        Border empty2 = BorderFactory.createEmptyBorder(0,20, 70, 50);
        recommendations.setLayout(layout);
        recommendations.setBorder(empty2);

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
        wrapper.add(helpPanel);
        wrapper.add(recommendations);
        frame.add(wrapper);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void display(JTextField search_bar, ArrayList<JLabel> labels){
        JFrame frame = new JFrame("Patient Panel");

        String patient_name_dirty = (search_bar.getText()).toLowerCase();
        String patient_name = Check_Data.Clean(patient_name_dirty);

        String[] result = null;
        //int counter = 1;
        String line;
        File in = new File(("Project\\testData\\sampleinput.csv"));
        Scanner sc = null;
        try {
            sc = new Scanner(in);
        } catch (FileNotFoundException ignore) {
        }
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            line = sc.nextLine();
            String[] current_line = (line.toLowerCase()).split(",");

            if (current_line[1].equals(patient_name)) {
                result = Check_Data.main(line);
            }
        }

        if(result == null) {
            result = Check_Data.main("Patient not found");
        }

        sc.close();

        int iter_val = 0;
        for (JLabel label : labels) {
            label.setText(result[iter_val]);
            if(result[iter_val].contains("CSS WARNING!"))
            {
                label.setForeground(Color.RED);
            } else {
                label.setForeground(Color.BLACK);
            }
            iter_val++;
        }

        JPanel recommendations = new JPanel();
        GridLayout layout = new GridLayout(0,2, 0, 1); // Rows is zero so the number becomes flexible
        recommendations.setLayout(layout);

        Border empty = BorderFactory.createEmptyBorder(0,20, 70, 50);
        recommendations.setBorder(empty);

        // labels for patient recommendation, have to be added to be able to display
        for (JLabel label : labels) {
            label.setHorizontalAlignment(2);
            recommendations.add(label);
        }

        JButton b = new JButton("Back");

        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                frame.dispose();
            }
        });

        JPanel wrapper = new JPanel();

        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS)); // Adds new panels underneath the last
        wrapper.add(recommendations);

        wrapper.add(b);

        Border empty2 = BorderFactory.createEmptyBorder(40,20, 150, 0);
        wrapper.setBorder(empty2);

        frame.add(wrapper);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    // -- ********** -- BUILDER DESIGN PATTERN -- ********** --
    public static ArrayList<JLabel> buildLabels(int label_amt) {
        ArrayList<JLabel> labels = new ArrayList<>();
        for (int i = 0; i < label_amt; i++) {
            JLabel label = new JLabel("",SwingConstants.CENTER);
            label.setFont(new Font("Verdana", Font.BOLD,17));
            labels.add(label);
        }
        return labels;
    }
    // -- ********** -- BUILDER DESIGN PATTERN -- ********** --
}
