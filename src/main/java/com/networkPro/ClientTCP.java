package com.networkPro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// 客户端
public class ClientTCP {
    public static void main(String[] args) throws IOException {
        // 创建socket,链接服务器
        Socket client = new Socket("localhost", 6666);
        // 获取输出流对象
        OutputStream os = client.getOutputStream();
        // 通过输出流，输出响应的数据
        os.write("你好，服务端".getBytes(StandardCharsets.UTF_8));

        // 3、获取输入流对象
        InputStream inputStream = client.getInputStream();

        // 通过输入流接收客户端发送的数据
        byte[] buffer = new byte[1024];
        int len = inputStream.read(buffer);
        System.out.println("客户端说： "+ new String(buffer, 0, len));
        // 关闭相关资源
        os.close();
        client.close();

    }
}
