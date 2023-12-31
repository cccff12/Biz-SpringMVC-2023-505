package com.callor.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.car.model.CarDto;
import com.callor.car.persistance.CarDao;
import com.callor.car.service.CarService;

@Service
public class CarServiceImplV1 implements CarService {

	protected final CarDao carDao;

	public CarServiceImplV1(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public CarDto findTachoByCarNum(String carnum) {
		return carDao.findTachoByCarNum(carnum);

	}

	@Override
	public int insert(CarDto carDto) {
		return carDao.insert(carDto);
	}

	@Override
	public List<CarDto> selectAll() {
//		carDao에게 데이터를 받는다
		return carDao.selectAll();
	}

//	annotation이 autowired다.
	/*
	 * method에 매개변수를 자동으로 주입해 달라는 요청
	 * 프로젝트가 시작되면 자동으로 실행
	 */
	@Autowired
	public void create_table() {
		carDao.create_carm_table(null);
	}
	
	
	
}
