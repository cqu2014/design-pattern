package pattern.strategy;

import pattern.enums.DirectionEnum;

/**
 * @Author Oliver Wang
 * @Description 中国象棋移动规则
 * @Created by IntelliJ IDEA 2020.02
 * @Date Create at 2020/11/25
 * @Since
 */

public interface IChineseChessTranslate {
    /**
     * 按照不同的方向移动
     *
     * @param direction
     * @return
     */
    boolean move(DirectionEnum direction);
}
