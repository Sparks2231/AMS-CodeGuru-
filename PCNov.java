public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int[] counter = {0}; // Usamos un array para permitir modificar dentro de la lambda

        // Creamos dos hilos que ejecutarán la misma tarea
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter[0]++; // Incremento sin sincronización
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter[0]++; // Incremento sin sincronización
            }
        });

        // Iniciamos ambos hilos
        t1.start();
        t2.start();

        // Esperamos a que ambos hilos terminen
        t1.join();
        t2.join();

        // Imprimimos el valor final de counter
        System.out.println("Counter final: " + counter[0]);
    }
}