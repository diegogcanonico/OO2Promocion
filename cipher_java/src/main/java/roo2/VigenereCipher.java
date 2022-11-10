package roo2;

//import roo2.Cipher;

public class  VigenereCipher extends Complement {
    CharRing keyword;

    public  VigenereCipher(String inputAlphabet, String kword){
        super(inputAlphabet);
        setKeyword(kword);
    };

    public VigenereCipher() {
        super("abcdefghijklmnopqrstuvwxyz");
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

    @Override
    protected void resetIndx() {
        this.keyword.resetIdx();
    }

    ;
    public void setKeyword(String srcString){
        keyword = new CharRing(srcString);
    }
    private int currentOffset(){
        return keyword.next()- alphabet[0];
    }
}