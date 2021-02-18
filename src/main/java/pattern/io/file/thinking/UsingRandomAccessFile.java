package pattern.io.file.thinking;

import pattern.constdata.ConstData;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/10
 * @since
 */
public class UsingRandomAccessFile {

  public static void main(String[] args) {
      String filepath = ConstData.DOC_PATH.concat("rtest.dat");
	  try (
	  		RandomAccessFile ioStream = new RandomAccessFile(filepath,"rw")
	  ){
          for (int i = 0; i < 7; i++) {
            ioStream.writeDouble(i * 1.414);
          }
          ioStream.writeUTF("The end of the file");
	  } catch (IOException e) {
	  	throw new RuntimeException("IOException");
	  }
	  display(filepath);
	  try (
              RandomAccessFile ioStream = new RandomAccessFile(filepath,"rw");
	  ){
	      ioStream.seek(5 * 8);
	      ioStream.writeDouble(47.0001);
	  } catch (IOException e) {
	  	throw new RuntimeException("IOException");
	  }
	  display(filepath);
  }

	/**
	 * 读取并展示 RandomAccessFile文件
	 *
	 * @param filepath
	 */
	static void display(String filepath){
		try (
				final RandomAccessFile rf = new RandomAccessFile(filepath, "r")
		){
		      for (int i = 0; i < 7; i++) {
		      	System.out.println("Value " + i + ": " + rf.readDouble());
		      }
              System.out.println(rf.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
