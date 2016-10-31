package com.gbi.alanpan.alanproject.dragrecyclerview.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by alan.pan on 2016/10/31.
 */
public interface RequestService {

    public static final String TEST_REQUEST = "51899716";

    @GET("book/search")
    Call<String> getSearchBooks(@Query("q") String name,
                                            @Query("tag") String tag, @Query("start") int start,
                                            @Query("count") int count);

}
