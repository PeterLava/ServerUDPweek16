import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
             boolean run = true;
             Scanner sc = new Scanner(System.in);
             DatagramSocket dgs = new DatagramSocket(6780);
             byte[] inArr = new byte[1000];

             while(run) {
                 DatagramPacket inPacket = new DatagramPacket(inArr, inArr.length);
                 dgs.receive(inPacket);
                 String inMsg = new String(inArr, 0, inPacket.getLength());
                 System.out.println("Client: " + inMsg);
                 System.out.print("skriv din besked: ");
                 String msg = sc.nextLine();
                 byte[] outArr = msg.getBytes();
                 DatagramPacket outPacket = new DatagramPacket(outArr, outArr.length, inPacket.getAddress(), inPacket.getPort());
                 dgs.send(outPacket);
            }
    }
}