package pattern.io.file;

import cn.hutool.core.lang.Console;
import pattern.ConstData;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/7
 * @since
 */
public class FilterPath1 {
  public static void main(String[] args) {
    // 项目主目录
    File path = new File(ConstData.FILE_NAME);
      String[] list = path.list((File dir, String name) ->{
          Pattern pattern = Pattern.compile(".*java$");
          return pattern.matcher(name).matches();
      });
      assert list != null;
      Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
      for (String filePath : list) {
          Console.log(filePath);
      }
  }
}
