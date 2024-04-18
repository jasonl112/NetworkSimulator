
public class LinkedEventList implements FutureEventList {
    private Node head;
    private int size;
    private int currentTime = 0;

    public Event removeFirst() {
        Node currNode = this.head;
        if (currNode == null) {
            return null;
        }

        if (this.size() == 1) {
            this.head = currNode.next;
            size--;

            currentTime = currNode.getItem().getArrivalTime();

            return currNode.getItem();
        }

        this.head = currNode.next;
        this.head.prev = null;
        size--;

        currentTime = currNode.getItem().getArrivalTime();
        return currNode.getItem();
    };

    // Use linear search
    public boolean remove(Event e) {

        if (this.size == 0) {
            return false;
        }

        if (this.size == 1 && this.head.getItem() == e) {
            this.head = null;
            this.size--;
            return true;
        }

        if (this.head.getItem() == e) {
            this.head = this.head.next;
            this.head.prev = null;
        }

        Node currNode = this.head;
        while (currNode != null) {
            if (currNode.getItem() == e) {
                if (this.size == 2) {
                    this.head.next = null;
                } else {
                    currNode.prev.next = currNode.next;
                    currNode.next.prev = currNode.prev;
                }

                size--;
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    };

    // Use linear search
    public void insert(Event e) {
        Node newNode = new Node(e);
        newNode.getItem().setInsertionTime(currentTime);
        // System.out.println("Inserting: " + newNode.getItem());

        if (this.size == 0) {
            this.head = newNode;
            this.size++;
            return;
        }

        if (this.size == 1) {
            Node currNode = this.head;

            if (newNode.getItem().getArrivalTime() >= currNode.getItem().getArrivalTime()) {
                newNode.next = null;
                currNode.next = newNode;
                newNode.prev = currNode;
                this.size++;
                return;
            } else {
                newNode.next = currNode;
                currNode.prev = newNode;
                this.head = newNode;
                this.size++;
                return;
            }

        }

        Node currNode = this.head;

        if (newNode.getItem().getArrivalTime() < currNode.getItem().getArrivalTime()) {
            newNode.next = currNode;
            currNode.prev = newNode;
            this.head = newNode;
            this.size++;
            return;
        }

        while (currNode != null) {
            if (currNode.next != null) {
                if (newNode.getItem().getArrivalTime() >= currNode.getItem().getArrivalTime()
                        && newNode.getItem().getArrivalTime() < currNode.next.getItem().getArrivalTime()) {
                    newNode.next = currNode.next;
                    currNode.next.prev = newNode;
                    currNode.next = newNode;
                    newNode.prev = currNode;
                    this.size++;
                    return;
                }
            } else {
                if (newNode.getItem().getArrivalTime() >= currNode.getItem().getArrivalTime()) {
                    newNode.next = null;
                    currNode.next = newNode;
                    newNode.prev = currNode;
                    this.size++;
                    return;
                }
            }

            currNode = currNode.next;
        }
    };

    public int size() {
        return this.size;

    };

    public int capacity() {
        return this.size;

    };

    public int getSimulationTime() {
        return currentTime;

    };

    public void printLinkedList() {
        Node currNode = this.head;
        System.out.println();
        System.out.println("Size: " + this.size());
        System.out.println("PRINTING List");
        while (currNode != null) {
            System.out.println(currNode.getItem());
            currNode = currNode.next;
        }
        System.out.println();
    }
}
