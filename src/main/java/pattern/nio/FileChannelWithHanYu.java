package pattern.nio;

import pattern.constdata.ConstData;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Oliver Wang
 * @description 使用channel处理中文
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/24
 * @since
 */
public class FileChannelWithHanYu {
  public static void main(String[] args) {
      final CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
      FileChannel fileChannel = null;
      try{
          fileChannel = new FileInputStream(ConstData.DOC_PATH + "hanyu.txt").getChannel();
          final ByteBuffer byteBuffer = ByteBuffer.allocate(64);
          final CharBuffer charBuffer = CharBuffer.allocate(64);
          int bytesRead = fileChannel.read(byteBuffer);
          while (bytesRead != -1){
              System.out.println("bytesRead: " + bytesRead);
              byteBuffer.flip();
              charsetDecoder.decode(byteBuffer,charBuffer,false);
              charBuffer.flip();

              System.out.print(charBuffer);
              charBuffer.clear();
              byteBuffer.clear();
              bytesRead = fileChannel.read(byteBuffer);
              System.out.println();
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
         if (fileChannel != null){
             try {
                 fileChannel.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
      }
  }
}
