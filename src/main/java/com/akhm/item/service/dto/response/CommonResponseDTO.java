package com.akhm.item.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponseDTO<T> {
	private boolean success;
	private String message;
	private T data;
	private int statusCode;

}
