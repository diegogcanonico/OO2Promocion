package roo2;

public abstract class ComplexCipher implements Cipher  {
    public boolean lastCipher = false;
    public Cipher cipherText;

    @Override
    public String cipher(String inputText) {
        if(!this.cipherText.getLastCipher())
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

    public void setLastCipherTrue(){
        this.lastCipher = true;
    }

    public boolean getLastCipher(){
        return this.lastCipher;
    }
}
