import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void cipherTestWithRailCountGreaterThanWorldLengthOk(){
        //Arrange
        RailFenceCipher rail = new RailFenceCipher(100);
        String parametro = "Hola";
        String esperado = "Hola";
        //Act
        String resultado = rail.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void cipherTestWorldLength3TimesHigherThanRailAnd2RailCountOk(){
        //Arrange
        RailFenceCipher rail = new RailFenceCipher(2);
        String parametro = "Camino";
        String esperado = "Cmnaio";
        //Act
        String resultado = rail.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }


    @Test
    public void cipherTestWorldLengthHigherThanRailAnd2RailCountWithBlankSpaceOk(){
        //Arrange
        RailFenceCipher rail = new RailFenceCipher(2);
        String parametro = "El Camino";
        String esperado = "E aiolCmn";
        //Act
        String resultado = rail.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
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
        String esperado = "Hloa";
        //Act
        String resultado = railFenceCipher.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void decipherTestWithRailCountGreaterThanWorldLengthOk(){
        //Arrange
        RailFenceCipher rail = new RailFenceCipher(100);
        String parametro = "Hola";
        String esperado = "Hola";
        //Act
        String resultado = rail.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void decipherTestWorldLength3TimesHigherThanRailAnd2RailCountOk(){
        //Arrange
        RailFenceCipher rail = new RailFenceCipher(2);
        String esperado = "Camino";
        String parametro = "Cmnaio";
        //Act
        String resultado = rail.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }


    @Test
    public void decipherTestWorldLengthHigherThanRailAnd2RailCountWithBlankSpaceOk(){
        //Arrange
        RailFenceCipher rail = new RailFenceCipher(2);
        String esperado = "El Camino";
        String parametro = "E aiolCmn";
        //Act
        String resultado = rail.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void decipherTestWith1RailCountOk(){
        //Arrange
        RailFenceCipher railFenceCipher2 = new RailFenceCipher(1);
        String parametro = "Hola";
        String esperado = "Hola";
        //Act
        String resultado = railFenceCipher2.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void decipherTestWithNegativeRailCountOk(){
        //Arrange
        //Act
        //Assert
        Assert.assertThrows(NegativeArraySizeException.class,
                ()->{new RailFenceCipher(-10);} );
    }



}
