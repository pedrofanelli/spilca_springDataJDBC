package models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

/*
 * Models the data in a row on our table in the DB
 * Spring Data needs to know which field is the primary key.
 * This model can also be called "Entity"
 */
public class Account {

	@Id
	private long id;
	
	private String name;
	private BigDecimal amount;
	
	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public BigDecimal getAmount() {
		return this.amount;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
