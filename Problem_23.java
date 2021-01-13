/*A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.*/

import java.io.*;
import java.util.*;
import java.math.*;
class Proc{
    int[] abunArray;
    Proc(){
        abunArray=new int[28124];
        Arrays.fill(abunArray,0);
        abunArray=fillArray(abunArray);
    }
    /*This finds all abundant numbers*/
    int[] fillArray(int[] ar){
        for(int i=2;i<=ar.length;i++){
            int sum=0;
            for(int j=1;j<=i/2;j++){
                if(i%j==0){
                    sum+=j;
                }
            }
            if(sum>i){
                ar[i]=1;
            }
        }
        return ar;
    }
    /*This finds all numbers that Can be written as a sum of two abundant numbers*/
    long abunNumSum(){
        int[] abunNumSumArr=new int[28124];
        Arrays.fill(abunNumSumArr,0);
        long sum=0;
        outer:
        for(int i=24;i<abunNumSumArr.length;i++){
            inner:
            for(int j=12;j<=i/2;j++){
                if(abunArray[j]==1){
                    int rem=i-j;
                    if(abunArray[rem]==1){
                        abunNumSumArr[i]=1;
                        sum+=i;
                        break inner;
                    }
                }
            }
        }
        return sum;
    }
    /**This finds the sum of numbers that Cannot be written as a sum of two abundant numbers
    *Steps: a.Find sum of all numbers from 1 to 28123
    * b.Find sum of all numbers that can be written as a sum of two abundant numbers
    * return a-b
    */
    long nonAbunSum(){
        long abanSum=abunNumSum();
        long sumAll=0;
        for(int i=0;i<=28123;i++){
            sumAll+=i;
        }
        long nonAbunSum=sumAll-abanSum;
        return nonAbunSum;
    }
}
public class Main
{
	public static void main(String[] args) {
	    Proc p=new Proc();
	    System.out.println(p.nonAbunSum());
	}
}
