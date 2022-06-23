package com.uas.uassi6tj1922500033;
import java.util.List;
import retrofit2.http.GET;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.QueryMap;
public interface DosenHolderApi {
    @GET("lecturer.php")
    Call<List<PostDosen>> getPosts(

    );
    @GET("lecturer.php")
    Call<List<PostDosen>> getPosts(@QueryMap Map<String,String> parameters);
}
