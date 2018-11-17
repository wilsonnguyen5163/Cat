import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cat extends JFrame implements ActionListener{
  JPanel titlePan = new JPanel();
  JPanel step2Pan = new JPanel();
  JPanel pan2Title = new JPanel();
  JPanel step3Pan = new JPanel();
  JPanel step4Pan = new JPanel();
  static JComboBox step1 = new JComboBox();
  static JLabel choice1 = new JLabel("Select your choice:", JLabel.CENTER);
  static JComboBox step2 = new JComboBox();
  static JLabel choice2 = new JLabel("Select your choice:", JLabel.CENTER);
  static JLabel chooseCat = new JLabel("Please enter Cat ID#:");
  static JTextField chooseCatField = new JTextField("                    ");
  static JButton okay = new JButton("Okay");
  static JLabel updateLabel = new JLabel("Enter the updated information:");
  static JTextField updateText = new JTextField("                    ");
  static JButton okay2 = new JButton("Okay");
    
  public cat() {
    setTitle("Cat-astrophe");
    setSize(1500, 1000);
    setResizable(false);
    titlePan.setLayout(new FlowLayout());
    
    JLabel image = new JLabel();
    titlePan.setPreferredSize(new Dimension (250,250));
    titlePan.setBackground(Color.white);
    image.setIcon(new ImageIcon("catpic.jpg"));
    titlePan.add(image);
    add(titlePan);
    
    choice1.setFont(new Font("Verdana", Font.PLAIN, 20));
    step1.setFont(new Font("Verdana", Font.PLAIN, 20));
    step1.addItem("Add a cat");
    step1.addItem("Update cat info");
    step1.addActionListener(this);
    titlePan.add(choice1);
    titlePan.add(step1);
    titlePan.setBackground(Color.white);
    
    getContentPane().setBackground(Color.white);
    setVisible(true);
  }
  
  public static void main (String[]args) {
    cat frame = new cat();
  }
  
  public void step2_chooseCat() {
    remove(titlePan);
    add(step2Pan);
    repaint();
    pack();
    
    pan2Title.setLayout(new FlowLayout());
    pan2Title.setBackground(Color.white);
    
    BoxLayout boxLayoutMenu = new BoxLayout(step2Pan, BoxLayout.Y_AXIS);
    step2Pan.setLayout(boxLayoutMenu);
    
    setSize(1500, 1000);
    chooseCat.setFont(new Font("Verdana", Font.PLAIN, 20));
    chooseCatField.setFont(new Font("Verdana", Font.PLAIN, 20));
    pan2Title.add(chooseCat);
    pan2Title.add(chooseCatField);
    pan2Title.add(okay);
    step2Pan.add(pan2Title);
    okay.addActionListener(this);
    setVisible(true);
  }
  
  public void step3_combo() {
    step2Pan.add(step3Pan);
    step3Pan.setBackground(Color.white);
    
    choice2.setFont(new Font("Verdana", Font.PLAIN, 20));
    step2.setFont(new Font("Verdana", Font.PLAIN, 20));
    step2.addItem("Proposal Date");
    step2.addItem("Name");
    step2.addItem("ID #");
    step2.addItem("Breed");
    step2.addItem("Location");
    step2.addItem("Adoption Counsellor");
    step2.addItem("Microchip #");
    step2.addItem("Age");
    step2.addItem("Sex");
    step2.addItem("Spayed or Neutered");
    step2.addItem("Shelter Name");
    step2.addItem("Shelter ID");
    step2.addItem("To Post");
    step2.addItem("Posted");
    step2.addItem("Store");
    step2.addItem("FIV Tested");
    step2.addItem("FLV Tested");
    step2.addItem("FVRCP Date");
    step2.addItem("Rabies Date");
    step2.addItem("Medical Notes");
    step2.addItem("Behavioural Notes");
    step2.addItem("Outcome");
    step2.addItem("Intake Date");
    step2.addActionListener(this);

    step2.addActionListener(this);
    step3Pan.add(choice2);
    step3Pan.add(step2);
    setVisible(true);
  }
  
  public void step4_update() {
    step2Pan.add(step4Pan);
    step4Pan.setBackground(Color.white);
    
    step4Pan.setLayout(new FlowLayout());
    updateLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
    updateText.setFont(new Font("Verdana", Font.PLAIN, 20));
    step4Pan.add(updateLabel);
    step4Pan.add(updateText);
    step4Pan.add(okay2);
    okay2.addActionListener(this);
    setVisible(true);
  }
  
  public void actionPerformed (ActionEvent event) {
    if (step1 == event.getSource()){
      if (step1.getSelectedItem().equals("Update cat info")) {
        step2_chooseCat();
      }
    }
    if (okay == event.getSource()){
      step3_combo();
    }
    if (step2 == event.getSource()) {
      step4_update();
    }
      
  }
}