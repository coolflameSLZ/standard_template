package com.cmpy.group.example.dto;

import com.cmpy.group.common.validation.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleResp {
    @NotBlank
    private String companyId;

    @NotBlank
    private String teamId;

    private String userId;

    private String jobId;

    @NotNull
    private Instant shiftStartAfter;

    @NotNull
    private Instant shiftStartBefore;

    private List<String> teams = new ArrayList<>();

    @DayOfWeek
    @NotBlank
    private String dayWeekStarts;

    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
    @NotBlank
    private String color;

    @AssertTrue(message = "开始时间必须小于结束时间")
    private boolean correctAfterAndBefore() {
        long duration = shiftStartAfter.toEpochMilli() - shiftStartBefore.toEpochMilli();
        return duration < 0;
    }


}
