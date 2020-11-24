package pattern.proxy.staticproxy;

import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;
import lombok.Setter;
import pattern.proxy.BankClerk;
import pattern.proxy.IBankVault;

/**
 * @author Oliver Wang
 * @description 银行职员代理类
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/24
 * @since
 */
@AllArgsConstructor
@Setter
public class BankClerkProxy implements IBankVault {

    private BankClerk bankClerk;

    @Override
    public Double withdraw(double money) {
        Console.log("BankClerkProxy 权鉴成功，开始 withdraw ...");
        return bankClerk.withdraw(money);
    }

    @Override
    public void save(double money) {
        Console.log("BankClerkProxy 权鉴成功，开始 save ...");
        bankClerk.save(money);
    }
}
