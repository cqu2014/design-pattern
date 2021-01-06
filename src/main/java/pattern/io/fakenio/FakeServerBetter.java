package pattern.io.fakenio;

import pattern.io.bio.ServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Oliver Wang
 * @description 使用线程池实现伪异步阻塞通信
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/6
 * @since
 */
public final class FakeServerBetter {
    //默认的端口号
    private static final int DEFAULT_PORT = 12345;
    //单例的ServerSocket
    private static ServerSocket serverSocket;
    //线程池 懒汉式的单例
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void start(){
        start(DEFAULT_PORT);
    }

    //这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
    public synchronized static void start(int port){
        if(serverSocket != null) return;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);
            while(true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("服务器已关闭。");
                serverSocket = null;
            }
        }
    }

}
