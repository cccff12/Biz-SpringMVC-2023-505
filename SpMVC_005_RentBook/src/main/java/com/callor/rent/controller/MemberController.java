package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/member")
public class MemberController {

//		Spring container 에게 memberservice 객체가 필요하니 주입하는 코드(dependeccy injection)	
	protected final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<MemberDto> memberList = memberService.selectAll();
		model.addAttribute("MEMBERS", memberList);
		return "member/home";
	}

	/*
	 * @ModelAttribute : MEMBER 객체를 새로 생성해 (NEW 객체) input.jsp에게 전달하는 역할
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("MEMBER") MemberDto memberDto) {
		return "member/input";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("MEMBER") MemberDto memberDto, Model model) {
		log.debug("회원정보 확인", memberDto);
//		insert는 post에서 실행되야 한다
		try {
			int result = memberService.insert(memberDto);
		} catch (Exception e) {
//			service throw로 전달한 message getter 하기
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);
			e.printStackTrace();
			return "member/input";
		}
		return "redirect:/member";
	}

//	보여주는 것이기때문에 get
	@RequestMapping(value = "/{b_code}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("b_code") String bcode, Model model) {

		MemberDto memberDto = memberService.findById(bcode);
//		여기 MEMBER는 새롭게 만들어지는 것
		model.addAttribute("MEMBER", memberDto);
//		@PathVariable("b_code")에서 만들어진 b_code를 여기에 보내준다
		return "member/detail";
	}

	@RequestMapping(value = "/{b_code}/update", method = RequestMethod.GET)
	public String update(@PathVariable("b_code") String bcode, Model model) {
		MemberDto memberDto = memberService.findById(bcode);
		model.addAttribute("MEMBER", memberDto);
		return "member/input";
	}

	@RequestMapping(value = "/{b_code}/update", method = RequestMethod.POST)
	public String update(@PathVariable("b_code") String bcode, @ModelAttribute("MEMBER") MemberDto memberDto,
			Model model) {
		memberDto.setM_code(bcode);
		try {
			int result = memberService.update(memberDto);
		} catch (Exception e) {
//			console에 exception log출력하는 코드
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("MESSAGE", message);

			return "member/input";
		}
//		@PathVariable 로 받은 b_code데이터를
//		redirect 코드에 그대로 적용하기
		/*
		 * 어제 했던 코드:
		 *	String.format("redirect"/member/%s/detail",bcode");
		 */
		
		return "redirect:/member/{b_code}/detail";
	}

//	위에서 @ModelAttribute ("MEMBER") 를 찾는다.
//	만약 찾았는데 값이 비어있다면 값을 넣어주고 값이 있다면 지나친다
//	임의로 값을 넣어줄수도 있다. builder패턴 사용시 마지막에 build(); 넣기 	

	/*
	 * @ModelAttribute를 생성하면 객체, 변수가 작용하는 범위가 Request 전체 영역에 대해 사용가능한 상태가 된다.
	 */
	@ModelAttribute("MEMBER")
	public MemberDto newMember() {
		return MemberDto.builder().build();
	}

}
