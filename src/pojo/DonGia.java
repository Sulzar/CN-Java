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
public class DonGia {
    private String maDT;
    private Date ngayAD;
    private float gia;

    public DonGia(String maDT, Date ngayAD, float gia) {
        this.maDT = maDT;
        this.ngayAD = ngayAD;
        this.gia = gia;
    }

    public DonGia() {
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public Date getNgayAD() {
        return ngayAD;
    }

    public void setNgayAD(Date ngayAD) {
        this.ngayAD = ngayAD;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
}
