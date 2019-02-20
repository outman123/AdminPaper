/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrator
 */
public class DataBase {
    private String dbURL;//数据库连接url
    private String user;//数据库的登录名
    private String password;//数据库的登录密码
    private Connection conn;
    private Statement stmt;
    public  ResultSet rs;
    public DataBase ()
 {
        dbURL="jdbc:mysql://localhost:3306/adminpaper?useUnicode=true&characterEncoding=utf-8&useSSL=false"; // 数据库标识名
     user="root"; // 数据库用户名
     password="123456";  // 数据库用户密码
       try {
            Class.forName("com.mysql.jdbc.Driver");  //加载驱动器
      conn= (Connection) DriverManager.getConnection(dbURL,user,password); //获取连接
     System.out.println("成功连接");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
 }
    
    public Connection getCon(){
    return conn;
    }
    public boolean isLogin(String strUserID,String strPassword)//传入用户账号，密码
    {
        try
        {
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement("select * from user where username=? and    password=?");
            ps.setString(1, strUserID);
            ps.setString(2, strPassword);
           rs = ps.executeQuery();
           if (rs.next())//如果rs可以next则说明该用户存在，密码正确。
           {
            return true;
           }
        }
        catch(Exception e)
        {
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return false;
    }
    public boolean register(String name,String Password){
        try {
            String sql="insert into user(username,password) values(?,?)";
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, Password);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void updatecheckpaper(String admin,java.sql.Date date,String year,String dept,String profession,String bookid){
    String sql="update paper set 试卷状态='已处理',取卷人=?, 取卷时间=? where 学年=? and 学院=? and 专业=? and 试卷编号=?";
    
        try {
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, admin);
            ps.setDate(2, date);
            ps.setString(3, year);
            ps.setString(4, dept);
            ps.setString(5, profession);
            ps.setString(6, bookid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "更新出错");
        }
            
    }
    
    public void changepassword(String username,String password){
    String sql="update user set password=? where username=?";
        try {
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2,username);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "修改出错");
        }
    }
    public boolean checkpassword(String username,String password){
    String sql="select password from user where username=? ";
    PreparedStatement ps;
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
            if(password.equals(rs.getString(1)))
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;    
    }
    
    public DefaultTableModel getResultSet0(String sql) throws SQLException {

        PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "未找到相关内容");
            return null;
        }

        Vector rows = new Vector();
        Vector columnHeads = new Vector();

        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            columnHeads.addElement(rsmd.getColumnName(i)); // 列名

        do {
            rows.addElement(getNextRow(rs, rsmd));//每一行数据
        }
        while (rs.next());
        DefaultTableModel model = new DefaultTableModel(rows, columnHeads);
        return model;
    }
    
    
    public DefaultTableModel getResultSet1(String sql,String year,String semester) throws SQLException {

        PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
        ps.setString(1,year);
        ps.setString(2, semester);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "未找到相关内容");
            return null;
        }

        Vector rows = new Vector();
        Vector columnHeads = new Vector();

        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            columnHeads.addElement(rsmd.getColumnName(i)); // 列名

        do {
            rows.addElement(getNextRow(rs, rsmd));//每一行数据
        }
        while (rs.next());
        DefaultTableModel model = new DefaultTableModel(rows, columnHeads);
        return model;
    }
    public DefaultTableModel getResultSet2(String sql,String year,String semester,String dept,String profession,String state) throws SQLException {

        PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
        ps.setString(1,year);
        ps.setString(2, semester);
        ps.setString(3,dept);
        ps.setString(4,profession);
        ps.setString(5,state);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "未找到相关内容");
            return null;
        }

        Vector rows = new Vector();
        Vector columnHeads = new Vector();

        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            columnHeads.addElement(rsmd.getColumnName(i)); // 列名

        do {
            rows.addElement(getNextRow(rs, rsmd));//每一行数据
        }
        while (rs.next());
        DefaultTableModel model = new DefaultTableModel(rows, columnHeads);
        return model;
    }
    public Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd)
            throws SQLException {
        Vector currentRow = new Vector();
        for (int i = 1; i <= rsmd.getColumnCount(); ++i)
            currentRow.addElement(rs.getString(i));
        return currentRow;
    }


}
