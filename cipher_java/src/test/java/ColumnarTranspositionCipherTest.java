import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import roo2.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnarTranspositionCipherTest {


    private CipherFactory factory;
    private Cipher columnarTranspositionCipher;

    private String valor;
    private String resultado;
    private String cadena;


    @BeforeEach
    void setupTest(){
        factory = new ConcreteTranspositionCipherFactory();
        this.cadena = "esto es objetos";

}

@Test
    public void correctValueTest(){
        setupTest();
        columnarTranspositionCipher = factory.createCipher("columnar,clave");
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
        this.columnarTranspositionCipher = factory.createCipher("columnar,hola");
        this.resultado = this.columnarTranspositionCipher.cipher(cadena);
        assertEquals(resultado,"oetsbeosojte*s**");

    }


@Test
    public void keywordShort(){
        setupTest();
        this.columnarTranspositionCipher = factory.createCipher("columnar,a");
        this.resultado = this.columnarTranspositionCipher.cipher(cadena);
        assertEquals(resultado,"estoesobjetos");
    }

@Test
public void keywordLong(){
    setupTest();
    this.columnarTranspositionCipher = factory.createCipher("columnar,palabra");
    Assert.assertThrows(NullPointerException.class,()->{this.columnarTranspositionCipher.cipher(cadena);});
}

@Test
    public void keywordNullValues(){
        setupTest();
        String parametro = "redictadoobjetos";
        String esperado = "redictadoobjetos";

        //valor blanco - numeros o simbolos
        this.columnarTranspositionCipher = factory.createCipher("columnar, ");
        String resultadoVacio2 = this.columnarTranspositionCipher.cipher(parametro);
        Assert.assertEquals(esperado, resultadoVacio2);

        Assert.assertThrows(IllegalArgumentException.class,()->{factory.createCipher("columnar,*&^%$");});

        Assert.assertThrows(IllegalArgumentException.class,()->{factory.createCipher("columnar,12345");});
    }


    @Test
    public void decipherTestOk(){
        //Arrange
        setupTest();
        String parametro = "irdedcatjoboseot";
        String esperado = "redictadoobjetos";
        //Act
        this.columnarTranspositionCipher = factory.createCipher("columnar,hola");
        String resultado = this.columnarTranspositionCipher.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);

    }

}
