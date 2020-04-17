package com.cmpy.group.example.api;

import com.cmpy.group.common.api.CommonResponse;
import com.cmpy.group.common.auth.AuthConstant;
import com.cmpy.group.common.validation.Group2;
import com.cmpy.group.example.constant.ExampleConst;
import com.cmpy.group.example.dto.ExampleReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

;

@FeignClient(name = ExampleConst.SERVICE_NAME, path = "/v1/company", url = "${staffjoy.company-service-endpoint}")
public interface CompanyClient {

    // ExampleApi
    @PostMapping(path = "/post")
    CommonResponse<String> createCompany(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz,
                                         @RequestBody @Validated({Group2.class}) ExampleReq exampleReq);

    @GetMapping(path = "/get")
    CommonResponse<String> listCompanies(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz,
                                         @RequestParam int offset, @RequestParam int limit);

}
