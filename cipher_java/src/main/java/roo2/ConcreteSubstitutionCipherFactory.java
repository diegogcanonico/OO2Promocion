package roo2;

public class ConcreteSubstitutionCipherFactory extends CipherFactory{

    private String[] parts;
    private String part1;
    private String part2;
    private String part3;


    @Override
    public Cipher createCipher(String texto) {
        parts = texto.trim().split("-");
        part1 = parts[0];
        part2 = parts[1];
        part3 = parts[2];
        if(part1.equals("Cesar") || part1.equals("cesar")){
            this.getCesarCipher(part2, Integer.valueOf(part3));
        } else {
            this.getVigenereCipher(part2, part3);
        }
        return null;
    }

    private Cipher getCesarCipher(String alfabeto, int salto){
        String clave;
        int longitudAlfabeto = alfabeto.length();
        if(longitudAlfabeto > 0) {
            int offset = salto;
            if (offset >= longitudAlfabeto) {
                while (offset >= longitudAlfabeto) {
                    offset = offset - longitudAlfabeto;
                }
            }
            clave = String.valueOf(alfabeto.charAt(offset));
            for (int j = 0; j <= alfabeto.length()-2; j++) {
                clave += alfabeto.charAt(offset);
            }
        } else {
            alfabeto= "abcdefghijklmnopqrstuvwxyz";
            clave = "a";
        }
        return new VigenereCipher(alfabeto, clave);
    }

    private Cipher getVigenereCipher(String alfabeto, String clave){
        return new VigenereCipher(alfabeto,clave);
    }

}
