package com.briup.zhaowenjie.book.bean;

import java.io.Serializable;

public class OrderLine implements Serializable {
    private Integer id;

    private Integer num;

    private Double cost;

    private Integer bookId;

    private Integer orderformId;
    
    private Book book;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(Integer orderformId) {
        this.orderformId = orderformId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", num=").append(num);
        sb.append(", cost=").append(cost);
        sb.append(", bookId=").append(bookId);
        sb.append(", orderformId=").append(orderformId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}