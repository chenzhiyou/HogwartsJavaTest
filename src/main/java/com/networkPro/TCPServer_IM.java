package com.networkPro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPServer_IM {
    public static void main(String[] args) {
        // 创建服务器
        ServerSocket ss = null;
        InputStream inputStream = null;
        Socket accept = null;
        OutputStream os = null;
        Scanner scanner = new Scanner(System.in);
        try {
            ss = new ServerSocket(6666);
            // 接受客户端的链接
            accept = ss.accept();// 建立完链接之后，会发生阻塞，等待客户端的链接
            System.out.println("服务端启动了，等待客户的输入");
            while (true){
                // 3、获取输入流对象
                inputStream = accept.getInputStream();

                // 通过输入流接收客户端发送的数据
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                System.out.println("客户端说： "+ new String(buffer, 0, len));

                // 服务端说的内容用键盘录入的方式来完成
                os = accept.getOutputStream();
                String content = scanner.nextLine();
                os.write(content.getBytes(StandardCharsets.UTF_8));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                os.close();
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    }
}
