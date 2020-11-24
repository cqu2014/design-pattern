package pattern.proxy.convert;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/24
 * @since
 */
@Data
@AllArgsConstructor
public class Father {
    private String name;

    public void say(){
    System.out.println("father says something");
    }
}
