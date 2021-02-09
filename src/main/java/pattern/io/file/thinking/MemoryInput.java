package pattern.io.file.thinking;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/8
 * @since
 */
public class MemoryInput {
  public static void main(String[] args) throws IOException {
    //
      System.out.println("================================");
      StringReader stringReader = new StringReader(BufferedInputFile.read("world.java"));
      int c;
      while ((c = stringReader.read()) != -1){
        System.out.print((char) c);
      }
  }
}
