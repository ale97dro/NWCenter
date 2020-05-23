package app;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        ProcessBuilder pb = new ProcessBuilder("clear");

        Scanner input = new Scanner(System.in);

        try
        {
            //Process process = Runtime.getRuntime().exec("clear");
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print("NWC > ");
            input.nextLine();
        }
        catch(Exception ex)
        {
            System.out.println("error");
        }

        System.out.println("Hello world");
    }    
}
