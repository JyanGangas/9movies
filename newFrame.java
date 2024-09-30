package com.mycompany.movies;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class newFrame extends JFrame {
    
    private int count;
    private int confirmation;
    
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel errorPanel;
    private JPanel basePanel;
    private JPanel textPanel;
    
    private JTextField title;
    private JTextField year;
    private JTextField duration;
    private JTextField director;
    private JComboBox type;
    
    private JLabel titleLabel;
    private JLabel yearLabel;
    private JLabel durationLabel;
    private JLabel directorLabel;
    private JLabel typeLabel;
    private JLabel errorLabel;
    
    private JButton submit;
    private JButton statistics;
    
    private JMenuBar menuBar;
    private JMenuItem aboutMenu;
    
    public newFrame() {
      
       //creation of the wanted elements
       titleLabel = new JLabel("Movie title:\t");
       yearLabel = new JLabel("Release year:\t");
       durationLabel = new JLabel("Duration:\t");
       directorLabel = new JLabel("Director:\t");
       typeLabel = new JLabel("Type:\t");
       errorLabel = new JLabel("");
       
       title = new JTextField(40);
       year = new JTextField(4);
       duration = new JTextField(4);
       director = new JTextField(50);
       String MovieTypesList[] = {"Action","Comedy","Drama","Fantasy","Horror","Mystery","Romance","Thriller","Western"};
       type = new JComboBox(MovieTypesList);
       
       submit = new JButton("Submit");
       statistics = new JButton("Statistics");
       
       //creation of panels and layouts for the app
       basePanel = new JPanel(new BorderLayout());
       basePanel.setBorder(new EmptyBorder(2,3,2,3));
       mainPanel = new JPanel(new GridBagLayout());
       mainPanel.setBorder(new EmptyBorder(5,5,5,5));
       textPanel = new JPanel (new GridLayout(10,1,10,5));
       textPanel.setBackground(Color.CYAN);
       mainPanel.setBackground(Color.LIGHT_GRAY);
       mainPanel.add(textPanel);
       basePanel.add(mainPanel, BorderLayout.CENTER);
       
       //adding elements on the panel
       textPanel.add(titleLabel);
       textPanel.add(title);
       textPanel.add(yearLabel);
       textPanel.add(year);      
       textPanel.add(durationLabel);
       textPanel.add(duration);      
       textPanel.add(directorLabel);
       textPanel.add(director);
       textPanel.add(typeLabel);
       textPanel.add(type);
       
       //adding button panel and buttons
       buttonPanel = new JPanel();
       buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
       buttonPanel.add(submit);
       buttonPanel.add(statistics);
       
       //error panel for unsaved data
       errorPanel = new JPanel();
       errorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
       errorPanel.add(errorLabel);
       
       //menu bar to support "About" menu
       menuBar = new JMenuBar();
       aboutMenu = new JMenuItem("About");
       menuBar.add(aboutMenu);
       
       //adding panels to the frame
       this.add(basePanel);
       this.add(buttonPanel, BorderLayout.SOUTH);
       this.add(errorPanel, BorderLayout.NORTH);
       this.setJMenuBar(menuBar);
       
       //editing frame
       this.setSize(600, 800);
       this.setLocation(500, 100);       
       this.setResizable(true);
       this.setTitle("9Movies: Movie Registration");
       this.setBackground(Color.WHITE);
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       //adding listener for close operation
       this.addWindowListener(new WindowListener() {
           @Override
           public void windowOpened(WindowEvent e) {
               
           }

           @Override
           public void windowClosing(WindowEvent e) {
               //in case there are no unsaved data in the boxes the app just asks if the user would like to exit
               if (title.getText().equals("") || year.getText().equals("") || duration.getText().equals("") || director.getText().equals(""))
               {
                   confirmation = JOptionPane.showConfirmDialog(null, "Do you want to close the application?", "exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                   if(confirmation == JOptionPane.YES_OPTION)
                   {
                        e.getWindow().dispose();
                   }
               }
               //in case there are unsaved data a more accurate message appears upon closing
               else
               {
                   confirmation = JOptionPane.showConfirmDialog(null, "You have unsubmited data.\nDo you wish to exit the application?", "exit, data deleted", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                   if(confirmation == JOptionPane.YES_OPTION)
                   {
                        e.getWindow().dispose();
                   }
               }
            }

           @Override
           public void windowClosed(WindowEvent e) {
               
           }

           @Override
           public void windowIconified(WindowEvent e) {
               
           }

           @Override
           public void windowDeiconified(WindowEvent e) {
               
           }

           @Override
           public void windowActivated(WindowEvent e) {
               
           }

           @Override
           public void windowDeactivated(WindowEvent e) {
           }
           
       }); 
       
       this.setVisible(true);
       
       //adding functionality to submit button
       submit.addActionListener(new ActionListener() 
       {
           @Override
           public void actionPerformed(ActionEvent e) 
           {
               //error message if 1 or more fields are left blank
               if (title.getText().equals("") || year.getText().equals("") || duration.getText().equals("") || director.getText().equals(""))
               {
                  errorLabel.setText("Unaible to register your submition! One or more elements are blank!");
                  errorLabel.setForeground(Color.red);
               }
               else
               {
                    //associating the data from the user to the attributes of the classs
                    Movies movie = new Movies();
                    movie.setTitle(title.getText());
                    movie.setRYear(year.getText());
                    movie.setDuration(duration.getText());
                    movie.setDirector(director.getText());
                    movie.setCategory((String) type.getSelectedItem());
                    
                    //save everything in the correct file depending oon the type of the movie
                    if (movie.getCategory().equals("Action"))
                    {
                        //app gives code to the movie with no user interfierance
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Action.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("AC"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Action.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                               System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Comedy"))
                    {
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Comedy.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("CO"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Comedy.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                            System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Drama"))
                    {
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Drama.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("DR"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Drama.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                            System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Fantasy"))
                    {
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Fantasy.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("FA"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Fantasy.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                            System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Horror"))
                    {
                        File file = new File("C:Movies\\src\\main\\java\\com\\mycompany\\movies\\Horror.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("HO"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Horror.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                            System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Mystery"))
                    {
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Mystery.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("MY"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Mystery.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                           System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Romance"))
                    {
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Romance.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("RO"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Romance.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                           System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Thriller"))
                    {
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Thriller.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("TH"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Thriller.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                           System.out.println("###Error in saving###\n");
                        }
                    }
                    else if (type.getSelectedItem().equals("Western"))
                    {
                        File file = new File("Movies\\src\\main\\java\\com\\mycompany\\movies\\Western.txt");
                        try (Scanner sc = new Scanner(file)) {
                                while(sc.hasNextLine())
                                {
                                    sc.nextLine();
                                    count++;
                                }
                                sc.close();
                        } catch (FileNotFoundException ex) {
                            ex.getStackTrace();
                        }
                        movie.setCode("WE"+count);
                        try (BufferedWriter actionBuffer = new BufferedWriter(new FileWriter("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Western.txt", true))) {
                               actionBuffer.write(movie.getCode() + " " + movie.getTitle() + " " + movie.getRYear() + " " + movie.getDuration() + " " + movie.getDirector());
                               actionBuffer.newLine();
                        } catch (IOException ex) {
                           System.out.println("###Error in saving###\n");
                        }
                    }
                    title.setText("");
                    year.setText("");
                    duration.setText("");
                    director.setText("");
                    errorLabel.setText(""); 
                }
           }
       });
       
       //adding functionality to statistics button
       statistics.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               new MovieStatistics();
           }
       });
       
       //adding fuctionality to about button
       aboutMenu.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e) {
               new About();
           }  
       });          
       
    }
    
}
