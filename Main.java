import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  

  JPanel mainPanel;

  JLabel fahrLabel; 
  JLabel CelLabel; 

  JTextField fahrInput; 
  JTextField celInput; 

  JButton fahrButton; 
  JButton celButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Tempature Converter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true); 

    //initalize the main panel 
    mainPanel = new JPanel(); 
    //Disable Layout helper 
    mainPanel.setLayout(null); 

    //Create side labels 
    fahrLabel = new JLabel("Degrees Fahrenhiet"); 
    CelLabel = new JLabel("Degrees Celsius"); 

    //set location for the labels 
    fahrLabel.setBounds(180,90,150,20); 
    CelLabel.setBounds(180,120,150,20); 

    //output labels to the panel 
    mainPanel.add(fahrLabel); 
    mainPanel.add(CelLabel); 

    //create text boxs for user input 
    fahrInput = new JTextField(); 
    celInput = new JTextField(); 

    //set location for the text boxes 
    fahrInput.setBounds(330,90,80,20); 
    celInput.setBounds(330,120,80,20); 

    //output text boxes to screen 
    mainPanel.add(fahrInput); 
    mainPanel.add(celInput); 

    //create buttons to convert Tempature 
    fahrButton = new JButton("F -> C");
    celButton = new JButton("C -> F"); 

    //add action listener to buttons 
    fahrButton.addActionListener(this); 
    celButton.addActionListener(this);

    //set location for buttons 
    fahrButton.setBounds(420,90,80,20); 
    celButton.setBounds(420,120,80,20); 

    //output buttons to panel 
    mainPanel.add(fahrButton); 
    mainPanel.add(celButton);  


    //add panel to window 
    frame.add(mainPanel);
 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand(); 

    if(command.equals("F -> C")){
      //get number from textbox 
      String firstBox = fahrInput.getText(); 

      //change strings into Integer and then do the equation 
      int sideA = Integer.parseInt(firstBox);

      int resultA = (sideA - 32) * 5 / 9;

      //output answer to text box 
      celInput.setText("" + resultA);

    }if(command.equals("C -> F")){

        //get numbers from text box 
        String secondBox = celInput.getText(); 

        //change string to integer and then do the equation 
        int sideB = Integer.parseInt(secondBox); 

        int resultB = (9 * sideB) / 5 + 32; 

        //output answer to text box 
        fahrInput.setText("" + resultB);  
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
