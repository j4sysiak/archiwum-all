package com.example.demo.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class DemoApplicationTests {

	Calculator calculator = new Calculator();

	@Test
	void itShouldAddNumbers() {
		//given
		int a = 10;
		int b = 20;

		//when
		int result = calculator.add(a, b);

		//then
		int expected = 30;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator {

		public int add(int numbA, int numbB) {
			return numbA + numbB;
		}
	}

}
