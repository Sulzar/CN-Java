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
public class Hang {
    private String maDT, tenDT, tenNSX, tenNCC;
    private String sl;

    public Hang(String maDT, String tenDT, String tenNSX, String tenNCC, String sl) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.tenNSX = tenNSX;
        this.tenNCC = tenNCC;
        this.sl = sl;
    }

    public Hang() {
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }
    
}
