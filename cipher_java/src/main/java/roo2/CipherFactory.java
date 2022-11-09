package roo2;

public interface CipherFactory {

    public Cipher createCipher(int T);


    public default Cipher createCipher(){
        return new VigenereCipher();
    }

    public default Cipher createCipher(String inputAlphabet, String kword){
        return new VigenereCipher(inputAlphabet, kword);
    }

    public default Cipher createCipher(int number, String inputAlphabet){
        return new CesarCipher(number, inputAlphabet);
    }


}
