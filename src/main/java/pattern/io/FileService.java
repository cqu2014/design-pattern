package pattern.io;

import java.io.*;
import java.util.Objects;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 202.02
 * @date Create at 2020/12/31
 * @since
 */
public class FileService {
  public static void main(String[] args) {
    // readAndWriteFile("chuci","dest.txt");
      readAndWriteFile("hello.txt","world.java");
      readAndWriteByte("wallet.jpg","qianbao.jpg");
      readAndWriteByte("chuci","dest.txt");

      System.exit(0);
  }
    /**
     * 使用默认字符集 按字符流操作文件
     *
     * @param source
     * @param dest
     */
  public static void readAndWriteFile(String source,String dest){
      try(
         BufferedReader reader = new BufferedReader(new FileReader(source));
         BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
              ) {
          String str;
          while ((str = reader.readLine()) != null){
              writer.write(str);
              writer.newLine();
          }
          writer.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

    /**
     * 读写字节流
     *
     * @param source
     * @param dest
     */
  public static void readAndWriteByte(String source,String dest){
      try(
              BufferedInputStream   bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
              BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
              ) {

          byte[] buffer = new byte[1024];
          int length;
          while ((length = bufferedInputStream.read(buffer,0,1024)) != -1){
              bufferedOutputStream.write(buffer, 0,length);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

    /**
     * 写文件
     *
     * @param filename
     * @param content
     */
  private void writeFile(String filename, String content){
      OutputStream out = null;
      try{
         out = new BufferedOutputStream(new FileOutputStream(filename));
          out.write(content.getBytes());
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (Objects.nonNull(out)){
              try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
  }
}