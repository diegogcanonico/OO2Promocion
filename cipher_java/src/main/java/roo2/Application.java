package roo2;

import java.util.List;

public class Application {
    private Cipher cipher;

    public Application(CipherFactory factory, List<Object> parametros) {
        if(parametros.isEmpty())
            cipher = factory.createCipher();
        else if(parametros.size() == 1)
            cipher = factory.createCipher(Integer.parseInt(String.valueOf(parametros.get(0))));
        else if(parametros.size() == 2)
            cipher = factory.createCipher(String.valueOf(parametros.get(0)), String.valueOf(parametros.get(1)));
        else
            cipher = factory.createCipher(Integer.parseInt(String.valueOf(parametros.get(0))), String.valueOf(parametros.get(1)));
    }

    public String cipher(String word) {
        return cipher.cipher(word);
    }

    public String decipher(String word) {
        return cipher.decipher(word);
    }
}
