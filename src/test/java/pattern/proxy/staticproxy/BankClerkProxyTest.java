package pattern.proxy.staticproxy;

import org.junit.Test;
import pattern.proxy.BankClerk;

public class BankClerkProxyTest {

  @Test
  public void withdraw() {
      BankClerk bankClerk = new BankClerk("猪八戒");
      BankClerkProxy clerkProxy = new BankClerkProxy(bankClerk);
      System.out.println("成功存储"+clerkProxy.withdraw(123.36)+"元");
      clerkProxy.save(123.5);
  }
}