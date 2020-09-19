/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.HoaDon;
import dataprovider.SQLServerDataProvider;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.ChiTietHD;
import pojo.DonGia;
import pojo.Hang;

/**
 *
 * @author ACER
 */
public class FileDAO {
    public static boolean capNhatDienThoai(Hang dt){
        boolean kq=false;
        String sql=String.format("update HANG set TENDT='%s', SOLUONG='%s', TENSX='%s', TENCC='%s'"+" where MADT='%s'", dt.getTenDT(), dt.getSl(), dt.getTenNSX(), dt.getTenNCC(), dt.getMaDT());
        SQLServerDataProvider provider=new SQLServerDataProvider();
        provider.open();
        int n=provider.executeUpdate(sql);
        if(n==1)
            kq=true;
        provider.close();
        return kq;
    }
    public static Hang layDienThoai(String maDT){
        Hang dt=null;
        try {
            String sql="select * from HANG where MADT="+maDT;
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            if(rs.next()){
                dt=new Hang();
                dt.setMaDT(rs.getString("MADT"));
                dt.setTenDT(rs.getString("TENDT"));
                dt.setSl(rs.getString("SOLUONG"));
            }
            provider.close();
        } catch (Exception e) {
        }
        return dt;
    }    
    public static ArrayList<Hang> layDanhSachDT(){
        ArrayList<Hang> dsDT=new ArrayList<Hang>();
        try {
            String sql="select * from HANG";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            while(rs.next()){
                Hang dt=new Hang();
                dt.setMaDT(rs.getString("MADT"));
                dt.setTenDT(rs.getString("TENDT"));
                dt.setSl(rs.getString("SOLUONG"));
                dt.setTenNSX(rs.getString("TENSX"));
                dt.setTenNCC(rs.getString("TENCC"));
                dsDT.add(dt);
            }
            provider.close();
        } catch (Exception e) {
        }
        return dsDT;
    }
    public static ArrayList<HoaDon> layDanhSachHD(){
        ArrayList<HoaDon> dsHD=new ArrayList<HoaDon>();
        try {
            String sql="select * from HOADON";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            while(rs.next()){
                HoaDon h=new HoaDon();
                h.setMaHD(rs.getString("MAHD"));
                h.setNgayBan(rs.getDate("NGAYBAN"));
                h.setTenVN(rs.getString("TENNV"));
                h.setMaKH(rs.getString("MAKH"));
                h.setTienBan(rs.getFloat("TIENBAN"));
                h.setGiamGia(rs.getFloat("GIAMGIA"));
                h.setThanhTien(rs.getFloat("THANHTIEN"));
                dsHD.add(h);
            }
            provider.close();
        } catch (Exception e) {
        }
        return dsHD;
    }
    public static ArrayList<ChiTietHD> layDanhSachCTHD(){
        ArrayList<ChiTietHD> dsCTHD=new ArrayList<ChiTietHD>();
        try {
            String sql="select * from CHITIETHD";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            while(rs.next()){
                ChiTietHD h=new ChiTietHD();
                h.setMaHD(rs.getString("MAHD"));
                h.setMaDT(rs.getString("MADT"));
                h.setSl(rs.getInt("SOLUONG"));
                h.setGiaBan(rs.getFloat("GIABAN"));
                h.setThanhTien(rs.getFloat("THANHTIEN"));
                dsCTHD.add(h);
            }
            provider.close();
        } catch (Exception e) {
        }
        return dsCTHD;
    }
    public static ArrayList<DonGia> layDanhSachDG(){
        ArrayList<DonGia> dsDG=new ArrayList<DonGia>();
        try {
            String sql="select * from DONGIA";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            while(rs.next()){
                DonGia dg=new DonGia();
                dg.setMaDT(rs.getString("MADT"));
                dg.setNgayAD(rs.getDate("NGAYAD"));
                dg.setGia(rs.getFloat("GIA"));
                dsDG.add(dg);
            }
            provider.close();
        } catch (Exception e) {
        }
        return dsDG;
    }
    public static boolean themhang(Hang h){
        boolean kq=false;
        String sql= String.format("Insert into Hang values ('%s','%s',%s,N'%s',N'%s')",h.getMaDT(),h.getTenDT(),h.getSl(),h.getTenNSX(),h.getTenNCC());
        SQLServerDataProvider provider=new SQLServerDataProvider();
        provider.open();
        int n= provider.executeUpdate(sql);
        if(n==1)
            kq=true;
        provider.close();
        return kq;
    }
    public static Hang timhang(String madt){
        Hang h=null;
        try {
            String sql="Select * from HANG where MADT="+madt;
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs= provider.executeQuery(sql);
            if(rs.next()){
                h=new Hang();
                h.setMaDT(rs.getString("MADT"));
                h.setTenDT(rs.getString("TENDT"));
                h.setSl(rs.getString("SOLUONG"));
                h.setTenNSX(rs.getString("TENSX"));
                h.setTenNCC(rs.getString("TENCC"));
            }
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h;
    }
}
