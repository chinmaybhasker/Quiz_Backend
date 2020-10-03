package com.example.Credicxo.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PerformaceEntity {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id", unique = true, nullable = false)
	  private int id;
	  
	@Column
	private String emailaddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	@Column
	private Integer percentage;

}
