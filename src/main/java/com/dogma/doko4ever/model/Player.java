package com.dogma.doko4ever.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Player {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column
	@NotNull
	private String firstName;

	@Column
	@NotNull
	private String lastName;

	@Column
	@NotNull
	private String email;

	@Column(columnDefinition = "bytea")
	@NotNull
	@ColumnTransformer(read = "pgp_sym_decrypt(password, 'mySecretKey')", write = "pgp_sym_encrypt(?, 'mySecretKey')")
	// encrypt.key should be moved to postgresql.conf - https://vladmihalcea.com/how-to-encrypt-and-decrypt-data-with-hibernate/
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
