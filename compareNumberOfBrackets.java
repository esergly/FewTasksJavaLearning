// Проверить баланс круглых скобок в выражении. Пример:"((x-8)+a(y-1))".

import java.util.Arrays;

import static java.awt.SystemColor.text;

public class compareNumberOfBrackets {
    public static void main(String[] args) {
/*
        // First solution
       String var = "(x-8)+a(y-1))";
       char a = '(';
       char b = ')';

       if(count(a, var)>count(b,var)){
           System.out.println("Opening brackets \"(\" more than closing brackets \")\".");
       }
       if(count(a, var)<count(b,var)){
           System.out.println("Opening brackets \"(\" less than closing brackets \")\".");
       }else{
           System.out.println("Quantity value of both types of brackets is correct.");
       }
   }

   private static int count(char a, String var) {
       int pos = 0;
       int count = 0;
       do {
           pos = var.indexOf(a, pos);
           if (pos >= 0) {
               count++;
               pos++;
           }
       } while (pos >= 0);
       return count;
*/
//----------------------------------------------------------------------------------------------------//

        // Second solution
        String var = "((x-8)+a(y-1))";
        String a = "(";
        String b = ")";
        int countA = 0, countB = 0;
        String[] charts = var.split("");

        for (String chart : charts) {
            if (chart.equals(a)) {
                countA++;
            }
            if (chart.equals(b)) {
                countB++;
            }
        }
        if (countA > countB) {
            System.out.println("Opening brackets \"(\" more than closing brackets \")\".");
        }
        if (countA < countB) {
            System.out.println("Opening brackets \"(\" less than closing brackets \")\".");
        }
        if (countA == countB){
            System.out.println("Quantity value of both types of brackets is correct.");
        }
    }
}

