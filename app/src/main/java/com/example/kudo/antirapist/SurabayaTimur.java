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
public class SurabayaTimur extends AppCompatActivity {
    ArrayAdapter alamatAdapter;
    Integer[] daftarFoto = new Integer[] {
            R.drawable.timur_1
    };
    String[] daftarHeadline = new String[]{
            "Polisi Bekuk Residivis Komplotan Penjahat Jalanan"
    };
    String[] daftarTanggal = new String[] {
            "30 Desember 2015"
    };
    String[] daftarLink = new String[] {
            "http://tribratanewsjatim.com/polisi-bekuk-residivis-komplotan-penjahat-jalanan/"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surabaya_timur);
        final ListView alamat = (ListView)findViewById(R.id.namaAlamat);
        final String[] daftarAlamat = new String[] {
                "Jalan Mendut"
        };
        alamatAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_2, android.R.id.text2, daftarAlamat);
        alamat.setAdapter(alamatAdapter);

        alamat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goToMaps = new Intent(SurabayaTimur.this, MainActivity.class);
                Double geoLatitude = -7.2576079;
                Double geoLongitude = 112.7528076;
                Bundle dataLokasi = new Bundle();

                dataLokasi.putDouble("latitude", geoLatitude);
                dataLokasi.putDouble("longitude", geoLongitude);
                dataLokasi.putString("location", daftarAlamat[position]);
                dataLokasi.putString("headline", daftarHeadline[position]);
                dataLokasi.putString("tanggal", daftarTanggal[position]);
                dataLokasi.putString("link", daftarLink[position]);
                dataLokasi.putInt("foto", daftarFoto[position]);
                goToMaps.putExtras(dataLokasi);

                startActivity(goToMaps);
            }
        });
    }
}
