/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.*;
import java.sql.*;
/**
 *
 * @author fakhryan
 */
public class Peminjaman {
    private int idpeminjaman, idanggota, idbuku;
    private Anggota ang = new Anggota();
    private Buku buku = new Buku();
    private String tanggalPinjam;
    private String tanggalKembali;
    private int denda, total;
    
    public Peminjaman(){
        
    }
    
    public Peminjaman(Anggota ang, Buku buku, String tanggalPinjam, String tanggalKembali, int denda, int total){
        this.ang = ang;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.denda = denda;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public int getIdanggota() {
        return idanggota;
    }

    public void setIdanggota(int idanggota) {
        this.idanggota = idanggota;
    }

    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public Anggota getAng() {
        return ang;
    }

    public void setAng(Anggota ang) {
        this.ang = ang;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }
    
    
    public Peminjaman getById(int id){
        Peminjaman pem = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("Select "
                + "p.idpeminjaman as idpeminjaman, "
                + "p.tanggalpinjam as tanggalpinjam, "
                + "p.tanggalkembali as tanggalkembali, "
                + "p.denda as denda, "
                + "p.total AS total, "
                + "a.idanggota as idanggota, "
                + "b.idbuku as idbuku "
                + "from peminjaman p left join anggota a on p.idanggota = a.idanggota "
                + "left join buku b on p.idbuku = b.idbuku where p.idpeminjaman = '" + id + "'");
        try{
            while(rs.next()){
                pem = new Peminjaman();
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdanggota(rs.getInt("idanggota"));
                pem.setIdbuku(rs.getInt("idbuku"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
                pem.setDenda(rs.getInt("denda"));
                pem.setTotal(rs.getInt("total"));
                pem.setAng(new Anggota().getById(pem.getIdanggota()));
                pem.setBuku(new Buku().getById(pem.getIdbuku()));
                
            }
        }catch(SQLException e){
        }
        return pem;
    }
    
    public ArrayList<Peminjaman> getAll(){
        ArrayList<Peminjaman> ListPinjam = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select "
                + "p.idpeminjaman as idpeminjaman, "
                + "p.tanggalpinjam as tanggalpinjam, "
                + "p.tanggalkembali as tanggalkembali, "
                + "p.denda as denda, "
                + "p.total AS total, "
                + "a.idanggota as idanggota, "
                + "b.idbuku as idbuku "
                + "from peminjaman p left join anggota a on p.idanggota = a.idanggota "
                + "left join buku b on p.idbuku = b.idbuku");
        try{
            while(rs.next()){
                Peminjaman pem = new Peminjaman();
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdanggota(rs.getInt("idanggota"));
                pem.setIdbuku(rs.getInt("idbuku"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
                pem.setDenda(rs.getInt("denda"));
                pem.setTotal(rs.getInt("total"));
                pem.setAng(new Anggota().getById(pem.getIdanggota()));
                pem.setBuku(new Buku().getById(pem.getIdbuku()));
                
                ListPinjam.add(pem);
            }
        }catch(SQLException e){
        }
        return ListPinjam;
    }
    
    public void save(){
        if(getById(idpeminjaman).getIdpeminjaman()== 0){
            String sql = "Insert into peminjaman (idanggota, idbuku, tanggalpinjam, tanggalkembali, denda) "
                    + "values ("
                    + "'" + this.getAng().getIdAnggota() + "', "
                    + "'" + this.getBuku().getIdbuku()+ "', "
                    + "'" + this.tanggalPinjam + "', "
                    + "'" +this.tanggalKembali + "', "
                    + "" +this.denda + " "
                    + ")";
            this.idpeminjaman = DBHelper.insertQueryGetId(sql);
        }else{
            String sql = "Update peminjaman set "
                    + " idanggota = '" + this.getAng().getIdAnggota() + "', "
                    + " idbuku = '" + this.getBuku().getIdbuku() + "', "
                    + " tanggalpinjam = '" + this.tanggalPinjam + "', "
                    + " tanggalkembali = '" + this.tanggalKembali + "',"
                    + " denda = " + this.denda + ""
                    + " WHERE idpeminjaman = "+this.idpeminjaman+"";
            DBHelper.executeQuery(sql);
        }
    }
    
    public void saveP(){
        if(getById(idpeminjaman).getIdpeminjaman()== 0){
            String sql = "Insert into peminjaman (idanggota, idbuku, tanggalpinjam, total) "
                    + "values ("
                    + "'" + this.getAng().getIdAnggota() + "', "
                    + "'" + this.getBuku().getIdbuku()+ "', "
                    + "'" + this.tanggalPinjam + "', "
                    + " " + this.total + " "
                    + ");";
            this.idpeminjaman = DBHelper.insertQueryGetId(sql);
            System.out.println(sql);
        }else{
            String sql = "Update peminjaman set "
                    + " idanggota = '" + this.getAng().getIdAnggota() + "', "
                    + " idbuku = '" + this.getBuku().getIdbuku() + "', "
                    + " tanggalpinjam = '" + this.tanggalPinjam + "', "
                    + " total = " + this.total + " "
                    + " WHERE idpeminjaman = "+this.idpeminjaman+"";
            DBHelper.executeQuery(sql);
        }
        
    }
    
    public void cariAnggota(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from anggota where idanggota = '" + id + "'");
        try{
            while(rs.next()){
                getAng().setIdAnggota(rs.getInt("idanggota"));
                getAng().setNama(rs.getString("nama"));
            }
        }catch(SQLException e){
        }
    }
    
    public void cariBuku(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from buku where idbuku = '" + id + "'");
        try{
            while(rs.next()){
                getBuku().setIdbuku(rs.getInt("idbuku"));
                getBuku().setJudul(rs.getString("judul"));
            }
        }catch(SQLException e){
        }
    }
    
    public void delete(){
        String sql = "Delete from peminjaman where idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(sql);
    }
}
