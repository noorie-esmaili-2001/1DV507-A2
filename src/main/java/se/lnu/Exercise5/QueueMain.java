package se.lnu.Exercise5;

public class QueueMain {

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        System.out.println("Is Empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue);
        System.out.println("Size: " + queue.size());
        System.out.println(queue.dequeue() + " dequeued");
        queue.enqueue("D");
        System.out.println(queue.last() + " enqueued");
        System.out.println(queue.first() + " is first element.");
        System.out.println(queue);
    }

}
