package models;

import java.math.BigDecimal;

/*
 * Represents a DTO (data transfer object), models the http request body
 */
public class TransferRequest {

	private long senderAccountId;
	private long receiverAccountId;
	private BigDecimal amount;
	
	public TransferRequest(long senderAccountId, long receiverAccountId, BigDecimal amount) {
		this.senderAccountId = senderAccountId;
		this.receiverAccountId = receiverAccountId;
		this.amount = amount;
	}
	
	public long getSenderId() {
		return this.senderAccountId;
	}
	public long getReceiverId() {
		return this.receiverAccountId;
	}
	public BigDecimal getAmount() {
		return this.amount;
	}
	public void setSenderId(long id) {
		this.senderAccountId = id;
	}
	public void setReceiverId(long id) {
		this.receiverAccountId = id;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
