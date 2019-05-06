package Uebung4;

public class NumberFinder {

    public static void main(String[] args) {
        int primeNumbersCount = 0;
        int counter = 0;

        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)){
                primeNumbersCount++;
            }
        }

        System.out.println(primeNumbersCount+" numbers from 1 to 10000 are prime");

        for (int i = 2; i < 10000; i++) {

            if (isPrime(i)&&isPalindrome(i)){
                System.out.print(i+" ");
                counter++;
            }

            if (counter==10){
                break;
            }
        }

        System.out.println();
        PrintEmirps();

    }

    public static void PrintEmirps() {

        int counter = 0;
        int currentNumber = 0;

        do {
            currentNumber++;
            int reverseNumber = Numbers.Reverse(currentNumber);

            if (Numbers.isPalindrome(currentNumber)){
                continue;
            }

            if(Numbers.isPrime(currentNumber)&&Numbers.isPrime(reverseNumber)){
                counter++;
                System.out.print(currentNumber+" ");
            }
        }
        while (counter<=10);

    }

    public static boolean isPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i==0){
                return  false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(int number) {

        String stringNumber = Integer.toString(number);
        String endPart = "";

        for (int i = stringNumber.length()-1; i > stringNumber.length()/2; i--) {
            endPart += stringNumber.charAt(i);
        }

        if (endPart.equals(stringNumber.substring(0,stringNumber.length()/2))){
            return true;
        }
        else {
            return false;
        }

    }
}
