package com.uas.uassi6tj1922500033;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class PostDosen {
    @SerializedName("nidn")
    @Expose
    private String nidn;
    @SerializedName("nama_dosen")
    @Expose
    private String nama_dosen;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gol_pang")
    @Expose
    private String gol_pang;
    @SerializedName("keahlian")
    @Expose
    private String keahlian;
    @SerializedName("program_studi")
    @Expose
    private String program_studi;
    public String get_nidn(){
        return nidn;
    }
    public void setNidn(String nidn){
        this.nidn = nidn;
    }
    public String get_Nama_Dosen(){
        return nama_dosen;
    }
    public String get_Jabatan(){
        return jabatan;
    }
    public String get_Gol_Pang(){
        return gol_pang;
    }
    public String get_Keahlian(){
        return keahlian;
    }
    public String get_Program_studi(){
        return program_studi;
    }
}
