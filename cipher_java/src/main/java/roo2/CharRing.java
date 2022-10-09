package roo2;

//import roo2.Cipher;

public class  CharRing {
    char[] source;
    int idx;
    
    public  CharRing(String srcString){
        source = new char[srcString.length()];
        srcString.getChars(0,srcString.length(), source, 0);
        idx = 0;
    };

    public char next( ){
        char result;
        if(idx >= source.length)
            idx=0;
        return source[idx++];     
        
    };

}