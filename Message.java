public class Message extends Event {

  @Override
  public void setInsertionTime(int currentTime) {
    this.insertionTime = currentTime;
    this.arrivalTime = currentTime + this.distance;
  }

  private int srcAddress;
  private int destAddress;
  private String type = "Request";
  private Host destination;
  private int distance;

  public Message(int srcAddress, int destAddress, String type) {
    this.srcAddress = srcAddress;
    this.destAddress = destAddress;
    this.type = type;
  }

  @Override
  public void cancel() {
    // LEAVE EMPTY
  }

  @Override
  public void handle() {
    destination.receive(this);
  }

  public String getMessage() {
    return this.type;
  }

  public int getSrcAddress() {
    return this.srcAddress;
  }

  public int getDestAddress() {
    return this.destAddress;
  }

  public void setNextHop(Host destination, int distance) {
    this.destination = destination;
    this.distance = distance;
    int temp = this.srcAddress;
    this.srcAddress = this.destAddress;
    this.destAddress = temp;
  }

  @Override
  public String toString() {
    return "[Event Message " + this.getId() + " (insertion time: " + this.getInsertionTime() + ", arrival time: " +
        this.getArrivalTime() + ")]";
  }

}
