package Activities;

import java.util.Arrays;

public class activity2 {
    public static void main(String []args){
        int[] numArr= {10,11,12,10,23,10};
        int sumVal=30;
        int num = 10;
        System.out.println("Array is : "+Arrays.toString(numArr));
        result(numArr,sumVal,num);
        System.out.println("SumValue is : "+sumVal);
    }

    public static boolean result(int[] numArr, int sumVal,int num ){
        int temp = 0;
        for (int numVal: numArr) {
            if (numVal == num) {
                temp += numVal;
            }  if (temp > sumVal) {
                break;
            }
        }
        return temp == sumVal;
    }
}
