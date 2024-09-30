package com.mycompany.movies;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class About extends JFrame{
    
    private JLabel appNameL;
    private JLabel programmerNameL;
    private JLabel amL;
    private JLabel timeL;
    private JLabel logoL;
    
    private JPanel aboutPanel;
    
    public About(){
       
       //usual element creation
       appNameL = new JLabel("Application name: 9Movies");
       programmerNameL = new JLabel("Name: Ιωάννης\nSurname: Γάγγας");
       amL = new JLabel("AM: 19390038");
       timeL = new JLabel("Date started: 5/6/2022   Date finished: 6/6/2022");
       //adding image
       logoL = new JLabel("");
       logoL.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\logo.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
       
       //panel creation
       aboutPanel = new JPanel();
       aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));
       
       aboutPanel.add(appNameL);
       aboutPanel.add(programmerNameL);
       aboutPanel.add(amL);
       aboutPanel.add(timeL);
       aboutPanel.add(logoL);
       
       //ading panel on the frame
       this.add(aboutPanel);
       //editting frame
       this.setSize(375, 350);
       this.setLocation(600, 130);       
       this.setResizable(true);
       this.setTitle("Infos about the project");
       this.setBackground(Color.WHITE);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       this.setVisible(true);
    }
}
