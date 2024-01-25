import java.util.ArrayList;
import java.util.List;

public class ListPrime {

    //{1,5,7,13,445,76,100}
    //Average value of prime values
    //3 1 3
    //7 1 7
    //8 1 2 4 8
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(445);
        integerList.add(100);

        int sumOfPrime = 0;
        int quantityOfPrime=0;
        for (Integer num : integerList) {
            int d = 0;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    d += 1;
                }
            }
            if (d==0){
                sumOfPrime+=num;
                quantityOfPrime+=1;
            }
        }
        System.out.println(sumOfPrime/quantityOfPrime);
    }
    }

