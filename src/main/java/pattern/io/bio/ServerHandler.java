package pattern.io.bio;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/6
 * @since
 */
public class ServerHandler implements Runnable{
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
