package roo2;

import java.util.Arrays;

public class ColumnarTranspositionCipher implements Cipher{

    private char [][] entrada;
    private int [] keywordNumbers;
    private String keyword;

    private StringBuilder salida;

    private int cantidadFilas;

    private String alfabeto = "abcdefghijklmnopqrstuvwxyz";

    public ColumnarTranspositionCipher(String keyword) {
        this.keyword = keyword;
    }

    public String cipher(String messaje){
        String mensajeEntrada = messaje.replace(" ","");
        guardadoEntrada(mensajeEntrada);
        int [] keywordOrder = busquedaPosiciones();
        String finalKeywordOrder = ordenamientoPosiciones(keywordOrder);
        guardadoEntrada(mensajeEntrada);
        return cifrado(finalKeywordOrder);
    }

    private int [] busquedaPosiciones() {
        int indice = 0;
        keywordNumbers = new int[keyword.length()];
        for(int i = 0; i < this.alfabeto.length(); i++){
            for(int j = 0; j < this.keyword.length(); j++){
                if(alfabeto.charAt(i) == keyword.charAt(j)){
                    indice++;
                    keywordNumbers[j] = indice;
                }
            }
        }
        return keywordNumbers;
    }

    private String ordenamientoPosiciones(int [] keywordOrder){
        String cadenaResultado = "";
        String cadenaPosiciones = "";
        for(int i = 0; i < keywordOrder.length; i++){
            cadenaPosiciones += (String.valueOf(keywordOrder[i]));
        }
        for(int i = 1; i< keywordOrder.length+1; i++){
            cadenaResultado+=(cadenaPosiciones.indexOf(String.valueOf(i)));
        }
        return cadenaResultado;
    }

    private void guardadoEntrada(String mensajeEntrada){
        int z = 0;
        int relleno = this.keyword.length() - (mensajeEntrada.length() % this.keyword.length());
        int totalCaracteres = mensajeEntrada.length() + relleno;
        this.cantidadFilas = (totalCaracteres) / this.keyword.length();
        this.entrada = new char[this.cantidadFilas][this.keyword.length()];
        for(int i = 0; i < cantidadFilas; i ++){
            for(int j = 0; j < keyword.length(); j++){
                if(z < mensajeEntrada.length() ) {
                    this.entrada[i][j] = mensajeEntrada.charAt(z);
                    z++;
                }
            }
        }
        int posicion = keyword.length() - relleno;
        if(relleno > 0){
            for (int i = posicion; i < keyword.length(); i++){
                this.entrada[this.cantidadFilas-1][i] = '*';
            }
        }
    }


    private String cifrado(String finalKeywordOrder){
        String textoCifrado = "";
        for(int i = 0; i < this.cantidadFilas; i ++){
            int z = 0;
            for(int j = 0; j < keyword.length(); j++){
                textoCifrado += (String.valueOf(this.entrada[i][Integer.parseInt(String.valueOf(finalKeywordOrder.charAt(z)))]));
                z++;
            }
        }
        return textoCifrado;
    }


    public String decipher(String inputText) {
    return null;
    }




}
