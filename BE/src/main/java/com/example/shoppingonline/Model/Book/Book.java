package com.example.shoppingonline.Model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@ManyToOne(cascade = CascadeType.ALL)
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