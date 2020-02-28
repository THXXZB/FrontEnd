package com.thx.service;

import com.thx.bean.User;
import com.thx.dao.UserDao;
import com.thx.db.DBConnection;
import com.thx.db.UserDaoImpl;

public class UserService implements UserDao{
	
	private DBConnection dbconn = null;

	private UserDao dao = null;
	
	public UserService() throws Exception{
		this.dbconn = new DBConnection();
		this.dao = new UserDaoImpl(this.dbconn.getConnection());
	}

	@Override
	//ע���û��������û���¼
	public boolean addUser(User user) throws Exception {
		boolean flag = false;
		if (user != null && this.dao.queryByName(user.getUname()) == null && this.dao.queryByEmail(user.getEmail()) == null) {
			flag = this.dao.addUser(user);
			System.out.println("flag="+flag);
		}
		return flag;
	}

	@Override
	//����uid�û���email
	public boolean editEmail(int uid, String email) throws Exception {
		if (isInt(uid) && email != null) {
			return this.dao.editEmail(uid, email);
		}
		return false;
	}

	@Override
	//��������
	public boolean editPasswd(int uid, String passwd) throws Exception {
		if (isInt(uid) && passwd != null) {
			return this.dao.editPasswd(uid, passwd);
		}
		return false;
	}

	@Override
	//������һ�ε�¼��ʱ��
	public boolean editLoginTime(int uid) throws Exception {
		if (isInt(uid)) {
			return this.dao.editLoginTime(uid);
		}
		return false;	
	}

	@Override
	//ע���û���ɾ�����û���Ϣ
	public boolean deleteUser(int uid) throws Exception {
		if (isInt(uid)) {
			return this.dao.deleteUser(uid);
		}
		return false;
	}

	@Override
	//�����û�����ѯ�û���Ϣ
	public User queryByName(String uname) throws Exception {
		if (uname != null) {
			return this.dao.queryByName(uname);
		}
		return null;
	}

	@Override
	//�����û��󶨵������ѯ�û���Ϣ
	public User queryByEmail(String email) throws Exception {
		if (email != null) {
			return this.dao.queryByEmail(email);
		}
		return null;
	}
	//������ת�����ַ���
	public boolean isInt(int index) {
		if (index == 0) {
			return false;
		}
		String str = String.valueOf(index);
		return str.matches("[0-9]+$");
	}

}
