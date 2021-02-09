package pattern.io.file.thinking;

import java.io.*;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/8
 * @since
 */
public class BufferedInputFile {

  public static void main(String[] args) throws IOException {
    System.out.println(read("world.java"));
  }

    /**
     * BufferedReader 读取文件
     *
     * @param filename
     * @return
     */
    public static String read(String filename) throws IOException {
        // 优先考虑使用字符处理类 + 缓冲
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filename));
        String s;
        StringBuilder builder = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null){
            builder.append(s).append("\n");
        }
        bufferedReader.close();
        return builder.toString();
    }
}
