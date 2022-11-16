package com.example.book;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.book.model.Book;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class BookApplicationTests {

	 @Autowired
	 private MockMvc mockMvc;

	 @Test
	 public void gettingBooksWithNoCriteria() throws Exception {
		this.mockMvc.perform(get("/books/byCriteria"))
			.andExpect(status().isBadRequest());
	 }

	 @Test
	 public void gettingBooksWithEmptyCriteria() throws Exception {
		Book book = new Book();

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(book);

		this.mockMvc.perform(get("/books/byCriteria").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
			.andExpect(status().isNoContent());
	 }

	 @Test
	 public void gettingBooksWithCriteria() throws Exception {
		Book book = new Book();
		book.setCategory("Novela");

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(book);

		this.mockMvc.perform(get("/books/byCriteria").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
			.andExpect(status().isOk())
			.andExpect(content().string("[{\"id\":1,\"name\":\"Cien años de soledad\",\"category\":\"Novela\",\"author\":\"Gabriel García Márquez\"}," + 
			"{\"id\":5,\"name\":\"El nombre de la rosa\",\"category\":\"Novela\",\"author\":\"Umberto Eco\"}]"));
	 }
}
