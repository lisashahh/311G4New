package Models;

import Services.FDCService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.beans.beancontext.BeanContextChild;
import java.util.ArrayList;
import java.util.List;

public class SearchResultDTO {
    private double kcal;
    private double protein;
    private double carbs;
    private double fat;
    private String foodName;


    public SearchResultDTO(double kcal, double protein, double carbs, double fat, String foodName) {
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.foodName = foodName;


    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getProtein() {
        return protein;

    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }


    public static List<SearchResultDTO> parsePOJO(SearchResultPojo searchResultPojo) {
        List<SearchResultDTO> searchResultDTOs = new ArrayList<>();


        for (SearchResultPojo.Food food :
                searchResultPojo.getFoods()) {
            String foodName = food.getDescription();
            double kcal, protein, carbs, fat;
            kcal = protein = carbs = fat = 0;
            for (SearchResultPojo.Food.FoodNutrient foodNutrient : food.getFoodNutrients()) {
                double value = foodNutrient.getValue();
                switch (foodNutrient.getNutrientId()) {
                    case 1008:
                        kcal = value;
                        break;
                    case 1003:
                        protein = value;
                        break;
                    case 1005:
                        carbs = value;
                        break;
                    case 1004:
                        fat = value;
                        break;
                }

            }
            searchResultDTOs.add(new SearchResultDTO(kcal, protein, carbs, fat, foodName));

        }
        return searchResultDTOs;

    }


}

