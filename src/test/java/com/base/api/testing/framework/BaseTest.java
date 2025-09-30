package com.base.api.testing.framework;

import com.base.api.testing.framework.config.TestConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
public class BaseTest {
}
