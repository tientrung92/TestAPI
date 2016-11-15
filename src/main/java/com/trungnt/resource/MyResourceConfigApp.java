package com.trungnt.resource;

import org.glassfish.jersey.server.ResourceConfig;

public class MyResourceConfigApp extends ResourceConfig {
  /**
   * Initialize resource configuration constructor.
   */
  public MyResourceConfigApp() {
    packages("com.trungnt.resource");
    register(com.trungnt.filters.CORSRespFilter.class);

  }
}
