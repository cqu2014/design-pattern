package pattern.strategy.client.piece;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pattern.enums.DirectionEnum;
import pattern.strategy.IChineseChessTranslate;
import pattern.strategy.client.IChineseChessPiece;
import pattern.strategy.client.Index;

/**
 * @author Oliver Wang
 * @description 马 走日
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/10
 * @since
 */
@Getter
@RequiredArgsConstructor
public class Horse extends Index implements IChineseChessPiece {
    private final IChineseChessTranslate translate;
    private final Index index;

    @Override
    public void move(DirectionEnum directionEnum) {
        // 校验是否能走抛异常回退
        check(directionEnum);
        // 根据马移动策略移动
        translate.move(directionEnum);
        // 处理是否删除棋子 刷新Context

    }

    @Override
    public Index position() {
        return null;
    }

    @Override
    public boolean check(DirectionEnum directionEnum) {
        return false;
    }

    @Override
    public void removePiece() {

    }
}
