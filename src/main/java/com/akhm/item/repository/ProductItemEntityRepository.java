package com.akhm.item.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.item.repository.entity.ProductItemEntity;

@Repository
public interface ProductItemEntityRepository extends JpaRepository<ProductItemEntity, UUID> {

}
