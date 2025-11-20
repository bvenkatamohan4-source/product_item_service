package com.akhm.item.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.akhm.item.repository.entity.ProductItemEntity;
import com.akhm.item.service.dto.ProductItemDTO;
import com.akhm.item.service.dto.SaveProductItemDTO;

@Mapper(componentModel = "spring")
public interface ProductItemMapper  {
	ProductItemMapper INSTANCE = Mappers.getMapper(ProductItemMapper.class);

	ProductItemEntity toEntity(SaveProductItemDTO saveProductItemDTO);
	ProductItemDTO toDto(ProductItemEntity productItemEntity);
	
	
}
