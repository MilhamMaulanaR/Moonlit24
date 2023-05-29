package helloapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuScene {
    private Stage stage;
    private ListView<String> recipeListView;
    private ObservableList<String> recipeList;
    
    MenuScene(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label1 = new Label("What would you");
        Label label2 = new Label("like to Cook?");
        Label label3 = new Label("Today recipe");
        Label label4 = new Label("Recommended");

        recipeList = FXCollections.observableArrayList(
            "Ayam Bakar Madu", "Ayam Szechuan Pedas", "Capcay Goreng Sayur", "Daging Tumis Buncis", "Ikan Bakar Bumbu Bali","Rendang Daging Padang", "Steak Daging Black Papper", "Daging Tumis Buncis","Ikan Bakar Bumbu Bali", "Ikan Goreng Tapung Asam Manis", "Sup Ikan Tomat", "Capcay Goreng Sayur", "Tumis Kangkung Bawang Putih", "Sayur Lodeh");

    recipeListView = new ListView<>();

        TextField searchField = new TextField();
        searchField.setPromptText("Search Recipe");
        searchField.setOnKeyReleased(event -> {
            String keyword = searchField.getText().trim().toLowerCase();
            ObservableList<String> filterList = FXCollections.observableArrayList();

            for (String recipe : recipeList) {
                if (recipe.toLowerCase().contains(keyword)) {
                    filterList.add(recipe);
                }
            }
            recipeListView.setItems(filterList);
        });

        recipeListView.setCellFactory(param -> {
            ListCell<String> cell = new ListCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item);
                    }
                }
            };

            cell.setOnMouseClicked(event -> {
                String selectedRecipe = cell.getItem();
                if (selectedRecipe != null) {
                    if (selectedRecipe.equals("Ayam Bakar Madu")){
                        AyamBakarMadu ayamBakarMadu = new AyamBakarMadu(stage);
                        ayamBakarMadu.show();
                    } else if (selectedRecipe.equals("Ayam Szechuan Pedas")){
                        AyamSzechuanPedas ayamSzechuanPedas = new AyamSzechuanPedas(stage);
                        ayamSzechuanPedas.show();
                    } else if (selectedRecipe.equals("Rendang Daging Padang")){
                        RendangDagingPadang rendangDagingPadang = new RendangDagingPadang(stage);
                        rendangDagingPadang.show();
                    } else if (selectedRecipe.equals("Steak Daging Black Paper")){
                        SteakDagingBlackPapper steakDagingBlackPapper = new SteakDagingBlackPapper(stage);
                        steakDagingBlackPapper.show();
                    } else if (selectedRecipe.equals("Daging Tumis Buncis")){
                        DagingTumisBuncis dagingTumisBuncis = new DagingTumisBuncis(stage);
                        dagingTumisBuncis.show();
                    } else if (selectedRecipe.equals("Ikan Bakar Bumbu Bali")){
                        IkanBakarBumbuBali ikanBakarBumbuBali = new IkanBakarBumbuBali(stage);
                        ikanBakarBumbuBali.show();
                    } else if (selectedRecipe.equals("Ikan Goreng Tepung Asam Manis")){
                        IkanGorengTepungAsamManis ikanGorengTepungAsamManis = new IkanGorengTepungAsamManis(stage);
                        ikanGorengTepungAsamManis.show();
                    } else if (selectedRecipe.equals("Sup Ikan Tomat")){
                        SupIkanTomat supIkanTomat = new SupIkanTomat(stage);
                        supIkanTomat.show();
                    } else if (selectedRecipe.equals("Capcay Goreng Sayur")){
                        CapcayGorengSayur capcayGorengSayur = new CapcayGorengSayur(stage);
                        capcayGorengSayur.show();
                    } else if (selectedRecipe.equals("Tumis Kangkung Bawang Putih")){
                        TumisKangkungBawangPutih tumisKangkungBawangPutih = new TumisKangkungBawangPutih(stage);
                        tumisKangkungBawangPutih.show();
                    } else if (selectedRecipe.equals("Sayur Lodeh")){
                        SayurLodeh sayurLodeh = new SayurLodeh(stage);
                        sayurLodeh.show();
                    }
                }
            });
            return cell;
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(searchField, recipeListView);
        
        Image image = new Image("file:D:/BG-PJMBLACK.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setFitHeight(100);
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitWidth(70);
        imageView2.setFitHeight(100);
        ImageView imageView3 = new ImageView(image);
        imageView3.setFitWidth(100);
        imageView3.setFitHeight(70);

        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(label1,0,0);
        gridPane.add(label2,0,1);
        gridPane.add(root,0,3);
        gridPane.add(label3,0,3);
        gridPane.add(imageView,0,4);
        gridPane.add(imageView2,1,4);
        gridPane.add(label4,0,5);
        gridPane.setAlignment(Pos.TOP_LEFT);
        
        Scene scene = new Scene(gridPane, 350, 600);
        stage.setScene(scene);
        stage.show();
    } 
}
