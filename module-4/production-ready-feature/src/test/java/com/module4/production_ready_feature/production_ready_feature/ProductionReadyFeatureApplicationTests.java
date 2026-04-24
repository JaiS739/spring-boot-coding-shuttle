package com.module4.production_ready_feature.production_ready_feature;

import com.module4.production_ready_feature.production_ready_feature.clients.EmployeeClient;
import com.module4.production_ready_feature.production_ready_feature.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductionReadyFeatureApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployee(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployee();
		System.out.println("employeeDTOList " + employeeDTOList);
	}

	@Test
	void getEmployeeId(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(2L);
		System.out.println("employeeDTO " + employeeDTO);
	}

}
