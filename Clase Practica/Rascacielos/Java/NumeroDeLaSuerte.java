import java.util.Scanner;

public class NumeroDeLaSuerte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su fecha de nacimiento en formato dd/mm/aaaa: ");
        String fechaNacimiento = sc.nextLine();
        sc.close();

        int dia = Integer.parseInt(fechaNacimiento.substring(0, 2));
        int mes = Integer.parseInt(fechaNacimiento.substring(3, 5));
        int anio = Integer.parseInt(fechaNacimiento.substring(6));

        int resultadoParcial = dia + mes + anio;
        int sumaDigitos = 0;

        while (resultadoParcial > 0) {
            sumaDigitos += resultadoParcial % 10;
            resultadoParcial /= 10;
        }

        System.out.println("Tu número de la suerte es: " + sumaDigitos);
    }
}
