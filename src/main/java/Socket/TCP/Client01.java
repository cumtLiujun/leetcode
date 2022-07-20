package Socket.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8100);
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("TCP连接成功 \n请输入：");
        while(true){
            byte[] car = new Scanner(System.in).nextLine().getBytes();
            outputStream.write(car);
            System.out.println("TCP协议的Socket发送成功");
            //刷新缓冲区
            outputStream.flush();
        }
    }
}
