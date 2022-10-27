public class Queue<E>
{
    public int size = 0;
    private Node<E> _head;

    public void add(E data){
        Node newNode = new Node(data);
        Node currentNode = _head;

        if(_head == null) { // якщо пуста черга
            _head = newNode;
        } else {
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }
    public E poll() {
        if(_head != null){
            E result = _head.data;
            _head = _head.next;
            size--;
            return result;
        } else {
            throw new NullPointerException("Пуста черга");
        }
    }
}

