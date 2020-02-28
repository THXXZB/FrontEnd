package com.thx.service;

import java.sql.SQLException;
import java.util.List;

import com.thx.bean.AlreadyBuy;
import com.thx.dao.AlreadyBuyDao;
import com.thx.db.AlreadyBuyDaoImpl;
import com.thx.db.DBConnection;

public class AlreadyBuyService implements AlreadyBuyDao{

	private DBConnection dbconn = null;

	private AlreadyBuyDao dao = null;
	
	public AlreadyBuyService() throws SQLException {
		this.dbconn = new DBConnection();
		this.dao = new AlreadyBuyDaoImpl(this.dbconn.getConnection());
	}
	
	@Override
	//�û�������Ʒ�����ӹ����¼
	public boolean addBuyGoods(int uid, int gid, int number) throws Exception {
		if (isInt(uid) && isInt(gid) && isInt(number)) {
			return this.dao.addBuyGoods(uid, gid, number);
		}
		return false;
	}

	@Override
	//��ѯ�����ѹ������Ʒ
	public List<AlreadyBuy> getAllBuyGoods(int uid) throws Exception {
		if (isInt(uid)) {
			return this.dao.getAllBuyGoods(uid);
		}
		return null;
	}
	
	//�ж��Ƿ�Ϊ���֣�������ת��Ϊ�ַ���
	public boolean isInt(int index) {
		if (index == 0) {  //Ϊ���򷵻�false
			return false;
		}
		String str = String.valueOf(index);
		return str.matches("[0-9]+$");
	}

}
