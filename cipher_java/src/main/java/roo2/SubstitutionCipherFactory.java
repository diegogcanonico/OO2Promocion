package roo2;

public class SubstitutionCipherFactory implements CipherFactory{

    @Override
    public Cipher createCipher(int number){
        return new CesarCipher(number);
    }
    

}
