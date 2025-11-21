package com.akhm.item.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akhm.item.exception.ApplicationException;
import com.akhm.item.exception.DuplicateItemCodeException;
import com.akhm.item.exception.InvalidRequestException;
import com.akhm.item.repository.ProductItemEntityRepository;
import com.akhm.item.repository.entity.ProductItemEntity;
import com.akhm.item.service.ProductItemService;
import com.akhm.item.service.dto.ProductItemDTO;
import com.akhm.item.service.dto.SaveProductItemDTO;
import com.akhm.item.service.mapper.ProductItemMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductItemServiceImpl implements ProductItemService {

	private final ProductItemEntityRepository productItemEntityRepository;
	private final ProductItemMapper productItemMapper;

	public ProductItemServiceImpl(ProductItemEntityRepository productItemEntityRepository,
			ProductItemMapper productItemMapper) {
		super();
		this.productItemEntityRepository = productItemEntityRepository;
		this.productItemMapper = productItemMapper;
	}

	@Override
	@Transactional
	public ProductItemDTO saveProductItem(SaveProductItemDTO saveProductItemDTO) {
		log.info("saveProductItem() started");
		if (saveProductItemDTO == null) {
			log.error("saveProductItemDTO is null");
			throw new InvalidRequestException("request body must be entered");

		}
		if (productItemEntityRepository.existsByItemCode(saveProductItemDTO.getItemCode())) {
			log.warn("duplicateItemCodeFound :{}", saveProductItemDTO.getItemCode());
			throw new DuplicateItemCodeException("item code must be unique");

		}
		try {
			ProductItemEntity productItemEntity = productItemMapper.toEntity(saveProductItemDTO);
			log.debug("mapped productItemEntity:{}", productItemEntity);
			if (productItemEntity != null) {
				ProductItemEntity savedProductItemEntity = productItemEntityRepository.save(productItemEntity);
				if (savedProductItemEntity != null) {
					log.info("productItem saved successfully with id:{}", savedProductItemEntity.getProductItemId());
					return productItemMapper.toDto(savedProductItemEntity);

				}

			}
		} catch (Exception e) {
			log.error("unknown error occured by saving productItemDetails", e.getMessage());
			throw new ApplicationException("fail to save product Item", e);

		}
		log.info("saveProductItem() ended");
		return null;
	}

}
