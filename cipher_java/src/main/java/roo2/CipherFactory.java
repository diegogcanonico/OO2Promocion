package roo2;

public class CipherFactory {


    public Cipher getCesarCipher(String alfabeto, int salto){
        return new CesarCipher(alfabeto,salto);
    }

    public Cipher getVigenereCipher(String alfabeto, String clave){
        return new VigenereCipher(alfabeto,clave);
    }

    public Cipher getRailFenceCipher(int rails){
        return new RailFenceCipher(rails);
    }
}
