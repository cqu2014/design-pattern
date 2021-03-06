package pattern.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/1/5
 * @since
 */
public class FileReaderService {
  public static void main(String[] args) {
      writeUtf82gbk("utf_8.txt","gbk.txt");
  }

    /**
     * 读取UTF8文件写出GBK类型文件
     *
     * @param inputPath "utf_8.txt"
     * @param outputPath "gbk.txt"
     */
  public static void writeUtf82gbk(String inputPath,String outputPath){
      BufferedReader bufferedReader = null;
      BufferedWriter bufferedWriter = null;
      try{
          InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8);
          bufferedReader = new BufferedReader(inputStreamReader);
          OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outputPath),"gbk");
          bufferedWriter = new BufferedWriter(outputStreamWriter);

          String line;
          while ((line = bufferedReader.readLine()) != null){
              bufferedWriter.write(line);
              // bufferedWriter.write("\n");
              bufferedWriter.newLine();
              System.out.println(line);
          }
          // 只有调用flush或者close方法才会触发收尾
          bufferedWriter.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }finally{
          try {
              if (bufferedReader != null) {
                  bufferedReader.close();
              }
              if (bufferedWriter != null) {
                  bufferedWriter.close();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
}
