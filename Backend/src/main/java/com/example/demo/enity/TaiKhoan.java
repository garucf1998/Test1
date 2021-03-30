package com.example.demo.enity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TaiKhoan
 *
 */
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    @OneToOne(mappedBy = "taikhoan")
    private NhanVien nhanvien;

    public TaiKhoan() {
        super();
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public TaiKhoan(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

}
