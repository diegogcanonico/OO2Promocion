import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import roo2.*;

public class VigenereCipherTest {

    private VigenereCipher vigenere;
    private VigenereCipher vigenere2;
    private String inputAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private String valor;
    private String result;
    private String cadena;

@BeforeEach
    public void setupTest() {
        this.vigenere = new VigenereCipher();
        this.vigenere.setKeyword(this.inputAlphabet);
        this.vigenere2 = new VigenereCipher(inputAlphabet,inputAlphabet);
    }

@Test
    public void correctValueTest(){
        this.valor = "cpflkt";
        this.cadena = "codigo";
        this.result = this.vigenere.cipher(this.cadena);
        assertEquals(valor, result);
        result = this.vigenere2.cipher("codigo");
        assertEquals(valor, result);

        /* Descipher
        se renicia el setup por el puntero del CharRing, sino no da el resultado
         */
        setupTest();
        this.result = this.vigenere.decipher(valor);
        assertEquals(this.cadena, this.result);
    }

@Test
    public void emptyString(){
        valor = "";
        result = this.vigenere.cipher("");
        assertEquals(valor, result);
        result = this.vigenere2.cipher("");
        assertEquals(valor, result);

        //Descipher
        this.result = this.vigenere.decipher(valor);
        assertEquals("", this.result);
}

@Test
    public void numbers(){
        valor = "123456";
        result = this.vigenere.cipher("123456");
        assertEquals(valor, result);
        result = this.vigenere2.cipher("123456");
        assertEquals(valor, result);

        //Descipher
        this.result = this.vigenere.decipher(valor);
        assertEquals("123456", this.result);
}

@Test
    public void specialCharacters(){
        valor = "!@#$%^";
        result = this.vigenere.cipher("!@#$%^");
        assertEquals(valor, result);
        result = this.vigenere2.cipher("!@#$%^");
        assertEquals(valor, result);

        //Descipher
        this.result = this.vigenere.decipher(valor);
        assertEquals("!@#$%^", this.result);
}

@Test
    public void sameLetters(){
        this.valor = "abcdef";
        this.cadena = "aaaaaa";
        this.result = this.vigenere.cipher(this.cadena);
        assertEquals(this.valor, this.result);
        this.result = this.vigenere2.cipher(this.cadena);
        assertEquals(this.valor, this.result);

        /* Descipher
        se renicia el setup por el puntero del CharRing, sino no da el resultado
         */
        setupTest();
        this.result = this.vigenere.decipher(this.valor);
        assertEquals(this.cadena, this.result);
}

@Test
    public void aSingleLetter(){
        this.valor = "a";
        this.cadena = "a";
        this.result = this.vigenere.cipher(this.cadena);
        assertEquals(this.valor, this.result);
        this.result = this.vigenere2.cipher(this.cadena);
        assertEquals(this.valor, this.result);

        setupTest();
        this.result = this.vigenere.decipher(this.valor);
        assertEquals(this.cadena, this.result);
}

@Test
    public void nullValue(){
        valor = null;
        Assert.assertThrows(NullPointerException.class,()->{this.vigenere.cipher(valor);});
        Assert.assertThrows(NullPointerException.class,()->{this.vigenere2.cipher(valor);});
        /*
        resultado NullPointerException - se rompe en el metodo cipher cuando hace
        char[] result = new char[inputText.length()]
        El tema es que este valor nunca va a ser ingresado por el usuario, se testea ?
        por teclado todo lo que se ingresa es un string
         */


    }

}
