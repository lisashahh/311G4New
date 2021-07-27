package Models;

import java.util.List;

public class SearchResultPojo {

    public static class Food {

        public static class FoodNutrient {

            private Integer nutrientId;
            private String nutrientName;
            private Double value;

            public Integer getNutrientId() {
                return nutrientId;
            }

            public void setNutrientId(Integer nutrientId) {
                this.nutrientId = nutrientId;
            }

            public String getNutrientName() {
                return nutrientName;
            }

            public void setNutrientName(String nutrientName) {
                this.nutrientName = nutrientName;
            }

            public Double getValue() {
                return value;
            }

            public void setValue(Double value) {
                this.value = value;
            }

        }


        private Integer fdcId;
        private String description;
        private List<FoodNutrient> foodNutrients = null;

        public Integer getFdcId() {
            return fdcId;
        }

        public void setFdcId(Integer fdcId) {
            this.fdcId = fdcId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<FoodNutrient> getFoodNutrients() {
            return foodNutrients;
        }

        public void setFoodNutrients(List<FoodNutrient> foodNutrients) {
            this.foodNutrients = foodNutrients;
        }

    }

    private List<Food> foods = null;

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

}