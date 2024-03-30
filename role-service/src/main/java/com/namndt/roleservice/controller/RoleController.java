package com.namndt.roleservice.controller;

import com.namndt.roleservice.response.RoleResponse;
import com.namndt.roleservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity<RoleResponse> getRoleByName(@RequestParam String roleName){
        RoleResponse roleResponse = roleService.getRoleByName(roleName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleResponse);
    }
}
