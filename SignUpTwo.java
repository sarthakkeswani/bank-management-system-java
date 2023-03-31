package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Struct;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener {
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton eyes, eno, syes, sno;
    JComboBox religion, category, income, education, occupation;
    String formno;
    SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religionL = new JLabel("Religion:");
        religionL.setFont(new Font("Raleway",Font.BOLD,20));
        religionL.setBounds(100,140,100,30);
        add(religionL);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categoryL = new JLabel("Category:");
        categoryL.setFont(new Font("Raleway",Font.BOLD,20));
        categoryL.setBounds(100,190,200,30);
        add(categoryL);

        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel incomeL = new JLabel("Income:");
        incomeL.setFont(new Font("Raleway",Font.BOLD,20));
        incomeL.setBounds(100,240,200,30);
        add(incomeL);

        String valIncome[] = {"null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel educationL = new JLabel("Educational:");
        educationL.setFont(new Font("Raleway",Font.BOLD,20));
        educationL.setBounds(100,290,200,30);
        add(educationL);

        JLabel qualificationL = new JLabel("Qualification:");
        qualificationL.setFont(new Font("Raleway",Font.BOLD,20));
        qualificationL.setBounds(100,315,200,30);
        add(qualificationL);

        String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupationL = new JLabel("Occupation:");
        occupationL.setFont(new Font("Raleway",Font.BOLD,20));
        occupationL.setBounds(100,390,200,30);
        add(occupationL);

        String occupationValues[] = {"Salaried","Self Employed","Business","Student","Retired","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup eagroup = new ButtonGroup();
        eagroup.add(eyes);
        eagroup.add(eno);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String religionS = (String) religion.getSelectedItem();
         String categoryS = (String) category.getSelectedItem();
         String incomeS = (String) income.getSelectedItem();
         String educationS = (String) education.getSelectedItem();
         String occupationS = (String) occupation.getSelectedItem();
         String seniorCitizen = null;
         if(syes.isSelected()){
            seniorCitizen = "Yes";
         } else if (sno.isSelected()){
            seniorCitizen = "No";
         } 

         String existingAccount = null;
         if(eyes.isSelected()){
            existingAccount = "Yes";
         } else if (eno.isSelected()){
            existingAccount = "No";
         }

         String panS = panTextField.getText();
         String adhaarS = aadharTextField.getText();

         try {
            Conn c  = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+religionS+"', '"+categoryS+"', '"+incomeS+"', '"+educationS+"', '"+occupationS+"', '"+panS+"', '"+adhaarS+"', '"+seniorCitizen+"', '"+existingAccount+"') ";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);

         } catch(Exception ex) {
            System.out.println(ex);
         }


    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
