package com.thx.bean;

public class AlreadyBuy {
	
	// ����
	private int aid;
	// �û�id
	private int uid;
	// ��Ʒid
	private int gid;
	// �������Ʒ����
	private int number;
	// ����ʱ��
	private String buyTime;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public AlreadyBuy(int aid, int uid, int gid, int number, String buyTime) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.gid = gid;
		this.number = number;
		this.buyTime = buyTime;
	}
	public AlreadyBuy() {
		super();
	}
	
}
