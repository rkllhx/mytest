package com.lmonkey.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_PRODUCT;


public class LMONKEY_PRODUCTDao {
	//添加
	public static int insert(LMONKEY_PRODUCT p) {
		String sql = "insert into LMONKEY_PRODUCT values(null, ?, ?,?,?,?,?,?)";
		Object[] params = {
					p.getPRODUCT_NAME(),
					p.getPRODUCT_DESCRIPTION(),
					p.getPRODUCT_PRICE(),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_FID(),
					p.getPRODUCT_CID(),
					p.getPRODUCT_FILENAME()
					};
		return Basedao.exectuIUD(sql, params);
	}
	
	//回显
	public static ArrayList<LMONKEY_PRODUCT> selectAll() {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 while(rs.next()) {
				 LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 list.add(p);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	//根据id获取对象
	public static LMONKEY_PRODUCT selectById(int id) {
		LMONKEY_PRODUCT p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 while(rs.next()) {
				  p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return p;
	}
	
	public static ArrayList<LMONKEY_PRODUCT> selectAllByFid(int fid) {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_FID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			 while(rs.next()) {
				 LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 list.add(p);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	public static ArrayList<LMONKEY_PRODUCT> selectAllByCid(int cid) {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from LMONKEY_PRODUCT where PRODUCT_CID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 list.add(p);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	/*//删除。。。。。。。
	public static ArrayList<LMONKEY_PRODUCT> selectALLById(ArrayList<Integer> ids) {
		ArrayList<LMONKEY_PRODUCT> arraylist = new ArrayList<LMONKEY_PRODUCT>();
		Connection conn =  Basedao.getconn();
		PreparedStatement ps = null;
		
		try {
			String sql = "delect from LMONKEY_PRODUCT where id=?";
			ps = conn.prepareStatement(sql);
			ResultSet rpg = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arraylist;
	}*/
	
	//删除
	public static int del(String id) {
		String sql = "delete from LMONKEY_PRODUCT where PRODUCT_ID = ?";
		Object[] parObjects = {id};
		return Basedao.exectuIUD(sql, parObjects);
	}
	
	public static ArrayList<LMONKEY_PRODUCT> selectAllById(ArrayList<Integer> ids) {
		ArrayList<LMONKEY_PRODUCT> lastlylist = new ArrayList<LMONKEY_PRODUCT>();
		 LMONKEY_PRODUCT p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
		    for(int i=0; i<ids.size(); i++) {
			
				String sql = "select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ids.get(i));
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 p = new LMONKEY_PRODUCT(
							 	rs.getInt("PRODUCT_ID"),
							 	rs.getString("PRODUCT_NAME"),
							 	rs.getString("PRODUCT_DESCRIPTION"),
							 	rs.getInt("PRODUCT_PRICE"),
							 	rs.getInt("PRODUCT_STOCK"),
							 	rs.getInt("PRODUCT_FID"),
							 	rs.getInt("PRODUCT_CID"),
							 	rs.getString("PRODUCT_FILENAME")
							 );
					 lastlylist.add(p);
				 }
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return lastlylist;
	}
	
	//获取所有商品记录
	public static ArrayList<LMONKEY_PRODUCT> selectAllP(int age, int count, String lookword) {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql = "";
			
			if(lookword!=null) {
				sql = "select * from LMONKEY_PRODUCT where PRODUCT_NAME like ? limit ?, ?";
//						+ " order by USER_BIRTHDAY desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%"+lookword+"%");
				 ps.setInt(2, (age-1)*count);
				 ps.setInt(3, count);
			}else{
				sql = "select * from LMONKEY_PRODUCT limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, (age-1)*count);
				 ps.setInt(2, count);
				 }
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 LMONKEY_PRODUCT u = new LMONKEY_PRODUCT(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 list.add(u);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 获取总记录数和总页数
	 * @param count
	 * @return
	 */
	public static int[] page(int count, String lookword){
		
		int arr[] = {0,1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			String sql = "";
			
			if(lookword!= null){
				sql = "SELECT COUNT(*) FROM lmonkey_product WHERE PRODUCT_NAME LIKE ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+lookword+"%");
			}else {
				sql = "SELECT COUNT(*) FROM lmonkey_product";
				
				ps = conn.prepareStatement(sql);
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				arr[0]= rs.getInt(1);
				
				if(arr[0]%count == 0){
					arr[1] = arr[0]/count;
				}else {
					arr[1] = arr[0]/count+1;
				}
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return arr;
	}
}