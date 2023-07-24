package com.callor.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.Book.model.BooksDto;
import com.callor.Book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	
	
	protected final BookService bookService;

	public HomeController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("books") BooksDto booksDto, Model model) {
		log.debug("홈콘트롤러");
		List<BooksDto> booklist = bookService.selectAll();
		model.addAttribute("BOOK_LIST", booklist);
		return "home";
	}

}
