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
public class SurabayaUtara extends AppCompatActivity {
    Intent goToMaps;
    ArrayAdapter alamatAdapter;
    String[] daftarAlamat = new String[] {
            "Jalan Indrapura",
            "Jalan Demak"
    };
    Double[] geoLatitude = new Double[] {
            -7.2332837,
            -7.2487298
    };
    Double[] geoLongitude = new Double[] {
            112.7285995,
            112.7186897
    };
    Integer[] daftarFoto = new Integer[] {
            R.drawable.utara_1,
            R.drawable.utara_2
    };
    String[] daftarHeadline = new String[]{
            "7 ABG Komplotan Penjambret di Surabaya Diringkus Polisi",
            "Tinggalkan Bukti Kejahatan, Dua Jambret Tertangkap Saat Menginap Di Hotel",
    };
    String[] daftarTanggal = new String[] {
            "Jumat, 12 Desember 2014, 19:17 WIB",
            "Rabu, 27 Januari 2016, 13:24 WIB",
    };
    String[] daftarLink = new String[] {
            "http://news.detik.com/berita-jawa-timur/2776164/7-abg-komplotan-penjambret-di-surabaya-diringkus-polisi",
            "http://surabayaraya.com/tinggalkan-bukti-kejahatan-dua-jambret-tertangkap-saat-menginap-di-hotel/",
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surabaya_utara);
        final ListView alamat = (ListView)findViewById(R.id.namaAlamat);
        alamatAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_2, android.R.id.text2, daftarAlamat);
        alamat.setAdapter(alamatAdapter);

        alamat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToMaps = new Intent(SurabayaUtara.this, MainActivity.class);
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
