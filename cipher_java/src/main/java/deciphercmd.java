import roo2.VigenereCipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class deciphercmd {
    public static void main(String[] args)
        throws IOException
    {
        //final CesarCipher cesar = new CesarCipher(3);
        final VigenereCipher vigenere = new VigenereCipher();

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
 
        // Printing the read line
       // System.out.println("Cesar Cipher:"+cesar.decipher(name));
        vigenere.setKeyword("abcdefghijklmnopqrstuvwxyz");
        System.out.println("Vigener Cipher:"+vigenere.decipher(name));
    }
}



