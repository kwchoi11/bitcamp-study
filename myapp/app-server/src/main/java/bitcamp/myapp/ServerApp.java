package bitcamp.myapp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("서버 실행중...");

    Socket socket = serverSocket.accept();

    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();

    byte[] buf = new byte[8192];
    int len = in.read(buf);
    String str = new String(buf, 0, len, "UTF-8");

    System.out.println(str);

    in.close();
    out.close();
    socket.close();
    serverSocket.close();
  }
}
