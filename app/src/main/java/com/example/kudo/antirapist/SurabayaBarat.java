package com.example.kudo.antirapist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Kudo on 7/16/2016.
 */
public class SurabayaBarat extends AppCompatActivity {
    Intent goToMaps;
    ArrayAdapter alamatAdapter;
    String[] daftarAlamat = new String[] {
            "Jalan Tanjungsari",
            "Jalan Lawu",
            "Jalan Putat Jaya",
            "Pakuwon Indah The Mansion"
    };
    Double[] geoLatitude = new Double[] {
            -7.2592876,
            -7.2576333,
            -7.2785238,
            -7.2907775
    };
    Double[] geoLongitude = new Double[] {
            112.6834695,
            112.7263182,
            112.7182507,
            112.6738211
    };
    Integer[] daftarFoto = new Integer[] {
            R.drawable.barat_1,
            R.drawable.barat_2,
            R.drawable.barat_3,
            R.drawable.barat_4
    };
    String[] daftarHeadline = new String[]{
            "Pengeroyokan di Jalan Tanjungsari Surabaya Berujung Tewaskan Dua Warga",
            "Cari Obat Altarnatif Buat Bibi, Malah Diperkosa",
            "Cegah Jadi Korban Kejahatan Seksual Anak, Kejaksaan Ingatkan Warha Putat Jaya",
            "Komplotan Perampok Tewas Ditembak Punya Bos Besar"
    };
    String[] daftarTanggal = new String[] {
            "Rabu, 5 Agustus 2015 12:54 WIB",
            "Senin, 25 April 2011 03:45 WIB",
            "SELASA, MEI 17, 2016",
            "May 5th, 2014, 12:55 pm"
    };
    String[] daftarLink = new String[] {
            "http://news.detik.com/berita-jawa-timur/2776164/7-abg-komplotan-penjambret-di-surabaya-diringkus-polisi",
            "http://surabayaraya.com/tinggalkan-bukti-kejahatan-dua-jambret-tertangkap-saat-menginap-di-hotel/",
            "http://www.kabarprogresif.com/2016/05/cegah-jadi-korban-kejahatan-seksual.html",
            "http://sumutpos.co/komplotan-perampok-tewas-ditembak-punya-bos-besar/"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surabaya_barat);
        final ListView alamat = (ListView)findViewById(R.id.namaAlamat);
        alamatAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_2, android.R.id.text2, daftarAlamat);
        alamat.setAdapter(alamatAdapter);

        alamat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToMaps = new Intent(SurabayaBarat.this, MainActivity.class);
                Bundle dataLokasi = new Bundle();
                try {
                    dataLokasi.putDouble("latitude", geoLatitude[position]);
                    dataLokasi.putDouble("longitude", geoLongitude[position]);
                    dataLokasi.putString("location", daftarAlamat[position]);
                    dataLokasi.putString("headline", daftarHeadline[position]);
                    dataLokasi.putString("tanggal", daftarTanggal[position]);
                    dataLokasi.putString("link", daftarLink[position]);
                    dataLokasi.putInt("foto", daftarFoto[position]);
                    goToMaps.putExtras(dataLokasi);
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
                startActivity(goToMaps);
            }
        });
    }
}
