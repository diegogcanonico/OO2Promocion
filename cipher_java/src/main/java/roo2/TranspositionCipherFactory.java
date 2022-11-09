package roo2;

public class TranspositionCipherFactory implements CipherFactory{

    public Cipher createCipher(int railCount){
        return new RailFenceCipher(railCount);
    }

}
