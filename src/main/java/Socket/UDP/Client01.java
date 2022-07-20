package Socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client01 {
    public static void main(String[] args) throws SocketException {
        try {
            DatagramSocket socket = new DatagramSocket(2345);
            byte[] buffer = "UDP协议的Socket请求，有可能失败哟".getBytes();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address);
            socket.send(packet);
            System.out.println("UDP协议的Socket发送成功");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
