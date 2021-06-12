import java.util.ArrayList;

public class choice_4 {
    choice_1 article = new choice_1(); //object to choice1
    choice_2 article2 = new choice_2();//object to choice2
    choice_3 article3 = new choice_3(); //object to choice3

    private ArrayList<Integer> codesChoice4 = article.getArticleCode();

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
                
                
                """, article.getArticleTitle(isValid),
                article.getArticleType1(isValid),
                article.getArticleType1(isValid),article.getArticleType2(isValid),
                article.getAuthorName(isValid),
                article.getCoauthorName(isValid)
                );
    }

    public void printRated(int isValid){
        for (int i = 0; i < article3.getHasRatingSize(); i++) {
            if (codesChoice4.get(isValid).equals(article3.getHasRating(i))) {
                System.out.println("THE ARTICLE HAS BEEN RATED: ");
                System.out.printf("""
                                Article's Title: %s
                                                
                                Research Contribution: %s
                                Research Results: %s
                                Research Methodology: %s
                                Innovation: %s
                                                        
                                                        
                                """, article.getArticleTitle(isValid),
                        article3.getRatingContribution(isValid),
                        article3.getRatingResult(isValid),
                        article3.getRatingMethodology(isValid),
                        article3.getRatingInnovation(isValid)
                );
                return;
            }
        }
        for (int i = 0; i < article2.getHasEvaluatorSize(); i++){
            if (isValid == article2.getHasEvaluator(i)){
                System.out.println("FOR EVALUATION (ΠΡΟΣ ΑΞΙΟΛΟΓΗΣΗ)!");
                return;
            }
        }
        System.out.println("PENDING EVALUATOR (ΕΚΡΕΜΜΕΙ ΟΡΙΣΜΟΣ ΑΞΙΟΛΟΓΗΤΗ)!");
    }
}
