/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class Petugas {
    private int idpetugas;
    private String nama, alamat, gender;
    private String telepon;
    
    public Petugas(){
        
    }
    
    public Petugas(String nama, String alamat, String telepon, String gender){
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.gender = gender;
    }
    
    public Petugas getById(int id){
        Petugas kat = new Petugas();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM petugas"
                + " WHERE idpetugas = '" +id+ "'");
        
        try{
            while(rs.next()){
                kat = new Petugas();
                kat.setIdPetugas(rs.getInt("idpetugas"));
                kat.setNama(rs.getString("nama"));
                kat.setAlamat(rs.getString("alamat"));
                kat.setTelepon(rs.getString("telepon"));
                kat.setGender(rs.getString("gender"));
            }
        }
        catch(SQLException e){
        }
        return kat;
    }
    
    public ArrayList<Petugas> getAll(){
        ArrayList<Petugas> ListPetugas = new ArrayList();
        String keyword = null;
        
        String sql = "SELECT * FROM petugas";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Petugas kat = new Petugas();
                kat.setIdPetugas(rs.getInt("idpetugas"));
                kat.setNama(rs.getString("nama"));
                kat.setAlamat(rs.getString("alamat"));
                kat.setTelepon(rs.getString("telepon"));
                kat.setGender(rs.getString("gender"));
                
                ListPetugas.add(kat);
            }
        }
        catch (SQLException e){
        }
        return ListPetugas;
    }
    
    public ArrayList<Petugas> search(String keyword){
        ArrayList<Petugas> ListPetugas = new ArrayList();
        
        String sql = "SELECT * FROM petugas WHERE"
                + " nama LIKE '%" + keyword + "%'"
                + " OR alamat LIKE '%" +keyword+ "%' "
                + " OR gender LIKE '%" +keyword+ "%' "
                + " OR telepon LIKE '%" +keyword+ "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Petugas kat = new Petugas();
                kat.setIdPetugas(rs.getInt("idpetugas"));
                kat.setNama(rs.getString("nama"));
                kat.setAlamat(rs.getString("alamat"));
                kat.setTelepon(rs.getString("telepon"));
                kat.setGender(rs.getString("gender"));
                
                ListPetugas.add(kat);
            }
        }
        catch (SQLException e){
        }
        return ListPetugas;
    }
    
    public void save(){
        if(getById(idpetugas).getIdPetugas() == 0){
            String SQL = "INSERT INTO petugas (nama, alamat, telepon, gender) VALUES("
                    +"  '" +this.nama+ "',"
                    +"  '" +this.alamat+ "',"
                    +"  '" +this.telepon+ "',"
                    +"  '" +this.gender+ "'"
                    +"  )";
            this.idpetugas = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE petugas SET"
                    +"  nama = '" +this.nama+ "',"
                    +"  alamat = '" +this.alamat+ "',"
                    +"  telepon = '" +this.telepon+ "',"
                    +"  gender = '" +this.gender+ "'"
                    +"  WHERE idpetugas = '" +this.idpetugas+ "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM petugas WHERE idpetugas = '" +this.idpetugas+ "'";
        DBHelper.executeQuery(SQL);
    }

    public int getIdPetugas() {
        return idpetugas;
    }

    public void setIdPetugas(int idpetugas) {
        this.idpetugas = idpetugas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
