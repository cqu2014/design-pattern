package pattern.io.file;

import pattern.ConstData;

import java.io.File;

/**
 * @author Oliver Wang
 * @description 管理文件目录
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/7
 * @since
 */
public class MakeDirectories {
    private static void usage(){
        System.err.println(
            "Usage: MakeDirectors path1 ......\n"
                + "Create each path \n"
                + "Usage: MakeDirectors -d path1 ......\n"
                + "Deletes each path\n"
                + "Usage: MakeDirectors -r path1 path2\n"
                + "Renames from path1 to path2");
            System.exit(1);
    }

    private static void fileData(File f){
        System.out.println(
                "Absolute path: " + f.getAbsolutePath()
                + "\n Can read: " + f.canRead()
                + "\n Can write: " + f.canWrite()
                + "\n getName: " + f.getName()
                + "\n getParent: " + f.getParent()
                + "\n getPath: " + f.getPath()
                + "\n length: " + f.length()
                + "\n lastModified: " + f.lastModified());
        if (f.isFile()){
            System.out.println("It's a file");
        } else if (f.isDirectory()){
            System.out.println("It's a directory");
        }
    }

  public static void main(String[] args) {
    if (args.length < 1){
        usage();
    }
    fileData(new File(ConstData.FILE_NAME));
  }
}
