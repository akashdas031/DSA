package DSA.leetCode;

/**
 * sumOfDigitOfNumber
 */
public class sumOfDigitOfNumber {

   //trying to declare the result variable outside of the recursive method
   public static  int res=0;//global variable
   public static int getSumg(int num){
    if(num<10){
        return num;
    }
    res=0;//make it 0 before adding the sum of digits to it and it will be pass as a argument to next level if it
    //contains multiple digits
    while(num!=0){
        res+=num%10;
        num/=10;
    }
    return getSumg(res);
   }
    //using recursion and declare the sum inside the method
public static int getSumr(int num){
    //if number is less than ten and it is a single digit and return it
    if(num<10){
        return num;
    }
    //declare a variable sum which will store the sum of the digits of the number
    int sum=0;
    //calculate the sum of the digits of the number 
    while(num!=0){
        sum+=num%10;
        num/=10;
    }
    //made recursion call for the sum as if it is again multiple digits then we can calculate the sum of the digits 
    //until it reach the single digit value
    return getSumr(sum);
}
    //using recursion and taking result value as a method parameter
    public static int getSum(int num,int sum){
        //base case,if the number is less than 10 then return the number
        if(num<10){
            return num;
        }
        //calculate the sum of the digits of the number 
        while(num !=0){
            sum+=num%10;
            num/=10;
        }
        //then made recursion call for the sum if it is more than one digit otherwise the number will be returned
        //here in this case 1243586=1+2+4+3+5+8+6=29 so made the recursion call for the number 29 and made the sum value to zero
        //so that the sum of the digits will be stored inside the sum and again if it is a multiple digit then made recursion call for next number

        return getSum(sum,0);
    }
    //Iterative approach
    public static int getSum(int num){
        //This while loop denotes that when the number is not a single digit then 
        //it will go inside the loop and add it's digit to a single digit value.
        while(num>9){
            //declare a variable sum which will store the sum of the digits of the number 
            int sum=0;
            //then run a while loop to add all the digits of the number and store it in the sum
            //until the num becomes zero 
            while(num!=0){
                //fetch the digit of the number by performing modulo operation with 10 to the number
                sum+=num%10;
                //then remove the digit after adding it in the sum
                num/=10;
            }
            //then after calculating the sum of the digits of the number to the sum 
            //if the sum of digits of the number in current iteration is also contains more than one digits 
            //then again the above loop will run and re-calculate the sum of the digits and this process will 
            //continue until the number becomes single digit
            //1243586 =1+2+4+3+5+8+6=29
            //so for 29 again this will run the previos loop and calculate the sum of it's digits
            //29=2+9=11
            //as the sum of digits of 29 aslo resulting in multiple digits other than single digit 
            //again the loop will run and calculate it's digit sum
            //11=1+1=2
            // so now the result of sum of digits is single digit and the outer while loop will not run again
            //and we found a single digit as the sum of the digits of the number and return the number
            num=sum;
        }
        return num;
    }
    public static void main(String[] args) {
        int num=1243586;
        System.out.println(getSumg(num));
    }
}