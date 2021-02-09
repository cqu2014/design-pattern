package pattern.io.file;

import cn.hutool.core.lang.Console;
import pattern.constdata.ConstData;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Oliver Wang
 * @description 文件路径类File的使用
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/7
 * @since
 */
public class FilePath {

  public static void main(String[] args) {
    // 项目主目录
      File path = new File(ConstData.FILE_NAME);
      String[] list;
      if (args.length == 0){
          list = path.list();
      } else {
          list = path.list(new DirFilter(".*java$"));
      }

      assert list != null;
      Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
      for (String filePath : list) {
          Console.log(filePath);
      }
  }

    /**
     * FilenameFilter 指定list 目录过滤器
     */
    private static class DirFilter implements FilenameFilter{
        private final Pattern pattern;

        public DirFilter(String regex){
            pattern = Pattern.compile(regex);
        }

        /**
         * Tests if a specified file should be included in a file list.
         *
         * @param   dir    the directory in which the file was found.
         * @param   name   the name of the file.
         * @return  <code>true</code> if and only if the name should be
         * included in the file list; <code>false</code> otherwise.
         */
        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
