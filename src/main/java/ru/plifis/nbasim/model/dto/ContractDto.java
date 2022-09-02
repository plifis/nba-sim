package ru.plifis.nbasim.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ContractDto {
    private Long id;
    private BigDecimal salary;
    private Integer length;

}
