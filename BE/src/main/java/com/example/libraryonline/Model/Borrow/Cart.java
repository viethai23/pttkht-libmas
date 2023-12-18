package com.example.libraryonline.Model.Borrow;

import com.example.libraryonline.Model.User.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "reader_id")
	private Reader reader;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items = new ArrayList<>();

	@Column(name = "total")
	private double total;

	@Column(name = "total_item")
	private int totalItem;

	@Column(name = "status")
	private String status;
}