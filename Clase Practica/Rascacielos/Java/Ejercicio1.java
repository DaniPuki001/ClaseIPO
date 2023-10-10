import java.util.Scanner;

/**
 *
 * @author danip
 */




public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Me pican las bolas");
        int anno;
        int mes;
        int dia;
        int numeromagico = 0;
        int n,r;
        boolean isDiaVal = false;
        boolean isBisiesto;
        
        do {            
            System.out.println("Dime tu ano:");
            anno = scanner.nextInt();
        } while (anno < 1 || anno > 2024);
        do {            
            System.out.println("Dime tu mes:");
            mes = scanner.nextInt();
            if (mes<1||mes>12) {
                System.err.println("ERROR MAMAWEBO");
                System.err.flush();
            }
        } while (mes < 1 || mes > 12);
        
        do {
            isDiaVal=true;
            System.out.println("Dime tu dia:");
            dia = scanner.nextInt();
            
            if (((anno%4 == 0) && !(anno%100 == 0)) || ((anno%4 == 0) && (anno%100 == 0)&&(anno%400 == 0))) {
                isBisiesto = true;
            }else{
                isBisiesto = false;
            
            }
            
            if (mes == 1 || mes == 3 ||mes == 5 ||mes == 7 ||mes == 8 ||mes == 10 || mes == 12){
                
            }else if(mes == 4 ||mes == 6 ||mes == 9 ||mes == 11){
                
            }else{
                if (( isBisiesto && dia <1|| dia >29)|| ( !isBisiesto && dia <1|| dia >28)) {
                    isDiaVal=false;
                }
            }
            
        } while (!isDiaVal);
        
        
       
        
        n = dia + mes + anno;
        while (n > 0) {
            r = n%10;
            n = n/10;
            
            numeromagico += r;
        }
        System.out.println(dia +"/"+ mes +"/"+ anno);
        System.out.println(numeromagico);
        
    }
    
}
