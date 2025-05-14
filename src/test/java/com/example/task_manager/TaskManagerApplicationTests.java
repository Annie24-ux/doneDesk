package com.example.task_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class TaskManagerApplicationTests {

	@Test
	void contextLoads() {
	}

}
