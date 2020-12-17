package pattern.proxy.convert;

import lombok.Setter;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/24
 * @since
 */
public class Son extends Father {
    @Setter
    private Integer id;

    public Son(String name) {
        super(name);
    }


    public void say(String song) {
        System.out.println("Son sing a song: " + song);
    }


}
