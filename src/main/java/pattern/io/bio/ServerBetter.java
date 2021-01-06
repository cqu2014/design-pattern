package pattern.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * @author Oliver Wang
 * @description ServerSocket监听端口提供服务
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/6
 * @since
 */
public final class ServerBetter {
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
}
