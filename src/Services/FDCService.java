package Services;

import Models.SearchResultPojo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class FDCService {

    public static final String BASE_URL = "https://api.nal.usda.gov/fdc/";
    public static final String API_KEY = "TKfXo4WGBdXO45O5M8cFDJx3kygusxUymgLSBQJd";
    private static IFDCService INSTANCE = null;

    public static IFDCService getClient() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(IFDCService.class);


        }
        return INSTANCE;
    }

    public static Call<SearchResultPojo> searchFoodByName(String foodName) {
        return getClient().searchFoodByName(foodName, API_KEY);
    }

}
