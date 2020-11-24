package pattern.proxy.dynamics;

import org.junit.Test;
import pattern.proxy.BankClerk;
import pattern.proxy.IBankVault;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class BankClerkHandlerTest {

  @Test
  public void invoke() {
      BankClerk bankClerk = new BankClerk("猪八戒");
      BankClerkHandler bankClerkHandler = new BankClerkHandler(bankClerk);
      IBankVault proxyInstance = (IBankVault) Proxy.newProxyInstance(bankClerk.getClass().getClassLoader(),
              bankClerk.getClass().getInterfaces(), bankClerkHandler);
      System.out.println("成功存储"+proxyInstance.withdraw(123.56)+"元");
      proxyInstance.save(25.36);
  }

  @Test
  public void proxyFactory(){
      IBankVault proxyInstance = (IBankVault) BankClerkHandler.proxyFactory(new BankClerk("猪八戒"));
      System.out.println("成功存储" + proxyInstance.withdraw(12345.00) + "元");
  }
}