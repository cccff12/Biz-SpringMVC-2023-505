package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.rent.models.BookDto;
import com.callor.rent.service.BookService;

/*
 * localhost:8080/rent/book/* 로 요청이 들어오면 
 * 처리할 시작점
 */
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
	public String home(Model model ) {
//		전체 데이터를 select해서 북에 보내겠다
		List<BookDto> books= bookService.selectAll();
		model.addAttribute("BOOKS", books);
		
		return "book/home";
	}

}
