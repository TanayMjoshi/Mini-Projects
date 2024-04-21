package Project;

//Q take input from user binary format and give the real number as output

import java.util.Scanner;

class Binary{
    Scanner sc = new Scanner(System.in);
    int a;
    int count;           //counts length of the number entered
    int [] arr;          //multiplication purpose
    int [] answer;       //sum at the end of each number after multiplication
    int sum;
    int lengthIs(){      //gives certain value to count
        a = sc.nextInt();
        int temp = a;
        while(temp > 0){
            temp /= 10;
            count++;
        }
        System.out.println(count);
        return count;
    }
    void baseNum(){                           //gives base to each number/element in array
        arr = new int[count];                 //assigning array no of elements it can hold
        for(int i = 0;i < arr.length;i++){   //loop that separates num and stores it in array
            int temp = a%10;
            a/=10;
            if(temp==1){                    //if number is 1 it gives base as 2
                arr[i] = temp*2;
            }
            else{
                arr[i] = 0;
            }
            System.out.println(i + " : " + arr[i]);
        }
        System.out.println("-----------");
    }

    void binaryNums(){                      //required multiplications for each element with their respective to power
        answer = new int[count];
        for(int i = 0;i<answer.length;i++){
            answer[i] = 1;
            System.out.println(i+" : "+answer[i]);
        }
        System.out.println("-----------");
        int num = 1;
        for(int i = 0;i < answer.length;i++){
            for(int j = 1;j < num;j++){
                answer[i] *= arr[i];
            }
            num++;
            System.out.println(i+" : "+answer[i]);
        }
        System.out.println("-----------");
    }

    void ansIs(){                       //final summation of all the digits to find out what the number was
        if(arr[0]==2){
            answer[0] = 1;
        }
        else{
            answer[0] = 0;
        }
        for(int i = 0;i<answer.length;i++){
            sum += answer[i];
        }
        System.out.println(sum);
    }
}
public class BinaryNumber {
    public static void main(String[] args) {
        Binary one = new Binary();
        one.lengthIs();
        one.baseNum();
        one.binaryNums();
        one.ansIs();
    }
}