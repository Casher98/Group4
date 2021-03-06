package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

class ArtifactView extends VBox {

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private ImageView imageView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label titleView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label artistView;

    @SuppressWarnings("unused") // Used in FXML binding
    @FXML
    private Label dateView;

    ArtifactView(ArtifactRecord record) {
        Preconditions.checkNotNull(record);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("artifactView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();

            Image image = new Image("http://cspvggp.dhcp.bsu.edu/OMI/" + record.getFileName());
            imageView.setImage(image);
            titleView.setText("Title: " + record.getTitle());
            artistView.setText("Artist: " + record.getArtist());
            dateView.setText("Date: " + record.getDate());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
