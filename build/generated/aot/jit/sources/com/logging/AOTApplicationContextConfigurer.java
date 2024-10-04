package com.logging;

import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.context.ApplicationContextConfigurer;
import java.lang.Override;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AOTApplicationContextConfigurer implements ApplicationContextConfigurer {
  static {
  }

  private static List list0() {
    return Collections.emptyList();
  }

  @Override
  public void configure(ApplicationContextBuilder builder) {
    builder.properties(new HashMap() {{
        put("micronaut.aot.enabled", true);
        put("micronaut.aot.runtime", "JIT");
        put("micronaut.aot.optimizations", list0());
        }});
  }
}
