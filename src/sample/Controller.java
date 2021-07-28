package sample;

import Models.SearchResultDTO;
import Services.FDCService;
import Services.Repository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {


    @FXML
    private TextField searchBar;

    @FXML
    private ListView<String> listView;


    @FXML
    void search(ActionEvent event) {
        List<SearchResultDTO> result;
        result = Repository.searchFood(searchBar.getText());
        System.out.println(searchBar.getText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result.forEach(System.out::println);

        listView.getItems().addAll(
                result.stream()
                        .map(SearchResultDTO::toString)
                        .collect(Collectors.toList())
        );

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        listView.getItems().addAll();
    }

    private List<String> searchList(String searchWords, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}
