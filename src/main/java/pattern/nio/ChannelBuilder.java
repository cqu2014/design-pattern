package pattern.nio;

import cn.hutool.core.lang.Console;
import pattern.constdata.ConstData;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Oliver Wang
 * @description 获取使用 FileChannel
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/20
 * @since
 */
public class ChannelBuilder {
    public static final int BUFFER_SIZE = 128;

    public static void main(String[] args) throws IOException {
        String filePath = ConstData.DOC_PATH + "data.txt";
        // delete the file if exits
        final File file = new File(filePath);
        if (file.exists() && file.delete()){
            Console.log("删除文件成功:{}",filePath);
        }

        FileChannel channel =
                new FileOutputStream(filePath).getChannel();
        channel.write(ByteBuffer.wrap("Some text Disconnected from the target VM, address: '127.0.0.1:51676', transport: 'socket' ".getBytes()));
        channel.close();

        // Add to the end of the file
        channel = new RandomAccessFile(filePath, "rw").getChannel();
        // Move to the end
        channel.position(channel.size());
        channel.write(ByteBuffer.wrap("some more Connected to the VM started by ':ChannelBuilder.main()' (localhost:51693). Open the debugger session tab".getBytes()));
        channel.close();

        // Read the file
        channel = new FileInputStream(filePath).getChannel();
        final ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        System.out.println(channel.read(byteBuffer));
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            System.out.print((char) byteBuffer.get());
        }
    }
}
