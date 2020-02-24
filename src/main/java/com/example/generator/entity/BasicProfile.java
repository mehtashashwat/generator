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
public class BasicProfile {

	private @Id @GeneratedValue Long id;

	private String name;

	private String phoneNumber;

	private String email;
}
