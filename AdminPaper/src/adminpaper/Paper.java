/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpaper;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "paper", catalog = "adminpaper", schema = "")
@NamedQueries({
    @NamedQuery(name = "Paper.findAll", query = "SELECT p FROM Paper p")
    , @NamedQuery(name = "Paper.findBy\u8bfe\u7a0b\u540d", query = "SELECT p FROM Paper p WHERE p.\u8bfe\u7a0b\u540d = :\u8bfe\u7a0b\u540d")
    , @NamedQuery(name = "Paper.findBy\u5b66\u5e74", query = "SELECT p FROM Paper p WHERE p.\u5b66\u5e74 = :\u5b66\u5e74")
    , @NamedQuery(name = "Paper.findBy\u5b66\u671f", query = "SELECT p FROM Paper p WHERE p.\u5b66\u671f = :\u5b66\u671f")
    , @NamedQuery(name = "Paper.findBy\u5b66\u9662", query = "SELECT p FROM Paper p WHERE p.\u5b66\u9662 = :\u5b66\u9662")
    , @NamedQuery(name = "Paper.findBy\u4e13\u4e1a", query = "SELECT p FROM Paper p WHERE p.\u4e13\u4e1a = :\u4e13\u4e1a")
    , @NamedQuery(name = "Paper.findBy\u8bd5\u5377\u4efd\u6570", query = "SELECT p FROM Paper p WHERE p.\u8bd5\u5377\u4efd\u6570 = :\u8bd5\u5377\u4efd\u6570")
    , @NamedQuery(name = "Paper.findBy\u8003\u8bd5\u65f6\u95f4", query = "SELECT p FROM Paper p WHERE p.\u8003\u8bd5\u65f6\u95f4 = :\u8003\u8bd5\u65f6\u95f4")
    , @NamedQuery(name = "Paper.findBy\u6700\u540e\u4fee\u6539\u65f6\u95f4", query = "SELECT p FROM Paper p WHERE p.\u6700\u540e\u4fee\u6539\u65f6\u95f4 = :\u6700\u540e\u4fee\u6539\u65f6\u95f4")
    , @NamedQuery(name = "Paper.findBy\u8bd5\u5377\u72b6\u6001", query = "SELECT p FROM Paper p WHERE p.\u8bd5\u5377\u72b6\u6001 = :\u8bd5\u5377\u72b6\u6001")
    , @NamedQuery(name = "Paper.findBy\u4e0a\u4f20\u7528\u6237", query = "SELECT p FROM Paper p WHERE p.\u4e0a\u4f20\u7528\u6237 = :\u4e0a\u4f20\u7528\u6237")
    , @NamedQuery(name = "Paper.findBy\u53d6\u5377\u4eba", query = "SELECT p FROM Paper p WHERE p.\u53d6\u5377\u4eba = :\u53d6\u5377\u4eba")
    , @NamedQuery(name = "Paper.findBy\u53d6\u5377\u65f6\u95f4", query = "SELECT p FROM Paper p WHERE p.\u53d6\u5377\u65f6\u95f4 = :\u53d6\u5377\u65f6\u95f4")
    , @NamedQuery(name = "Paper.findBy\u4fee\u6539\u72b6\u6001", query = "SELECT p FROM Paper p WHERE p.\u4fee\u6539\u72b6\u6001 = :\u4fee\u6539\u72b6\u6001")})
public class Paper implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "\u8bfe\u7a0b\u540d")
    private String 课程名;
    @Basic(optional = false)
    @Column(name = "\u5b66\u5e74")
    private String 学年;
    @Basic(optional = false)
    @Column(name = "\u5b66\u671f")
    private String 学期;
    @Basic(optional = false)
    @Column(name = "\u5b66\u9662")
    private String 学院;
    @Basic(optional = false)
    @Column(name = "\u4e13\u4e1a")
    private String 专业;
    @Basic(optional = false)
    @Column(name = "\u8bd5\u5377\u4efd\u6570")
    private int 试卷份数;
    @Basic(optional = false)
    @Column(name = "\u8003\u8bd5\u65f6\u95f4")
    @Temporal(TemporalType.DATE)
    private Date 考试时间;
    @Basic(optional = false)
    @Column(name = "\u6700\u540e\u4fee\u6539\u65f6\u95f4")
    @Temporal(TemporalType.DATE)
    private Date 最后修改时间;
    @Basic(optional = false)
    @Column(name = "\u8bd5\u5377\u72b6\u6001")
    private String 试卷状态;
    @Basic(optional = false)
    @Column(name = "\u4e0a\u4f20\u7528\u6237")
    private String 上传用户;
    @Basic(optional = false)
    @Column(name = "\u53d6\u5377\u4eba")
    private String 取卷人;
    @Basic(optional = false)
    @Column(name = "\u53d6\u5377\u65f6\u95f4")
    @Temporal(TemporalType.DATE)
    private Date 取卷时间;
    @Basic(optional = false)
    @Column(name = "\u4fee\u6539\u72b6\u6001")
    private String 修改状态;

    public Paper() {
    }

    public Paper(String 课程名) {
        this.课程名 = 课程名;
    }

    public Paper(String 课程名, String 学年, String 学期, String 学院, String 专业, int 试卷份数, Date 考试时间, Date 最后修改时间, String 试卷状态, String 上传用户, String 取卷人, Date 取卷时间, String 修改状态) {
        this.课程名 = 课程名;
        this.学年 = 学年;
        this.学期 = 学期;
        this.学院 = 学院;
        this.专业 = 专业;
        this.试卷份数 = 试卷份数;
        this.考试时间 = 考试时间;
        this.最后修改时间 = 最后修改时间;
        this.试卷状态 = 试卷状态;
        this.上传用户 = 上传用户;
        this.取卷人 = 取卷人;
        this.取卷时间 = 取卷时间;
        this.修改状态 = 修改状态;
    }

    public String get课程名() {
        return 课程名;
    }

    public void set课程名(String 课程名) {
        this.课程名 = 课程名;
    }

    public String get学年() {
        return 学年;
    }

    public void set学年(String 学年) {
        this.学年 = 学年;
    }

    public String get学期() {
        return 学期;
    }

    public void set学期(String 学期) {
        this.学期 = 学期;
    }

    public String get学院() {
        return 学院;
    }

    public void set学院(String 学院) {
        this.学院 = 学院;
    }

    public String get专业() {
        return 专业;
    }

    public void set专业(String 专业) {
        this.专业 = 专业;
    }

    public int get试卷份数() {
        return 试卷份数;
    }

    public void set试卷份数(int 试卷份数) {
        this.试卷份数 = 试卷份数;
    }

    public Date get考试时间() {
        return 考试时间;
    }

    public void set考试时间(Date 考试时间) {
        this.考试时间 = 考试时间;
    }

    public Date get最后修改时间() {
        return 最后修改时间;
    }

    public void set最后修改时间(Date 最后修改时间) {
        this.最后修改时间 = 最后修改时间;
    }

    public String get试卷状态() {
        return 试卷状态;
    }

    public void set试卷状态(String 试卷状态) {
        this.试卷状态 = 试卷状态;
    }

    public String get上传用户() {
        return 上传用户;
    }

    public void set上传用户(String 上传用户) {
        this.上传用户 = 上传用户;
    }

    public String get取卷人() {
        return 取卷人;
    }

    public void set取卷人(String 取卷人) {
        this.取卷人 = 取卷人;
    }

    public Date get取卷时间() {
        return 取卷时间;
    }

    public void set取卷时间(Date 取卷时间) {
        this.取卷时间 = 取卷时间;
    }

    public String get修改状态() {
        return 修改状态;
    }

    public void set修改状态(String 修改状态) {
        this.修改状态 = 修改状态;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (课程名 != null ? 课程名.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paper)) {
            return false;
        }
        Paper other = (Paper) object;
        if ((this.课程名 == null && other.课程名 != null) || (this.课程名 != null && !this.课程名.equals(other.课程名))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adminpaper.Paper[ \u8bfe\u7a0b\u540d=" + 课程名 + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
