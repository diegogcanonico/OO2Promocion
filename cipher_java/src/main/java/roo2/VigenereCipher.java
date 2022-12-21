package roo2;

//import roo2.Cipher;

public class  VigenereCipher extends ComplexCipher implements Cipher{
    CharRing keyword;
    char[] alphabet;

    public  VigenereCipher(String inputAlphabet, String kword){
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
        setKeyword(kword);
    };

    public VigenereCipher() {
        String inputAlphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
        keyword = new CharRing("a");
    };

    protected char cipherChar( char inputChar){
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        return this.offset(idx,inputChar,currentOffset());

    };


    protected char decipherChar(char inputChar){
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        return this.deoffset(idx,inputChar,currentOffset());
    }


    protected void resetIndx() {
        this.keyword.resetIdx();
    }


    public String cipher(String inputText){
        if ((this.cipherText!= null) && (this.cipherText.cipher(inputText) != " ")) {
            inputText = this.cipherText.cipher(inputText);
        }
        char[] result = new char[inputText.length()];
        inputText.getChars(0, inputText.length(), result, 0);
        for (int idx = 0; idx < result.length; idx++)
            result[idx] = cipherChar(result[idx]);
        this.resetIndx();
        return new String(result);

    };

    public String decipher(String inputText){
        char[] result = new char[inputText.length()] ;
        inputText.getChars(0, inputText.length(), result, 0);

        for (int idx=0; idx < result.length; idx++)
            result[idx]=decipherChar(result[idx]);
        return new String(result);
    };

    public char offset (int idx, char inputChar, int valor){
        char result;
        int offset;
        if(idx < 0){
            result= inputChar;
        }
        else{ offset = idx + valor;
            if(offset<alphabet.length){
                result= alphabet[offset];
            }
            else{
                result= alphabet[offset - alphabet.length];
            }
        }
        return result;
    }
    public char deoffset (int idx, char inputChar, int valor){
        int offset;
        char result;

        if(idx <0){
            result =inputChar;
        }
        else{
            offset = idx - valor;

            if(offset>=0){
                result= alphabet[offset];
            }
            else{
                result= alphabet[ alphabet.length + offset];
            }
        }
        return result;
    }

    ;
    public void setKeyword(String srcString){
        keyword = new CharRing(srcString);
    }
    private int currentOffset(){
        return keyword.next()- alphabet[0];
    }
}