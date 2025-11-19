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
	@Column(name = "PRODUCT_ITEM_ID")
	private UUID productItemId;
	@Column(name = "N_CATAGORY_ID")
	private Long catagoryId;
	@Column(name = "PRODUCT_ID")
	private Long productId;
	@Column(name = "C-ITEM_NAME")
	private String itemName;
	private String itemDiscripution;
	private String itemCode;
	private String itemImage;
	private Integer itemQuantity;
	private Double price;
	private String status;
	@Column(name = "")
	private Long createdBy;
	private Long updatedBy;
	@Column(name = "D_CREATED_AT")
	private LocalDateTime createdAt;
	@Column(name = "D_UPDATED_AT")
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePrastis() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
