/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author ACER
 */
public class ChiTietHD {
    private String maHD, maDT;
    private int sl;
    private float giaBan, thanhTien;

    public ChiTietHD(String maHD, String maDT, int sl, float giaBan, float thanhTien) {
        this.maHD = maHD;
        this.maDT = maDT;
        this.sl = sl;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public ChiTietHD() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
    
}
