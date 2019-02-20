/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Administrator
 */
public class FileServer {
    
    public  boolean downFile(String url, int port,String username, String password, String remotePath,String fileName,String localPath) {  
    boolean success = false;  
    FTPClient ftp = new FTPClient(); 
    String encoding = System.getProperty("file.encoding");
    try {  
        int reply;  
        ftp.setControlEncoding(encoding);
        ftp.connect(url, port);  
        //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器  
        ftp.login(username, password);//登录  
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();  
        if (!FTPReply.isPositiveCompletion(reply)) {  
            ftp.disconnect();  
            return success;  
        }  
        System.out.println("ftp服务器登陆成功");
//        ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录  
        ftp.changeWorkingDirectory(new String(remotePath.getBytes(encoding),"iso-8859-1"));
        FTPFile[] fs = ftp.listFiles();  
        for(FTPFile ff:fs){  
            if(ff.getName().equals(fileName)){  
                File localFile = new File(localPath+"/"+ff.getName());  
                  
                OutputStream os = new FileOutputStream(localFile);   
                ftp.retrieveFile(ff.getName(), os);  
                os.flush();
                os.close();  
            }  
        }  
          
        ftp.logout();  
        success = true;  
    } catch (IOException e) {  
        e.printStackTrace();  JOptionPane.showMessageDialog(null, "下载失败");
    } finally {  
        if (ftp.isConnected()) {  
            try {  
                ftp.disconnect();  
            } catch (IOException ioe) {  
            }  
        }  
    }  
    return success;  
}  
    
    
    
    public  boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {  
    boolean success = false;  
    FTPClient ftp = new FTPClient();  
    try {  
        int reply;  
        ftp.connect(url, port);//连接FTP服务器  
        //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器  
        ftp.login(username, password);//登录  
        reply = ftp.getReplyCode();  
        if (!FTPReply.isPositiveCompletion(reply)) {  
            ftp.disconnect();  
            return success;  
        }  
        ftp.changeWorkingDirectory(path);  
        ftp.storeFile(filename, input);           
          
        input.close();  
        ftp.logout();  
        success = true;  
    } catch (IOException e) {  
        e.printStackTrace();  JOptionPane.showMessageDialog(null, "上传失败");
    } finally {  
        if (ftp.isConnected()) {  
            try {  
                ftp.disconnect();  
            } catch (IOException ioe) {  
            }  
        }  
    }  
    return success;  
}  
    
}
