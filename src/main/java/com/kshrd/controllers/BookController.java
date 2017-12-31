package com.kshrd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.javafaker.Faker;
import com.kshrd.models.Book;
import com.kshrd.models.Publisher;
import com.kshrd.services.BookService;
import com.kshrd.services.FileUploadService;
import com.kshrd.services.PublisherService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	PublisherService publisherService;

	@GetMapping("/")
	public String getBooks(@RequestParam(value="searchText", required=false) String str, Model model) {
		List<Book> books;
		if (str==null) {
			books = bookService.findAll();
		}else {
			books = bookService.findByText(str);
			model.addAttribute("searchText", str);
		}
		model.addAttribute("books", books);
		return "book/index";
	}
	
//	@GetMapping("/search")
//	public String searchBooks(@RequestParam("searchText") String str, Model model) {
//		List<Book> books = bookService.findByText(str);
//		model.addAttribute("books", books);
//		return "book/index";
//	}
	
	@GetMapping("/book/{id}")
	public String viewBook(@PathVariable("id") int id, Model model) {
		Book book = bookService.findById(id);
		System.out.println(book.toString());
		model.addAttribute("book", book);
		model.addAttribute("highlight", new Faker().lorem().paragraph(10));
		return "book/book-detail";
	}
	
	@GetMapping("/admin")
	public String bookList(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "book/admin/admin-index";
	}
	
	@GetMapping("/admin/book/add")
	public String addBook(Model model) {		
		model.addAttribute("addStatus", true);
		model.addAttribute("book", new Book());
		model.addAttribute("publishers", publisherService.getAllPublishers());
		return "/book/admin/admin-add-edit";
	}
	
	@PostMapping("/admin/book/add")
	public String saveBook(@RequestParam("file") MultipartFile file,
						   @RequestParam(value="publisherIds") int publisherIds[],
						   @Validated Book book,
			  			   BindingResult result,
			  			   Model model) {
		
		//If there are some errors occur
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + " : " + error.getDefaultMessage());
			}
			model.addAttribute("addStatus", true);
			model.addAttribute("book", book);
			return "/book/admin/admin-add-edit";
		}
		
		//Upload File to hard drive and get its URL
		String filePath = fileUploadService.upload(file);
		book.setCoverImage(filePath);
		
		//Set publishers
		List<Publisher> publishers = new ArrayList<Publisher>();
		for (int publisherId : publisherIds) {
			publishers.add(new Publisher(publisherId));
		}
		book.setPublishers(publishers);
		
		//Save books
		bookService.save(book);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/book/edit/{id}")
	public String editBook(Model model, @PathVariable("id") int id) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		model.addAttribute("addAttribute", false);
		model.addAttribute("publishers", publisherService.getAllPublishers());
		return "/book/admin/admin-add-edit";
	}
	
	@PostMapping("/admin/book/edit")
	public String updateBook(@RequestParam("file") MultipartFile file,
							 @RequestParam(value="publisherIds") int publisherIds[],
							   @Validated Book book,
				  			   BindingResult result,
				  			   Model model) {
		
		System.out.println(book.toString());
		
		//If there are some errors occur
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + " : " + error.getDefaultMessage());
			}
			model.addAttribute("addStatus", false);
			model.addAttribute("book", book);
			return "/book/admin/admin-add-edit";
		}
		
		//Upload File to hard drive and get its URL
		if (!file.isEmpty()) {
			String filePath = fileUploadService.upload(file);
			book.setCoverImage(filePath);
		}
		
		//Set publishers
		List<Publisher> publishers = new ArrayList<Publisher>();
		for (int publisherId : publisherIds) {
			publishers.add(new Publisher(publisherId));
		}
		book.setPublishers(publishers);
		
		//Start updating book
		bookService.update(book.getId(), book);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/book/delete/{id}")
	public String showDeleteForm(@PathVariable("id") int id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		return "book/admin/admin-confirm-delete";
	}
	
	@PostMapping("/admin/book/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user/user";
	}
	
	@GetMapping("/dba")
	public String dba() {
		return "dba/dba";
	}
}
