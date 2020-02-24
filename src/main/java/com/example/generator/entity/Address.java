package com.example.generator.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Address {

	public enum AddressType {
		BILLING, DELIVERY;
	}

	private @Id @GeneratedValue Long id;

	private String line1;

	private String line2;

	private String city;

	private String state;

	private String country;

	private AddressType addressType;
}
