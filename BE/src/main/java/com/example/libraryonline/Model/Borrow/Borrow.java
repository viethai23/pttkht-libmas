package com.example.libraryonline.Model.Borrow;

import com.example.libraryonline.Model.User.Reader;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne()
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_id")
	private Shipping shipping;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "reader_id")
	private Reader reader;

	@Column(name = "borrow_date")
	private Date borrowDate;

	@Column(name = "borrow_day")
	private int borrowDay;

	@Column(name = "due")
	private Date due;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "status")
	private String status;
}