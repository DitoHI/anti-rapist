package com.example.kudo.antirapist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Kudo on 7/16/2016.
 */
public class SurabayaSelatan extends AppCompatActivity {
    Intent goToMaps;
    ArrayAdapter alamatAdapter;
    String[] daftarAlamat = new String[] {
            "Jalan Gayungsari Timur",
            "Jalan Raya Pasar Kembang",
            "Jalan Raya Darmo"
    };
    Double[] geoLatitude = new Double[] {
            -7.3378053,
            -7.2709288,
            -7.2834958
    };
    Double[] geoLongitude = new Double[] {
            112.719477,
            112.7261353,
            112.7346265
    };
    Integer[] daftarFoto = new Integer[] {
            R.drawable.jalan_gayungsari_timur,
            R.drawable.jalan_raya_pasar_kembang,
            R.drawable.jalan_raya_darmo
    };
    String[] daftarHeadline = new String[]{
            "Rampas Hp di Gayungsari, Dua Pelajar SMA Dihajar Massa dan Nyaris Dibakar",
            "Tak Punya Uang Hadiri Kondangan, ABG Jambret Tas",
            "Kenal Lewat BBM, Dua Pelajar di Surabaya Gauli Pelajar SMP"
    };
    String[] daftarTanggal = new String[] {
            "Selasa, 12 Januari 2016 01:36 WIB",
            "Minggu, 15 Mei 2016",
            "Minggu, 13 Maret 2016 23:00 WIB"
    };
    String[] daftarLink = new String[] {
            "http://www.bangsaonline.com/berita/17941/rampas-hp-di-gayungsari-dua-pelajar-sma-dihajar-massa-dan-nyaris-dibakar",
            "http://surabayanews.co.id/2016/05/15/59035/tak-punya-uang-hadiri-kondangan-abg-jambret-tas.html",
            "http://www.bangsaonline.com/berita/20415/kenal-lewat-bbm-dua-pelajar-di-surabaya-gauli-pelajar-smp-ditangkap-saat-gituan"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surabaya_selatan);
        final ListView alamat = (ListView)findViewById(R.id.namaAlamat);
        alamatAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_2, android.R.id.text2, daftarAlamat);
        alamat.setAdapter(alamatAdapter);

        alamat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToMaps = new Intent(SurabayaSelatan.this, MainActivity.class);
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
