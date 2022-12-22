import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roo2.*;

public class DecoratorTest {


    private ComplexCipher vigenere;
    private ComplexCipher columnar;
    private ComplexCipher railFance;

    private VigenereCipher vigenere2;
    private RailFenceCipher railFance2;
    private ColumnarTranspositionCipher columnar2;


    @BeforeEach
    public void setupTest() {
        vigenere = new VigenereCipher("abcdefghijklmnopqrstuvwxyz", "clave");
        vigenere2 = new VigenereCipher("abcdefghijklmnopqrstuvwxyz", "clave");
        railFance = new RailFenceCipher(4);
        railFance2 = new RailFenceCipher(4);
        columnar = new ColumnarTranspositionCipher("cifra");
        columnar2 = new ColumnarTranspositionCipher("cifra");
    }

    @Test
    public void cipherTest() {
        setupTest();
        vigenere.setLastCipherTrue();
        railFance.setCipher(vigenere);
        columnar.setCipher(railFance);
        System.out.println("columnar " + columnar.cipher("alojomora"));

        System.out.println("--------------------------------------------");

    }
}
