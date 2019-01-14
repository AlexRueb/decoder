/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Alex Rueb
 */
public class Decoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String f = "src/input.txt";
        // TODO code application logic here
        String message = new String();
        try (BufferedReader b = new BufferedReader(new FileReader(f))) {
            String line = new String();
            String mainCode = new String();
            line = b.readLine();
            while (line != null) {
                mainCode = mainCode + line;
                line = b.readLine();

            }
            message = mainCode;
            System.out.println(mainCode.length());

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        decode(message);
    }

    public static void printMessage(String message) {
        int i = 0;
        while (i < message.length()) {
            System.out.println("");
            for (int wordCt = 0; wordCt < 10;) {
                char cur = message.charAt(i);
                String curString = Character.toString(cur);
                if (curString.equals(" ")) {
                    System.out.print(curString);
                    wordCt++;
                } else {
                    System.out.print(curString);
                }
                i++;
                if (i == message.length()) {
                    break;
                }
            }
        }
    }

    public static void decode(String message) {
        //print main message
        printMessage(message);

        //creates a copy of the message, which will be modified
        String modifiedMessage = String.copyValueOf(message.toCharArray(), 0, message.length());
        System.out.println("");
        System.out.println("");
        System.out.println("");
        printMessage(modifiedMessage);

        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Type ! to quit");
            System.out.println("What character to switch:  ");
            String pre = sc.next();
            if (pre.equals("!")) {
                done = true;
            } else {
                System.out.println("switch to what character:  (or ! to cancel)");
                String post = sc.next();
                if (!post.equals("!")) {
                    //the character that preChar is switched to
                    char postChar = post.charAt(0);

                    modifiedMessage = modifiedMessage.replace(pre, Character.toString(postChar).toUpperCase());
                    printMessage(message);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    printMessage(modifiedMessage);
                }
            }
        }
    }
}
