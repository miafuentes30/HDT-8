/*
 * Clase del VectorHeap, que maneja la cola con una prioridad Heap.
 */


/*
 * @param <E> el tipo de elementos que contendrá la cola de prioridad, debe ser comparable
 */
class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private java.util.Vector<E> data;

    /**
     * Construye un nuevo VectorHeap vacío.
     */
    public VectorHeap() {
        data = new java.util.Vector<>();
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     * 
     * @param value el elemento a agregar
     * @return true si el elemento se agregó correctamente
     */
    @Override
    public boolean add(E value) {
        data.add(value);
        int index = data.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (data.get(index).compareTo(data.get(parentIndex)) >= 0) break;
            E temp = data.get(index);
            data.set(index, data.get(parentIndex));
            data.set(parentIndex, temp);
            index = parentIndex;
        }
        return true;
    }
    
    /**
     * Elimina y devuelve el elemento de menor prioridad en la cola.
     * 
     * @return el elemento de menor prioridad, o null si la cola está vacía
     */
    @Override
    public E remove() {
        if (data.isEmpty()) return null;
        E result = data.get(0);
        E last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            int index = 0;
            while (index < data.size() / 2) {
                int leftChild = 2 * index + 1;
                int rightChild = leftChild + 1;
                int minChild = leftChild;
                if (rightChild < data.size() && data.get(rightChild).compareTo(data.get(leftChild)) < 0) {
                    minChild = rightChild;
                }
                if (data.get(index).compareTo(data.get(minChild)) <= 0) break;
                E temp = data.get(index);
                data.set(index, data.get(minChild));
                data.set(minChild, temp);
                index = minChild;
            }
        }
        return result;
    }
    
    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return true si la cola de prioridad está vacía, false de lo contrario
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    } 
    
    /**
     * Obtiene el número de elementos en la cola de prioridad.
     * 
     * @return el número de elementos en la cola de prioridad
     */
    @Override
    public int size() {
        return data.size();
    }
}
