package pattern.strategy;

import cn.hutool.core.lang.Console;
import pattern.enums.DirectionEnum;

/**
 * @author Oliver Wang
 * @description 炮移动规则
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/25
 * @since
 */
public class CannonMoveStrategy implements IChineseChessTranslate{
    @Override
    public boolean move(DirectionEnum direction) {
        Console.log("炮向 {} 翻山移动",String.valueOf(direction));
        switch (direction){
            case UP:
                Console.log("纬度增加 N，经度保持不变");
                break;
            case DOWN:
                Console.log("纬度减少 N，经度保持不变");
                break;
            case LEFT:
                Console.log("经度减少 N，纬度保持不变");
                break;
            case RIGHT:
                Console.log("经度增加 N，纬度保持不变");
                break;
            default:
                throw new RuntimeException("CannonMoveStrategy error");
        }
        return true;
    }
}
