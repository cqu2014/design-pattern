package pattern.io;

import java.io.*;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/5
 * @since
 */
public class PrintWriterService {
  public static void main(String[] args) {
    println("utf_8.txt","println.txt");
  }

    /**
     * PrintWriter格式化输出字符
     *
     * @param inputPath
     * @param outputPath
     */
    private static void println(String inputPath,String outputPath){
        try(
                BufferedReader bufferedWriter = new BufferedReader(new FileReader(inputPath));
                // PrintWriter重定向到文件
                PrintWriter printWriter =new PrintWriter(new FileWriter(outputPath))) {
            String line;
            while ((line = bufferedWriter.readLine()) != null){
                printWriter.println(line);
            }
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
