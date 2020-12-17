package pattern.observe;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.Objects;
import java.util.concurrent.Executors;

/**
 * @author Oliver Wang
 * @description
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/17
 * @since
 */
public class EventBusUtil {
    private volatile static EventBus eventbus;
    private volatile static AsyncEventBus asyncEventBus;

    /**
     * 双重锁 单例 AsyncEventBus
     *
     * @return AsyncEventBus
     */
    private static AsyncEventBus getAsyncEventBus(){
        if (Objects.isNull(asyncEventBus)){
            synchronized(AsyncEventBus.class){
                if (Objects.isNull(asyncEventBus)){
                    asyncEventBus = new AsyncEventBus(
                            Executors.newFixedThreadPool(3)
                    );
                }
            }
        }
        return asyncEventBus;
    }

    private static EventBus getEventBus(){
        if (Objects.isNull(eventbus)){
            synchronized(EventBus.class){
                if (Objects.isNull(eventbus)){
                    eventbus = new EventBus("Oliver event bus");
                }
            }
        }
        return eventbus;
    }

    /**
     * 发布事件 订阅者在publisher线程中依次执行
     *
     * @param event
     */
    public static void post(Object event){
        getEventBus().post(event);
    }

    /**
     * 发布事件 多个订阅者在AsyncEventBus线程池中并发执行
     *
     * @param event
     */
    public static void asyncPost(Object event){
        getAsyncEventBus().post(event);
    }

    /**
     * 同时注册同步异步监听者
     *
     * @param listener
     */
    public static void register(Object listener){
        getEventBus().register(listener);
        getAsyncEventBus().register(listener);
    }

}
