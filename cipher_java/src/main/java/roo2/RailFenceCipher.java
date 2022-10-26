package roo2;

public class  RailFenceCipher implements Cipher {
    String[] rails;
    BouncingIndex bIndex;

    public  RailFenceCipher(int railCount){
        rails = new String[railCount];
        for (int idx =0; idx < rails.length; idx++)
            rails[idx]="";
        bIndex = new BouncingIndex(railCount);

    };

    public String cipher(String inputText){
        String result = "";
        char inputChar[] = new char[inputText.length()];
        inputText.getChars(0,inputText.length(), inputChar, 0);
        railsGenerator(inputText, inputChar);
        for(int idx=0; idx < rails.length; idx++){
            result += rails[idx];
        }
        return result; 
    }

    private void railsGenerator(String inputText, char[] inputChar) {
        for(int idx = 0; idx < inputText.length(); idx++){
            int rIndex= bIndex.next();
            rails[rIndex]+=  inputChar[idx];
        }
    }

    public String decipher(String inputText){
        StringBuilder decodedMessage = new StringBuilder(inputText);
        int currPosition = 0;
        for(int row = 0; row < bIndex.maxSize; row++) {
            int iter = 0;
            for(int i = row; i < inputText.length(); i += getTerm(iter++, row, bIndex.maxSize)) {
                decodedMessage.setCharAt(i, inputText.charAt(currPosition++));
            }
        }
        return decodedMessage.toString();
    };

    private int getTerm(int iteration, int row, int size) {
        if ((size == 0) || (size == 1)) {
            return 1;
        }
        if((row == 0) || (row == size-1)) {
            return (size-1)*2;
        }
        if (iteration % 2 == 0) {
            return (size-1-row)*2;
        }
        return 2*row;
    }

}