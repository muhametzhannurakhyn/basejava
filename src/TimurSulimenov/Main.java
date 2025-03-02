package TimurSulimenov;

public class Main {
    public static void main(String[] args) {
        NewsPage BBC_news = new NewsPage();
        Education ENU_edu = new Education();

        BBC_news.showPage();

        System.out.println("\n=============================\n");

        ENU_edu.showPage();
    }
}


//private static int bibarySearch(int[] numbers, int numberToFind){
//    int low = 0;
//    int hight = numbers.length;
//
//    while(low >= hight){
//        int middlePosition = (low + hight)/2;
//        int middleNumber = numbers[middlePosition];
//
//        if(numberToFind == middleNumber){
//            return middlePosition
//        }
//
//        if(numberToFind)
//    }
//}


