package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.address.dao.AddrDao;
import com.callor.address.dao.BuyerDao;
import com.callor.address.dao.ScoreDao;
import com.callor.address.models.AddrDto;
import com.callor.address.service.AddrService;

@Service
public class AddrServiceImplV1 implements AddrService {
// final 을 쓸거면 생성자에서 초기화를 해야한다.

	/*
	 * 의존성 주입(Dependency Inject: DI) 객체를 선언하고, 클래스의 생성자를 통해 객체를 초기화 하는 java의 전통적인
	 * 객체생성 코드와 대비되는 Spring Framework Project 의 독특한 기법 객체를 선언만 하고, 의존성 주입 절차를 수행하면
	 * Spring Container 에 의해 이미 생성되어 준비된 객체를 주입해주는 기능
	 * 
	 * 의존성 주입을 하는 3가지 방법 1. 필드 주입 2. 생성자 주입 3. setter 주입
	 * 
	 */

//	1. 필드 의존성 주입(field Dependency Inject)
	/*
	 * 필드 (클래스 영역)에 객체를 선언하고 @Autowired 를 부착하는 방법 Spring Project의 전통적인 코딩에서 가장 많이
	 * 사용하던 방법 이 방법이 메모리 관리 측면에서 문제가 있다는 보고가 있으면서 사용이 점차 줄어들고 있다. 이 방법은 메모리 누수를 줄이기
	 * 위하여 객체를 private로 선언할 것을 권장하는 방법이다. 객체를 private로 선언하면 상속(extend)했을 때 다시 객체를
	 * 선언해야 하는 문제가 발생한다.
	 * 
	 * 참고로 메모리 누수 정보 public > protected > private 순으로 작아진다
	 */
	protected BuyerDao buyerDao;

// 2. 생성자 의존성 주입(constructor DI)
	/*
	 * 생성자를 통해서 주입될 객체는 final로 선언을 한다 이 방식의 특징은 한 번 주입이 되면, 코드가 작동되는 중에 또 다시 주입을 할 수
	 * 없다. 즉 객체 보호가 완전하다 객체의 순환참조가 없다 이 방식은 메모리 누수가 없고, 객체가 보호되며, 순환참조에 의한 코드의
	 * exception을 막는다.
	 * 
	 * @Autowired를 안붙여도 된다.
	 * 
	 * 이 방식을 사용하려면 반드시 생성자 메서드가 있어야 한다. 코드가 다소 번잡해 진다. 실수로 생성자 메서드를 만들지 않았을 경우
	 * Nullpointer exception이 발생한다.
	 */

	protected final AddrDao addrDao;

	public AddrServiceImplV1(AddrDao addrDao) {
		this.addrDao = addrDao;

	}

//	3. setter 의존성 주입(Setter DI)
	/*
	 * 객체를 필드영역에 선언만 하고 별도의 메서드를 통하여 주입을 하는 방법
	 * 
	 * 단점: method가 public으로 완전 개방된 상태이기 때문에 누군가 실수나 임의로 객체를 변경 할 수 있다.
	 * 
	 * 
	 */

	protected ScoreDao scoreDao;

	@Autowired
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
	public List<AddrDto> selectAll() {
		return addrDao.selectAll();
	}

	@Override
	public AddrDto findById(String id) {
		return addrDao.findById(id);
	}

	@Override
	public String idCheck(String id) {

		AddrDto dto = addrDao.findById(id);
		if (dto == null)
			return "OK";
		else
			return "FAIL";

	}

	@Override
	public List<AddrDto> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddrDto> findByTel(String Tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(AddrDto addrDto) {

		int result = addrDao.insert(addrDto);
		return result;
	}

	@Override
	public int update(AddrDto addrDto) {
		int result = addrDao.update(addrDto);

		return result;
	}

	@Override
	public int delete(String id) {
		int result = addrDao.delete(id);
		return result;
	}

}