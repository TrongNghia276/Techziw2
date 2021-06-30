package com.enoch.shoppersparadise.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.enoch.shoppersparadise.model.Address;
import com.enoch.shoppersparadise.model.Billing;
import com.enoch.shoppersparadise.model.Cart;
import com.enoch.shoppersparadise.model.Product;
import com.enoch.shoppersparadise.model.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class DAO extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "aa";
    private static final String TABLE_PRODUCT = "product";
    private static final String KEY_ID = "productId";
    private static final String KEY_NAME = "productName";
    private static final String KEY_IMAGE = "productImage";

    private static final String KEY_STOCK = "stock";
    private static final String KEY_PRICE = "price";

    private static final String KEY_CATEGORY = "categoryName";

    private static final String KEY_DES = "description";

    private static final String TABLE_USER = "User";
    private static final String KEYID = "userId";
    private static final String KEYNAME = "userName";
    private static final String FULLNAME = "fullName";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    private static final String TABLE_ADDRESS = "Address";
    private static final String ADDRESS_ID = "addressId";
    private static final String ADDRESSU_ID = "UserId";
    private static final String Line1 = "line1";
    private static final String Line2 = "line2";
    private static final String Phone = "phone";
    private static final String City = "city";
    private static final String Zipcode = "zipcode";
    private static final String State = "state";
    private static final String Country = "country";

    private static final String TABLE_CART = "Cart";
    private static final String cartId = "cartId";
    private static final String productId = "productId";
    private static final String quantity = "quantity";
    private static final String couponId = "couponId";
    private static final String addressId = "addressId";
    private static final String userId = "userId";

    private static final String TABLE_BILL = "Billing";
    private static final String BillID = "BillID";
    private static final String UserId = "UserId";
    private static final String FullName = "FullName";
    private static final String date = "date";
    private static final String ProductName = "ProductName";
    private static final String Phonebill = "Phone";
    private static final String Line1b = "Line1";
    private static final String Line2b = "Line2";
    private static final String TotalPrice = "TotalPrice";
    private static final String payment = "payment";

    private static String TAG = DAO.class.getName();
    private  String DB_PATH = "/data/data/com.enoch.shoppersparadise/databases/";
    private static String DB_NAME = "ss";
    private SQLiteDatabase myDataBase = null;
    private final Context myContext;

    public DAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        myContext = context;
        Log.v("log_tag", "DBPath: " + DB_PATH);
    }
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(dbExist){
            Log.v("log_tag", "database does exist");
        }else{
            Log.v("log_tag", "database does not exist");
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private boolean checkDataBase(){

        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();

    }

    public boolean openDataBase() throws SQLException
    {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        myDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return myDataBase != null;

    }


    @Override
    public synchronized void close()
    {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
    if(!checkDataBase()){
        Log.i("DAO","Create db");
    }

        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_IMAGE + " TEXT," + KEY_PRICE +" INTEGER," + KEY_DES+" TEXT," +  KEY_STOCK+" INTEGER," + KEY_CATEGORY+" TEXT" +" )";



        db.execSQL(CREATE_PRODUCT_TABLE);
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEYID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEYNAME + " TEXT,"
                + FULLNAME + " TEXT," + PASSWORD +" TEXT," + EMAIL +" TEXT" +")";

        db.execSQL(CREATE_USER_TABLE);
        String CREATE_ADDRESS_TABLE = "CREATE TABLE " + TABLE_ADDRESS + "("
                + ADDRESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + ADDRESSU_ID + " INTEGER,"
                + Line1 + " TEXT," + Line2 +" TEXT," + Phone +" TEXT,"  + City +" TEXT," + Zipcode +" TEXT," + State +" TEXT,"+ Country +" TEXT" +")";

        db.execSQL(CREATE_ADDRESS_TABLE);
        String CREATE_CART_TABLE = "CREATE TABLE " + TABLE_CART + "("
                + cartId + " INTEGER PRIMARY KEY AUTOINCREMENT," + productId + " INTEGER,"
                + quantity + " INTEGER," + couponId +" INTEGER," + addressId +" INTEGER,"  + userId +" INTEGER" +")";

       db.execSQL(CREATE_CART_TABLE);
       String CREATE_BILL_TABLE = "CREATE TABLE " + TABLE_BILL + "("
                + BillID + " INTEGER PRIMARY KEY AUTOINCREMENT," + UserId + " INTEGER,"
                + FullName + " TEXT," + date +" TEXT," + ProductName +" TEXT,"  + Phone +" TEXT," +Line1b +" TEXT," +Line2b +" TEXT," +TotalPrice +" INT," +payment +" TEXT" +")";

        db.execSQL(CREATE_BILL_TABLE);
    }

    public List<Cart> getListCart(int id) {
        List<Cart> cart = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CART, new String[] { cartId,
                        productId, quantity,couponId ,addressId,userId}, userId + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Cart cart1 = new Cart(parseInt(cursor.getString(0)),
                        parseInt(cursor.getString(1)), parseInt(cursor.getString(2)), parseInt(cursor.getString(3)), parseInt(cursor.getString(4)),parseInt(cursor.getString(5))
                        );
                cart.add(cart1);
            } while (cursor.moveToNext());
        }

        // return contact

        db.close();
        return cart;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);

        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESS);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        onCreate(db);
        db.close();
    }
    public void addAddress(Address address) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ADDRESSU_ID, address.getUserId());
        values.put(Line1, address.getLine1());

        values.put(Line2, address.getLine2());
        values.put(Phone, address.getPhone());
        values.put(City, address.getCity());
        values.put(Zipcode, address.getZipcode());
        values.put(State, address.getState());
        values.put(Country, address.getCountry());
        db.insert(TABLE_ADDRESS, null, values);
        db.close();
    }

    public List<Billing> getListBill(int id) {
        List<Billing> bill = new ArrayList<Billing>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BILL, new String[] { BillID,
                        UserId, FullName,date ,ProductName,Phone,Line1,Line2,TotalPrice,payment}, UserId + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Billing bill1 = new Billing(parseInt(cursor.getString(0)),
                        parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)
                        , cursor.getString(6), cursor.getString(7),parseInt(cursor.getString(8)), cursor.getString(9));
                bill.add(bill1);
            } while (cursor.moveToNext());
        }

        // return contact

        db.close();
        return bill;

    }
    public void addBill(Billing bill) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserId, bill.getUserId());
        values.put(FullName, bill.getFullName());

        values.put(date, bill.getDate());
        values.put(ProductName, bill.getProductName());
        values.put(Phone, bill.getPhone());
        values.put(Line1b, bill.getLine1());
        values.put(Line2b, bill.getLine2());
        values.put(TotalPrice, bill.getTotalPrice());

        values.put(payment, bill.getPayment());
        db.insert(TABLE_BILL, null, values);
        db.close();
    }
    public Integer deleteCart (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CART,
                cartId+" = ? ",
                new String[] { Integer.toString(id) });
    }
    public Integer deleteCartPro (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CART,
                userId+" = ? ",
                new String[] { Integer.toString(id) });
    }
    public void addCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(productId, cart.getProductId());
        values.put(quantity, cart.getQuantity());
        values.put(userId, cart.getUserId());
        values.put(couponId, cart.getCouponId());
        values.put(addressId, cart.getAddressId());
        db.insert(TABLE_CART, null, values);
        db.close();
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEYNAME, user.getUserName());
        values.put(FULLNAME, user.getFullName());

        values.put(PASSWORD, user.getPassword());
        values.put(EMAIL, user.getEmail());
        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public List<Address> getListAddress(int id) {
        List<Address> address = new ArrayList<Address>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ADDRESS, new String[] { ADDRESS_ID,
                        ADDRESSU_ID, Line1,Line2 ,Phone,City,Zipcode,State,Country}, ADDRESSU_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Address addr = new Address(parseInt(cursor.getString(0)),
                        parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)
                        , cursor.getString(6), cursor.getString(7), cursor.getString(8));
                address.add(addr);
            } while (cursor.moveToNext());
        }

        // return contact

        db.close();
        return address;

    }
    public User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[] { KEYID,
                        KEYNAME, FULLNAME,PASSWORD ,EMAIL}, KEYID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return contact

        db.close();
        return user;
    }
    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getProductName());
        values.put(KEY_IMAGE, product.getProductImage());

        values.put(KEY_PRICE, product.getPrice());
        values.put(KEY_DES, product.getDescription());
        values.put(KEY_STOCK, product.getStock());
        values.put(KEY_CATEGORY, product.getCategoryName());
        db.insert(TABLE_PRODUCT, null, values);
        db.close();
    }

    public void updateCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(productId, cart.getProductId());
        values.put(quantity, cart.getQuantity());
        values.put(userId, cart.getUserId());
        values.put(couponId, cart.getCouponId());
        values.put(addressId, cart.getAddressId());
        db.update(TABLE_CART,values,cartId +" = "+cart.getCartId(),null);
        db.close();

    }
    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<Product>();
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setProductId(parseInt(cursor.getString(0)));
                product.setProductName(cursor.getString(1));
                product.setProductImage(cursor.getString(2));
                product.setPrice(cursor.getInt(3));
                product.setDescription(cursor.getString(4));
                product.setStock(cursor.getInt(5));
                product.setCategoryName(cursor.getString(6));
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return productList;

    }
    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setUserId(parseInt(cursor.getString(0)));
                user.setUserName(cursor.getString(1));
                user.setFullName(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                user.setEmail(cursor.getString(4));
                users.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return users;

    }
    public boolean updateProduct (Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getProductName());
        values.put(KEY_IMAGE, product.getProductImage());

        values.put(KEY_PRICE, product.getPrice());
        values.put(KEY_DES, product.getDescription());
        values.put(KEY_STOCK, product.getStock());
        values.put(KEY_CATEGORY, product.getCategoryName());
        db.update(TABLE_PRODUCT, values, "productId = ? ", new String[] { Integer.toString(product.getProductId()) } );
        db.close();
        return true;
    }
    public int numberOfRowsProduct(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.close();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_PRODUCT);
        return numRows;
    }
}
