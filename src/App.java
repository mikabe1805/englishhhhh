import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
public class App extends Application {
    Stage window;
    private int decision;
    String name;
    private int sadPoints = 0;
    BorderPane startScreenLayout = new BorderPane();
    Label dialogue;
    VBox vDBox = new VBox();
    HBox decisionHBox = new HBox();
    Scene scene;
    Label talker = new Label();
    int progressInt = 0;
    MediaPlayer soundEffectMediaPlayer;
    String text;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    Group letterImage;
    Image letter; 
    Image letter2; 
    Group root2 = new Group(); 
    Group root3 = new Group(); 
    ImageView letterImageView = new ImageView();
    FadeTransition fade = new FadeTransition(); 
    FadeTransition ft = new FadeTransition(Duration.millis(1000));
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage window) throws Exception {
        fade.setDuration(Duration.millis(3000));   
        fade.setFromValue(10);  
        fade.setToValue(0.1);  
        fade.setCycleCount(1);  
        ft.setFromValue(0.1);
        ft.setToValue(10);
        Font font = Font.loadFont("file:font.ttf", 35);
        Font font1 = Font.loadFont("file:font.ttf", 45);

        Image soldier = new Image(new FileInputStream("images/soldier.png"));
        ImageView startImageView1 = new ImageView(); 
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

        letter = new Image(new FileInputStream("images/letter.png"));
        letter2 = new Image(new FileInputStream("images/openedletter.png"));
        letterImageView.setX(50);
        letterImageView.setY(25);
        letterImageView.setFitHeight(2120);
        letterImageView.setFitWidth(1280); 
        letterImageView.setPreserveRatio(true);
        letterImage = new Group(letterImageView);
        letterImageView.setImage(letter);

        String path = "animations/beginning.mp4";  
        Media media = new Media(new File(path).toURI().toString());  
        mediaPlayer = new MediaPlayer(media);  
        MediaView mediaView = new MediaView(mediaPlayer);  
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        Group root = new Group();  
        root.getChildren().add(mediaView);  

        String path2 = "animations/letter.mp4";
        Media media2 = new Media(new File(path2).toURI().toString());  
        mediaPlayer2 = new MediaPlayer(media2);  
        MediaView mediaView2 = new MediaView(mediaPlayer2);  
        root2.getChildren().add(mediaView2);  
        
        String path3 = "animations/dodgedraft.mp4";
        Media media3 = new Media(new File(path3).toURI().toString());  
        mediaPlayer3 = new MediaPlayer(media3);  
        MediaView mediaView3 = new MediaView(mediaPlayer3);  
        root3.getChildren().add(mediaView3);  

        VBox beginningVBox = new VBox();
        window.setTitle("English Project");
        Button playButton = new Button("Play");
        playButton.setPrefSize(80, 30);
        playButton.setStyle("-fx-font-size: 24; ");

        TextField nameTextField = new TextField();

        Label titleText = new Label("The Things They Carried:\n\t\t   The Game");
        titleText.setFont(font);
        Label nameText = new Label("Enter your name.");
        nameText.setFont(font);
        Label welcomeText = new Label();
        welcomeText.setFont(font);
        beginningVBox.getChildren().addAll(titleText, nameTextField, nameText);
        beginningVBox.setAlignment(Pos.CENTER);
        beginningVBox.setSpacing(20);
        beginningVBox.setPadding(new Insets(10,10,10,10));


        HBox beginningHBox = new HBox();
        beginningHBox.getChildren().add(beginningVBox);
        beginningHBox.setAlignment(Pos.CENTER);
        beginningHBox.setSpacing(200);


        Label sadText = new Label("Sad Points: 0");
        sadText.setFont(font);

        dialogue = new Label();
        dialogue.setFont(font);
        
        HBox dBox = new HBox();
        dBox.getChildren().add(dialogue);
        dBox.setAlignment(Pos.CENTER);

        HBox talkerBox = new HBox();
        talker.setFont(font1);
        talkerBox.getChildren().add(talker);
        talkerBox.setPadding(new Insets(0, 0, 0, 20));
        talkerBox.setAlignment(Pos.BASELINE_LEFT);

        vDBox.getChildren().addAll(talkerBox, dBox);
        vDBox.setSpacing(20);

        BorderPane.setMargin(beginningHBox, new Insets(10, 10, 10, 10));
        startScreenLayout.setCenter(beginningHBox);
        BorderPane.setMargin(startImage1, new Insets(10, 10, 10, 10));
        startScreenLayout.setLeft(startImage1);
        BorderPane.setMargin(startImage2, new Insets(10, 10, 10, 10));
        startScreenLayout.setRight(startImage2);
        BorderPane.setMargin(vDBox, new Insets(10, 10, 150, 10));
        startScreenLayout.setBottom(vDBox);
        scene = new Scene(startScreenLayout, 1280, 720);
        window.setScene(scene);
        window.show();

        playButton.setOnAction(e -> {
            progressInt = 1;
            startScreenLayout.setRight(null);
            startScreenLayout.setLeft(null);
            startScreenLayout.setCenter(root);
            startScreenLayout.setTop(beginningHBox);
            beginningHBox.getChildren().add(sadText);
            beginningHBox.setPadding(new Insets(10,10,10,370));
            beginningVBox.getChildren().remove(welcomeText);
            beginningVBox.getChildren().remove(playButton);
            mediaPlayer.play();
            talker.setText("Narrator");
            animate("You're sitting at home relaxing when suddenly the doorbell rings...");
        });

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (progressInt == 0) {
                    beginningVBox.getChildren().clear();
                    beginningVBox.getChildren().addAll(titleText, welcomeText, playButton);
                    name = nameTextField.getText();
                    welcomeText.setText("Hi " + name + ".");
            }
            }
            if (e.getCode() == KeyCode.SPACE) {
                progressInt++;
                System.out.println(progressInt);
                dialogueMethod();
            }
        });
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
        // use .setOnFinished to make something happen only after the animation finishes
        if (progressInt == 1) {
            animation.setOnFinished(e -> {
                dingDong();
            });
        }
        animation.play();
    }
    public void dialogueMethod() {
        if (progressInt == 2) {
            mediaPlayer.stop();
            mediaPlayer2.play();
            mediaPlayer2.setRate(1.5);
            startScreenLayout.setCenter(root2);
            animate("You walk to the door and see a letter.");
        }
        else if (progressInt == 3) {
            talker.setText("");
            animate("");
            startScreenLayout.setCenter(letterImage);
        }
        else if (progressInt == 4) {
            talker.setText("You (" + name + ")");
            animate("Oh no...");
        }
        else if (progressInt == 5) {
            fade.setNode(startScreenLayout); 
            ft.setNode(startScreenLayout);
            fade.setOnFinished(e -> {
                decision("Open the Letter", "Don't Open the Letter");
                ft.play();
            });
            fade.play();  
        }
        else if (progressInt == 6) {
            talker.setText("");
            animate("");
            startScreenLayout.setCenter(letterImage);
            startScreenLayout.setBottom(vDBox);
            if (openletter)
                letterOpening();
        }
        else if (progressInt == 7 && openletter) {
            openLetter();
        }
        else if (progressInt == 7 && dontopenletter) {
            dontOpenLetter();
        }
        else if (progressInt > 7 && progressInt < 10 && openletter) {
            animate("...");
        }
        else if (progressInt == 10 && openletter) {
            animate("...what do I do?");
        }
        else if (progressInt == 11 && openletter) {
            fade.setNode(startScreenLayout); 
            ft.setNode(startScreenLayout);
            fade.setOnFinished(e -> {
                decision("Dodge the Draft", "Go to War");
                ft.play();
            });
            fade.play();  
        }
    }
    boolean dontopenletter;
    boolean openletter;
    public void decision(String choice1, String choice2) {
        decisionHBox.getChildren().clear();
        Button choice1Button = new Button(choice1);
        Button choice2Button = new Button(choice2);
        choice1Button.setPrefSize(600, 600);
        choice2Button.setPrefSize(600, 600);
        choice1Button.setStyle("-fx-font-size: 50");
        choice2Button.setStyle("-fx-font-size: 50");
        decisionHBox.getChildren().addAll(choice1Button, choice2Button);
        decisionHBox.setSpacing(15);
        decisionHBox.setAlignment(Pos.CENTER);
        startScreenLayout.setRight(null);
        startScreenLayout.setLeft(null);
        startScreenLayout.setBottom(null);
        startScreenLayout.setCenter(decisionHBox);
        if (progressInt == 5) {
            choice1Button.setOnAction(e -> {
                openletter = true;
                progressInt++;
                dialogueMethod();
            });
            choice2Button.setOnAction(e -> {
                dontopenletter = true;
                progressInt++;
                dialogueMethod();
            });
        }
        if (progressInt == 11) {
            choice1Button.setOnAction(e -> {
                dodgeDraft();
            });
            choice2Button.setOnAction(e -> {
            });
        }
    }
    public void playAnimation(String animationName) {

        // enter code for playing animation
    }
    public void walk(String image1name, String image2name) {

        // alternate between image 1 and image 2
    }

    public void addSadPoints(int amount) {
        sadPoints+=amount;
        // animate numbers going up and call ding() after each one
        // make it add sad points 1 by 1 and play a ding sound
    }

    public void relaxingSequence() {

        //whatever
    }
    public void dontOpenLetter() {

        startScreenLayout.setCenter(root2);
        talker.setText("Narrator");
        animate("You throw the letter into the trash bin.");
    }
    public void openLetter() {
        talker.setText("Narrator");
        letterImageView.setImage(letter2);
        animate("You open the letter.");
    }
    public void GoToWar() {

        addSadPoints(4);
    }
    public void dodgeDraft() {
        startScreenLayout.setCenter(root3);
        mediaPlayer3.play();
        mediaPlayer3.setRate(1.5);
        startScreenLayout.setBottom(null);
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

    public void letterOpening() {
        String s = "sounds/opening.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.3);
        soundEffectMediaPlayer.play();
    }

}