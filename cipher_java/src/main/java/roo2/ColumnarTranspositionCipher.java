package roo2;

public class ColumnarTranspositionCipher extends ComplexCipher{

    private char [][] entrada;
    private int [] keywordNumbers;
    private String keyword;

    private int cantidadFilas;

    private String alfabeto = "abcdefghijklmnopqrstuvwxyz";

    public ColumnarTranspositionCipher(String keyword) {
        if (this.isAlpha(keyword) || keyword.equals("") || keyword.equals(" ")) {
            try {
                if (keyword.length() <= 5) {
                    this.keyword = keyword;
                } else {
                    throw new Exception("error en Keyword");
                }
            } catch (Exception e) {
                System.out.println("El largo del keyword excede el limite de 5 caracteres permitidos");
            }
        } else throw new IllegalArgumentException("La keyword ingresada contiene caracteres inválidos");
    }

    public boolean isAlpha(String s)
    {
        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public String cipher(String messaje){
        if ((this.cipherText!= null) && (this.cipherText.getLastCipher())) {
            messaje = this.cipherText.cipher(messaje);
        }
        if (!this.keyword.equals("") && !this.keyword.equals(" ") && this.keyword != null) {
            String mensajeEntrada = messaje.replace(" ", "");
            int[] keywordOrder = busquedaPosiciones();
            String finalKeywordOrder = ordenamientoPosiciones(keywordOrder);
            guardadoEntrada(mensajeEntrada);
            return cifrado(finalKeywordOrder);
        }
        return messaje;
    }

    public String decipher(String messaje){
        if(!this.keyword.equals("") && !this.keyword.equals(" ") && this.keyword != null) {
            String mensajeEntrada = messaje.replace(" ", "");
            int[] keywordOrder = busquedaPosiciones();
            StringBuilder finalKeywordOrder = new StringBuilder();
            for (int i = 0; i < keywordOrder.length; i++) {
                finalKeywordOrder.append(keywordOrder[i]);
            }
            guardadoEntrada(mensajeEntrada);
            return cifrado(finalKeywordOrder.toString());
        } return messaje;
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
            cadenaResultado+=(cadenaPosiciones.indexOf(String.valueOf(i)))+1;
        }
        return cadenaResultado;
    }

    private void guardadoEntrada(String mensajeEntrada){
        int z = 0;
        int relleno;
        int diferencia = mensajeEntrada.length() % this.keyword.length();
        if(diferencia == 0 ){
            relleno = 0;
        } else {
            relleno = this.keyword.length() - (mensajeEntrada.length() % this.keyword.length());
        }
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
                textoCifrado += (String.valueOf(this.entrada[i][Integer.parseInt(String.valueOf(finalKeywordOrder.charAt(z)))-1]));
                z++;
            }
        }
        return textoCifrado;
    }


}
