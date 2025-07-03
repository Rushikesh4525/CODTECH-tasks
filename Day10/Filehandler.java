package day_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filehandler {
    public static void main(String[] args) {
        String filename = "examples.txt";

        // Write to a file
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Hello, I am Rushikesh Panmand\nI am pursuing internship in Codec Technologies.");
            System.out.println(" File written successfully.\n");
        } catch (IOException e) {
            System.out.println(" Error in writing the file.");
        }

        // Read the file
        System.out.println("📖 Reading file content:");
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(" Error reading the file.");
        }

        //Modifying the file
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            StringBuilder modifiedContent=new StringBuilder();

            while (sc.hasNextLine()) {
                String line= sc.nextLine();
                modifiedContent.append(line.replace("Hello", "hello")).append("\n");

            }sc.close();
            //write modified content back to file
            FileWriter writer = new FileWriter(file);
            writer.write(modifiedContent.toString());
            writer.close();
            System.out.println("File modified successfully");
            }catch (IOException e){
            System.out.println("Error in modifying the file ");


        }
    }
}
