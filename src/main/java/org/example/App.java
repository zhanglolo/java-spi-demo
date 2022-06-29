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
