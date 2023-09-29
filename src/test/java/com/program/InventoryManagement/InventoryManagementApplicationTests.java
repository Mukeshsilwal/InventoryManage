package com.program.InventoryManagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class InventoryManagementApplicationTests {
	public Calculator calculator=new Calculator();

	@Test
	void checkAddNumber() {
		int num1=30;
		int num2=40;
		int result=calculator.addNumber(num1,num2);
		assertThat(result).isEqualTo(70);
	}

	class Calculator{
		int addNumber(int a,int b){
			return a+b;
		}
	}

}
