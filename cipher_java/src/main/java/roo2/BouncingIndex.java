package roo2;

//import roo2.Cipher;

public class  BouncingIndex implements IndexGenerator{
    int maxSize;
    int idx;

    Boolean check = false;
    
    public  BouncingIndex(int size){
        maxSize= size;
        idx = 0;
    };

    public Integer next( ){
        int result;
        if(maxSize != 1) {
            if (idx == 0 || idx == maxSize - 1)
                check = !check;
            result = idx;
            if (check)
                idx++;
            else
                idx--;
            return result;
        } else return 0;
    };

}