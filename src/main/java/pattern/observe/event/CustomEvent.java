package pattern.observe.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Oliver Wang
 * @description 事件信息体
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/17
 * @since
 */
@Data
@AllArgsConstructor
public class CustomEvent {
    private String name;
    private int age;
}
