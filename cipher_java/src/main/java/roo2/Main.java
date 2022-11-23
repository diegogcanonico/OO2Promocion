package roo2;

public class Main {
    public static void main(String[] args) {

        CipherFactory factory = new CipherFactory();
        String palabra = "texto para cifrar";
        System.out.println("Prueba con Vigenere");
        Cipher vigenere = factory.getVigenereCipher("abcdefghijklmnopqrstuvwxyz", "clave");
        palabra = "texto para cifrar";
        palabra = vigenere.cipher(palabra);
        System.out.println("La palabra cifrada es: " + palabra);
        System.out.println("La palabra descifrada es: " + vigenere.decipher(palabra));

        System.out.println("----------------------------------------");

        System.out.println("Prueba con RailFance");
        Cipher railfance = factory.getRailFenceCipher(3);
        palabra = "texto para cifrar";
        palabra = railfance.cipher(palabra);
        System.out.println("La palabra cifrada es: " + palabra);
        System.out.println("La palabra descifrada es: " + railfance.decipher(palabra));

        System.out.println("----------------------------------------");
        System.out.println("Prueba de Cesar mediante Vigenere");
        Cipher cesarConVigenere = factory.getCesarCipher("abcd", 2);
        palabra = cesarConVigenere.cipher("cada");
        System.out.println("La palabra cifrada es: " + palabra);
        System.out.println("La palabra descifrada es: " + cesarConVigenere.decipher(palabra));


        System.out.println("----------------------------------------");
        System.out.println("Prueba de Columnar Transposition Cipher");
        System.out.println("La palabra clave es casino y la frase a cifrar es 'esto es objetos'");
        ColumnarTranspositionCipher cipher = new ColumnarTranspositionCipher("clave");
        String resultado = cipher.cipher("esto es objetos");
        System.out.println("La frase cifrada es "+resultado);





    }
}

