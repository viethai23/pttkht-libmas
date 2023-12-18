package com.example.libraryonline.Model.Borrow;

import com.example.libraryonline.Model.Book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	@JsonIgnore
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Book book;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "amount")
	private double amount;
}