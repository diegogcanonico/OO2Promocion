package roo2;

public class CipherFactory {

    public Cipher getCesarCipher(String alfabeto, int salto){
        String clave;
        int longitudAlfabeto = alfabeto.length();
        if(longitudAlfabeto > 0) {
            int offset = salto;
            if (offset >= longitudAlfabeto) {
                while (offset >= longitudAlfabeto) {
                    offset = offset - longitudAlfabeto;
                }
            }
            clave = String.valueOf(alfabeto.charAt(offset));
            for (int j = 0; j <= alfabeto.length()-2; j++) {
                clave += alfabeto.charAt(offset);
            }
        } else {
            alfabeto= "abcdefghijklmnopqrstuvwxyz";
            clave = "a";
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
