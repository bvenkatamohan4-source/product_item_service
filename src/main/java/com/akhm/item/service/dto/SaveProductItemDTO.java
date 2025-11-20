package com.akhm.item.service.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveProductItemDTO implements Serializable {

	private static final long serialVersionUID = 7239235688230017796L;
	@NotNull
	private Long catagoryId;
	@NotNull
	private Long productId;
	@NotBlank(message = "item is manatory")
	@Pattern(regexp = "^[A-Z a-z]+([A-Za-z0-9]+)*$", message ="item name must be starts with alphabet ,alphaNumeric allowed and no leading/training")
	private String itemName;
	@NotBlank(message = "item  is manatory")
	@Pattern(regexp = "^[A-Z a-z]+([A-Za-z0-9]+)*$", message ="item name must be starts with alphabet ,alphaNumeric allowed and no leading/training")
	private String itemDiscripution;
	private String itemCode;
	private String itemImage;
	private Integer itemQuantity;
	private Double price;

}
