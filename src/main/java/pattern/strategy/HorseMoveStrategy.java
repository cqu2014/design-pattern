package pattern.strategy;

import cn.hutool.core.lang.Console;
import pattern.enums.DirectionEnum;

/**
 * @author Oliver Wang
 * @description 马移动的规则
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/25
 * @since
 */
public class HorseMoveStrategy implements IChineseChessTranslate{

    /**
     * 还可以按照方向使用工厂方法生成移动策略
     *
     * @param direction
     * @return
     */
    @Override
    public boolean move(DirectionEnum direction) {
        Console.log("马向 {} 走日移动",String.valueOf(direction));
        switch (direction){
            case UP:
                Console.log("纬度增加2，经度增加1或者减少1");
                break;
            case DOWN:
                Console.log("纬度减少2，经度增加1或者减少1");
                break;
            case LEFT:
                Console.log("经度减少2，维度增加1或者减少1");
                break;
            case RIGHT:
                Console.log("经度增加2，维度增加1或者减少1");
                break;
            default:
                throw new RuntimeException("HorseMoveStrategy error");
        }
        return true;
    }
}
