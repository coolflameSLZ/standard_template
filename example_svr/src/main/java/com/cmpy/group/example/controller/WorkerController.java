package com.cmpy.group.example.controller;

import com.cmpy.group.common.api.CommonResponse;
import com.cmpy.group.common.auth.AuthConstant;
import com.cmpy.group.common.auth.AuthContext;
import com.cmpy.group.common.auth.Authorize;
import com.cmpy.group.example.dto.ExampleReq;
import com.cmpy.group.example.service.PermissionService;
import com.cmpy.group.example.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/company/worker")
@Validated
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @Autowired
    PermissionService permissionService;


    @GetMapping(path = "/get")
    @Authorize(value = {
            AuthConstant.AUTHORIZATION_AUTHENTICATED_USER,
            AuthConstant.AUTHORIZATION_SUPPORT_USER,
            AuthConstant.AUTHORIZATION_WWW_SERVICE
    })
    public CommonResponse<String> getWorker(@RequestParam String companyId,
                                            @RequestParam String teamId,
                                            @RequestParam String userId) {

        if (AuthConstant.AUTHORIZATION_AUTHENTICATED_USER.equals(AuthContext.getAuthz())) {
            permissionService.checkPermissionTeamWorker(companyId, teamId);
        }

        return CommonResponse.success();
    }

    @DeleteMapping(path = "/delete")
    @Authorize(value = {
            AuthConstant.AUTHORIZATION_AUTHENTICATED_USER,
            AuthConstant.AUTHORIZATION_SUPPORT_USER
    })
    public CommonResponse<String> deleteWorker(@RequestBody @Validated String workid) {
        return CommonResponse.success();
    }

    @PostMapping(path = "/create")
    @Authorize(value = {
            AuthConstant.AUTHORIZATION_AUTHENTICATED_USER,
            AuthConstant.AUTHORIZATION_SUPPORT_USER,
            AuthConstant.AUTHORIZATION_WWW_SERVICE,
            AuthConstant.AUTHORIZATION_WHOAMI_SERVICE
    })
    public CommonResponse<String> createWorker(@RequestBody @Validated ExampleReq req) {
        return CommonResponse.success();
    }
}
