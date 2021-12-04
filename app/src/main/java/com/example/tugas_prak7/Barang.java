package com.example.tugas_prak7;

public class Barang {
    private String _id, _namabarang, _warna, _berat;
    public Barang (String id, String nama, String warna, String berat) {
        this._id = id;
        this._namabarang = nama;
        this._warna = warna;
        this._berat = berat;
    }
    public Barang() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _namabarang;
    }
    public void set_nama(String _nama) {
        this._namabarang = _nama;
    }
    public String get_warna() {
        return _warna;
    }
    public void set_warna(String _warna) {
        this._warna = _warna;
    }
    public String get_berat() {
        return _berat;
    }
    public void set_berat(String _berat) {
        this._berat = _berat;
    }
}

