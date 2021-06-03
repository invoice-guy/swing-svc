package com.svc.swing.service;

import com.svc.swing.domain.SvcRepository;
import com.svc.swing.dto.SvcSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SvcService {
    private final SvcRepository svcRepository;

    @Transactional
    public void saveService(SvcSaveRequestDto requestDto) {
        svcRepository.save(requestDto.toEntity());
    }

}
