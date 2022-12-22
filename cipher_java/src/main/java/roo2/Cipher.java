package roo2;

// interface
public interface Cipher {
    public void setLastCipherTrue();
    public boolean getLastCipher();
    public String cipher(String inputText);
    public String decipher(String inputText); 
  }