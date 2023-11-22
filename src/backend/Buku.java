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
public class Buku {
    private int idbuku;
    private Kategori kategori= new Kategori();
    private String judul, penerbit, penulis;
    private int tahun_terbit, total;

    public Buku(){
        
    }
    
    public Buku(Kategori kategori, String judul, String penerbit, String penulis, int tahun_terbit, int total){
        this.kategori = kategori;
        this.judul = judul;
        this.penerbit = penerbit;
        this.penulis = penulis;
        this.tahun_terbit = tahun_terbit;
        this.total = total;
    }
    
    public Buku getById(int id){
        Buku buku = new Buku();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " b.idbuku AS idbuku, "
                + " b.judul AS judul, "
                + " b.penerbit AS penerbit, "
                + " b.penulis AS penulis, "
                + " b.tahun_terbit AS tahun_terbit, "
                + " b.total AS total, "
                + " k.idkategori AS idkategori, "
                + " k.nama AS nama, "
                + " k.keterangan AS keterangan "
                + " FROM buku b "
                + " LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                + " WHERE b.idbuku = '" +id+ "'");
        
        try{
            while(rs.next()){
                buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setTahun_terbit(rs.getInt("tahun_terbit"));
                buku.setTotal(rs.getInt("total"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return buku;
    }
    
    public ArrayList<Buku> getAll(){
        ArrayList<Buku> ListBuku = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " b.idbuku AS idbuku, "
                + " b.judul AS judul, "
                + " b.penerbit AS penerbit, "
                + " b.penulis AS penulis, "
                + " b.tahun_terbit AS tahun_terbit, "
                + " b.total AS total, "
                + " k.idkategori AS idkategori, "
                + " k.nama AS nama, "
                + " k.keterangan AS keterangan "
                + " FROM buku b "
                + " LEFT JOIN kategori k ON b.idkategori = k.idkategori ");
        
        try{
            while(rs.next()){
                Buku buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setTahun_terbit(rs.getInt("tahun_terbit"));
                buku.setTotal(rs.getInt("total"));
                
                ListBuku.add(buku);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListBuku;
    }
    
    public ArrayList<Buku> search(String keyword){
        ArrayList<Buku> ListBuku = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + " b.idbuku AS idbuku, "
                + " b.judul AS judul, "
                + " b.penerbit AS penerbit, "
                + " b.penulis AS penulis, "
                + " b.tahun_terbit AS tahun_terbit, "
                + " b.total AS total, "
                + " k.idkategori AS idkategori, "
                + " k.nama AS nama, "
                + " k.keterangan AS keterangan "
                + " FROM buku b "
                + " LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                + " WHERE b.judul LIKE '%" +keyword+ "%' "
                        + " OR b.penerbit LIKE '%" +keyword+ "%' "
                        + " OR b.penerbit LIKE '%" +keyword+ "%' ");
        
        try{
            while(rs.next()){
                Buku buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setTahun_terbit(rs.getInt("tahun_terbit"));
                buku.setTotal(rs.getInt("total"));
                
                ListBuku.add(buku);
            }
        } catch(SQLException e){
        }
        return ListBuku;
    }
    
    public void save(){
        if(getById(idbuku).getIdbuku() == 0){
            String SQL = "INSERT INTO buku (judul, idkategori, penulis, penerbit, tahun_terbit, total) VALUES("
                    +"  '" +this.judul+ "',"
                    +"  '" +this.getKategori().getIdkategori()+ "',"
                    +"  '" +this.penulis+ "',"
                    +"  '" +this.penerbit+ "',"
                    +"  " +this.tahun_terbit+ ","
                    +"  " +this.total+ ""
                    +"  )";
            this.idbuku = DBHelper.insertQueryGetId(SQL);
        }
        else{
            String SQL = "UPDATE buku SET"
                    +"  judul = '" +this.judul+ "',"
                    +"  idkategori = '" +this.getKategori().getIdkategori()+ "',"
                    +"  penulis = '" +this.penulis+ "',"
                    +"  penerbit = '" +this.penerbit + "',"
                    +"  tahun_terbit = " +this.tahun_terbit + ","
                    +"  total = " +this.total + ""
                    +"  WHERE idbuku = '" +this.idbuku+ "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM buku WHERE idbuku = '" +this.idbuku+ "'";
        DBHelper.executeQuery(SQL);
    }
    
    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(int tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
