package com.example.libraryonline.Model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne()
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@ManyToOne()
	@JoinColumn(name = "author_id")
	private Author author;

	@Column(name = "name")
	private String name;

	@Column(name = "des")
	private String des;

	@Column(name = "fee")
	private float fee;

	@Column(name = "stock_quantity")
	private int stockQuantity;

	@Column(name = "image")
	private String image;
}