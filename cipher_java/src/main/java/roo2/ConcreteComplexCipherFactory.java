package roo2;

public class ConcreteComplexCipherFactory extends CipherFactory{

    private String[] parts;
    private String part;
    private String part1;
    private String part2;
    private String part3;
    private String cipherName;
    private String[] substringPart;
    private Cipher cipher;

    private ComplexCipher lastCipher;
    private ComplexCipher complexCipher;
    private ConcreteSubstitutionCipherFactory substitutionFactory;
    private ConcreteTranspositionCipherFactory transpositionFactory;


    @Override
    public Cipher createCipher(String texto) {
        parts = texto.split("-");
        for(int i = 0; i < parts.length; i++){
            part = parts[i];
            substringPart = part.split(",");
            cipherName = substringPart[0].toLowerCase();
            switch (cipherName){
                case "cesar": case "vigenere":
                    cipher = substitutionFactory.createCipher(part);
                case "rail": case "columnar":
                    cipher = transpositionFactory.createCipher(part);
            }
            if(i > 0){
                complexCipher = (ComplexCipher)cipher;
                complexCipher.setCipher(lastCipher);
                lastCipher = complexCipher;
            } else {
                lastCipher = (ComplexCipher)cipher;
            }
        }
    return complexCipher;
    }





}

