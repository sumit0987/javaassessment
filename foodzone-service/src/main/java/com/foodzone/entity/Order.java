package com.foodzone.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="order_detail")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId; 
	private double orderCost;
	private long paymentId;
	
	@OneToMany(mappedBy="order",cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH,
			CascadeType.REMOVE})
	private List<OrderItem> orderItems;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH,
			CascadeType.REMOVE})
	@JoinColumn(name="user_id")
	//@JsonIgnore
	private User user;
	
	private Date orderDate;
	
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
//			CascadeType.PERSIST,CascadeType.REFRESH,
//			CascadeType.REMOVE})
//	@JoinColumn(name="user_id")
//	//@JsonIgnore
//	private User user;
	
	
	
	
}
