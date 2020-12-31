package pattern.observe;

import cn.hutool.core.util.IdUtil;
import org.junit.Before;
import org.junit.Test;
import pattern.observe.event.CustomEvent;
import pattern.observe.listener.EventListenerChina;
import pattern.observe.listener.EventListenerRussia;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class EventBusUtilTest {
    EventListenerChina listenerChina;
    EventListenerRussia listenerRussia;
    CustomEvent customEvent;

  @Before
  public void setUp() {
      listenerChina = new EventListenerChina();
      listenerRussia = new EventListenerRussia();
      customEvent = new CustomEvent("Trump",32);
      EventBusUtil.register(listenerChina);
      EventBusUtil.register(listenerRussia);

  }

  @Test
  public void post() {
      EventBusUtil.post(customEvent);
      EventBusUtil.post(new Object());
  }

  @Test
  public void asyncPost() {
      EventBusUtil.asyncPost(customEvent);

      try {
          TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

  @Test
  public void uuid(){
    System.out.println(UUID.randomUUID());
    System.out.println(IdUtil.simpleUUID());
  }
}