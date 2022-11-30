package roo2;

public abstract class DecoratorCipher extends CipherText  {


    public CipherText cipherText;

    @Override
    public String cipher(String inputText) {
        if(this.cipherText.cipher(inputText)!= " ")
            return this.cipher(this.cipherText.cipher(inputText));
        return this.cipher(inputText);
    }

    @Override
    public String decipher(String inputText) {
        return null;
    }

    public void setCipherText(CipherText cipherText){
        this.cipherText = cipherText;
    }
}
