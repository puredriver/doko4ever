package com.dogma.doko4ever.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column
	@NotNull
	private String firstname;

	@Column
	@NotNull
	private String lastname;

	@Column
	@NotNull
	private String email;

	@Column
	@NotNull
	private int active;

	// @Column(columnDefinition = "bytea")
	// @NotNull
	// @ColumnTransformer(read = "pgp_sym_decrypt(password, 'mySecretKey')", write =
	// "pgp_sym_encrypt(?, 'mySecretKey')")
	// encrypt.key should be moved to postgresql.conf -
	// https://vladmihalcea.com/how-to-encrypt-and-decrypt-data-with-hibernate/
	// private String password;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
