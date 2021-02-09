package pattern.io.file.thinking;

import pattern.constdata.ConstData;

import java.io.*;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/9
 * @since
 */
public class FileOutputShortcut {
  public static void main(String[] args) throws IOException {
      String filename = ConstData.DOC_PATH.concat("FileOutputShortcut.out");
      BufferedReader bufferedReader = new BufferedReader(new StringReader(BufferedInputFile.read(ConstData.FILE_NAME.concat("FileOutputShortcut.java"))));
      // Here's shortcut
      PrintWriter out = new PrintWriter(filename);
      int lineCount = 1;
      String s;
      while ((s = bufferedReader.readLine()) != null){
          out.println(lineCount++ + ": " + s);
      }
      bufferedReader.close();
      out.close();
      System.out.println(BufferedInputFile.read(filename));
  }
}
