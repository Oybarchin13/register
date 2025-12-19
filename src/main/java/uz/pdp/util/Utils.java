package uz.pdp.util;

import java.util.Scanner;

public class Utils {


    public static Scanner scannerNum  = new Scanner(System.in);
    public static Scanner scannerStr = new Scanner(System.in);
    public static String currentUserId;

    public static int getNum(String text){
        System.out.print(text  + ": ");
        return scannerNum.nextInt();
    }
    public static String  getStr(String text){
        System.out.print(text  + ": ");
        return scannerStr.nextLine();
    }


}
