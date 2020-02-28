package com.thx.service;

import java.sql.SQLException;
import java.util.List;

import com.thx.bean.ShoppingCart;
import com.thx.dao.ShoppingCartDao;
import com.thx.db.DBConnection;
import com.thx.db.ShoppingCartDaoImpl;

public class ShoppingCartService implements ShoppingCartDao{

	private DBConnection dbconn = null;

	private ShoppingCartDao dao = null;
	
	public ShoppingCartService() throws SQLException {
		this.dbconn = new DBConnection();
		this.dao = new ShoppingCartDaoImpl(this.dbconn.getConnection());
	}

	@Override
	//����Ʒ���빺�ﳵ
	public boolean addGoods(int uid, int gid, int number) throws Exception {
		if (isInt(uid) && isInt(gid) && isInt(number)) {
			return this.dao.addGoods(uid, gid, number);
		}
		return false;
	}

	@Override
	//�ӹ��ﳵ��ɾ����Ʒ
	public boolean deleteGoods(int uid, int gid, int number) throws Exception {
		if (isInt(uid) && isInt(gid) && isInt(number)) {
			return this.dao.deleteGoods(uid, gid, number);
		}
		return false;
	}

	@Override
	//��ȡ���ﳵ�����е���Ʒ
	public List<ShoppingCart> getAllGoods(int uid) throws Exception {
		if (isInt(uid)) {
			return this.dao.getAllGoods(uid);
		}
		return null;
	}

	@Override
	//��ѯ���û����ﳵ���Ƿ��Ѿ����и���Ʒ
	//������򷵻ع��ﳵid����Ʒ����
	//���򷵻ؿ�
	public String getDesignateGoodsMs(int uid, int gid) throws Exception {
		if (isInt(uid) && isInt(gid)) {
			return this.dao.getDesignateGoodsMs(uid, gid);
		}
		return "";
	}

	@Override
	//����id and number֧������Ʒ����
	public boolean payGoods(int uid, int gid, int number) throws Exception {
		if (isInt(uid) && isInt(gid) && isInt(number)) {
			return this.dao.payGoods(uid, gid, number);
		}
		return false;
	}

	@Override
	//֧�����ﳵ��������Ʒ�Ķ���
	public boolean payAllGoods(int uid) throws Exception {
		if (isInt(uid)) {
			return this.dao.payAllGoods(uid);
		}
		return false;
	}
	//������ת��Ϊ�ַ���
	public boolean isInt(int index) {
		if (index == 0) {
			return false;
		}
		String str = String.valueOf(index);
		return str.matches("[0-9]+$");
	}
	
}
