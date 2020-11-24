package pattern.proxy;

import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author Oliver Wang
 * @description 银行职员
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/24
 * @since
 */
@AllArgsConstructor
@Setter
public class BankClerk implements IBankVault {
    private String name;

    @Override
    public Double withdraw(double money) {
        Console.log("BankClerk {} start withdraw {}",name,money);
        return money;
    }

    @Override
    public void save(double money) {
        Console.log("BankClerk {} start save {}",name,money);
    }
}
