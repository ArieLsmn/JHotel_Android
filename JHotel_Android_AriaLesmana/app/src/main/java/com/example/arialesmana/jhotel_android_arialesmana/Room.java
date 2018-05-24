package com.example.arialesmana.jhotel_android_arialesmana;

/**
 * Pendata kamar pada Hotel
 *
 * @author Aria Lesmana
 * @version 1.8
 * @since 19-4-2018
 */
public class Room {
    private Hotel hotel;//new Hotel("Prodeo",new Lokasi(100,100,"Jakarta"),5);
    private String roomNumber;
    private String statusKamar;// status_kamar=StatusKamar.Vacant;
    private double dailyTariff;
    private String tipeKamar;

    /**
     * Constructor for objects of class Room
     */
    public Room(String roomNumber, String statusKamar, double dailyTariff, String tipeKamar) {
        //this.hotel=hotel;
        this.roomNumber = roomNumber;
        this.dailyTariff = dailyTariff;
        this.statusKamar = statusKamar;
        this.tipeKamar = tipeKamar;
    }

    /**
     * @return the sum of x and y
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * @return
     */
    public String getNomorKamar() {
        return roomNumber;
    }

    /**
     * @return
     */
    public double getDailyTariff() {
        return dailyTariff;
    }

    /**
     * @return
     */
    public String getStatusKamar() {
        return statusKamar;
    }

    /*public Pesanan getPesanan(){
        return pesan;
    }*/

    /**
     * @return
     */
    public String getTipeKamar()
    {
        return tipeKamar;
    }

    /**
     *
     * @param hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * @param nomor_kamar
     */
    public void setNomorKamar(String nomor_kamar) {
        this.roomNumber = nomor_kamar;
    }

    /**
     * @param dailyTariff
     */
    public void setDailyTariff(double dailyTariff) {
        this.dailyTariff = dailyTariff;
    }

    /**
     * @param statusKamar
     */
    public void setStatusKamar(String statusKamar) {
        this.statusKamar = statusKamar;
    }

    /*public void setPesanan(Pesanan pesan){
        this.pesan=pesan;
    }*/


}