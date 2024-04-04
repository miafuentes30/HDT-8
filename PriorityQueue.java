/*
 * Clase casi similar al tipo Node
 */

 interface PriorityQueue<E> {
    boolean add(E element);
    E remove();
    boolean isEmpty();
    int size();
}
