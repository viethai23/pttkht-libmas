package com.example.shoppingonline.Model.User;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "librarian")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
public class Librarian extends User {
	@Column(name = "position")
	private String position;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "salary")
	private double salary;
}