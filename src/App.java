import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.nio.file.Paths;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class App extends Application {
    Stage window;
    private int decision;
    private int sadPoints = 0;
    Label dialogue;
    MediaPlayer soundEffectMediaPlayer;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage window) throws Exception {
        Image soldier = new Image(new FileInputStream("images/soldier.png"));
        ImageView startImageView1 = new ImageView(); 
        Font font = Font.loadFont("file:font.ttf", 50);
        startImageView1.setX(50);
        startImageView1.setY(25);
        startImageView1.setFitHeight(600);
        startImageView1.setFitWidth(600);
        startImageView1.setPreserveRatio(true);
        Group startImage1 = new Group(startImageView1);
        startImageView1.setImage(soldier);
        ImageView startImageView2 = new ImageView(); 
        startImageView2.setX(50); 
        startImageView2.setY(25); 
        startImageView2.setFitHeight(600); 
        startImageView2.setFitWidth(600); 
        startImageView2.setPreserveRatio(true);  
        Group startImage2 = new Group(startImageView2);
        startImageView2.setImage(soldier);

        window.setTitle("English Project");
        Button playButton = new Button("Play");
        playButton.setPrefSize(80, 30);
        playButton.setStyle("-fx-font-size: 18; ");
        
        playButton.setOnAction(e -> {
            animate("You're sitting at home relaxing when suddenly the doorbell rings...");
            dingDong();
        });

        dialogue = new Label();
        dialogue.setFont(font);
        
        HBox dBox = new HBox();
        dBox.getChildren().add(dialogue);
        dBox.setAlignment(Pos.CENTER);
        
        BorderPane startScreenLayout = new BorderPane();
        BorderPane.setMargin(playButton, new Insets(10, 10, 10, 10));
        startScreenLayout.setCenter(playButton);
        BorderPane.setMargin(startImage1, new Insets(10, 10, 10, 10));
        startScreenLayout.setLeft(startImage1);
        BorderPane.setMargin(startImage2, new Insets(10, 10, 10, 10));
        startScreenLayout.setRight(startImage2);
        BorderPane.setMargin(dBox, new Insets(10, 10, 150, 10));
        startScreenLayout.setBottom(dBox);
        Scene scene = new Scene(startScreenLayout, 1920, 1000);
        window.setScene(scene);
        window.show();
    }

    // plays animation of person sitting down sipping tea
    // diologue "youre sitting at home relaxing when suddenly the bell rings"
    // plays ding sound
    // plays get up animation
    // alternate between image 1 and image 2 (facing right) for walk while simultaneously shifting the background image (im gonna make a huge image that you can move to the door)
    // play pick up letter animation (switch background images to 1 without the letter on the ground)
    // DECISION 1: open letter or dont open letter
    // if NOT OPEN, play put letter down animation, switch background image back, and walk back to chair using facing left images
    // fade out to show passing time
    // knock sound, walk to open it, someone talks to you with some angry sims4 sounds, you get arrested
    // GAME OVER
    // if OPEN, show letter image
    // show DECISION 2: dodge draft or go to war
    // if DODGE DRAFT: play throw away letter animation, play chuckle sound, and play run away animation
    // if GO TO WAR: fade out, show sitting in camp set up
    // DECISION 3: talk or dont talk
    // if TALK: play talking animation and fade out
    // if DONT TALK: just stay sitting in silence and fade out
    // DECISION 4: rescue or run away
    // if GO TO SAFETY: 

    public void animate(String content) {
        Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(2500));
            }
        
            protected void interpolate(double frac) {
                int length = content.length();
                int n = Math.round(length * (float) frac);
                dialogue.setText(content.substring(0, n));
            }
        
        };
        
        animation.play();
    }

    public int decision(String choice1, String choice2) {
        // enter code for making decisions
        // only the making, not the consequences
        decision = 1;
        return decision;
    }
    public void playAnimation(String animationName) {

        // enter code for playing animation
    }
    public void walk(String image1name, String image2name) {

        // alternate between image 1 and image 2
    }

    public void addSadPoints(int amount) {

        // make it add sad points 1 by 1 and play a ding sound
    }

    public void relaxingSequence() {

        //whatever
    }
    public void dontOpenLetter() {

    }
    public void openLetter() {

    }
    public void GoToWar() {

        addSadPoints(4);
    }
    public void dodgeDraft() {


    }
    public void talk() {

        addSadPoints(-2);
    }
    public void dontTalk() {


    }
    public void goToSafety() {

        if (sadPoints == 2) {
            addSadPoints(100);
        } else {
            addSadPoints(4);
        }
    }

    public void ding() {
        String s = "sounds/ding.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.1);
        soundEffectMediaPlayer.play();
    }

    public void dingDong() {
        String s = "sounds/dingDong.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.1);
        soundEffectMediaPlayer.play();
    }

    public void angrySims() {
        String s = "sounds/angrySims.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.1);
        soundEffectMediaPlayer.play();
    }

    public void knock() {
        String s = "sounds/knock.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.1);
        soundEffectMediaPlayer.play();
    }

    public void chuckle() {
        String s = "sounds/chuckle.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.1);
        soundEffectMediaPlayer.play();
    }

}