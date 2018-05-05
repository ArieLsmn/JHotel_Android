package com.example.arialesmana.jhotel_android_arialesmana;

/**
 * Pendata kamar pada Hotel
 *
 * @author Aria Lesmana
 * @version 1.8
 * @since 19-4-2018
 */
public class Room
{
    private Hotel hotel;//new Hotel("Prodeo",new Lokasi(100,100,"Jakarta"),5);
    private String roomNumber;
    private String statusKamar;// status_kamar=StatusKamar.Vacant;
    private double dailyTariff;
    private String tipeKamar;
    /**
     * Constructor for objects of class Room
     */
    public Room(String roomNumber,String statusKamar,double dailyTariff,String tipeKamar){
        //this.hotel=hotel;
        this.roomNumber=roomNumber;
        this.dailyTariff=dailyTariff;
        this.statusKamar=statusKamar;
        this.tipeKamar = tipeKamar;
    }

    /**
     * @return    the sum of x and y
     */
    public Hotel getHotel(){
        return hotel;
    }

    /**
     *
     * @return
     */
    public String getNomorKamar(){
        return roomNumber;
    }

    /**
     *
     * @return
     */
    public double getDailyTariff(){
        return dailyTariff;
    }

    /**
     *
     * @return
     */
    /*public StatusKamar getStatusKamar(){
        return status_kamar;
    }

    /*public Pesanan getPesanan(){
        return pesan;
    }*/

    /**
     *
     * @return
     */
    /*abstract public TipeKamar getTipeKamar();

    /**
     *
     * @param hotel
     */
    public void setHotel(Hotel hotel)
    {
        this.hotel=hotel;
    }

    /**
     *
     * @param nomor_kamar
     */
    public void setNomorKamar(String nomor_kamar){
        this.roomNumber=nomor_kamar;
    }

    /**
     *
     * @param dailyTariff
     */
    public void setDailyTariff(double dailyTariff){
        this.dailyTariff=dailyTariff;
    }

    /**
     *
     * @param status_kamar
     */
    /*public void setStatusKamar(StatusKamar status_kamar){
        this.status_kamar=status_kamar;
    }

    /*public void setPesanan(Pesanan pesan){
        this.pesan=pesan;
    }*/

    /**
     *
     * @return
     */
    public String toString(){
        String roomHotel = "Hotel : "+hotel.getNama()+"\n";
        //String roomTipe = "Tipe : "+getTipeKamar()+"\n";
        String roomHarga = "Harga : "+dailyTariff+"\n";
        //String roomStatus = "Status : "+status_kamar+"\n";
        //String roomPelanggan = "Pelanggan : "+DatabasePesanan.getPesananAktif(this)+"\n";
        //String roomCust = "Pelanggan : "+pesan.getPelanggan().getNama()+"\n";
        // if(DatabasePesanan.getPesananAktif(this)== null)
        //     return roomHotel+roomTipe+roomHarga+roomStatus;//+roomCust;

        //else
        return roomHotel/*+roomTipe+roomHarga+roomStatus+roomPelanggan*/;
    }
    /*public void printData(){
        System.out.println("Room");
        System.out.println("Hotel = "+hotel.getNama());
        System.out.println("Nomor = "+nomor_kamar);
        System.out.println("Tipe = "+getTipeKamar());
        System.out.println("Tersedia = "+isAvailable);
        System.out.println("Status = "+status_kamar);
        System.out.println("Harga = "+dailyTariff);
    }*/

}

