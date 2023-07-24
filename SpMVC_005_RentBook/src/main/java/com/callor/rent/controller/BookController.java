package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.rent.models.BookDto;
import com.callor.rent.service.BookService;

import lombok.extern.slf4j.Slf4j;

/*
 * localhost:8080/rent/book/* 로 요청이 들어오면 
 * 처리할 시작점
 */
@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {

//	mapper 다음 dao 다음 controller
// 밑에 자름
	// protected final BookDao bookDao;

//	dao를 잘라서 serviceimpl에 붙이고 service를 가져옴
	protected final BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

// 이걸 하면 자동으로 테이블 생성
//	자름
//	@Autowired
//	public void create_table() {
//		bookDao.creat_book_table(null);
//		
//		
//	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
//		전체 데이터를 select해서 북에 보내겠다
		List<BookDto> books = bookService.selectAll();
		model.addAttribute("BOOKS", books);

		return "book/home";
	}

//		도서정보 입력화면을 보여주는 메서드 , 보여주기때문에 get이다
//	여기 dto값은 비어있어 제일 밑에 있는 메서드에서 modelattribute로 dto를 채워 여기에 넣었다
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("BOOK") BookDto bookDto) {
		return "book/input";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("BOOK") BookDto bookDto, Model model) {
		log.debug("@@@@@@@@전달된 데이터{}", bookDto);

		int result = bookService.insert(bookDto);

		return "redirect:/book";
	}

//	주소에 첨가된 변수를 받는 방법
//	@PathVariable("bcode") 에서 value = "/{bcode}/detail" 로 가고
//	(앞의 2개는 이름이 같아야 한다. 뒤는 달라도 됨)
//	value에서 String bcode 로 간다
	@RequestMapping(value = "/{bcode}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("bcode") String bcode, Model model) {

		BookDto bookDto = bookService.findById(bcode);
//		여기서"BOOK"은 input.jsp의 <f:form modelAttribute="BOOK"> 이다
//		input.jsp에서 저장된 데이터를 가져와서 보여주는 것
		model.addAttribute("BOOK", bookDto);
		return "book/detail";
	}

	@RequestMapping(value = "/{bcode}/update", method = RequestMethod.GET)
	public String update(@PathVariable("bcode") String bcode, Model model) {
		BookDto bookDto = bookService.findById(bcode);
		model.addAttribute("BOOK", bookDto);
		model.addAttribute("STATE", "UPDATE");
		return "book/input";
	}

	@RequestMapping(value = "/{bcode}/update", method = RequestMethod.POST)
	public String update(@PathVariable("bcode") String bcode, @ModelAttribute("BOOK") BookDto bookDto, Model model) {

//		bcode가 빈칸이 아니면 dto에 저장
		if (!bcode.isBlank())
			bookDto.setB_code(bcode);
		int result = bookService.update(bookDto);
		return String.format("redirect:/book/%s/detail", bcode);
	}

	// 위의 insert 에 BOOK dto에 값을 담아주는 것이다 위에 매개변수에 dto가 선언된 것 만으로는 값이 비어있다
	/*
	 * @modelattribute("BOOK") 이라는 선언이 있는 매개변수가 발견되거든 BOOKDTO bookDto 객체에 데이터가 있는지
	 * 확인하고 만약 null 값이면 새로운 BookDto 객체를 생성해 주입하는 메서드
	 */
	@ModelAttribute("BOOK")
	public BookDto newBookDto() {
		return BookDto.builder().build();
	}

}
