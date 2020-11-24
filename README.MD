## 代理模式
#### 静态代理
1. proxy同被代理的类Subject共同实现功能接口（功能抽象类）
2. proxy中引用Subject并在初始化时传入，基于Subject对象完成方法的实现并添加格外功能
##### 缺点
一个被代理类对应一个Proxy类，导致类的数据成倍递增，增加了项目复杂度和维护难度
#### 动态代理
1. JDK提供InvocationHandler接口和Proxy类来完成动态代理功能
2. InvocationHandler基于被代理类Subject的实例来完成对应业务逻辑并实现定制外逻辑(invoke中操作的是subject独享，不要调用代理对象proxy的方法OOM)
3. Proxy通过静态方法动态生成代理类对象并绑定InvocationHandler
4. 一般在InvocationHandler实现类中实现ProxyFactory以简化代码