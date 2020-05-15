package cn.hgy.data.structure;

/**
 * 链表
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
public class LinkedList<T> {

    // 第一个
    private Node first;
    // 最后一个
    private Node last;

    public void add(T element) {
        final Node l = last;
        final Node newNode = new Node(l, element, null);
        last = newNode;
        if (l == null) { // 当前没有元素
            first = newNode;
        } else {
            l.next = last;
        }
    }

    public void transfer(){
        
    }

    public void foreach() {
        if (first != null) {
            Node cur = first;
            while (cur != null) {
                System.out.println(cur.value);
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.foreach();
    }

    /**
     * 节点信息，双链表
     */
    private static class Node<T> {

        private T value;
        private Node next;
        private Node prev;

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
