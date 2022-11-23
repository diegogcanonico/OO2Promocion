import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import roo2.Cipher;
import roo2.CipherFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnarTranspositionCipherTest {


    private CipherFactory factory;
    private Cipher columnarTranspositionCipher;
    private String valor;
    private String resultado;
    private String cadena;

@BeforeEach
    public void setupTest(){
        this.factory = new CipherFactory();
        this.cadena = "esto es objetos";

}

@Test
    public void correctValueTest(){
        setupTest();
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("clave");
        this.resultado = this.columnarTranspositionCipher.cipher(cadena);
        assertEquals(resultado,"teesobseojst*o*");

        //caracteres especiales
        this.cadena ="^&%$";
        this.resultado = this.columnarTranspositionCipher.cipher(cadena);
        assertEquals(resultado,"%^*&$");
}
@Test
    public void keywordShort(){
        setupTest();
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("a");
        this.resultado = this.columnarTranspositionCipher.cipher(cadena);
        assertEquals(resultado,"estoesobjetos*");
    }

@Test
public void keywordLong(){
    setupTest();
    this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("palabra");
    Assert.assertThrows(NullPointerException.class,()->{this.columnarTranspositionCipher.cipher(cadena);});
}

@Test
    public void keywordNullValues(){
        setupTest();
        //Valor vacio
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("");
        Assert.assertThrows(ArithmeticException.class,()->{this.columnarTranspositionCipher.cipher(cadena);});
        //valor blanco - numeros o simbolos
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher(" ");
        Assert.assertThrows(NumberFormatException.class,()->{this.columnarTranspositionCipher.cipher(cadena);});

        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("*&^%$");
        Assert.assertThrows(NumberFormatException.class,()->{this.columnarTranspositionCipher.cipher(cadena);});

        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("12345");
        Assert.assertThrows(NumberFormatException.class,()->{this.columnarTranspositionCipher.cipher(cadena);});
    }

}
