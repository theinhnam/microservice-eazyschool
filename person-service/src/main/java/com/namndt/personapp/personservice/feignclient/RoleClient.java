package com.namndt.personapp.personservice.feignclient;

import com.namndt.personapp.personservice.response.RoleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "role-service", path = "/role-app/api")
public interface RoleClient {

    @GetMapping("/role")
    public ResponseEntity<RoleResponse> getRoleByName(@RequestParam String roleName);
}
