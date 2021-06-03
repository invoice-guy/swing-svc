package com.svc.swing.dto;

import com.svc.swing.domain.Svc;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SvcSaveRequestDto {
    private int id;

    private String svcnum;
    private String svcstcd;
    private String svcscrbdt;
    private String svctermdt;

    private int custnum;


    @Builder
    public SvcSaveRequestDto(String svcnum, String svcstcd, String svcscrbdt, String svctermdt) {
        this.svcnum=svcnum;
        this.svcstcd=svcstcd;
        this.svcscrbdt=svcscrbdt;
        this.svctermdt=svctermdt;
        this.custnum=custnum;
    }


    public Svc toEntity() {
        return Svc.builder()
                .svcnum(svcnum)
                .svcstcd(svcstcd)
                .svcscrbdt(svcscrbdt)
                .svctermdt(svctermdt)
                .custnum(custnum)
                .build();
    }

}
