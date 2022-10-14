package com.networkPro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        // 创建服务器
        ServerSocket ss = new ServerSocket(6666);
        // 接受客户端的链接
        Socket accept = ss.accept();// 建立完链接之后，会发生阻塞，等待客户端的链接

        // 3、获取输入流对象
        InputStream inputStream = accept.getInputStream();

        // 通过输入流接收客户端发送的数据
        byte[] buffer = new byte[1024];
        int len = inputStream.read(buffer);
        System.out.println("客户端说： "+ new String(buffer, 0, len));

        // 服务端写出数据到客户端
        OutputStream os = accept.getOutputStream();
        os.write("你好，客户端".getBytes(StandardCharsets.UTF_8));

        inputStream.close();
        accept.close();

    }
}
