package pattern.strategy;

import cn.hutool.core.lang.Console;
import pattern.enums.DirectionEnum;

/**
 * @author Oliver Wang
 * @description 象移动策略
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/25
 * @since
 */
public class ElephantMoveStrategy implements IChineseChessTranslate{
    @Override
    public boolean move(DirectionEnum direction) {
        Console.log("象/相向 {} 走田移动",String.valueOf(direction));
        switch (direction){
            case UP:
                Console.log("纬度增加2，经度增加1或者减少2");
                break;
            case DOWN:
                Console.log("纬度减少2，经度增加1或者减少2");
                break;
            case LEFT:
                Console.log("经度减少2，维度增加1或者减少2");
                break;
            case RIGHT:
                Console.log("经度增加2，维度增加1或者减少2");
                break;
            default:
                throw new RuntimeException("ElephantMoveStrategy error");
        }
        return true;
    }
}
