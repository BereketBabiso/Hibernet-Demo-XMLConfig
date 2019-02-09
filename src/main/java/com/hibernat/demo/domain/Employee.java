package com.hibernat.demo.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee implements Serializable {

	private long id;
	private String name;
	private double salary;
}
