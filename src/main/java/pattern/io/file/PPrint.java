package pattern.io.file;

import cn.hutool.core.collection.CollectionUtil;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Oliver Wang
 * @description 格式化目录打印展示格式
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/7
 * @since
 */
public class PPrint {
    public static String format(Collection<File> c){
        if (CollectionUtil.isEmpty(c)){
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        c.forEach(x->{
            if (c.size() != 1){
                result.append("\n ");
            }
            result.append(x.getName());
        });

        if (c.size() != 1){
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<File> collection){
        System.out.println(format(collection));
    }

    public static void pprint(File[] objects){
        System.out.println(format(Arrays.asList(objects)));
    }
}
