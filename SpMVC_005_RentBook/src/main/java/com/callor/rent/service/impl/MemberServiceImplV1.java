package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.MemberDao;
import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.MEMBER_V1)
public class MemberServiceImplV1 implements MemberService {

	protected final MemberDao memberDao;

	public MemberServiceImplV1(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}

	/*
	 * 회원을 동록 할 때 밑에서 가져와 새로운 코드를 생성하여 memberDto 에 업데이트 하고 회원정보 insert하기
	 */
	@Override
	public int insert(MemberDto memberDto) throws Exception {

//		.trim() white space 제거하기
		String tel = memberDto.getM_tel().trim();
		String name = memberDto.getM_name().trim();

//		  이름 + 전화번호가 중복되지 않도록 하기
		MemberDto resultDto = memberDao.findNameAndTel(name, tel);
//		이름 +전화번호가 중복된 경우
		if (resultDto != null) {
			throw new Exception("NAME_TEL");
		}

		String mCode = this.getNewCode();
		memberDto.setM_code(mCode);

		return memberDao.insert(memberDto);
	}

	@Override
	public String getNewCode() {
		String mCode = memberDao.getMaxMCode();
//		db는 처음에 아무것도 없는 null 값이기에 값 추가
		String newCode = "000001";
		if (mCode != null) {
//			가져와서 +1한 후 문자열로 변환하는 코드
			newCode = String.format("%06d", Integer.valueOf(mCode) + 1);
		}
		return newCode;
	}

	@Override
	public List<MemberDto> selectAll() {
		return memberDao.selectAll();
	}

	@Autowired
	public void create_member_table() {
		memberDao.create_member_table(null);
	}

	@Override
	public MemberDto findById(String bcode) {
		return memberDao.findById(bcode);
	}

	@Override
	public int update(MemberDto memberDto) throws Exception {

		String name = memberDto.getM_name().trim();
		String tel = memberDto.getM_tel().trim();

		MemberDto resultDto = memberDao.findNameAndTel(name, tel);

		/*
		 * 수정하기 위해 입력한 이름과 전화번호로 SELECT를 했는데 같은 데이터가 있다면 1. 만약 m_code가 같다. : 이름과 전화번호를
		 * 변경하지 않고 저장하기를 클릭했다. 2. 만약 m_code가 다르다: 이미 등록된 회원의 이름 전화번호로 다시 수정을 시도하였다. =>
		 * 중복 데이터 오류
		 */
		if (resultDto != null && resultDto.getM_code().equals(memberDto.getM_code())) {
			throw new Exception("NAME_TEL");
		}
		return memberDao.update(memberDto);
	}
}
