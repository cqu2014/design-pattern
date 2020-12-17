package pattern.strategy.client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oliver Wang
 * @description 棋盘上下文环境,全局唯一
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/10
 * @since
 */
public final class CheckerboardContext {
    // 活着的棋子位置
    List<IChineseChessPiece> alivePiece = new ArrayList<>(2<<4);
}
