package com.coding_shuttle.rest.rest_api.repository;

import com.coding_shuttle.rest.rest_api.entity.EmployeeEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
