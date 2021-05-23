import java.util.ArrayList;

public class choice_4 {
    choice_1 article = new choice_1(); //object to choice1
    choice_2 article2 = new choice_2();//object to choice2
    choice_3 article3 = new choice_3(); //object to choice3

    private ArrayList<String> titleChoice4 = article.getArticleTitle();
    private ArrayList<String> type1Choice4 = article.getArticleType1();
    private ArrayList<String> type2Choice4 = article.getArticleType2();
    private ArrayList<String> authorChoice4 = article.getAuthorName();
    private ArrayList<Integer> codesChoice4 = article.getArticleCode();
    private ArrayList<String> coAuthorChoice4 = article.getCoauthorName();
    private ArrayList<Integer> hasEvaluatorChoice4 = article2.getHasEvaluator();
    private ArrayList<Integer> hasRatingChoice4 = article3.getHasRating();
    private static ArrayList<Integer> ratingContributionChoice4 = choice_3.getRatingContribution();
    private static ArrayList<Integer> ratingResultChoice4 = choice_3.getRatingResult();
    private static ArrayList<Integer> ratingMethodologyChoice4 = choice_3.getRatingMethodology();
    private static ArrayList<Integer> ratingInnovationChoice4 = choice_3.getRatingInnovation();

    public void printRatings(){
        int isValid = article2.scanTheCode(); //gets the code from from method in choice 2
        if (isValid == -1){
            System.out.println("Exiting...");
            return;
        }
        printAll(isValid); //prints the characteristics
        printRated(isValid);
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

    public void printRated(int isValid){
        for (int i = 0; i < hasRatingChoice4.size(); i++) {
            if (codesChoice4.get(isValid).equals(hasRatingChoice4.get(i))) {
                System.out.println("THE ARTICLE HAS BEEN RATED: ");
                System.out.printf("""
                                Article's Title: %s
                                                
                                Research Contribution: %s
                                Research Results: %s
                                Research Methodology: %s
                                Innovation: %s
                                                        
                                                        
                                """, titleChoice4.get(isValid),
                        ratingContributionChoice4.get(isValid),
                        ratingResultChoice4.get(isValid),
                        ratingMethodologyChoice4.get(isValid),
                        ratingInnovationChoice4.get(isValid)
                );
                return;
            }
        }
        for (int i = 0; i < hasEvaluatorChoice4.size(); i++){
            if (isValid == hasEvaluatorChoice4.get(i)){
                System.out.println("FOR EVALUATION (ΠΡΟΣ ΑΞΙΟΛΟΓΗΣΗ)!");
                return;
            }
        }
        System.out.println("PENDING EVALUATOR (ΕΚΡΕΜΜΕΙ ΟΡΙΣΜΟΣ ΑΞΙΟΛΟΓΗΤΗ)!");
    }
}
