package pattern.io.processcontrol;

/**
 * @author Oliver Wang
 * @description 执行进程异常
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2021/2/10
 * @since
 */
public class OSExecuteException extends RuntimeException{
    public OSExecuteException(String message){
        super(message);
    }
}
