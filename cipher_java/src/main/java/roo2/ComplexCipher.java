package roo2;

public abstract class ComplexCipher implements Cipher  {


    public Cipher cipherText;

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

    public void setCipher(Cipher cipher){
        this.cipherText = cipher;
    }
}
