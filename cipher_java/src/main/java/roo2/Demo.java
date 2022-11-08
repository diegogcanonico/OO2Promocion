package roo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static Scanner lectura = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner ingresoTeclado = new Scanner(System.in);
        Integer pregunta1;
        List<Object> pregunta2;
        do {
            pregunta1 = preguntaPorOpcion();
            if(pregunta1 == 4 )
                break;
            pregunta2 = preguntaPorParametros(pregunta1);
            Application app = configureApplication(pregunta1, pregunta2);
            System.out.println("Ingrese una cadena a cifrar: ");
            String palabra = ingresoTeclado.nextLine();
            String palabraCifrada = app.cipher(palabra);
            System.out.println("La palabra cifrada es: ");
            System.out.println(palabraCifrada);
            System.out.println("Ahora la palabra cifrada se pasa por el decipher: ");
            System.out.println(app.decipher(palabraCifrada));
            System.out.println("\n");
            presionarTeclaParaContinuar();
        } while(pregunta1 != 4);
        System.out.println("Programa finalizado.");
    }




    private static Application configureApplication(Integer usedCipher, List<Object> parametros) {
        Application app;
        CipherFactory factory = null;
        switch (usedCipher) {
            case 1, 2:
                factory = new SubstitutionCipherFactory();
                break;
            case 3:
                factory = new TranspositionCipherFactory();
                break;
            case 4:
                System.out.println("Cerrando programa.");
                break;
            default:{
                System.out.println("Opción incorrecta. Recuerde ingresar 1 para Cesar, 2 para Vigenere y 3 para Rail Fence o 4 para cerrar.");
                break;}
            }
        System.out.println("\n");
        app = new Application(factory, parametros);
        return app;
    }


    public static int  preguntaPorOpcion(){
        int valor = 0;
        while (valor == 0) {
            System.out.println(
                    "Menú de opciones\n"
                            + "-------------->\n"
                            + "1. Solicitar uso de Cesar Cipher. \n"
                            + "2. Solicitar uso de Vigenere Cipher. \n"
                            + "3. Solicitar uso de Rail Fence Cipher. \n"
                            + "4. Salir del programa. \n"
                            + "Seleccione una opción: "
            );
            valor = lectura.nextInt();
            if (valor <= 0 || valor > 4){
                System.out.println("Opción incorrecta. Recuerde ingresar 1 para Cesar, 2 para Vigenere y 3 para Rail Fence o 4 para cerrar.");
                valor=0;}
        }
        return valor;
    }

    public static List<Object> preguntaPorParametros(Integer pregunta1){
        List<Object> parameterList = new ArrayList<>();
        System.out.println("Ingrese la opcion para la cantidad de parametros que va a utilizar\n");
        switch (pregunta1) {
            case 1:System.out.println(
                "-------------->\n"
                +"1. Con un parámetro. \n"
                +"2. Con dos parámetros. \n"
                +"Seleccione una opción: ");
                break;
            case 2:System.out.println(
                     "-------------->\n"
                     +"0. Sin parámetros. \n"
                     +"2. Con dos parámetros. \n"
                     +"Seleccione una opción: ");
                break;
            case 3:System.out.println(
                    "-------------->\n"
                    +"1. Con un parámetro. \n");
                    break;
        }
        int cantParametros= lectura.nextInt();
        if (cantParametros > 3 || cantParametros < 0) {
            System.out.println("Opción incorrecta. Recuerde ingresar las opciones dadas por el sistema");
            preguntaPorParametros(pregunta1);
        }
            switch (cantParametros){
                case 0: break;
                case 1:
                    System.out.println("Ingrese el parámetro: ");
                    parameterList.add(lectura.nextInt());
                    break;
                case 2:
                    System.out.println("¿Los dos parámetros son de tipo String?: \n"
                            +"-------------->\n"
                            +"1. Si. \n"
                            +"2. No. \n"
                            +"Seleccione una opción: "
                    );
                    if (lectura.nextInt() ==1){
                        System.out.println("Ingrese el primer parámetro de tipo String");
                        lectura = new Scanner(System.in);
                        String param1 = lectura.nextLine();
                        parameterList.add(param1);
                        System.out.println("Ingrese el segundo parámetro de tipo String");
                        lectura = new Scanner(System.in);
                        String param2 = lectura.nextLine();
                        parameterList.add(param2);
                    }
                    else{
                        System.out.println("Ingrese el primer parámetro de tipo Integer");
                        lectura = new Scanner(System.in);
                        parameterList.add(lectura.nextInt());
                        System.out.println("Ingrese el segundo parámetro de tipo String");
                        lectura = new Scanner(System.in);
                        parameterList.add(lectura.nextLine());
                        parameterList.add("Tiene un entero y un string");
                    }
                default:
                    System.out.println("Opción incorrecta. Recuerde ingresar las opciones dadas por el sistema");
                    break;
            }
        return parameterList;
    }


    static public void presionarTeclaParaContinuar()
    {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Presionar Enter para continuar...");
        try
        {
            seguir = teclado.nextLine();
        }
        catch(Exception e)
        {}
    }

}
