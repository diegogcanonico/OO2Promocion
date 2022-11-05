package roo2;

public class TranspositionCipherFactory implements CipherFactory{

    public Cipher createCipher(int railCount){
        return new RailFenceCipher(railCount);
    }

    @Override
    public Cipher createCipher() {
        return null;
    }

    @Override
    public Cipher createCipher(String inputAlphabet, String kword) {
        return null;
    }

    @Override
    public Cipher createCipher(int number, String inputAlphabet) {
        return null;
    }
}
