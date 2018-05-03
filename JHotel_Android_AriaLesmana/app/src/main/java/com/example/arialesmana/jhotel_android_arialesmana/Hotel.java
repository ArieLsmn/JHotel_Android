package com.example.arialesmana.jhotel_android_arialesmana;

/**
 * Pemroses data Hotel
 *
 * @author Aria Lesmana
 * @version 1.7
 * @since 19-4-2018
 *
 *
 */
public class Hotel
{
    private int id;
    private String nama;
    private Lokasi lokasi;// instance variables - replace the example below with your own
    private int bintang;

    /**
     * @param nama
     * @param lokasi
     * @param bintang
     */
    public Hotel(int id,String nama,Lokasi lokasi,int bintang)
    {
        this.nama=nama;
        this.lokasi=lokasi;
        this.bintang=bintang;
        this.id=id;
    }
    /**
     * @return int id
     */
    public int getID(){

        return id;
    }
    /**
     * @return int bintang
     */
    public int getBintang(){

        return bintang;
    }
    /**
     * @return String nama
     */
    public String getNama(){
        return nama;
    }
    /**
     * @return Lokasi lokasi
     */
    public Lokasi getLokasi(){
        return lokasi;
    }
    /**
     * @param id
     */
    public void setID(int id){
        this.id=id;
    }
    /**
     * @param nama
     */
    public void setNama(String nama){
        this.nama=nama;
    }
    /**
     * @param lokasi
     */
    public void setLokasi(Lokasi lokasi){
        this.lokasi=lokasi;
    }
    /**
     * @param bintang
     */
    public void setBintang(int bintang)
    {
        this.bintang=bintang;
    }
    /**
     * @return String informasi dari seluruh variabel kelas
     */
    public String toString(){
        String hotelName = "Nama : "+this.nama+"\n";
        String hotelLokasi = "Lokasi : "+this.lokasi.getDeskripsi()+"\n";
        String hotelBintang = "Bintang: "+this.bintang+"\n";

        return hotelName+hotelLokasi+hotelBintang;
    }

}