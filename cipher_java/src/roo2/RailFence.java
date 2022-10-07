package roo2;

public class  RailFenceCipher implements Cipher {
    String[] rails;
    BouncingIndex bIndex;

    public  CesarCipher(int railsCount){
        rails = new String[railCount];
        bIndex = new BouncingIndex(railCount);

    };

    public String cipher(String inputText){
        String result = "";
        for(int idx =0; idx < inputText.length(); idx++){
            int rIndex= bIndex.next();
            rails[rIndex]+=  inputText[idx]; 

        }
        for(int idx=0; idx < rails.length; idx++)
            result += rails[idx];    
        return result; 
    }; 

    public String decipher(String inputText){
        
        return inputText; 
    }; 


}