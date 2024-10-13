import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LanzadorTriangulo {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        //Creamos 3 procesos para lanzar la clase Triangulo, con su classpath para saber la ruta donde se encuentra
        ProcessBuilder proceso = new ProcessBuilder("java", "-cp", classpath, "Triangulo","5");
        ProcessBuilder proceso2 = new ProcessBuilder("java", "-cp", classpath, "Triangulo","7");
        ProcessBuilder proceso3 = new ProcessBuilder("java", "-cp", classpath, "Triangulo","9");
        //re-dirigimos la salida del proceso y la salida de errores hacia ficheros de texto plano que están
        //en la carpeta resources del proyecto
        proceso.redirectError(new File("src/resources/errores1.txt"));
        proceso.redirectOutput(new File("src/resources/triangulo1.txt"));
        proceso2.redirectError(new File("src/resources/errores2.txt"));
        proceso2.redirectOutput(new File("src/resources/triangulo2.txt"));
        proceso3.redirectError(new File("src/resources/errores3.txt"));
        proceso3.redirectOutput(new File("src/resources/triangulo3.txt"));

        //con un try y un catch lanzamos los procesos al mismo tiempo con intencion de capturar
        //cualquier error de IO
        try {
            proceso.start();
            proceso2.start();
            proceso3.start();
            System.out.println("El proceso ha sido lanzado con exito");
            System.out.println("Revisa el contenido de src/resources/salida.txt\ny de src/resources/errores.txt ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
