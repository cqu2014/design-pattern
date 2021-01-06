package pattern.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/5
 * @since
 */
public class ReaderFromConsole {
    /**
     * 转换流从控制台上读入数据
     * @param args
     */
  public static void main(String[] args) {
      BufferedReader bufferedReader = null;
      try {
          bufferedReader = new BufferedReader(new InputStreamReader(System.in));
          String lineStr;
          while (!"".equals(lineStr = bufferedReader.readLine())){
            System.out.println(lineStr);
          }
      } catch (Exception exception) {
          exception.printStackTrace();
      } finally{
          if (bufferedReader != null) {
              try {
                  bufferedReader.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
  }
}
