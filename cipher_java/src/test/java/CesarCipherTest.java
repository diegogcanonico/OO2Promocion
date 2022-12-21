import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roo2.*;


public class CesarCipherTest {
    private ConcreteSubstitutionCipherFactory factory;
    private Cipher cesarCipher;


    @BeforeEach
    void setUp(){
        factory = new ConcreteSubstitutionCipherFactory();
        cesarCipher = factory.createCipher("cesar,abcdefghijklmnopqrstuvwxyz,3");
    }


    @Test
    public void cipherTestOk(){
        //Arrange
        String parametro = "zeta";
        String esperado = "Cesar Cipher:chwd";
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
        String parametro = null;
        //Act
        //Assert
        Assert.assertThrows(NullPointerException.class,
                ()->{cesarCipher.cipher(parametro);} );
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
    public void cipherTestWith2Parameters26Ok(){
        //Arrange
        Cipher cesarCipherWith2Parameters = factory.createCipher("cesar,abcdefghijklmnopqrstuvwxyz,26");
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
        Cipher cesarCipherWith2Parameters = factory.createCipher("cesar,,8");
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
        //Act
        //Assert
        Assert.assertThrows(StringIndexOutOfBoundsException.class,
                ()->{factory.createCipher("cesar,abcdefghijklmnopqrstuvwxyz,-10");} );
    }

}
