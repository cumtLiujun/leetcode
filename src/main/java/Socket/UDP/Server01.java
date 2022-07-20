package Socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server01 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("等待UDP协议传输数据");
            socket.receive(packet);
            //packet.getLength返回将要发送或者接收的数据的长度。
            int length = packet.getLength();
            System.out.println("接收数据：" + new String(buffer, 0, length));
//            成功，传输数据完成  关闭socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
