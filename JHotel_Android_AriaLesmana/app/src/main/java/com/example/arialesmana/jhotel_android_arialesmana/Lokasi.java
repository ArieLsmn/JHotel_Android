package com.example.arialesmana.jhotel_android_arialesmana;
/**
 * Pendata lokasi Hotel disertai koordinat dan deskripsi
 *
 * @author Aria Lesmana
 * @version 1.7
 * @since 19-4-2018
 *
 *
 */
public class Lokasi {
        // instance variables - replace the example below with your own
        private float x_coord;
        private float y_coord;
        private String deskripsi;
        /**
         * Constructor for objects of class Lokasi
         */
    public Lokasi(float x_coord,float y_coord,String deskripsiLokasi)
        {
            this.x_coord=x_coord;
            this.y_coord=y_coord;
            deskripsi=deskripsiLokasi;
        }

        /**
         *
         * @return  int x_coord, koordinat x lokasi
         */
        public float getX()
        {
            return x_coord;
        }

        /**
         *
         * @return int y_coord, koordinat y lokasi
         */
        public float getY()
        {
            return y_coord;
        }

        /**
         *
         * @return String deskripsiLokasi, deksripsi dari lokasi
         */
        public String getDeskripsi()
        {
            return deskripsi;
        }

        /**
         *
         * @param x_coord Koordinat x yang akan diset
         */
        public void setX(float x_coord)
        {
            this.x_coord=x_coord;
        }

        /**
         *
         * @param y_coord Koordinat y yang akan diset
         */
        public void setY(float y_coord)
        {
            this.y_coord=y_coord;
        }

        /**
         *
         * @param deskripsi Deskripsi dari lokasi
         */
        public void setDeskripsi(String deskripsi){
        this.deskripsi=deskripsi;
    }

        /**
         *
         * @return String Data dari lokasi
         */
        public String toString(){
        String locX = "X : "+this.x_coord+"\n";
        String locY = "Y : "+this.y_coord+"\n";
        String locDeskripsi = "Deskripsi : "+this.deskripsi+"\n";

        return locX+locY+locDeskripsi;
    }
}

