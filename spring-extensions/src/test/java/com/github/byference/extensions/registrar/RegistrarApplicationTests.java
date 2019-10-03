package com.github.byference.extensions.registrar;

import com.github.byference.extensions.registrar.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrarApplicationTests {

	@Autowired
	private TestMapper testMapper;

	@Test
	public void testMapperTest() {

		assert "proxy: name".equals(testMapper.name());
		assert "proxy: echo".equals(testMapper.echo());
	}
}
