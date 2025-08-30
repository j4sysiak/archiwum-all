package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class DemoApplicationTests {

	Calculator undertest = new Calculator();

	@Test
	void itShouldAddTwoNumbers() {
		//given
		int x=20;
		int y=30;

		//when
		int result = undertest.add(x, y);

		//then
		assertThat(result).isEqualTo(50);

	}

	class Calculator {
		int add(int a, int b) {
			return a+b;
		}
	}

}
