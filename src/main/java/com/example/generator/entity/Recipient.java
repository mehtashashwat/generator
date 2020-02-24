package com.example.generator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
public class Recipient {
	private BasicProfile basicProfile;

	@JsonProperty("addresses")
	private List<Address> addresses;
}
