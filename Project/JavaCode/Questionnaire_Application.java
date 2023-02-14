
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/* Steps For Export to runnable .jar file:
 * File->Export->Java->Runnable JAR file
 * Set file/files to package together
 * Set destination of file on your computer
 * Select Package libraries (Make sure to delete previous .jar file)*/

@SuppressWarnings("serial")
public class Questionnaire_Application extends JFrame {


	public Questionnaire_Application() {
        JFrame frame = new JFrame("Doctor Assisting Questionnaire");
        frame.setLayout(new GridLayout(3, 2));

        JPanel button_panel = new JPanel(new GridLayout(1,5));
        JPanel text_panel = new JPanel(new GridLayout(2,0));
        JPanel next_button_panel = new JPanel();

        //------------------------------------------------//
        
        JLabel jlabel = new JLabel("Doctor Assisting Questionnaire",SwingConstants.CENTER);
        jlabel.setFont(new Font("Verdana", Font.BOLD,26));
        
        //jlabel.setForeground(Color.RED); Text Color Option

        ButtonGroup buttonGroup = new ButtonGroup();
        
        JButton option1 = new JButton("Personal Info");
        JButton option2 = new JButton("Quiz 1");
        JButton option3 = new JButton("Quiz 2");
        JButton option4 = new JButton("Quiz 3");
        JButton option5 = new JButton("Quiz 4");
        
        //------------------------------------------------//
        
        option1.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){personal_info();}
           });
        option2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                Questions zfr = new Questions();
                zfr.main();
            }
        });
        option3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                Questions zfr = new Questions();
                zfr.main();
            }
        });
        option4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                Questions zfr = new Questions();
                zfr.main();
            }
        });
        option5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                Questions zfr = new Questions();
                zfr.main();
            }
        });


        //------------------------------------------------//
        
        buttonGroup.add(option1); //adds buttons to a button group for macro manipulation
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);
        buttonGroup.add(option5);

        button_panel.add(option1); //adds button to panel
        button_panel.add(option2);
        button_panel.add(option3);
        button_panel.add(option4);
        button_panel.add(option5);

        text_panel.add(jlabel); //adds text block to text displaying panel

        frame.add(text_panel);
        frame.add(button_panel);
        frame.add(next_button_panel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    private void personal_info() { //write down personal info of patient
    	JFrame f = new JFrame("Personal Info");
    	JPanel text = new JPanel(new GridLayout(2,0));
    	JLabel jlabel = new JLabel("Enter Personal Info Below:",SwingConstants.CENTER);
    	jlabel.setFont(new Font("Verdana", Font.BOLD,26));
    	
    	text.add(jlabel); //adds text block to text displaying panel
    	
    	f.add(text); //adds the text displaying panel to the frame
    	
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setVisible(true);
    }
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
		Questionnaire_Application qa = new Questionnaire_Application();
    }
    
}
