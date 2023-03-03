import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Steps For Export to runnable .jar file:
 * File->Export->Java->Runnable JAR file
 * Set file/files to package together
 * Set destination of file on your computer
 * Select Package libraries (Make sure to delete previous .jar file)*/

@SuppressWarnings("serial")
public class Questionnaire_Application extends JFrame {


	public Questionnaire_Application() {
        search_bar();

        // Below code commented out in case we need to add additional functionalities/windows to the application

       /* JFrame frame = new JFrame("Doctor Assisting Questionnaire");
        frame.setLayout(new GridLayout(3, 2));

        JPanel button_panel = new JPanel(new GridLayout(1,5));
        JPanel text_panel = new JPanel(new GridLayout(2,0));
        JPanel next_button_panel = new JPanel();

        //------------------------------------------------//
        
        JLabel jlabel = new JLabel("Doctor Assisting Application",SwingConstants.CENTER);
        jlabel.setFont(new Font("Verdana", Font.BOLD,26));
        
        //jlabel.setForeground(Color.RED); Text Color Option
        
        JButton option1 = new JButton("Patient Search Bar");
        
        //------------------------------------------------//
        
        option1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){search_bar();}
            });

        //------------------------------------------------//

        button_panel.add(option1); //adds button to panel

        text_panel.add(jlabel); //adds text block to text displaying panel

        frame.add(text_panel);
        frame.add(button_panel);
        frame.add(next_button_panel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  */
	}
	
    private void search_bar() { //write down personal info of patient
    	JFrame f = new JFrame("Patient Lookup");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	
    	JPanel wrapper = new JPanel( new FlowLayout(0, 0, FlowLayout.LEADING) );
    	
    	JTextField search_bar = new JTextField(30);
    	JLabel jlabel = new JLabel("Enter Patient Name Below For Results:",SwingConstants.CENTER);
    	JButton search_button = new JButton("Search");
    	
    	jlabel.setFont(new Font("Verdana", Font.BOLD,26));
    	search_bar.setFont(new Font("Verdana", Font.BOLD,26));
    	
    	search_bar.setHorizontalAlignment(JTextField.CENTER);

        JLabel jlabel2 = new JLabel("",SwingConstants.CENTER);
        jlabel2.setFont(new Font("Verdana", Font.BOLD,20));
        JLabel jlabel3 = new JLabel("",SwingConstants.CENTER);
        jlabel3.setFont(new Font("Verdana", Font.BOLD,20));
        JLabel jlabel4 = new JLabel("",SwingConstants.CENTER);
        jlabel4.setFont(new Font("Verdana", Font.BOLD,20));
        JLabel jlabel5 = new JLabel("",SwingConstants.CENTER);
        jlabel5.setFont(new Font("Verdana", Font.BOLD,20));
        JLabel jlabel6 = new JLabel("",SwingConstants.CENTER);
        jlabel6.setFont(new Font("Verdana", Font.BOLD,20));
    	search_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
            	String patient_name = search_bar.getText();
                try {
                    String line;
                    Scanner sc = new Scanner(new File("Project\\testData\\sampleinput.csv"));
                    sc.useDelimiter(",");   //sets the delimiter pattern
                    while (sc.hasNext())  //returns a boolean value
                    {
                        line = sc.nextLine();
                        if (line.toLowerCase().contains(patient_name.toLowerCase())) {
                            //System.out.println(line);
                            Check_Data data = new Check_Data();
                            String[] result = data.main(line);
                            jlabel2.setText(result[0].toString());
                            jlabel3.setText(result[1].toString());
                            jlabel4.setText(result[2].toString());
                            jlabel5.setText(result[3].toString());
                            jlabel6.setText(result[4].toString());
                            break;
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    // ignore
                }
            	//after finding it you should probably open a new panel for displaying the data
            }
            
    	});
    	
    	wrapper.add(search_bar);
    	wrapper.add(search_button);
    	
    	panel.add(jlabel);//adds text block to text displaying panel
    	panel.add(wrapper);
        // labels for patient recommendation
        panel.add(jlabel2);
        panel.add(jlabel3);
        panel.add(jlabel4);
        panel.add(jlabel6);
        panel.add(jlabel5);     // Recommendation label
    	
    	f.add(panel); //adds the text displaying panel to the frame
    	
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setVisible(true);
    }
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Questionnaire_Application qa = new Questionnaire_Application();
    }
}
