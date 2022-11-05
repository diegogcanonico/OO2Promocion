package roo2;

public class SubstitutionCipherFactory implements CipherFactory{

    @Override
    public Cipher createCipher(int number){
        return new CesarCipher(number);
    }
    @Override
    public Cipher createCipher(){
        return new VigenereCipher();
    }
    @Override
    public Cipher createCipher(String inputAlphabet, String kword){
        return new VigenereCipher(inputAlphabet, kword);
    }
    @Override
    public Cipher createCipher(int number, String inputAlphabet){
        return new CesarCipher(number, inputAlphabet);
    }

}
