package com.thx.factory;

import java.util.List;

import com.thx.bean.ShoppingCart;

public interface ShoppingCartDao {

	// id�û������Ʒ�����ﳵ
	public boolean addGoods(int uid, int gid, int number) throws Exception;

	// id�û�ɾ�����ﳵ�е���Ʒ
	public boolean deleteGoods(int uid, int gid, int number) throws Exception;

	// id�û���ѯ���ﳵ������Ʒ
	public List<ShoppingCart> getAllGoods(int uid) throws Exception;

	// uid�û���ѯ���ﳵ��gid��Ʒ������
	public String getDesignateGoodsMs(int uid, int gid) throws Exception;

	// id�û�֧�����ﳵ��gid��Ʒ
	public boolean payGoods(int uid, int gid, int number) throws Exception;

	// id�û�֧�����ﳵ��������Ʒ
	public boolean payAllGoods(int uid) throws Exception;
}
