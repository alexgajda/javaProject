import java.util.ArrayList;

public class choice_5 {
    //object to choice 1
    choice_1 article = new choice_1();
    //VARIABLES THAT STORE THE TYPE OF ARTICLE DATA FROM DATABASE FROM CHOICE 1
    private ArrayList<String> sumType1Articles = article.getArticleType1();
    private ArrayList<String> sumType2Articles = article.getArticleType2();

    public void showAllArticles(){
        //PRINT THE SUM OF ALL TYPES
        System.out.printf("""
                
                
                Total Articles: %s
                Total Full Paper Articles: %s
                Total Paper in Progress Articles: %s
                Regular Articles: %s
                Case Study Articles: %s
                
                
                """, sumType1Articles.size(),
                //CALCULATES THE TOTAL TYPES IN EACH METHOD, WHICH RETURNS THE SUM
                fullPaper(),
                PaperInProgress(),
                Regular(),
                caseStudy());
    }

    //EACH METHOD RETURNS THE SUM TYPE OF ALL THE ARTICLES
    public int fullPaper(){
        int counter = 0;
        for (int i = 0; i < sumType1Articles.size(); i++){
            if (sumType1Articles.get(i).equals("Full paper")){
                counter++;
            }
        }
        return counter;
    }

    public int PaperInProgress(){
        int counter = 0;
        for (int i = 0; i < sumType1Articles.size(); i++){
            if (sumType1Articles.get(i).equals("Paper in progress")){
                counter++;
            }
        }
        return counter;
    }

    public int Regular(){
        int counter = 0;
        for (int i = 0; i < sumType2Articles.size(); i++){
            if (sumType2Articles.get(i).equals("Regular")){
                counter++;
            }
        }
        return counter;
    }

    public int caseStudy(){
        int counter = 0;
        for (int i = 0; i < sumType2Articles.size(); i++){
            if (sumType2Articles.get(i).equals("Case Study")){
                counter++;
            }
        }
        return counter;
    }

}
