package Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) {
//        初始化数据
        ServerSocket serverSocket =  null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            serverSocket = new ServerSocket(8100);
            System.out.println("服务器监听8100端口");
//            不断开连接，保持长连接
            while (true) {
//               等待客户端连接
                socket = serverSocket.accept();
                System.out.println("客户端连接成功，信息：" + socket.getRemoteSocketAddress());
                inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
//                读取客户端写入数据
                while ((len = inputStream.read(buffer)) > 0) {
                    System.out.println(new String(buffer, 0, len));
                }
                // 回复客户端信息
                outputStream = socket.getOutputStream();
                outputStream.write("hello".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
