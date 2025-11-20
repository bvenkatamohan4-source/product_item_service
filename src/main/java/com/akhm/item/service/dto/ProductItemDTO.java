package com.akhm.item.service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductItemDTO extends SaveProductItemDTO {
	
	private static final long serialVersionUID = -2143857536557110367L;
	private String status;
	private Long createdBy;
	private Long updatedBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
