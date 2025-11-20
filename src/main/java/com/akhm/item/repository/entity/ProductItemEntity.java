package com.akhm.item.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_ITEM_TL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductItemEntity implements Serializable {
	
	private static final long serialVersionUID = 5181519932155305626L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "PRODUCT_ITEM_ID",length = 50,nullable = false,unique = true)
	private UUID productItemId;
	@Column(name = "N_CATAGORY_ID",length = 50,nullable = false,unique = true)
	private Long catagoryId;
	@Column(name = "N_PRODUCT_ID",length = 50,nullable = false,unique = true)
	private Long productId;
	@Column(name = "C_ITEM_NAME",length = 50,nullable = false,unique = false)
	private String itemName;
	@Column(name = "C_ITEM_DISCRIPUTION",length = 500,nullable = false,unique = false)
	private String itemDiscripution;
	@Column(name =" C_ITEM_CODE",length = 50,nullable = false,unique = false)
	private String itemCode;
	@Column(name = "ITEM_IMAGE",length = 50,nullable = false,unique = false)
	private String itemImage;
	@Column(name = "D_ITEM_QUANTITY",length = 50,nullable = false,unique = false)
	private Integer itemQuantity;
	@Column(name = "D_PRICE",length = 50,nullable = false,unique = false)
	private Double price;
	@Column(name = "C_STATUS",length = 50,nullable = false,unique = false)
	private String status;
	@Column(name = "N_CREATED_BY",length = 50,nullable = false,unique = false)
	private Long createdBy;
	@Column(name = "N_UPDATED_AT",length = 50,nullable = false,unique = false)
	private Long updatedBy;
	@Column(name = "D_CREATED_AT",nullable = false,updatable = false)
	private LocalDateTime createdAt;
	@Column(name = "D_UPDATED_AT",nullable = true,updatable = true)
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
