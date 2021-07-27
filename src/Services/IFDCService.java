package Services;

import Models.SearchResultPojo;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IFDCService {
    @GET("/fdc/v1/foods/search")
    Call<SearchResultPojo> searchFoodByName(@Query("query") String foodName, @Query("api_key") String apiKey);
}

