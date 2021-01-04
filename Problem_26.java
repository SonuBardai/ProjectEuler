/*
Reciprocal cycles: A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*/

import java.io.*;
import java.util.*;
import java.math.*;
class Proc{
    int largeCycle(int n){
            int max=0;
            int maxNum=0;
        for(int i=2;i<n;i++){
            int x=1;
            int[] ar=new int[i];
            Arrays.fill(ar,-1);
            int count=0;
            while(true){
                int y=(x*10)%i;
                if(ar[x]==-1){
                    count++;
                    ar[x]=y;
                    x=y;
                }
                else {
                    if(max<count){
                        max=count;
                        maxNum=i;
                    }
                    break;
                }
            }
        }
        return maxNum;
    }
}
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Proc p=new Proc();
    System.out.println("Enter decimal limit: ");
		int n=sc.nextInt();
		int sol=p.largeCycle(n);
		System.out.println(sol);
	}
}
