package com.example.kelompok_8.lib.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.kelompok_8.R;
import com.example.kelompok_8.lib.Interface.ProductItemClickListener;
import com.example.kelompok_8.lib.Model.Product;
import com.example.kelompok_8.lib.adapter.ProductItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MoreWisata extends AppCompatActivity {

    private ImageView btnBack;

    private List<Product> productItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_wisata);

        // Button Kembali
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Settings List Voew
        // List Product
        ListView listViewProducts = findViewById(R.id.listViewProducts);

        // Inisialisasi list produk
        productItemList = new ArrayList<>();

        // Tambahkan produk ke productItemList
        productItemList.add(new Product("Rosin Hotel Resort", "Rosin Hotel Resort terletak di jantung Desa Karangasem, Bantul, menawarkan perpaduan sempurna antara kenyamanan modern dan keindahan alam pedesaan. " +
                "Resort ini menjadi destinasi ideal bagi wisatawan yang mencari ketenangan, " +
                "keindahan alam, dan pengalaman budaya " +
                "yang autentik di Yogyakarta.", "Rp. 500.000","Karang Asem, Muntuk, Kec. Dlingo, Kabupaten Bantul, Daerah Istimewa Yogyakarta", R.drawable.item1));

        productItemList.add(new Product("Homestay Kawasan Deswita Karang Asem", "Homestay Kawasan Deswita Karang Asem terletak di Desa Karangasem, Bantul," +
                " sebuah daerah yang dikenal dengan keindahan alam dan budaya tradisional Jawa yang kental." +
                "Homestay ini menawarkan pengalaman menginap yang hangat dan autentik," +
                "membuat para tamu merasa seperti di rumah sendiri sambil menikmati pesona pedesaan Yogyakarta.", "Rp. 300.000", "Karang Asem, Muntuk, Kec. Dlingo, Kabupaten Bantul, Daerah Istimewa Yogyakarta", R.drawable.item2));

        productItemList.add(new Product("Almiya Homestay", "Almiya Homestay terletak di Desa Karangasem, Bantul, menawarkan pengalaman menginap yang nyaman dan autentik di tengah-tengah keindahan pedesaan Yogyakarta. " +
                "Homestay ini merupakan tempat yang ideal bagi para wisatawan" +
                "yang ingin merasakan keramahan lokal dan keindahan alam sekitar", "Rp. 100.000", "Karang Asem, Muntuk, Kec. Dlingo, Kabupaten Bantul, Daerah Istimewa Yogyakarta",  R.drawable.item3));

        productItemList.add(new Product("Wisata Menganyam Bambu", "Wisata Menganyam Bambu di Desa Karangasem, Bantul, adalah destinasi unik yang menawarkan pengalaman mendalam dalam seni tradisional menganyam bambu. " +
                "Kegiatan ini tidak hanya memberikan wawasan tentang kerajinan tangan khas Jawa, " +
                "tetapi juga memungkinkan para wisatawan untuk berpartisipasi secara langsung dalam proses kreatif tersebut.", "Rp. 50.000", "Karang Asem, Muntuk, Kec. Dlingo, Kabupaten Bantul, Daerah Istimewa Yogyakarta",  R.drawable.item4));

        // Inisialisasi adapter
        ProductItemAdapter adapterItem = new ProductItemAdapter(this, productItemList, new ProductItemClickListener() {
            @Override
            public void onProductItemClick(Product product) {
                // Navigasi ke halaman detail produk dan kirimkan data produk yang dipilih
                Intent intent = new Intent(MoreWisata.this, DetailProduct.class);
                intent.putExtra("product", product);
                startActivity(intent);
            }
        });

        listViewProducts.setAdapter(adapterItem);
    }
}