package com.svc.swing.web;

import com.svc.swing.domain.Svc;
import com.svc.swing.domain.SvcRepositorySupport;
import com.svc.swing.dto.CustResponseDto;
import com.svc.swing.dto.SvcSaveRequestDto;
import com.svc.swing.service.SvcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SvcApiController {
    private final SvcService svcService;
    private final SvcRepositorySupport svcRepositorySupport;

    private final RestTemplate restTemplate;

    @PostMapping("/api/v1/svc")
    public void save(@RequestBody SvcSaveRequestDto requestDto) {
        svcService.saveService(requestDto);
    }

    @GetMapping("/api/v1/svc/{svcnum}")
    public List<Svc> find(@PathVariable String svcnum) {
        return svcRepositorySupport.findBySvcnum(svcnum);
    }

    @GetMapping("/api/v1/cust/{custnum}")
    public CustResponseDto find(@PathVariable int custnum) {
        String url = String.format("http://localhost:8090/api/v1/cust/%s", custnum);

        ResponseEntity<CustResponseDto> responseData = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                CustResponseDto.class);

        return responseData.getBody();
    }
}
