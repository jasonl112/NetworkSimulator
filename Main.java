import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    HashMap<Integer, SimpleHost> activeHosts = new HashMap<Integer, SimpleHost>();
    LinkedEventList eventList = new LinkedEventList();

    File myFile = new File("simulation4.txt");
    Scanner myScnr = new Scanner(myFile);

    // Create FirstHost
    int address = myScnr.nextInt();
    SimpleHost firstHost = new SimpleHost();
    firstHost.setHostParameters(address, eventList);
    activeHosts.put(address, firstHost);

    // Create Neighbors
    address = myScnr.nextInt();
    while (address != -1) {
      int distance = myScnr.nextInt();
      SimpleHost newHost = new SimpleHost();
      newHost.setHostParameters(address, eventList);
      activeHosts.put(address, newHost);
      firstHost.addNeighbor(newHost, distance);
      newHost.addNeighbor(firstHost, distance);
      address = myScnr.nextInt();

    }

    // Create Pings

    while (myScnr.hasNext()) {
      int srcAddress = myScnr.nextInt();
      int desAddress = myScnr.nextInt();
      int interval = myScnr.nextInt();
      int duration = myScnr.nextInt();
      activeHosts.get(srcAddress).sendPings(desAddress, interval, duration);
    }

    while (eventList.size() > 0) {
      Event removedEvent = eventList.removeFirst();
      removedEvent.handle();
    }

    myScnr.close();

  }
}
