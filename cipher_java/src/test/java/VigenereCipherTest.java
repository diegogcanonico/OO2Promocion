import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import roo2.*;

public class VigenereCipherTest {

    private String valor;
    private String result;
    private String cadena;
    private ConcreteSubstitutionCipherFactory factory;
    private Cipher vigenere;
    private Cipher vigenere2;

@BeforeEach
    public void setupTest() {
        factory = new ConcreteSubstitutionCipherFactory();
        vigenere = factory.createCipher("vigenere, , ");
        vigenere2 = factory.createCipher("vigenere,abcdefghijklmnopqrstuvwxyz,abcdefghijklmnopqrstuvwxyz");
    }

@Test
    public void correctValueTest(){
        this.valor = "codigo";
        this.cadena = "codigo";
        this.result = vigenere.cipher(this.cadena);
        assertEquals(valor, result);
        result = vigenere2.cipher("codigo");
        this.valor = "cpflkt";
        assertEquals(valor, result);

        // Descipher

        this.result = this.vigenere2.decipher(valor);
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
        this.result = this.vigenere2.cipher(this.cadena);
        assertEquals(this.valor, this.result);
        this.valor = "aaaaaa";
        this.result = this.vigenere.cipher(this.cadena);
        assertEquals(this.valor, this.result);

        //Descipher

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

        //Descipher
        this.result = this.vigenere.decipher(this.valor);
        assertEquals(this.cadena, this.result);
}

@Test
    public void nullValue(){
        valor = null;
        Assert.assertThrows(NullPointerException.class,()->{this.vigenere.cipher(valor);});
        Assert.assertThrows(NullPointerException.class,()->{this.vigenere2.cipher(valor);});



    }

}
