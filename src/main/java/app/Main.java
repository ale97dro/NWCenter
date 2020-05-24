package app;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        //ProcessBuilder pb = new ProcessBuilder("clear");

        Scanner input = new Scanner(System.in);

        //Process process = Runtime.getRuntime().exec("clear");

        String command = "";

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while(!command.equals("exit"))
        {
            System.out.print("NWC > ");
            command = input.nextLine();
        }
        

        System.out.println("Closing NW Center...");
    }    
}
