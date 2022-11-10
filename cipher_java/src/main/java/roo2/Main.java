package roo2;

public class Main {
    public static void main(String[] args) {
        CipherFactory factory = new CipherFactory();
        Cipher cesar = factory.getCesarCipher("abcdefghijklmnopqrstuvwxyz",5);
        String palabra = "texto para cifrar";
        System.out.println("El texto a cifrar para los 3 cifradores es: " + palabra);
        System.out.println("Prueba con Cesar");
        palabra = cesar.cipher(palabra);
        System.out.println("La palabra cifrada es: " + palabra);
        System.out.println("La palabra descifrada es: " + cesar.decipher(palabra));

        System.out.println("----------------------------------------");

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
    }
}

