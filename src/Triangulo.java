import java.time.LocalDateTime;

public class Triangulo {
    public static void main(String[] args) {
        //añadimos la fecha actual hasta los milisegundos
        //tanto al inicio como al final, asi podemos saber
        //que proceso finaliza primero, etc
        System.out.println(LocalDateTime.now());
        if (args.length == 0) {
            System.out.println("Se requiere un argumento");
            return;
        }
        int filas = Integer.parseInt(args[0]);
        for (int i = filas; i >= 1; i--) {
            for (int n = 1; n <= i; n++) {
                System.out.print(n);
            }
            System.out.println();
        }
        System.out.println(LocalDateTime.now());

    }
}