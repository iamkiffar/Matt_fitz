import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * (Write/read data) Write a program to create a file name
 * Project6.txt if it does not exist. 
 * Write 100 integers created randomly into the file using
 * text I/O. Integers are separated by spaces in the file. 
 * Read the data back
 * from the file and display the data in increasing order.           
 *
 * @author Matt Fitzgerald
 * @version 10.26.2020
 */
public class Project6 {
    /** Main method that writes a program 
     * to create a text file named Project6.txt 
     * if it does not already exist
     */
    public static void main(String[] args) throws Exception 
    {
        File file = new File("Project6.txt");
        if (file.exists()) 
        {
            System.out.println("File already exists");
            System.exit(0);
        }

        try 
        (
        
        PrintWriter output = new PrintWriter(file);
        ) {
            for (int i = 0; i < 100; i++) 
            {
                output.print(((int)(Math.random() * 500) + 1));
                output.print(" ");
            }
        }

        int[] numbersArray = new int[100];

        try
        ( Scanner input = new Scanner(file);)
        {
            int i = 0;
            while (input.hasNext()) 
            {
                numbersArray[i++] = input.nextInt();
            }
        }

        selectionSort(numbersArray);

        for(int i = 0; i < numbersArray.length; i++)
        {
            System.out.println(numbersArray[i]);
        }
    }
    
    /**
     * Sorts the array in order from
     * smallest integer to largest integer
     */
    public static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j <arr.length; j++)
            {
                if (arr[j] < arr[index])
                { 
                    index = j;
                }
            }

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
}
