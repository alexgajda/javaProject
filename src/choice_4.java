import java.util.ArrayList;
import java.util.Scanner;

public class choice_4 {
    choice_1 article = new choice_1(); //object to choice1
    choice_2 article2 = new choice_2();
    choice_3 article3 = new choice_3();
    Scanner input = new Scanner(System.in);

    private ArrayList<String> titleChoice4 = article.getArticleTitle();
    private ArrayList<String> type1Choice4 = article.getArticleType1();
    private ArrayList<String> type2Choice4 = article.getArticleType2();
    private ArrayList<String> authorChoice4 = article.getAuthorName();
    private ArrayList<String> coAuthorChoice4 = article.getCoauthorName();

    public void printRatings(){
        int isValid = article2.scanTheCode(); //gets the code from from method in choice 2
        printAll(isValid); //prints the characteristics
    }

    public void printAll(int isValid){
        System.out.printf("""
                
                
                Article's Title: %s
                Article's type: %s
                %s type: %s
                Author: %s
                Co-Author: %s
                
                
                """, titleChoice4.get(isValid),
                type1Choice4.get(isValid),
                type1Choice4.get(isValid),type2Choice4.get(isValid),
                authorChoice4.get(isValid),
                coAuthorChoice4.get(isValid)
                );
    }





}
