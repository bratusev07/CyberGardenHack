package ru.bratusev.cybergardenhack.services.network;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;
import ru.bratusev.cybergardenhack.models.CalendarModel;

public interface JSONPlaceHolderApi {
    @GET("server.php?flg=3")
    Call<CalendarModel> getCalendar();

    @GET("server.php?flg4")
    Call<Boolean> login(@Query("user") String user, @Query("pass") String pass);
}
