import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class choice_3 {
    choice_1 article = new choice_1(); //object to choice1
    choice_2 article2 = new choice_2(); //object to choice2

    //GETS THE CHARACTERISTICS OF THE ARTICLE STORED IN CHOICE 1
    private ArrayList<Integer> codesChoice3 = article.getArticleCode();
    private ArrayList<String> titleChoice3 = article.getArticleTitle();
    private ArrayList<String> keysChoice3 = article.getArticleKey();
    private ArrayList<String> type1Choice3 = article.getArticleType1();
    private ArrayList<String> type2Choice3 = article.getArticleType2();
    private ArrayList<Integer> hasEvaluatorChoice3 = article2.getHasEvaluator();

    Scanner input = new Scanner(System.in);
    int isValid;

    public int ShowChoice3() {
        isValid = article2.scanTheCode(); //gets the code from from method in choice 2
        if (isValid == -1){
            System.out.println("Exiting...");
            return -1;
        }
        printAll(isValid); //prints code name type and title
        return codesChoice3.get(isValid);
    }

    //GETS THE EMAILS FROM THE EVALUATORS STORED IN CHOICE 2
    private ArrayList<String> evaluatorMailChoice2 = article2.getEvaluatorEmail();
    //NEW VARIABLES THAT STORE THE RATINGS OF THE EVALUATORS
    private static ArrayList<Integer> ratingContribution = new ArrayList<Integer>();
    private static ArrayList<Integer> ratingResult = new ArrayList<Integer>();
    private static ArrayList<Integer> ratingMethodology = new ArrayList<Integer>();
    private static ArrayList<Integer> ratingInnovation = new ArrayList<Integer>();
    private static ArrayList<Integer> hasRating = new ArrayList<Integer>();

    public void addRating(int isRated){
        for (int i = 0; i < hasRating.size(); i++){
            if (isRated == hasRating.get(i)){
                System.out.println("Article has already been rated!");
                return;
            }
        }
        if (evaluatorMailChoice2.size() != 0) { //if there is at least 1 evaluator in database
            String mailTemp;
            boolean isValid2;
            System.out.print("Enter the evaluator's email: ");
            do { //email validation
                mailTemp = input.nextLine();
                //calls the email validation method in choice 1 (SEE CHOICE 1)
                isValid2 = article.isValidEmailAddress(mailTemp);
                if (!isValid2) {
                    System.out.println("Wrong email address, Try again: "); //if it is not valid email
                }
            } while (!isValid2);

            if (mailTemp.equals(evaluatorMailChoice2.get(findEvaluator(mailTemp)))) {   //if the evaluator's email is in database
                hasRating.add(isRated);
                //Gets all the ratings
                System.out.print("Congratulations, you are a evaluator! Your ratings must be between (1-10)." +
                        " Please enter your ratings below:\n");
                System.out.print("Research Contribution: ");
                ratingContribution.add(returnRating());
                System.out.print("Research Results: ");
                ratingResult.add(returnRating());
                System.out.print("Research Methodology: ");
                ratingMethodology.add(returnRating());
                System.out.print("Innovation: ");
                ratingInnovation.add(returnRating());
                printRatings(isValid); //prints title and the ratings
            } else {    //if the email given is not in evaluator's email database
                System.out.print("Evaluator not found in database!\n");
            }
        } else { //if there are 0 evaluators stored in database
            System.out.print("These is no evaluator in database!\n");
        }
    }

    public int findEvaluator(String mailTemp){
        //return if there is an evaluator email in database
        int i;
        for ( i = 0; i < codesChoice3.size(); i++){
            if (mailTemp.equals(evaluatorMailChoice2.get(i))){
                return i;
            }
        }
        return i-1;
    }

    public int returnRating(){
        //CHECKS IF THE RATING IS 1-10 AND RETURN IT
        int rating;
        do {
            rating = input.nextInt();
            if (rating < 1 || rating > 10){
                System.out.print("Rating must be in the range of 1-10, Try again: ");
            }
        }while (rating < 1 || rating > 10);
        input.nextLine();
        return rating;
    }

    public void printAll(int isValid) {
        //prints all the characteristics after the submit of the article's code
        System.out.printf("""
                
                Article's Title: %s
                Article's Code: %s
                Article's Key Code: %s
                Article's type: %s
                %s's type: %s
                
                
                """,titleChoice3.get(isValid),codesChoice3.get(isValid),
                keysChoice3.get(isValid),type1Choice3.get(isValid),
                type1Choice3.get(isValid),type2Choice3.get(isValid));
    }

    public void printRatings(int isValid){
        //prints title and rations after the submit
        System.out.printf("""
                
                
                Article's Title: %s
                
                Research Contribution: %s
                Research Results: %s
                Research Methodology: %s
                Innovation: %s
                
                
                """,titleChoice3.get(isValid),
                ratingContribution.get(ratingContribution.size() - 1),
                ratingResult.get(ratingResult.size() - 1),
                ratingMethodology.get(ratingMethodology.size() - 1),
                ratingInnovation.get(ratingInnovation.size() - 1));
    }

    public static ArrayList<Integer> getHasRating() {
        return hasRating;
    }

    public static ArrayList<Integer> getRatingResult() {
        return ratingResult;
    }

    public static ArrayList<Integer> getRatingInnovation() {
        return ratingInnovation;
    }

    public static ArrayList<Integer> getRatingMethodology() {
        return ratingMethodology;
    }

    public static ArrayList<Integer> getRatingContribution() {
        return ratingContribution;
    }

}