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
public class SurabayaPusat extends AppCompatActivity {
    Intent goToMaps;
    ArrayAdapter alamatAdapter;
    String[] daftarAlamat = new String[] {
            "Jalan Genteng Kali",
            "Jalan Ambengan"
    };
    Double[] geoLatitude = new Double[] {
            -7.2561172,
            -7.2559617
    };
    Double[] geoLongitude = new Double[] {
            112.735845,
            112.7467396
    };
    Integer daftarFoto[] = new Integer[] {
            R.drawable.pusat_1,
            R.drawable.pusat_2
    };
    String[] daftarHeadline = new String[]{
            "Anak Polisi Jadi Korban Perampasan Motor Di Jalan Genteng Kali",
            "Kawanan Curanmor Tertangkap saat Razia"
    };
    String[] daftarTanggal = new String[] {
            "Senin, 20 Juni 2016 , 08:05:00",
            "Kamis, 14 April 2016 11:40 WIB"
    };
    String[] daftarLink = new String[] {
            "http://www.jpnn.com/read/2016/06/20/441553/Alamaak-Anak-Polisi-jadi-Korban-Perampasan-Motor-",
            "http://www.realita.co/index.php?news=Kawanan-Curanmor-Tertangkap-saat-Razia~3b1ca0a43b79bdfd9f9305b812982962d36deb26a1d0200d5520abb71bfe28b2"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surabaya_pusat);
        final ListView alamat = (ListView)findViewById(R.id.namaAlamat);
        alamatAdapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_2, android.R.id.text2, daftarAlamat);
        alamat.setAdapter(alamatAdapter);

        alamat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToMaps = new Intent(SurabayaPusat.this, MainActivity.class);
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
