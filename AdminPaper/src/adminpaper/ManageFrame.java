/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpaper;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */

public class ManageFrame extends javax.swing.JFrame implements ItemListener,ListSelectionListener{

    /**
     * Creates new form ManageFrame
     */
    int row;ListSelectionModel selectmodel;
    String name;JTable table=new JTable();
    String year="2016-2017";String semester="第一学期";String dept="计算机";String profession="软件工程";String state="未处理";
    DATABASE.DataBase db=new DATABASE.DataBase();
     String sql="select * from paper where 学年=? and 学期=? and 学院=? and 专业=? and 试卷状态=?";
    String sql1="select *from paper";
    public ManageFrame(String str) {
        name=str;
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        jComboBox1.addItemListener(this);
        jComboBox2.addItemListener(this);
        jComboBox3.addItemListener(this);
        jComboBox4.addItemListener(this);
        jComboBox5.addItemListener(this);
        
//        table.addMouseListener(new MouseAdapter(){
// public void mouseReleased(java.awt.event.MouseEvent e)
//{
////是否左建双击
//if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e))
//{
//   int option = JOptionPane.showConfirmDialog(null, "确定", "确认取卷",
//		JOptionPane.YES_OPTION);
//	if (option == JOptionPane.YES_OPTION) {
//	    System.out.println("yes");
//
//	} else if (option == JOptionPane.YES_NO_OPTION) {
//	    System.out.println("no");
//
//	}else if (option == JOptionPane.NO_OPTION) {
//	    System.out.println("this no");
//        }
//}
//}});
        
//        setTable(sql,year,semester,dept,profession,state);
         try {
            DefaultTableModel model= db.getResultSet0(sql1);
            table.setModel(model);
//            table.repaint();
//            table.updateUI();
        } catch (SQLException ex) {
            Logger.getLogger(statisticframe.class.getName()).log(Level.SEVERE, null, ex);
        }
            JScrollPane scroll = new JScrollPane(table);
            scroll.setBounds(0,125,830,600);
            //scroll.setBorder(new TitledBorder("借阅信息"));
            getContentPane().add(scroll);
            scroll.setOpaque(false);
            scroll.getViewport().setOpaque(false);
            table.setOpaque(false);
            
            table.setRowSelectionAllowed(true);
        selectmodel=table.getSelectionModel();
        selectmodel.addListSelectionListener(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("试卷管理系统");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("统计");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("保存");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 255));
        jButton3.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("退出");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 255, 255));
        jButton5.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("修改密码");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addGap(44, 44, 44)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016-2017", "2015-2016", "2014-2015" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "第一学期", "第二学期" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "计算机", "化药", "外语学院", "管理学院", " " }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "软件工程", "智能", "英语翻译", "高数", "工商管理" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "未处理", "已取卷", "已处理" }));

        jButton4.setText("查询");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("学年");
        jLabel1.setOpaque(true);

        jLabel2.setText("学期");
        jLabel2.setOpaque(true);

        jLabel3.setText("学院");
        jLabel3.setOpaque(true);

        jLabel4.setText("专业");
        jLabel4.setAutoscrolls(true);
        jLabel4.setOpaque(true);

        jLabel5.setText("状态");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jButton4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(336, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void itemStateChanged(ItemEvent e){
           if(e.getSource()==jComboBox1){
               if(e.getStateChange()==ItemEvent.SELECTED){
                  year=(String) jComboBox1.getSelectedItem();
               }
           }
           if(e.getSource()==jComboBox2){
                if(e.getStateChange()==ItemEvent.SELECTED){
                   semester=(String) jComboBox2.getSelectedItem();
                }
           }
           if(e.getSource()==jComboBox3){
                if(e.getStateChange()==ItemEvent.SELECTED){
                   dept=(String) jComboBox3.getSelectedItem();
                }
           }
           if(e.getSource()==jComboBox4){
                if(e.getStateChange()==ItemEvent.SELECTED){
                   profession=(String) jComboBox4.getSelectedItem();
                }
           }
           if(e.getSource()==jComboBox5){
                if(e.getStateChange()==ItemEvent.SELECTED){
                   state=(String) jComboBox5.getSelectedItem();
                }
           }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new statisticframe();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new saveframe(name,year,semester,dept,profession,state);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int flag= JOptionPane.showConfirmDialog(this,"请确认是否退出","注意",JOptionPane.YES_OPTION);
       if(flag==JOptionPane.YES_OPTION){
            new login();
        this.dispose();
       }
       
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
         DefaultTableModel model=(DefaultTableModel) table.getModel();
       for(int i=0;i<table.getRowCount();i++)
       model.removeRow(i);
            
       this.setTable(sql,year,semester,dept,profession,state);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new changepassword(name);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    public void setTable(String sql,String year,String semester,String dept,String profession,String state) {
        try {
            DefaultTableModel model= db.getResultSet2(sql, year, semester,dept,profession,state);
            table.setModel(model);
//            table.repaint();
//            table.updateUI();
        } catch (SQLException ex) {
            Logger.getLogger(statisticframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    
      } 
    
    public void valueChanged(ListSelectionEvent e) {
        row=table.getSelectedRow();
        String isload=String.valueOf(table.getValueAt(row,8)).trim();
        if(isload.equals("已处理")){
            JOptionPane.showMessageDialog(this,"该试卷已经被处理");
            return;
        }
        else {
            int option = JOptionPane.showConfirmDialog(null, "确定取卷", "确认",
		JOptionPane.YES_OPTION);
	if (option == JOptionPane.YES_OPTION) {
                                       
        java.util.Date curDate = new java.util.Date();
            java.sql.Date data = new java.sql.Date(curDate.getTime());
            String bookid=String.valueOf(table.getValueAt(row, 0));
        db.updatecheckpaper(name, data,year,dept, profession,bookid);
        
        new saveframe(bookid,year,semester,dept,profession,state);

	} else if (option == JOptionPane.YES_NO_OPTION) {
	    
	}else if (option == JOptionPane.NO_OPTION) {
	   
        }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFrame("001");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
