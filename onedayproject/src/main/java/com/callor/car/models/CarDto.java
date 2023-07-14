package com.callor.car.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDto {
	private int c_seq;
	private String c_type;
	private String c_startday;
	private String c_starttime;
	private String c_startdistance;
	private String c_arrival;
	private String c_arrivaltime;
	private String c_arrivaldistance;
	private String c_place;
	private String c_pay;

}
