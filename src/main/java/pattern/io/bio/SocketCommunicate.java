package pattern.io.bio;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/6
 * @since
 */
public class SocketCommunicate {
  public static void main(String[] args) throws InterruptedException {
      //启动线程，运行服务器
      new Thread(ServerBetter::start).start();

      TimeUnit.MILLISECONDS.sleep(100);

      //启动线程，运行客户端
      char[] operators = {'+', '-', '*', '/'};
      Random random = new Random(System.currentTimeMillis());
    new Thread(
            () -> {
              while (true) {
                // 随机产生算术表达式
                String expression =
                    random.nextInt(10)
                        + ""
                        + operators[random.nextInt(4)]
                        + (random.nextInt(10) + 1);
                // 创建socket连接客户端并发送参数
                SocketClient.send(expression);
                try {
                  TimeUnit.SECONDS.sleep(random.nextInt(3));
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            })
        .start();
  }
}
