package pattern.nio;

import pattern.constdata.ConstData;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/24
 * @since
 */
public class FileChannelUsage2 {
  public static void main(String[] args) throws IOException {
      RandomAccessFile randomAccessFile = new RandomAccessFile(ConstData.DOC_PATH+"data.txt", "r");
      final FileChannel accessFileChannel = randomAccessFile.getChannel();
      // 定义Buffer读取文件
      ByteBuffer byteBuffer = ByteBuffer.allocate(48);
      int bufferRead = accessFileChannel.read(byteBuffer);
      while (bufferRead != -1){
          System.out.println("Read: " + bufferRead);
          // 读写模式切换
          byteBuffer.flip();
          while (byteBuffer.hasRemaining()){
              System.out.print((char) byteBuffer.get());
          }
          byteBuffer.clear();
          bufferRead = accessFileChannel.read(byteBuffer);
          System.out.println();
      }
      randomAccessFile.close();
      accessFileChannel.close();
  }
}
