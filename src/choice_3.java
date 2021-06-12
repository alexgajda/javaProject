import java.util.ArrayList;
import java.util.Scanner;

public class choice_3 {
    int isValid;
    choice_1 article = new choice_1(); //object to choice1
    choice_2 article2 = new choice_2(); //object to choice2

    //GETS THE CHARACTERISTICS OF THE ARTICLE STORED IN CHOICE 1
    private ArrayList<Integer> codesChoice3 = article.getArticleCode();

    Scanner input = new Scanner(System.in);

    public int ShowChoice3() {
        isValid = article2.scanTheCode(); //gets the code from from method in choice 2
        if (isValid == -1){
            System.out.println("Exiting...");
            return -1;
        }
        printAll(isValid); //prints code name type and title
        return codesChoice3.get(isValid);
    }

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
        if (article2.getEvaluatorEmailSize() != 0) { //if there is at least 1 evaluator in database
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

            int temp = findEvaluator(mailTemp);
            if (temp == -1){
                System.out.println("Evaluator not found!");
                return;
            }
            if (mailTemp.equals(article2.getEvaluatorEmail(temp))) {   //if the evaluator's email is in database
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
        for (int i = 0; i < article2.getHasEvaluatorSize(); i++){
            if (article2.getHasEvaluator(i) == isValid) {
                if (mailTemp.equals(article2.getEvaluatorEmail(i))) {
                    return i;
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public int returnRating(){
        //CHECKS IF THE RATING IS 1-10 AND RETURN IT
        int rating;
        do {
            while (!input.hasNextInt()) { //checks if it is a number
                System.err.println("That's not a number!");
                input.next();
            }
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
                
                
                """,article.getArticleTitle(isValid),codesChoice3.get(isValid),
                article.getArticleKey(isValid),article.getArticleType1(isValid),
                article.getArticleType1(isValid),article.getArticleType2(isValid));
    }

    public void printRatings(int isValid){
        //prints title and rations after the submit
        System.out.printf("""
                
                
                Article's Title: %s
                
                Research Contribution: %s
                Research Results: %s
                Research Methodology: %s
                Innovation: %s
                
                
                """,article.getArticleTitle(isValid),
                ratingContribution.get(ratingContribution.size() - 1),
                ratingResult.get(ratingResult.size() - 1),
                ratingMethodology.get(ratingMethodology.size() - 1),
                ratingInnovation.get(ratingInnovation.size() - 1));
    }

    public int getHasRating(int i) {
        return hasRating.get(i);
    }

    public int getHasRatingSize(){
        return hasRating.size();
    }

    public int getRatingResult(int i) {
        return ratingResult.get(i);
    }

    public int getRatingInnovation(int i) {
        return ratingInnovation.get(i);
    }

    public int getRatingMethodology(int i) {
        return ratingMethodology.get(i);
    }

    public int getRatingContribution(int i) {
        return ratingContribution.get(i);
    }

}