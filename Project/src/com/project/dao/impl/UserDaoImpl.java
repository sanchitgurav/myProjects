package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.dao.UserDao;
import com.project.dto.UserDTO;
import com.project.utility.DbConnection;

public class UserDaoImpl implements UserDao {

	private Connection con;

	@Override
	public boolean saveUser(UserDTO user) {
		// TODO Auto-generated method stub
//		System.out.println("In Dao Layer");
//		System.out.println(user);
		PreparedStatement ps = null;
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("insert into user_tbl(name,email,password,city) values(?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAddress());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("update user_tbl set name = ?, password = ?, city = ? where email = ? ");

			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getEmail());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("delete from user_tbl where email = ?");
			ps.setString(1, email);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean searchUser(String email) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("select * from user_tbl where email = ?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int userId = rs.getInt("user_id");
				String name = rs.getString("name");
				String userEmail = rs.getString("email");
				String password = rs.getString("password");
				String address = rs.getString("city");
				System.out.println("Id = " + userId + " Name = " + name + " Email = " + userEmail + " Password = "
						+ password + " City = " + address);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public List<UserDTO> showAllUser() {
		// TODO Auto-generated method stub
		List<UserDTO> userList = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("select * from user_tbl");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("user_id"); // int userId = rs.getInt(1);
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String address = rs.getString("city");

				UserDTO user = new UserDTO(userId, name, email, password, address);
				userList.add(user);
				System.out.println("Id = " + userId + " Name = " + name + " Email = " + email + " City = " + address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

}
