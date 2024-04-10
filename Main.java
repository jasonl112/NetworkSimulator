import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    LinkedEventList eventList = new LinkedEventList();

    File myFile = new File("simulation1.txt");
    Scanner myScnr = new Scanner(myFile);

    int address = myScnr.nextInt();
    SimpleHost firstHost = new SimpleHost();
    firstHost.setHostParameters(address, eventList);

    address = myScnr.nextInt();
    while (address != -1) {
      int distance = myScnr.nextInt();
      SimpleHost newHost = new SimpleHost();
      newHost.setHostParameters(address, eventList);
      firstHost.addNeighbor(newHost, distance);
      newHost.addNeighbor(firstHost, distance);
      address = myScnr.nextInt();
    }

    while (myScnr.hasNext()) {
      int srcAddress = myScnr.nextInt();
      System.out.println(srcAddress);
      int desAddress = myScnr.nextInt();
      System.out.println(desAddress);
      int interval = myScnr.nextInt();
      int duration = myScnr.nextInt();
      Message newMessage = new Message(srcAddress, desAddress);
      firstHost.sendToNeighbor(newMessage);
    }

    myScnr.close();

  }
}
