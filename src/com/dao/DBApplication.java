package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.model.Login;
import com.model.Register;
public class DBApplication {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int bal;
	public Connection myConnection() 
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public int saveData(List<Register> lst) //method to save data
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Register a=null;
		con=myConnection();
		try
		{
			Iterator<Register> itr=lst.iterator();
			System.out.println("dbsave2");
			while(itr.hasNext())
			{
				System.out.println("dbsave3");
				a=itr.next();
				ps=con.prepareStatement("insert into Registration values(?,?,?,?)");
				ps.setInt(1,a.getUno());
				ps.setString(2,a.getFname());
				ps.setString(3,a.getPass());
				ps.setDouble(4,a.getBal());
				i = ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	public List<Register> getAllData()  //method to display all data
	{
		List<Register> lst=new LinkedList<Register>();
		con=myConnection();
		try
		{
		Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from Registration");
			while(rs.next())
			{
				Register a=new Register();
				a.setUno(rs.getInt(1));
				a.setFname(rs.getString(2));
				a.setPass(rs.getString(3));
				a.setBal(rs.getDouble(4));
				lst.add(a);
				System.out.println("cnt");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	public int getbal1(int rno)
	{
		con=myConnection();
		try
		{
			con = myConnection();
			ps=con.prepareStatement("select bal from Registration where rno=?");
			ps.setDouble(1, rno);
			ResultSet rs = ps.executeQuery();
			rs.next();
			bal = rs.getInt(1);
			con.close();
				}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return bal;
	}
	
public int deposit(int a, int rno) //method to deposit amount
{
		
		int b=0;
		try {
			myConnection();
			List<Register> lst=getAllData();
			for(Register r:lst)
			{
				if((r.getBal()>a) )
				{ 
					ps = con.prepareStatement("update Registration set bal=? where rno=?");
					ps.setDouble(1, r.getBal()+a);
					ps.setInt(2, rno);
					b = ps.executeUpdate();
				}		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
		
	}
	
	public boolean validateUser(Login l)
	{
		myConnection();
		List<Register> lst=getAllData();
		boolean b=false;
		for(Register r:lst)
		{
			if(r.getUno()==l.getUno())
			{
				if(r.getPass().equals(l.getPass()))
				{
					b=true;
					break;
				}
			}
		}
		return b;
	}
}
