package pattern.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Oliver Wang
 * @description ServerSocket监听端口提供服务
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/6
 * @since
 */
public class ServerBetter {
    /**
     * 默认端口号
     */
    private final static int DEFAULT_PORT = 12345;
    /**
     * ServerSocket实例
     */
    private static ServerSocket serverSocket;


    public static void  start(){
        start(DEFAULT_PORT);
    }

    /**
     * 创建实例监听端口
     *
     * @param port
     */
    public synchronized static void start(int port){
        if (Objects.nonNull(serverSocket)){
            return;
        }
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);
            // 无线循环监听客户端连接,若无客户端接入 则阻塞在 accept操作上
            while (true) {
                Socket socket = serverSocket.accept();
                //当有新的客户端接入时，会执行下面的代码,然后创建一个新的线程处理这条Socket链路
                new Thread(new ServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("服务器已关闭!");
        }
    }

  private static class ServerHandler implements Runnable {
        private Socket socket;
        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

      @Override
      public void run() {
          try(
                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                  PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                  ){
                String expression;
                String result;
                while ((expression = bufferedReader.readLine()) != null){
                    System.out.println("服务器收到消息：" + expression + "当前线程名称：" + Thread.currentThread().getName());
                    String[] strings = expression.split(" ");
                    result = Arrays.toString(strings);
                    printWriter.println(result);
                }
          } catch (IOException e) {
              e.printStackTrace();
          } finally {
              try {
                  socket.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
              socket = null;
          }
      }
  }
}
