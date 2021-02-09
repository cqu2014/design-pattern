package pattern.io.file;

import lombok.Data;
import pattern.constdata.ConstData;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/7
 * @since
 */
public class Directory {

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println(walk("."));
        } else {
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
        System.out.println("****************************************************");
        PPrint.pprint(walk(ConstData.FILE_NAME).dirs);
    }

    public static File[] local(File dir, final String regex){
        return dir.listFiles((File FileDir, String name) -> {
            Pattern pattern = Pattern.compile(regex);
            return pattern.matcher(name).matches();
        });
    }

    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }

    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }

    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    /**
     * 递归获取文件目录集合
     *
     * @param startDir
     * @param regex
     * @return
     */
    private static TreeInfo recurseDirs(File startDir,String regex){
        if (startDir == null || regex == null){
            throw new RuntimeException("recurseDirs 入参错误.");
        }
        TreeInfo result = new TreeInfo();
        for (File file : Objects.requireNonNull(startDir.listFiles())) {
            if (file.isDirectory()){
                result.getDirs().add(file);
                result.addAll(recurseDirs(file,regex));
            } else {
                if (file.getName().matches(regex)){
                    result.getFiles().add(file);
                }
            }
        }
        return  result;
    }

    @Data
    private static class TreeInfo implements Iterable<File>{
        private List<File> files = new LinkedList<>();
        private List<File> dirs = new LinkedList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        public void addAll(TreeInfo other){
            files.addAll(other.getFiles());
            dirs.addAll(other.getDirs());
        }

        @Override
        public String toString(){
            return "dirs: " + PPrint.format(dirs) +
                    "\n\nfiles: " + PPrint.format(files);
        }
    }
}
