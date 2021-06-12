import java.util.ArrayList;
import java.util.Scanner;

public class choice_2 {
    choice_1 article = new choice_1(); //object to choice 1

    private ArrayList<Integer> codesChoice2 = article.getArticleCode();

    private static ArrayList<Integer> hasEvaluator = new ArrayList<Integer>();

    Scanner input = new Scanner(System.in); //scanner input
    int isValid;    //variable that indicates if article's code is real or not

    public int showChoice2(){
        isValid = scanTheCode();
        if (isValid == -1){
            System.out.println("Exiting...");
            return -1;
        }
        for (int i = 0; i < hasEvaluator.size(); i++){
            if (isValid == hasEvaluator.get(i)){
                System.out.println("The article has already an evaluator in database!");
                return -1;
            }
        }
        printAll(isValid); //prints code name type and title
        return isValid;
    }

    public int scanTheCode(){
        int isValid; //variable that stores the code and returns if it is in database
        int tempCode;
        System.out.print("Give me the article's code (Exit -1): ");
        do {
            while (!input.hasNextInt()) {
                System.err.println("That's not a number! (Exit: -1)");
                input.next();
            }
            tempCode = input.nextInt();
            input.nextLine(); //after next int, not to be confused with \n
            if (tempCode == -1){
                return -1;
            }
            isValid = findCode(tempCode);
            if (isValid == -1){ //if the code is invalid and not in database
                System.out.print("Couldn't find code, Try again: ");
            }
        }while (isValid == -1 && tempCode != -1); //leaves while it finds the correct code that is in database
        return isValid;
    }

    public int findCode(int tempCode){
        for (int i = 0; i < codesChoice2.size(); i++){
            if (tempCode == codesChoice2.get(i)){
                return i; //returns != 1 if the article's code is already in database
            }
        }
        return -1; //return -1 if the article's code is wrong
    }

    public void printAll(int isValid){
        //prints all the elements that were asked
        System.out.printf("""
                
                
                Article's code: %s
                Article's Title: %s
                Author's name/surname: %s
                Article's Type: %s
                %s's type: %s
                
                
                """,codesChoice2.get(isValid),article.getArticleTitle(isValid),
                article.getAuthorName(isValid),article.getArticleType1(isValid),
                article.getArticleType1(isValid),article.getArticleType2(isValid)
        );
    }

    /************************EVALUATOR***********************/
    //THESE VARIABLES STORE THE EVALUATOR'S INFORMATION
    private static ArrayList<String> evaluatorEmail = new ArrayList<String>();
    private ArrayList<String> evaluatorName = new ArrayList<String>();
    private ArrayList<String> evaluatorTitle = new ArrayList<String>();
    private ArrayList<String> evaluatorOrganism = new ArrayList<String>();

    public void addEvaluator(int isValid2){
        int find2; //variable that finds if the evaluator is already in database
        boolean find1; //variable that finds if the author is the evaluator of its own article
        String mailTemp;
        boolean isValid; //checks if the email is valid (real) or not
        System.out.print("Enter Evaluator's mail: ");
        do {
            mailTemp = input.nextLine();
            //calls the email validation method in choice 1 (SEE CHOICE 1)
            isValid = article.isValidEmailAddress(mailTemp);
            if (!isValid){
                System.out.println("Wrong email address, Try again: "); //if it is not valid email
            }
        }while(!isValid);

        find1 = findAuthors(mailTemp);
        if (find1 == false){ //if the evaluator's are the authors
            System.out.print("Authors can't be Evaluators of their own article!\n");
            return; //returns to main
        }else{ //if the evaluators are not the authors
            hasEvaluator.add(isValid2);
            //hasCode.add()
            find2 = findEvaluator(mailTemp);
            if (find2 == -1){ //if the evaluator is not in database
                //adds email
                evaluatorEmail.add(mailTemp);
                //adds name
                System.out.print("Enter Evaluator's name and surname: ");
                evaluatorName.add(input.nextLine());
                //adds organism
                System.out.print("Give Evaluator's Organism (Press 1 to skip): ");
                String organismTemp = input.nextLine();
                if (organismTemp.equals("1")) { //if the input is 1 it skips
                    evaluatorOrganism.add("NA"); //NA = skipped
                } else {
                    evaluatorOrganism.add(organismTemp);
                }
                //adds authors title
                System.out.print("Give Evaluator's Title (Press 1 to skip): ");
                String titleTemp = input.nextLine();
                if (titleTemp.equals("1")) { //if the input is 1 it skips
                    evaluatorTitle.add("NA"); //NA = skipped
                } else {
                    evaluatorTitle.add(titleTemp);
                }
                System.out.print("Evaluator has successfully been added!\n");
            }else{ //if the evaluator is already in database, no new inputs
                System.out.println("Evaluator has been found in database!\n");
                evaluatorEmail.add(evaluatorEmail.get(find2));
                evaluatorName.add(evaluatorName.get(find2));
                evaluatorTitle.add(evaluatorTitle.get(find2));
                evaluatorOrganism.add(evaluatorOrganism.get(find2));
            }
        }
    }

    public int findEvaluator(String mailTemp){
        //checks if the evaluator's email is already in database
        for (int i = 0; i < evaluatorEmail.size(); i++){
            if(mailTemp.equals(evaluatorEmail.get(i))){
                return i;
            }
        }
        return -1;
    }

    public boolean findAuthors(String mailTemp){
        //checks if the authors are the article's evaluators (false = yes \\ true = no)
        if (mailTemp.equals(article.getAuthorMail(isValid)) || mailTemp.equals(article.getCoauthorMail(isValid))){
            return false;
        }
        return true;
    }

    public String getEvaluatorEmail(int i) {
        return evaluatorEmail.get(i);
    }

    public int getEvaluatorEmailSize(){
        return evaluatorEmail.size();
    }

    public int getHasEvaluator(int i) {
        return hasEvaluator.get(i);
    }

    public int getHasEvaluatorSize(){
        return hasEvaluator.size();
    }
}