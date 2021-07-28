package Services;

import Models.SearchResultDTO;
import Models.SearchResultPojo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static List<SearchResultDTO> searchFood(String foodName) {
        final List<SearchResultDTO> resultDTOs = new ArrayList<SearchResultDTO>();
        FDCService.searchFoodByName(foodName).enqueue(new Callback<SearchResultPojo>() {
            @Override
            public void onResponse(Call<SearchResultPojo> call, Response<SearchResultPojo> response) {
                SearchResultDTO.parsePOJO(response.body()).forEach(resultDTOs::add);
            }

            @Override
            public void onFailure(Call<SearchResultPojo> call, Throwable throwable) {
                System.out.println("we suck");
            }
        });

        return resultDTOs;
    }
}
