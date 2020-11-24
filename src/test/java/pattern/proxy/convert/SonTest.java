package pattern.proxy.convert;

import org.junit.Test;

import static org.junit.Assert.*;

public class SonTest {

  @Test
  public void say() {
      Father father = new Son("孙悟空");
      father.say();
      //father.say("齐天大圣");无法调用
      Son son = (Son) father;
      son.say();
      son.say("齐天大圣");

      father = new Father("孙悟空");
      // throw java.lang.ClassCastException
      son = (Son) father;
  }
}