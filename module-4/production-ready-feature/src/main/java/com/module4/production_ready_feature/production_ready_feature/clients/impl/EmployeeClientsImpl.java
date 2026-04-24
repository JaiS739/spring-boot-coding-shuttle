package com.module4.production_ready_feature.production_ready_feature.clients.impl;

import com.module4.production_ready_feature.production_ready_feature.clients.EmployeeClient;
import com.module4.production_ready_feature.production_ready_feature.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientsImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientsImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        log.error("error log");
        log.warn("warn log");
        log.info("info log");
        log.debug("debug log");

        try {
            log.info("api call success");
            return restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<EmployeeDTO>>() {});
        } catch (Exception e) {
            log.error("error in getAllEmployee", e);
            throw new RuntimeException(e); // don't swallow exception
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId){
        try{
            return restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<EmployeeDTO>() {});
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    };
}
