package com.thx.service;

import java.sql.SQLException;
import java.util.List;

import com.thx.bean.Goods;
import com.thx.dao.GoodsDao;
import com.thx.db.DBConnection;
import com.thx.db.GoodsDaoImpl;

public class GoodsService implements GoodsDao{

	private DBConnection dbconn = null;

	private GoodsDao dao = null;
	
	public GoodsService() throws SQLException {
		this.dbconn = new DBConnection();
		this.dao = new GoodsDaoImpl(this.dbconn.getConnection());
	}
	
	@Override
	//������Ʒ
	public boolean addGoods(Goods goods) throws Exception {
		if (goods != null) {  // ���goods��Ϊ�գ�ִ�����Ӳ���
			return this.dao.addGoods(goods);
		}
		return false;
	}

	@Override
	//����gid and types ��ѯ��Ʒ����ҳ��ʾ
	public List<Goods> getLatestGoods(int gid, String type) throws Exception {
		if (isInt(gid) & type != null) {
			return this.dao.getLatestGoods(gid, type);
		}
		return null;
	}

	@Override
	//��ȡ���е���Ʒ
	public List<Goods> getAllGoods() throws Exception {
		return this.dao.getAllGoods();
	}

	@Override
	//������Ʒ
	public boolean editInfo(Goods goods) throws Exception {
		if (goods != null) {
			return this.dao.editInfo(goods);
		}
		return false;
	}

	@Override
	//����idɾ����Ʒ
	public boolean deleteGoods(int gid) throws Exception {
		if (this.dao.queryById(gid) != null & isInt(gid)) {
			return this.dao.deleteGoods(gid);
		}
		return false;
	}

	@Override
	//����gid��ѯ��Ʒ��Ϣ
	public Goods queryById(int gid) throws Exception {
		if (isInt(gid)) {
			return this.dao.queryById(gid);
		}
		return null;
	}

	@Override
	//������Ʒid��ȡ����Ʒ������
	public int queryNumberById(int gid) throws Exception {
		if (isInt(gid)) {
			return this.dao.queryNumberById(gid);
		}
		return 0;
	}

	@Override
	//��ѯ��Ʒ�е���������
	public String[] queryTypes() throws Exception {
		return this.dao.queryTypes();
	}

	@Override
	//��ѯĳ�����������Ʒ��id��name
	public List<Goods> getTypeGoodsList(String type) throws Exception {
		if (type != null) {
			return this.dao.getTypeGoodsList(type);
		}
		return null;
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
