package at.htl.mydate;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int counter = 1;
        String aktuellesDatum = "0";

        String eingabe;

        System.out.print("1. Datum: ");
        eingabe = scanner.nextLine();

        while (!eingabe.equals("quit"))
        {
            counter++;
            MyDate myDate = new MyDate(eingabe);

            System.out.print(counter + " jüngstes Datum: ");
            eingabe = scanner.nextLine();

            if(myDate.isYoungerThan())
            {
                aktuellesDatum = myDate.formatDate();
            }
            else
            {
                System.out.println(aktuellesDatum);
            }
        }
    }
}
