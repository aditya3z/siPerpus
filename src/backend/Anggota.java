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
public class Anggota {
    private int idanggota;
    private String nama, alamat, gender, program_studi;
    private String telepon;
    
    public Anggota(){
        
    }
    
    public Anggota(String nama, String alamat, String telepon, String gender, String program_studi){
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.gender = gender;
        this.program_studi = program_studi;
    }
    
    public Anggota getById(int id){
        Anggota kat = new Anggota();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota"
                + " WHERE idanggota = '" +id+ "'");
        
        try{
            while(rs.next()){
                kat = new Anggota();
                kat.setIdAnggota(rs.getInt("idanggota"));
                kat.setNama(rs.getString("nama"));
                kat.setAlamat(rs.getString("alamat"));
                kat.setTelepon(rs.getString("telepon"));
                kat.setGender(rs.getString("gender"));
                kat.setProgram_studi(rs.getString("program_studi"));
            }
        }
        catch(SQLException e){
        }
        return kat;
    }
    
    public ArrayList<Anggota> getAll(){
        ArrayList<Anggota> ListAnggota = new ArrayList();
        String keyword = null;
        
        String sql = "SELECT * FROM anggota";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Anggota kat = new Anggota();
                kat.setIdAnggota(rs.getInt("idanggota"));
                kat.setNama(rs.getString("nama"));
                kat.setAlamat(rs.getString("alamat"));
                kat.setTelepon(rs.getString("telepon"));
                kat.setGender(rs.getString("gender"));
                kat.setProgram_studi(rs.getString("program_studi"));
                
                ListAnggota.add(kat);
            }
        }
        catch (SQLException e){
        }
        return ListAnggota;
    }
    
    public ArrayList<Anggota> search(String keyword){
        ArrayList<Anggota> ListAnggota = new ArrayList();
        
        String sql = "SELECT * FROM anggota WHERE"
                + " nama LIKE '%" + keyword + "%'"
                + " OR alamat LIKE '%" +keyword+ "%' "
                + " OR gender LIKE '%" +keyword+ "%' "
                + " OR program_studi LIKE '%" +keyword+ "%' "
                + " OR telepon LIKE '%" +keyword+ "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Anggota kat = new Anggota();
                kat.setIdAnggota(rs.getInt("idanggota"));
                kat.setNama(rs.getString("nama"));
                kat.setAlamat(rs.getString("alamat"));
                kat.setTelepon(rs.getString("telepon"));
                kat.setGender(rs.getString("gender"));
                kat.setProgram_studi(rs.getString("program_studi"));
                
                ListAnggota.add(kat);
            }
        }
        catch (SQLException e){
        }
        return ListAnggota;
    }
    
    public void save(){
        if(getById(idanggota).getIdAnggota() == 0){
            String SQL = "INSERT INTO anggota (nama, alamat, telepon, gender, program_studi) VALUES("
                    +"  '" +this.nama+ "',"
                    +"  '" +this.alamat+ "',"
                    +"  '" +this.telepon+ "',"
                    +"  '" +this.gender+ "',"
                    +"  '" +this.program_studi+ "'"
                    +"  )";
            this.idanggota = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE Anggota SET"
                    +"  nama = '" +this.nama+ "',"
                    +"  alamat = '" +this.alamat+ "',"
                    +"  telepon = '" +this.telepon+ "',"
                    +"  gender = '" +this.gender+ "',"
                    +"  program_studi = '" +this.program_studi+ "' "
                    +"  WHERE idanggota = '" +this.idanggota+ "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM anggota WHERE idanggota = '" +this.idanggota+ "'";
        DBHelper.executeQuery(SQL);
    }

    public int getIdAnggota() {
        return idanggota;
    }

    public void setIdAnggota(int idanggota) {
        this.idanggota = idanggota;
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

    public String getProgram_studi() {
        return program_studi;
    }

    public void setProgram_studi(String program_studi) {
        this.program_studi = program_studi;
    }
    
}
