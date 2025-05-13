

/**
 * Clase de utilidad para operaciones con pilas.
 * Esta clase proporciona métodos estáticos para realizar diversas operaciones
 * en pilas, como copiar, imprimir, ordenar y calcular el tamaño.
 */
public class StackUtil {
    /**
     * Constructor privado para evitar la instanciación de la clase de utilidad.
     */
    private StackUtil() {

    }
    /**
     * Crea una copia de la pila dada.
     * La pila original permanece sin cambios después de la operación.
     *
     * @param stack la pila que se desea copiar
     * @return una nueva pila que contiene los mismos elementos que la pila original
     */
    public static Stack copy(Stack stack) {
        Stack result = new StaticStack();
        Stack aux = new StaticStack();
        // Transfiere los elementos de la pila original a una pila auxiliar
        while(!stack.isEmpty()) {
            int top = stack.getTop();
            aux.add(top);
            stack.remove();
        }
        // Transfiere los elementos de la pila auxiliar de vuelta a la original y a la nueva pila
        while(!aux.isEmpty()) {
            int top = aux.getTop();
            stack.add(top);
            result.add(top);
            aux.remove();
        }


        return result;
    }


    /**
     * Imprime los elementos de la pila dada en la consola.
     * La pila original permanece sin cambios después de la operación.
     *
     * @param stack la pila cuyos elementos se desean imprimir
     */
    public static void print(Stack stack) {
        Stack copy = copy(stack);


        while(!copy.isEmpty()) {
            int top = copy.getTop();
            System.out.println(top);
            copy.remove();
        }
    }
    /**
     * Ordena la pila dada en orden ascendente utilizando el algoritmo de ordenamiento burbuja.
     * El ordenamiento se realiza en la misma pila.
     *
     * @param stack la pila que se desea ordenar
     */
    public static void bubbleSort(Stack stack) {
        int size = size(stack);
        for(int i = 0; i < size - 1; i++) {
            move(stack);
        }
    }
    /**
     * Calcula el tamaño de la pila dada.
     * La pila original permanece sin cambios después de la operación.
     *
     * @param stack la pila cuyo tamaño se desea calcular
     * @return el número de elementos en la pila
     */
    public static int size(Stack stack) {
        if (stack == null) {
            return 0;
        }


        if (stack.isEmpty()) {
            return 0;
        }


        int top = stack.getTop();
        stack.remove();
        int size = size(stack);
        stack.add(top);
        return 1 + size;
    }


    private static void move(Stack stack) {
        if(stack == null) {
            return;
        }


        if(stack.isEmpty()) {
            return;
        }


        int top = stack.getTop();
        stack.remove();
        if(stack.isEmpty()) {
            stack.add(top);
            return;
        }


        int next = stack.getTop();
        stack.remove();
        if(top > next) {
            stack.add(top);
            move(stack);
            stack.add(next);
            return;
        }


        stack.add(next);
        move(stack);
        stack.add(top);
    }
    public static Stack mapToStack(VersionedStack versionedStack) {
        Stack result = new StaticStack();
        for (int i = 0; i < versionedStack.count; i++) {
            result.add(versionedStack.array[i]);
        }
        return result;
    }
    
    /**
     * Convierte una instancia de Stack a una instancia de VersionedStack.
     * @param stack La pila a convertir.
     * @return Una nueva instancia de VersionedStack con los mismos elementos.
     */
    public static VersionedStack mapToVersionedStack(Stack stack) {
        VersionedStack versionedStack = new VersionedStack();
        Stack aux = copy(stack); // Copiamos la pila para no modificar la original.
        while (!aux.isEmpty()) {
            versionedStack.add(aux.getTop());
            aux.remove();
        }
        return versionedStack;
    }

}


