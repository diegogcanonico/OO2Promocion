package roo2;

public interface CipherFactory {

    public Cipher createCipher(int T);

    public Cipher createCipher();

    public Cipher createCipher(String inputAlphabet, String kword);

    public Cipher createCipher(int number, String inputAlphabet);


}
