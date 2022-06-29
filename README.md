# Java SPI  (Service Provider Interface) 简易demo

#### SPI接口 `Connectable`

```other
package org.example;

public interface Connectable {
  String getConnection();
}
```

#### SPI接口的实现类 `AConnect` `BConnect`

```other
package org.example;

public class AConnect implements Connectable{
  @Override
  public String getConnection() {
    return "A";
  }
}
```

```other
package org.example;

public class BConnect implements Connectable{
  @Override
  public String getConnection() {
    return "B";
  }
}
```

#### `classpath`下的META-INF/services/目录里创建一个以服务接口命名的文件

文件名`org.example.Connectable` ,文件内容：

```other
org.example.AConnect
org.example.BConnect
```

每一个服务提供类写一行

#### 服务调用

```other
package org.example;

import java.util.ServiceLoader;

public class App {
  public static void main( String[] args ) {
    ServiceLoader<Connectable> load = ServiceLoader.load(Connectable.class);
    for (Connectable connectable : load) {
      System.out.println(connectable);
      System.out.println(connectable.getConnection());
    }
  }
}
```

```other
org.example.AConnect@f6f4d33
A
org.example.BConnect@3f99bd52
B
```

