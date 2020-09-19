/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class HoaDon {
    private String maHD, tenVN, maKH;
    private Date ngayBan;
    private float tienBan, giamGia, thanhTien;

    public HoaDon(String maHD, String tenVN, String maKH, Date ngayBan, float tienBan, float giamGia, float thanhTien) {
        this.maHD = maHD;
        this.tenVN = tenVN;
        this.maKH = maKH;
        this.ngayBan = ngayBan;
        this.tienBan = tienBan;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public HoaDon() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenVN() {
        return tenVN;
    }

    public void setTenVN(String tenVN) {
        this.tenVN = tenVN;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public float getTienBan() {
        return tienBan;
    }

    public void setTienBan(float tienBan) {
        this.tienBan = tienBan;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
    
}
