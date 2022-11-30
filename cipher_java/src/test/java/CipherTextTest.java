import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import roo2.*;

public class CipherTextTest {

    private CipherText cipherText;
    private DecoratorCipher vigenere;
    private DecoratorCipher columnar;
    private DecoratorCipher railFance;

    private VigenereCipher vigenere2;
    private RailFenceCipher railFance2;
    private ColumnarTranspositionCipher columnar2;



@BeforeEach
    public void setupTest() {
        cipherText = new ConcreteCipherText();
        vigenere = new VigenereCipher("abcdefghijklmnopqrstuvwxyz", "clave");
        vigenere2 = new VigenereCipher("abcdefghijklmnopqrstuvwxyz", "clave");
        railFance = new RailFenceCipher(4);
        railFance2 = new RailFenceCipher(4);
        columnar = new ColumnarTranspositionCipher("cifra");
        columnar2 = new ColumnarTranspositionCipher("cifra");
    }

@Test
    public void cipherTest(){
        setupTest();
        vigenere.setCipherText(cipherText);
        railFance.setCipherText(vigenere);
        columnar.setCipherText(railFance);
        System.out.println("columnar " + columnar.cipher("alojomora"));

        System.out.println("--------------------------------------------");

        String resul = vigenere2.cipher("alojomora");
        resul = railFance2.cipher(resul);
        resul = columnar2.cipher(resul);
        System.out.println(resul);
        System.out.println("columnar " + columnar2.cipher(railFance2.cipher(vigenere2.cipher("alojomora"))));




}
}
