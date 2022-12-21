package roo2;

public class Main {
    public static void main(String[] args) {

        CipherFactory factory = new ConcreteSubstitutionCipherFactory();
        Cipher vigenere = factory.createCipher("vigenere-abcdefghijklmnopqrstuvwxyz-clave");
        String palabra = "texto para cifrar";
        System.out.println("Prueba con Vigenere");
        palabra = "texto para cifrar";
        palabra = vigenere.cipher(palabra);
        System.out.println("La palabra cifrada es: " + palabra);
        System.out.println("La palabra descifrada es: " + vigenere.decipher(palabra));

        System.out.println("----------------------------------------");

        System.out.println("Prueba con RailFance");
        Cipher railfance = factory.createCipher("rail-2");
        palabra = "texto para cifrar";
        palabra = railfance.cipher(palabra);
        System.out.println("La palabra cifrada es: " + palabra);
        System.out.println("La palabra descifrada es: " + railfance.decipher(palabra));

        System.out.println("----------------------------------------");
        System.out.println("Prueba de Cesar mediante Vigenere");
        Cipher cesarConVigenere = factory.createCipher("cesar-abcdefghijklmnopqrstuvwxyz-3");
        palabra = cesarConVigenere.cipher("cada");
        System.out.println("La palabra cifrada es: " + palabra);
        System.out.println("La palabra descifrada es: " + cesarConVigenere.decipher(palabra));


        CipherFactory factory2 = new ConcreteTranspositionCipherFactory();
        System.out.println("----------------------------------------");
        System.out.println("Prueba de Columnar Transposition Cipher");
        System.out.println("La palabra clave es sol y la frase a cifrar es hola juan");
        Cipher railFence = factory2.createCipher("rail-3");
        String resultado = railFence.cipher("hola juan");
        System.out.println("La frase cifrada es " + resultado);

        System.out.println("----------------------------------------");
        System.out.println("Prueba de Columnar Transposition Cipher");
        System.out.println("La palabra clave es sol y la frase a cifrar es hola juan");
        Cipher columnar = factory2.createCipher("columnar-sol");
        resultado = columnar.cipher("hola juan");
        System.out.println("La frase cifrada es "+resultado);

        System.out.println("----------------------------------------");
        System.out.println("Prueba de Columnar Transposition Cipher");
        System.out.println("La palabra clave es sol y la frase a cifrar es hola juan");
        columnar = factory2.createCipher("columnar-sol");
        resultado = columnar.decipher("lohuja*na");
        System.out.println("La frase cifrada es "+resultado);





    }
}

