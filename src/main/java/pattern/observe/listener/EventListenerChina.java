package pattern.observe.listener;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.google.common.eventbus.Subscribe;
import pattern.observe.event.CustomEvent;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author Oliver Wang
 * @description 检测者
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/17
 * @since
 */
public class EventListenerChina {

    @Subscribe
    public void onEvent(CustomEvent event){
        Console.log("{} EventListenerChina1 -->订阅消息{}，线程{}", Instant.now(),
                JSONUtil.toJsonStr(event),Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void onEvent1(CustomEvent event){
        Console.log("{} EventListenerChina2-->订阅消息{}，线程{}", Instant.now(),
                JSONUtil.toJsonStr(event),Thread.currentThread().getName());
    }
}
