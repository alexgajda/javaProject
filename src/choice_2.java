import java.util.ArrayList;
import java.util.Scanner;

public class choice_2 {
    choice_1 article = new choice_1(); //object to choice 1

    //VARIABLES THAT STORE THE DATA FROM CHOICE 1 TO BE USED IN CHOICE 2
    //those variables help to find the characteristics of the articles and authors that were stored in choice 1
    private ArrayList<Integer> codesChoice2 = article.getArticleCode();
    private ArrayList<String> nameChoice2 = article.getAuthorName();
    private ArrayList<String> titleChoice2 = article.getArticleTitle();
    private ArrayList<String> type1Choice2 = article.getArticleType1();
    private ArrayList<String> type2Choice2 = article.getArticleType2();
    private ArrayList<String> mailAuthor = article.getAuthorMail();
    private ArrayList<String> mailCoAuthor = article.getCoauthorMail();

    private Scanner input = new Scanner(System.in); //scanner input
    int isValid;    //variable that indicates if article's code is real or not

    public void showArticle(){
        System.out.print("Give me the article's code: ");
        do {
            int tempCode = input.nextInt();
            if (tempCode == 0){ //if the user wants to exit and go back to table of contents
                return;
            }
            isValid = findCode(tempCode);
            if (isValid == -1){ //if the code is invalid and not in database
                System.out.print("Couldn't find code, Try again (press 0 to exit): ");
            }
        }while (isValid == -1); //leaves while it finds the correct code that is in database
        input.nextLine(); //after next int not to be confused with \n
        printAll(isValid); //prints code name type and title
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
                
                
                """,codesChoice2.get(isValid),titleChoice2.get(isValid),
                nameChoice2.get(isValid),type1Choice2.get(isValid),
                type1Choice2.get(isValid),type2Choice2.get(isValid)
        );
    }

    /************************EVALUATOR***********************/
    //THESE VARIABLES STORE THE EVALUATOR'S INFORMATION
    private ArrayList<String> evaluatorEmail = new ArrayList<String>();
    private ArrayList<String> evaluatorName = new ArrayList<String>();
    private ArrayList<String> evaluatorTitle = new ArrayList<String>();
    private ArrayList<String> evaluatorOrganism = new ArrayList<String>();

    public void addEvaluator(){
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
            System.out.print("Authors can't be Evaluators of their own article!");
            return; //returns to main
        }else{ //if the evaluators are not the authors
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
                System.out.print("Evaluator has successfully been added! ");
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
        if (mailTemp.equals(mailAuthor.get(isValid)) || mailTemp.equals(mailCoAuthor.get(isValid))){
            return false;
        }
        return true;
    }

}