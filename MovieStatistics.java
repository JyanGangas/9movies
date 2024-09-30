package com.mycompany.movies;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovieStatistics extends JFrame {
    
    private int actionC = 0;
    private int comedyC = 0;
    private int dramaC = 0;
    private int fantasyC = 0;
    private int horrorC = 0;
    private int mysteryC = 0;
    private int romanceC = 0;
    private int thrillerC = 0;
    private int westernC = 0;
    private int movieSum = 0;
    private int moviesByC [] = {actionC, comedyC, dramaC, fantasyC, horrorC, mysteryC, romanceC, thrillerC, westernC};
    private int temp;
    private int index;
    
    private JPanel sPanel;
    private JLabel movieCount;
    private JLabel mostMovies;
    
    
    
    public MovieStatistics(){
       
       //creating elements and panels
       movieCount = new JLabel("Total number of movies registered: " + MovieNumber());
       BiggestCategory();
       
       sPanel = new JPanel();
       sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.Y_AXIS));
       
       sPanel.add(movieCount);
       sPanel.add(mostMovies);
       
       sPanel.setBackground(Color.CYAN);
       this.add(sPanel);
       
       //editing frame
       this.setSize(500, 570);
       this.setLocation(300, 180);       
       this.setResizable(true);
       this.setTitle("9Movies: Movie database statistics");
       this.setBackground(Color.WHITE);
       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       this.setVisible(true);
    }
    
    //methods to count number of movies in each category
    public int ActionCount()
    {
        File fileAC = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Action.txt");
        try (Scanner sc = new Scanner(fileAC)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                actionC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return actionC;
    }
    public int ComedyCount()
    {
        File fileCO = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Comedy.txt");
        try (Scanner sc = new Scanner(fileCO)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                comedyC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return comedyC;
    }
    public int DramaCount()
    {
        File fileDR = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Drama.txt");
        try (Scanner sc = new Scanner(fileDR)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                dramaC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return dramaC;
    }
    public int FantasyCount()
    {
        File fileFA = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Fantasy.txt");
        try (Scanner sc = new Scanner(fileFA)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                fantasyC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return fantasyC;
    }
    public int HorrorCount()
    {
        File fileHO = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Horror.txt");
        try (Scanner sc = new Scanner(fileHO)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                horrorC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return horrorC;
    }
    public int MysteryCount()
    {
        File fileMY = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Mystery.txt");
        try (Scanner sc = new Scanner(fileMY)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                mysteryC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return mysteryC;
    }
    public int RomanceCount()
    {
       File fileRO = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Romance.txt");
        try (Scanner sc = new Scanner(fileRO)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                romanceC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return romanceC;
    }
    public int ThrillerCount()
    {
        File fileTH = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Thriller.txt");
        try (Scanner sc = new Scanner(fileTH)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                thrillerC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return thrillerC;
    }
    public int WesternCount()
    {
        File fileWE = new File("C:\\Users\\ranke\\OneDrive\\Εικόνες\\OneDrive\\Έγγραφα\\NetBeansProjects\\Movies\\src\\main\\java\\com\\mycompany\\movies\\Western.txt");
        try (Scanner sc = new Scanner(fileWE)) {
            while(sc.hasNextLine())
            {
                sc.nextLine();
                westernC++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
        
        return westernC;
    }
    
    //method that gives the sum of all movies
    private int MovieNumber(){
 
        movieSum = ActionCount() + ComedyCount() + DramaCount() + FantasyCount() + HorrorCount() + MysteryCount() + RomanceCount() + ThrillerCount() + WesternCount();
        return movieSum;
    }
    
    //method to find the category with the most movies
    private JLabel BiggestCategory(){
        
        moviesByC[0] = ActionCount()/2;
        moviesByC[1] = ComedyCount()/2;
        moviesByC[2] = DramaCount()/2;
        moviesByC[3] = FantasyCount()/2;
        moviesByC[4] = HorrorCount()/2;
        moviesByC[5] = MysteryCount()/2;
        moviesByC[6] = RomanceCount()/2;
        moviesByC[7] = ThrillerCount()/2;
        moviesByC[8] = WesternCount()/2;
        
        temp = moviesByC[0];
        for(int i=0; i<9; i++)
        {
            if(temp < moviesByC[i])
            {
                temp = moviesByC[i];
                index = i;
            }
        }
        mostMovies = switch (index) {
            case 0 -> new JLabel("The action category has the most movies registered with movie count " + moviesByC[index]);
            case 1 -> new JLabel("The comedy category has the most movies registered with movie count " + moviesByC[index]);
            case 2 -> new JLabel("The drama category has the most movies registered with movie count " + moviesByC[index]);
            case 3 -> new JLabel("The fantasy category has the most movies registered with movie count " + moviesByC[index]);
            case 4 -> new JLabel("The horror category has the most movies registered with movie count " + moviesByC[index]);
            case 5 -> new JLabel("The mystery category has the most movies registered with movie count " + moviesByC[index]);
            case 6 -> new JLabel("The romance category has the most movies registered with movie count " + moviesByC[index]);
            case 7 -> new JLabel("The thriller category has the most movies registered with movie count " + moviesByC[index]);
            default -> new JLabel("The western category has the most movies registered with movie count " + moviesByC[index]);
        };
        
        return mostMovies;
    }
}

