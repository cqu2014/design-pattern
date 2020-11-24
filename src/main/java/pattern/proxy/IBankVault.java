package pattern.proxy;

/**
 * @Author Oliver Wang
 * @Description 银行金库
 * @Created by IntelliJ IDEA 2020.02
 * @Date Create at 2020/11/24
 * @Since
 */

public interface IBankVault {

    /**
     * 取钱
     *
     * @param money
     * @return
     */
    Double withdraw(double money);

    /**
     * 存钱
     *
     * @param money
     */
    void save(double money);
}