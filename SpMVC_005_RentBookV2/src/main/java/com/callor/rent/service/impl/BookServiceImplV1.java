package com.callor.rent.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.BookDao;
import com.callor.rent.models.BookDto;
import com.callor.rent.models.PageDto;
import com.callor.rent.service.BookService;

import lombok.extern.slf4j.Slf4j;

// 여기 따로 설정함
@Slf4j
@Service(QualifierConfig.SERVICE.BOOK_V1)
public class BookServiceImplV1 implements BookService {

	protected final BookDao bookDao;

	public BookServiceImplV1(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	// 이걸 하면 자동으로 테이블 생성
//	book controller에서 가져옴
	@Autowired
	public void create_table() {
		try {
			bookDao.creat_book_table(null);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<BookDto> selectAll() {
		return bookDao.selectAll();
	}

	@Override
	public int insert(BookDto bookDto) {
		return bookDao.insert(bookDto);
	}

	@Override
	public BookDto findById(String bcode) {
		return bookDao.findById(bcode);
	}

	@Override
	public int update(BookDto bookDto) {

		return bookDao.update(bookDto);
	}

	@Override
	public List<BookDto> findByBName(String bname) {

		return bookDao.findByBName(bname.trim());
	}

	@Override
	public List<BookDto> selectPage(String page) {
		try {
			int intPageNum = Integer.valueOf(page);
//			intPageNum = (intPageNum - 1) * 10;
			intPageNum = --intPageNum * 10;

			int intLimit = 10;
			return bookDao.selectpage(intLimit, intPageNum);

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public void selectPage(String page, Model model, String search) {
	//	검색어를 빈칸을 기준으로 분해하기
		String[] searchs = search.split(" ");
//		배열을 리스트로만드는 방법
		List<String>searchList= Arrays.asList(searchs);
		
		int totalCount = bookDao.selectSearchCount(searchList);
		int intPageNum = Integer.valueOf(page);

		PageDto pageDto = PageDto.builder().
				pageNum(intPageNum).
				totalCount(totalCount).
				build();

		List<BookDto> books = bookDao.selectSearchPage(
				pageDto.getLimitCount(),
				pageDto.getOffSetNum(),
				searchList);

		model.addAttribute("BOOKS", books);
		model.addAttribute("PAGINATION", pageDto);

	}

	@Override
	public void selectPage(String page, Model model) {
		// TODO Auto-generated method stub

		// List<BookDto> books = bookDao.selectAll();
		// int totalCount = books.size();

		int totalCount = bookDao.selectCount();
		int intPageNum = Integer.valueOf(page);

		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();

		log.debug("page{}", pageDto);

		List<BookDto> books = bookDao.selectpage(pageDto.getLimitCount(), pageDto.getOffSetNum());

		model.addAttribute("BOOKS", books);
		model.addAttribute("PAGINATION", pageDto);

	}

//		오라클 겸용
//	@Override
//	public void selectPage(String page, Model model) {
//		// TODO Auto-generated method stub
//
//		List<BookDto> books = bookDao.selectAll();
//		int totalCount = books.size();
//		int intPageNum = Integer.valueOf(page);
//
//		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();
//
//		List<BookDto> pageBooks = new ArrayList<>();
//		for (int index = pageDto.getOffSetNum(); index < pageDto.getLimitCount() + pageDto.getOffSetNum(); index++) {
//			pageBooks.add(books.get(index));
//
//		}
//
//		log.debug("page{}", pageDto);
//		model.addAttribute("BOOKS", pageBooks);
//		model.addAttribute("PAGINATION", pageDto);
//
//	}

}
