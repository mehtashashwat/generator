package com.example.generator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
public class Order {

	private String orderId;

	@JsonProperty("products")
	private List<Product> listProduct;

	private Recipient recipient;

}
