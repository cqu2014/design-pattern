package pattern.strategy.client;

import pattern.enums.DirectionEnum;

/**
 * @Author Oliver Wang
 * @Description 中国象棋棋子父类
 * @Created by IntelliJ IDEA 2020.02
 * @Date Create at 2020/11/25
 * @Since
 */

public interface IChineseChessPiece {
    /**
     * 移动
     *
     * @param directionEnum
     */
    void move(DirectionEnum directionEnum);

    /**
     * 获取当前棋子的位子
     *
     * @return
     */
    Index position();

    /**
     * 判断是否可以移动
     *
     * @param directionEnum
     * @return
     */
    boolean check(DirectionEnum directionEnum);

    /**
     * 吃掉对方棋子
     */
    void removePiece();
}
