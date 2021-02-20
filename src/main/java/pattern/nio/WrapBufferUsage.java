package pattern.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Oliver Wang
 * @description Buffer的wrap方法测试偏移量
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/20
 * @since
 */
public class WrapBufferUsage {
  public static void main(String[] args) {
      byte[] bytes = new byte[50];
      final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes, 10, 10);
      // java.nio.HeapByteBuffer[pos=10 lim=15 cap=20]
      System.out.println(byteBuffer);
      // byteBuffer.put((byte) 2);
      // byteBuffer.put(new byte[]{1,2,3,4,5});
      byteBuffer.putLong(12L);
      System.out.println(byteBuffer);
      // LITTLE_ENDIAN 小端模式
      System.out.println(ByteOrder.nativeOrder());
  }
}
