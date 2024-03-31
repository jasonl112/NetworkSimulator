public class Node {
  private final int item;
  public Node next;
  public Node prev;

  public Node(int item) {
    this.item = item;
    this.next = null;
    this.prev = null;
  }

  public int getItem() {
    return this.item;
  }
}