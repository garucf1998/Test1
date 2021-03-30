package com.example.demo.enity;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BenhNhan
 *
 */
@Entity
@Table(name = "BenhNhan")
public class BenhNhan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBenhNhan;
    private String tenBenhNhan;
    private String diaChi;
    private String email;
    private String cmnd;
    private String soDienThoai;
    private boolean gioiTinh;
    private String ngaySinh;

    public BenhNhan() {
        super();
    }
    public Integer getIdBenhNhan() {
        return this.idBenhNhan;
    }

    public void setIdBenhNhan(Integer idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }
    public String getTenBenhNhan() {
        return this.tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }
    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSoDienThoai() {
        return this.soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
