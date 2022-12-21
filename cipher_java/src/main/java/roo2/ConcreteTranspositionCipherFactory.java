package roo2;

public class ConcreteTranspositionCipherFactory extends CipherFactory{

    private String[] parts;
    private String part1;
    private String part2;
    private String part3;


    @Override
    public Cipher createCipher(String texto) {
        parts = texto.trim().split("-");
        part1 = parts[0];
        part2 = parts[1];
        if(part1.equals("RailFence") || part1.equals("railfence") || part1.equals("rail fence") || part1.equals("Rail fence") || part1.equals("rail") || part1.equals("Rail")){
            this.getRailFenceCipher(Integer.valueOf(part2));
        } else {
            this.getColumnarTranspositionCipher(part2);
        }
        return null;
    }

    public Cipher getRailFenceCipher(int rails){
        return new RailFenceCipher(rails);
    }

    public Cipher getColumnarTranspositionCipher (String keyword){
        return new ColumnarTranspositionCipher(keyword);
    }

}
