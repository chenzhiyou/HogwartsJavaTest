package com.networkPro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient_IM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket client = null;
        OutputStream os = null;
        InputStream inputStream = null;
        try {
            client = new Socket("localhost", 6666);
            System.out.println("客户端启动了，等待用户的输入");
            while (true){
                os = client.getOutputStream();
                // 通过输出流，输出响应的数据
                String content = scanner.nextLine();
                os.write(content.getBytes(StandardCharsets.UTF_8));

                // 3、获取输入流对象

                inputStream = client.getInputStream();

                // 通过输入流接收客户端发送的数据
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                System.out.println("服务端说： "+ new String(buffer, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭相关资源
            try {
                inputStream.close();
                os.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }
}
