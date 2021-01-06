package pattern.io.bio;

import java.io.*;
import java.net.Socket;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/6
 * @since
 */
public class SocketClient {
    //默认的端口号
    private static final int DEFAULT_SERVER_PORT = 12345;
    //默认服务器Ip
    private static final String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void send(String expression){
        send(DEFAULT_SERVER_PORT,expression);
    }

    /**
     * 负责创建连接 发送信息接收结果
     *
     * @param port
     * @param expression
     */
    public static void send(int port,String expression){
        System.out.println("算术表达式为：" + expression + "当前线程名称：" + Thread.currentThread().getName());
        try(
                Socket socket = new Socket(DEFAULT_SERVER_IP,port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                ){
            printWriter.println(expression);
            System.out.println(expression + " 结果为：" + reader.readLine());
            /*String line;
            while ((line = reader.readLine()) != null){
                System.out.println(" 结果为："+ line);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
