package com.enoch.shoppersparadise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.enoch.shoppersparadise.DAO.DAO;
import com.enoch.shoppersparadise.model.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class createdb extends AppCompatActivity {
    Button create,go;
    public static final String DATABASE_NAME = "ss";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DAO dao = new DAO(getBaseContext());

        File dbfile=new File("/data/data/com.enoch.shoppersparadise/databases","aa");

        if (!dbfile.exists()) {

        }
        else{

        }



        setContentView(R.layout.activity_createdb);
        create = findViewById(R.id.create);
        go = findViewById(R.id.go);
        Random rand = new Random();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO db = new DAO(getBaseContext());
                Product product = new Product();
                product.setProductName("Samsung Galaxy Note 10");
                product.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/samsung-galaxy-note-10-den.png?alt=media&token=851704cb-3f14-4cf6-a5e1-c38e42cfea1f");
                product.setDescription("Fast charging, long lasting intelligent power and super speed processing outlast whatever you throw at Note 10\n" +
                        "S pen’s newest Evolution gives you the power of air gestures, a remote shutter and playlist button and handwriting to text, all in One Magic wand\n" +
                        "With a full set of Pro lenses, super stabilization, live video bokeh and precision audio recording, Note 10 is a studio in your pocket\n" +
                        "Note 10’s nearly bezel less Infinity display gives an immersive, cinematic quality to whatever you’re viewing\n" +
                        "Internet usage time(LTE) (hours) up to 14. Internet usage time(wi fi) (hours) up to 14. Audio playback time (hours, wireless) up to 60. Talk time (4G LTE) (hours) up to 38. Video playback time (hours, wireless) up to 19.");
                product.setStock(10);
                product.setPrice(584);
                product.setCategoryName("Phone");
                db.addProduct(product);
                Product product1 = new Product();
                product1.setProductName("Iphone XI Pro Max");
                product1.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/iphone-11-pro-max-green-phi-hung-mobile_e81123d842f34a84bf7919a9cd15a3d5_grande.png?alt=media&token=f86f82b8-d4fd-48b7-82db-abb5d37b7e0a");
                product1.setDescription("Fully unlocked and compatible with any carrier of choice (e.g. AT&T, T-Mobile, Sprint, Verizon, US-Cellular, Cricket, Metro, etc.).\n" +
                        "The device does not come with headphones or a SIM card. It does include a charger and charging cable that may be generic, in which case it will be UL or Mfi (Made for iPhone) Certified.\n" +
                        "Inspected and guaranteed to have minimal cosmetic damage, which is not noticeable when the device is held at arms length.\n" +
                        "Successfully passed a full diagnostic test which ensures like-new functionality and removal of any prior-user personal information.\n" +
                        "Tested for battery health and guaranteed to have a minimum battery capacity of 80%.");
                product1.setStock(10);
                product1.setPrice(671);
                product1.setCategoryName("Phone");
                db.addProduct(product1);
                Product product2 = new Product();
                product2.setProductName("Xiaomi Redmi 7");
                product2.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/redmi_7_01-1.png?alt=media&token=82a3abb9-e3d8-4b5d-a8f8-1bdd1faad4a7");
                product2.setDescription("This Certified Refurbished product is tested to work and look like new with minimal to no signs of wear & tear; the product comes with relevant accessories and is backed by a minimum six month supplier backed warranty; box may be generic\n" +
                        "4 GB RAM | 64 GB ROM | Expandable Upto 256 GB | The Corning Gorilla Glass 5\n" +
                        "16.0 cm (6.3 inch) FHD+ Display | 4000 mAh Li-polymer Battery\n" +
                        "(12MP + 2MP ) Back Camera | 13MP Front Camera\n" +
                        "4000 mAh Li-polymer Battery | Corning Gorilla Glass | 5 Face Unlock | IR Remote Control");
                product2.setStock(10);
                product2.setPrice(171);
                product2.setCategoryName("Phone");
                db.addProduct(product2);
                Product product3 = new Product();
                product3.setProductName("Vans CANVAS SK8-HI");
                product3.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/TRIBAL%20CHECK%20-TRUEWHITE%20-%24120.png?alt=media&token=a02bf1d1-a6cb-417a-abcc-3121003095f7");
                product3.setDescription("Package Dimensions : 14.1 x 8.8 x 5.1 inches; 2.56 Pounds\n" +
                        "Item model number : VN0A38GEVS6\n" +
                        "Department : Womens\n" +
                        "Date First Available : March 8, 2019\n" +
                        "Manufacturer : Vans");
                product3.setStock(10);
                product3.setPrice(120);
                product3.setCategoryName("shoes");
                db.addProduct(product3);
                Product product4 = new Product();
                product4.setProductName("LOUNGEWEAR TREFOIL ESSENTIALS HOODIE");
                product4.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/LOUNGEWEAR%20TREFOIL%20ESSENTIALS%20HOODIE_HazyOrange.png?alt=media&token=c9cf78d8-025e-4dfd-8ed3-21a69f6e30d8");
                product4.setDescription("Bell bottoms, disco and lava lamps. Get into a '70s mood with this essential adidas hoodie. An embroidered Trefoil logo adds a touch of class. Soft, all-cotton French terry feels plush.\n" +
                        "\n" +
                        "Our cotton products support sustainable cotton farming. This is part of our ambition to end plastic waste.\n" +
                        "\n");
                product4.setStock(10);
                product4.setPrice(100);
                product4.setCategoryName("shirt");
                db.addProduct(product4);

                Product product5 = new Product();
                product5.setProductName("CLUB QUARTER-ZIP SWEATSHIRT");
                product5.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/CLUB%20QUARTER-ZIP%20SWEATSHIRT_Black.png?alt=media&token=aff817de-15b1-4031-8cd2-a7d42189aef3");
                product5.setDescription("As a die-hard golf fan, you don't head for the clubhouse just because the temperature starts to dip. Play through chilly weather in comfort with this adidas golf sweatshirt. Swing through every shot in a distraction-free fit, and stay cozy until your final putt drops into the cup.\n" +
                        "\n" +
                        "This product is made with recycled content as part of our ambition to end plastic waste.\n" +
                        "\n");
                product5.setStock(10);
                product5.setPrice(120);
                product5.setCategoryName("shirt");
                db.addProduct(product5);

                Product product6 = new Product();
                product6.setProductName("ADIDAS Z.N.E. FULL-ZIP HOODIE");
                product6.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/ADIDAS%20Z.N.E.%20FULL-ZIP%20HOODIE_RoyalBlue.png?alt=media&token=ec7d3f22-7789-4c1b-99b5-796580f904c4");
                product6.setDescription("Put the right recovery plan in place. Make this adidas hoodie a part of it. Because to play hard, you have to rest hard, and the comfortable build of this sweatshirt sets you up for success. It's made of recycled materials as part of the adidas commitment to help end plastic waste.");
                product6.setStock(10);
                product6.setPrice(200);
                product6.setCategoryName("shirt");
                db.addProduct(product6);

                Product product7 = new Product();
                product7.setProductName("3-STRIPES QUARTER-ZIP PULLOVER");
                product7.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/3-STRIPES%20QUARTER-ZIP%20PULLOVER_CrewNavyMel.png?alt=media&token=31099f59-ea2e-4b81-8d3d-e4001b3526cc");
                product7.setDescription("Feel great on the course and look good in the clubhouse. This adidas golf pullover has a doubleknit design that hides a sweat-wicking, mesh interior under a soft, casual exterior. Brisk days on the course never felt this good. Recycled materials are one step towards reducing plastic waste.");
                product7.setStock(10);
                product7.setPrice(70);
                product7.setCategoryName("shirt");
                db.addProduct(product7);

                Product product8 = new Product();
                product8.setProductName("Nike Pro Warm");
                product8.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/Nike%20Pro%20Warm.png?alt=media&token=2f5249ca-629a-44ff-aae7-839c111392cb");
                product8.setDescription("Ideal for wear on its own or layered under a kit, the Nike Pro Warm Top helps keep you warm and moving naturally. Ribbing in key areas allows flexibility where you need it. This product is made from at least 75% recycled polyester fabric.\n" +
                        "\n" +
                        "Colour Shown: Black/White\n" +
                        "Style: CV3047-010");
                product8.setStock(10);
                product8.setPrice(110);
                product8.setCategoryName("shirt");
                db.addProduct(product8);

                Product product9 = new Product();
                product9.setProductName("Converse Chuck Taylor");
                product9.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/Chuck%20Taylor%20All%20Star-%20BlackWhite%20%24150.png?alt=media&token=18c70385-c709-4e06-8eb2-51ffae2304e9");
                product9.setDescription("Casual shoes with durable canvas uppers.\n" +
                        "Lace-up front with metal eyelets.\n" +
                        "Canvas lining and a cushioned footbed provides hours of comfort.\n" +
                        "Original rubber toe box and toe guard, tonal sidewall trim and All Star® heel patch.\n" +
                        "Signature Converse® rubber outsole.\n" +
                        "Imported.\n" +
                        "Product measurements were taken using size Men's 9, Women's 11, width Medium. Please note that measurements may vary by size.\n" +
                        "Weight of footwear is based on a single item, not a pair.\n" +
                        "Measurements:\n" +
                        "Weight: 15 oz");
                product9.setStock(10);
                product9.setPrice(150);
                product9.setCategoryName("shoes");
                db.addProduct(product9);
                Product product10 = new Product();
                product10.setProductName("BASAS BUMPER");
                product10.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/Brown.png?alt=media&token=84681fa9-12bb-4bb9-9c8a-f964115bd162");
                product10.setDescription("Casual shoes with durable canvas uppers.\n" +
                        "Lace-up front with metal eyelets.\n" +
                        "Canvas lining and a cushioned footbed provides hours of comfort.\n" +
                        "Original rubber toe box and toe guard, tonal sidewall trim and All Star® heel patch.\n" +
                        "Signature Converse® rubber outsole.\n" +
                        "Imported.\n" +
                        "Product measurements were taken using size Men's 9, Women's 11, width Medium. Please note that measurements may vary by size.\n" +
                        "Weight of footwear is based on a single item, not a pair.\n" +
                        "Measurements:\n" +
                        "Weight: 15 oz");
                product10.setStock(10);
                product10.setPrice(115);
                product10.setCategoryName("shoes");
                db.addProduct(product10);
                Product product11 = new Product();
                product11.setProductName("Nike Air Zoom Pegasus");
                product11.setProductImage("https://firebasestorage.googleapis.com/v0/b/shopper-e3a25.appspot.com/o/Pink.png?alt=media&token=dd1866bc-2fa6-4997-b723-5ab821b359cd");
                product11.setDescription("The Nike Air Zoom Pegasus 38 returns to put a spring in your steps, skips and jumps using the same responsive foam as its predecessor. Breathable mesh in the upper combines the comfort and durability you want, plus more wiggle room for your toes.\n" +
                        "\n" +
                        "Colour Shown: Particle Grey/Midnight Navy/White\n" +
                        "Style: CZ4178-015");
                product11.setStock(10);
                product11.setPrice(218);
                product11.setCategoryName("shoes");
                db.addProduct(product11);

                new AlertDialog.Builder(createdb.this)
                        .setTitle("Success")
                        .setMessage("Success")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        }).show();
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(createdb.this, MainActivity.class));
            }
        });
    }
}