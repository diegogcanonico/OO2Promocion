package roo2;

//import roo2.Cipher;

public class  CesarCipher extends Complement {

    int jump = 0;
    public  CesarCipher(String inputAlphabet,int number){
        super(inputAlphabet);
        jump = number;
    };

    public  CesarCipher(int number) {
        super("abcdefghijklmnopqrstuvwxyz");
        jump = number;
    };


    protected char cipherChar( char inputChar){
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        return this.offset(idx,inputChar,jump);

    };

    protected char decipherChar( char inputChar){
        int idx=java.util.Arrays.binarySearch(alphabet,inputChar);
        return this.deoffset(idx,inputChar,jump);
    }

    @Override
    protected void resetIndx() {
    }

    ;


}