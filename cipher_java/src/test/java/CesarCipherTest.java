import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roo2.CesarCipher;


public class CesarCipherTest {
    private CesarCipher cesarCipher;
    private CesarCipher cesarCipherWith2Parameters;



    @BeforeEach
    void setUp(){
        cesarCipher = new CesarCipher(3);
        cesarCipherWith2Parameters = new CesarCipher(3, "abcdefghijklmnopqrstuvwxyz");
    }


    @Test
    public void cipherTestOk(){
        //Arrange
        String parametro = "Hola";
        String esperado = "Cesar Cipher:Hrod";
        //Act
        String resultado = cesarCipher.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestOkWithNumericParameter(){
        //Arrange
        String parametro = "123";
        String esperado = "Cesar Cipher:123";
        //Act
        String resultado = cesarCipher.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestOkWithSymbolParameter(){
        //Arrange
        String parametro = "$%&";
        String esperado = "Cesar Cipher:$%&";
        //Act
        String resultado = cesarCipher.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestNotOkWithEmptyArray(){
        //Arrange
        String[] parametro = new String[1];
        //Act
        //Assert
        Assert.assertThrows(NullPointerException.class,
                ()->{cesarCipher.cipher(parametro[0]);} );
    }

    @Test
    public void decipherTestOk(){
        //Arrange
        String parametro = "Hrod";
        String esperado = "Cesar Cipher:Hola";
        //Act
        String resultado = cesarCipher.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void decipherTestOkWithNumericParameter(){
        //Arrange
        String parametro = "123";
        String esperado = "Cesar Cipher:123";
        //Act
        String resultado = cesarCipher.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void decipherTestOkWithSymbolParameter(){
        //Arrange
        String parametro = "$%&";
        String esperado = "Cesar Cipher:$%&";
        //Act
        String resultado = cesarCipher.decipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void decipherTestNotOkWithNullParameter(){
        //Arrange
        String parametro = null;
        //Act
        //Assert
        Assert.assertThrows(NullPointerException.class,
                ()->{cesarCipher.decipher(parametro);} );
    }

    @Test
    public void decipherTestNotOkWithEmptyArray(){
        //Arrange
        String[] parametro = new String[1];
        //Act
        //Assert
        Assert.assertThrows(NullPointerException.class,
                ()->{cesarCipher.decipher(parametro[0]);} );
    }

    @Test
    public void cipherTestWith2Parameters26Ok(){
        //Arrange
        CesarCipher cesarCipherWith2Parameters = new CesarCipher(26,"abcdefghijklmnopqrstuvwxyz");
        String parametro = "Hola";
        String esperado = "Cesar Cipher:Hola";
        //Act
        String resultado = cesarCipherWith2Parameters.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestWith2ParametersEmptyAlphabetOk(){
        //Arrange
        CesarCipher cesarCipherWith2Parameters = new CesarCipher(8,"");
        String parametro = "Hola";
        String esperado = "Cesar Cipher:Hola";
        //Act
        String resultado = cesarCipherWith2Parameters.cipher(parametro);
        //Assert
        Assert.assertEquals(esperado, "Cesar Cipher:"+resultado);
    }

    @Test
    public void cipherTestWith2ParametersNotOk(){
        //Arrange
        CesarCipher cesarCipherWith2Parameters = new CesarCipher(-10,"abcdefghijklmnopqrstuvwxyz");
        String parametro = "Hola";
        //Act
        //Assert
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,
                ()->{cesarCipherWith2Parameters.cipher(parametro);} );
    }

}
