package pattern.io.file.thinking;

import pattern.constdata.ConstData;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/8
 * @since
 */
public class FormattedMemoryInput {
  public static void main(String[] args) throws IOException {
    //
    DataInputStream dataInputStream =
        new DataInputStream(
            new ByteArrayInputStream(
                BufferedInputFile.read(ConstData.FILE_NAME + "FormattedMemoryInput.java")
                    .getBytes(Charset.defaultCharset())));
      // 判断文件是否读取结束 此处是乱码
      while (dataInputStream.available() != 0){
          System.out.print((char) dataInputStream.readByte());
      }
  }
}
