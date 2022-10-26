package roo2;

public class Main {
    public static void main(String[] args) {
        RailFenceCipher rail = new RailFenceCipher(3);

        System.out.println(rail.cipher("El Camino"));

        System.out.println(rail.decipher("EaolCmn i"));

    }
}

