import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roo2.CesarCipher;
import roo2.RailFenceCipher;

public class RailFenceCipherTest {
    private RailFenceCipher railFenceCipher;

    @BeforeEach
    void setUp(){
        railFenceCipher = new RailFenceCipher(2);
    }


    @Test
    public void cipherTestOk(){
        //Arrange
        String parametro = "Hola";
        String esperado = "Cesar Cipher:Hloa";
        //Act
        String resultado = railFenceCipher.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestNotOk(){
        //Arrange
        String parametro = "Hola";
        String esperado = "Cesar Cipher:Hloaa";
        //Act
        String resultado = railFenceCipher.cipher(parametro);
        //Assert
        Assert.assertNotEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestWith1RailCountOk(){
        //Arrange
        RailFenceCipher railFenceCipher2 = new RailFenceCipher(1);
        String parametro = "Hola";
        String esperado = "Cesar Cipher:Hola";
        //Act
        String resultado = railFenceCipher2.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestWithNegativeRailCountOk(){
        //Arrange
        //Act
        //Assert
        Assert.assertThrows(NegativeArraySizeException.class,
                ()->{new RailFenceCipher(-10);} );
    }

    @Test
    public void decipherTestOk(){
        //Arrange
        String parametro = "Hola";
        String esperado = "Hola";
        //Act
        String resultado = railFenceCipher.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }



}
