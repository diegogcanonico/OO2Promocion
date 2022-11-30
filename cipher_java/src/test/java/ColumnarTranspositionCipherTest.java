import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import roo2.Cipher;
import roo2.CipherFactory;
import roo2.ColumnarTranspositionCipher;
import roo2.RailFenceCipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnarTranspositionCipherTest {


    private CipherFactory factory;
    private Cipher columnarTranspositionCipher;

    private Cipher columnarTransposition;

    private String valor;
    private String resultado;
    private String cadena;


@BeforeEach
    void setupTest(){
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
    public void correctValue2Test(){
        setupTest();
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("hola");
        this.resultado = this.columnarTranspositionCipher.cipher(cadena);
        assertEquals(resultado,"oetsbeosojte*s**");

    }


@Test
    public void keywordShort(){
        setupTest();
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("a");
        this.resultado = this.columnarTranspositionCipher.cipher(cadena);
        assertEquals(resultado,"estoesobjetos");
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
        String parametro = "redictadoobjetos";
        String esperado = "redictadoobjetos";
        //Valor vacio
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher("");
        String resultadoVacio1 = this.columnarTranspositionCipher.cipher(parametro);
        Assert.assertEquals(esperado, resultadoVacio1);

        //valor blanco - numeros o simbolos
        this.columnarTranspositionCipher = factory.getColumnarTranspositionCipher(" ");
        String resultadoVacio2 = this.columnarTranspositionCipher.cipher(parametro);
        Assert.assertEquals(esperado, resultadoVacio2);

        Assert.assertThrows(IllegalArgumentException.class,()->{factory.getColumnarTranspositionCipher("*&^%$");});

        Assert.assertThrows(IllegalArgumentException.class,()->{factory.getColumnarTranspositionCipher("12345");});
    }


    @Test
    public void decipherTestOk(){
        //Arrange
        setupTest();
        String parametro = "irdedcatjoboseot";
        String esperado = "redictadoobjetos";
        //Act
        this.columnarTransposition = factory.getColumnarTranspositionCipher("hola");
        String resultado = this.columnarTransposition.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);

    }

}
