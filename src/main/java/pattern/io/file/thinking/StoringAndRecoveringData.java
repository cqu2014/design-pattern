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
public class StoringAndRecoveringData {
  public static void main(String[] args){
      String filepath = ConstData.DOC_PATH.concat("StoringAndRecoveringData.txt");
      try(
              DataOutputStream outputStream = new DataOutputStream(
                      new BufferedOutputStream(
                              new FileOutputStream(filepath)))
      ){
          // 数据存储与恢复
          outputStream.writeDouble(3.1415926);
          outputStream.writeUTF("That was pi");
          outputStream.writeDouble(1.41413);
          outputStream.writeUTF("Square root of 2");
      } catch (IOException e) {
          e.printStackTrace();
      }
      try(
		      DataInputStream inputStream = new DataInputStream(
				      new BufferedInputStream(
						      new FileInputStream(filepath)))
		      ){
	      System.out.println(inputStream.readDouble());
	      System.out.println(inputStream.readUTF());
	      System.out.println(inputStream.readDouble());
	      System.out.println(inputStream.readUTF());
      } catch (IOException e) {
	      e.printStackTrace();
      }
  }
}
