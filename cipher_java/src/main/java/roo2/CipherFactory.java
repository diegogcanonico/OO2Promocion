package roo2;

public class CipherFactory {

    public Cipher getCesarCipher(String alfabeto, int salto){
        int offset = salto;
        int longitudAlfabeto = alfabeto.length();
        if (offset >= longitudAlfabeto) {
            while (offset >= longitudAlfabeto) {
                offset = offset - longitudAlfabeto;
            }
        }
        String clave = String.valueOf(alfabeto.charAt(offset));
        for (int j = 0; j <= 25; j++) {
            clave += alfabeto.charAt(offset);
        }
        return new VigenereCipher(alfabeto, clave);
    }

    public Cipher getVigenereCipher(String alfabeto, String clave){
        return new VigenereCipher(alfabeto,clave);
    }

    public Cipher getRailFenceCipher(int rails){
        return new RailFenceCipher(rails);
    }
}
