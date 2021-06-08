import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
public class App extends Application {
    Stage window;
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
    Label sadText = new Label("Sad Points: 0");
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;
    MediaPlayer mediaPlayer5;
    MediaPlayer dingMediaPlayer;
    MediaPlayer musicMediaPlayer;
    MediaPlayer decisionMusicMediaPlayer;
    VBox gameOverBox = new VBox();
    Group letterImage;
    Image letter; 
    Image letter2; 
    Image arrestedImage;
    Image silentImage;
    Image talkingImage;
    Image gameOverImage;
    Image saveOrDontImage;
    Image saveImage;
    Image dontSave1Image;
    Image dontSave2Image;
    Image bothDieImage;
    Group root2 = new Group(); 
    Group root3 = new Group(); 
    Group root4 = new Group(); 
    Group root5 = new Group(); 
    Group gameOver = new Group();
    ImageView letterImageView = new ImageView();
    ImageView gameOverImageView = new ImageView();
    FadeTransition fade = new FadeTransition(); 
    FadeTransition fade2 = new FadeTransition(); 
    FadeTransition fade3 = new FadeTransition();
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
        fade2.setDuration(Duration.millis(3000));   
        fade2.setFromValue(10);  
        fade2.setToValue(0.1);  
        fade2.setCycleCount(1); 
        fade3.setDuration(Duration.millis(1000));   
        fade3.setFromValue(10);  
        fade3.setToValue(0.1);  
        fade3.setCycleCount(1); 
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
        arrestedImage = new Image(new FileInputStream("images/arrested.png"));
        silentImage = new Image(new FileInputStream("images/silence.png"));
        talkingImage = new Image(new FileInputStream("images/talk.png"));
        gameOverImage = new Image(new FileInputStream("images/gameover.png"));
        saveOrDontImage = new Image(new FileInputStream("images/saveordont.png"));
        saveImage = new Image(new FileInputStream("images/save.png"));
        dontSave1Image = new Image(new FileInputStream("images/dontsave1.png"));
        dontSave2Image = new Image(new FileInputStream("images/dontsave2.png"));
        bothDieImage = new Image(new FileInputStream("images/bothdie.png"));
        letterImageView.setX(50);
        letterImageView.setY(25);
        letterImageView.setFitHeight(2120);
        letterImageView.setFitWidth(1280); 
        letterImageView.setPreserveRatio(true);
        letterImage = new Group(letterImageView);
        letterImageView.setImage(letter);

        gameOverImageView.setX(50);
        gameOverImageView.setY(25);
        gameOverImageView.setFitHeight(1000);
        gameOverImageView.setFitWidth(600); 
        gameOverImageView.setPreserveRatio(true);
        gameOver = new Group(gameOverImageView);
        gameOverImageView.setImage(gameOverImage);

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

        String path4 = "animations/dontopenletter.mp4";
        Media media4 = new Media(new File(path4).toURI().toString());  
        mediaPlayer4 = new MediaPlayer(media4);  
        MediaView mediaView4 = new MediaView(mediaPlayer4);  
        root4.getChildren().add(mediaView4); 


        String path5 = "animations/arrested.mp4";
        Media media5 = new Media(new File(path5).toURI().toString());  
        mediaPlayer5 = new MediaPlayer(media5);  
        MediaView mediaView5 = new MediaView(mediaPlayer5);  
        root5.getChildren().add(mediaView5); 

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

        Button playAgainButton = new Button("Play Again");
        playAgainButton.setStyle("-fx-font-size: 24");

        gameOverBox.getChildren().addAll(gameOver, playAgainButton);
        gameOverBox.setSpacing(20);
        gameOverBox.setAlignment(Pos.CENTER);

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
        music();

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

        playAgainButton.setOnAction(e -> {
            dontopenletter = false;
            openletter = false;
            gotToWarBool = false;
            talkbool = false;
            donttalkbool = false;
            mediaPlayer.stop();
            mediaPlayer2.stop();
            mediaPlayer3.stop();
            mediaPlayer4.stop();
            mediaPlayer5.stop();
            nameTextField.setText("");
            sadPoints = 0;
            progressInt = 0;
            dialogue.setText("");
            talker.setText("");
            beginningHBox.getChildren().remove(sadText);
            beginningVBox.getChildren().addAll(nameTextField, nameText);
            startScreenLayout.setTop(null);
            startScreenLayout.setLeft(startImage1);
            startScreenLayout.setRight(startImage2);
            startScreenLayout.setBottom(vDBox);
            startScreenLayout.setCenter(beginningHBox);
            beginningHBox.setPadding(new Insets(10,10,10,10));
        });

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (progressInt == 0) {
                    beginningVBox.getChildren().clear();
                    beginningVBox.getChildren().addAll(titleText, welcomeText, playButton);
                    name = nameTextField.getText();
                    if (!name.equals("Steve") && !name.equals("steve")) {
                        welcomeText.setText("Hi " + name + ".");
                    } else {
                        welcomeText.setText(";)");
                    }
            }
            }
            if (e.getCode() == KeyCode.SPACE && isHappening()) {
                progressInt++;
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
    Animation animation;

    public void animate(String content) {
        animation = new Transition() {
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
        if (progressInt == 3) {
            animation.setOnFinished(e -> {
                letterImageView.setImage(letter);
                startScreenLayout.setCenter(letterImage);
            });
        }
        if (progressInt == 4) {
            animation.setOnFinished(e -> {
                progressInt++;
                dialogueMethod();
            });
        }
        if (progressInt == 10 && openletter) {
            animation.setOnFinished(e -> {
                progressInt++;
                dialogueMethod();
            });
        }
        if (progressInt == 14 && gotToWarBool) {
            animation.setOnFinished(e -> {
                progressInt++;
                dialogueMethod();
            });
        }
        if (progressInt == 23) {
            animation.setOnFinished(e -> {
                progressInt++;
                dialogueMethod();
            });
        }
        animation.play();
    }
    boolean decisionScreen = false;
    public boolean isHappening() {
        boolean playing2 = mediaPlayer3.getStatus().equals(Status.PLAYING);
        boolean playing3 = mediaPlayer4.getStatus().equals(Status.PLAYING);
        boolean playing4 = mediaPlayer5.getStatus().equals(Status.PLAYING);
        // if (playing1 == false || playing2 == false || playing3 == false || playing4 == false || playing5 == false)
        //     playing = true;
        if (ft.getCurrentRate()!=0.0d || fade.getCurrentRate()!=0.0d || animation.getCurrentRate()!=0.0d || animationSad.getCurrentRate()!=0.0d || animationHappy.getCurrentRate()!=0.0d || decisionScreen == true || playing2 == true || playing3 == true || playing4 == true)
            return false;
        else if ((progressInt == 6 && soundEffectMediaPlayer.getStatus().equals(Status.PLAYING) == false))
            return false;
        else 
            return true;
    }
    public void dialogueMethod() {
        switch (progressInt) {
            case 2: 
                mediaPlayer.stop();
                mediaPlayer2.play();
                mediaPlayer2.setRate(1.8);
                startScreenLayout.setCenter(root2);
                animate("You walk to the door and see a letter.");
                break;
            case 3:
                talker.setText("Narrator");
                animate("You pick up the letter.");
                break;
            case 4:
                talker.setText("You (" + name + ")");
                animate("Oh no...");
                break;
            case 5:
                fade.setNode(startScreenLayout); 
                ft.setNode(startScreenLayout);
                fade.setOnFinished(e -> {
                    decisionMusic();
                    musicMediaPlayer.pause();
                    decision("Open the Letter", "Don't Open the Letter");
                    ft.play();
                });
                fade.play();  
                break;
            case 6:
                talker.setText("");
                animate("");
                startScreenLayout.setCenter(letterImage);
                startScreenLayout.setBottom(vDBox);
                if (openletter) {
                    letterOpening();
                    if (progressInt == 6) {
                        soundEffectMediaPlayer.setOnEndOfMedia(() -> {
                            progressInt++;
                            dialogueMethod();
                        });   
                    }
                }
                break;
            case 7: 
                if (openletter){
                    openLetter();
                } else {
                    dontOpenLetter();
                }
                break;
            case 8:
            if (dontopenletter) {
                fade.setOnFinished(e -> {
                    startScreenLayout.setBottom(null);
                    startScreenLayout.setCenter(root5);
                    mediaPlayer5.play();
                    mediaPlayer5.setRate(1.35);
                    mediaPlayer5.setOnEndOfMedia(() -> {
                        fade2.play();
                    });    
                    knock();
                    ft.play();
                });
                fade2.setOnFinished(e -> {
                    ft.play();
                    startScreenLayout.setCenter(letterImage);
                    letterImageView.setImage(arrestedImage);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    gameOverMethod();
                });
                fade.play(); 
            }
            case 9:
                animate("...");
                break;
            
            case 10:
                animate("...what do I do?");
                break;
            case 11:
                fade.setNode(startScreenLayout); 
                ft.setNode(startScreenLayout);
                fade.setOnFinished(e -> {
                    decisionMusic();
                    musicMediaPlayer.pause();
                    decision("Dodge the Draft", "Go to War");
                    ft.play();
                });
                fade.play();  
                break;

            case 12:
                startScreenLayout.setBottom(vDBox);
                talker.setText("");
                animate("*silence*");
                break;
            case 13:
                talker.setText("Narrator");
                animate("The night is dark and the air is filled with distant hollers, no one dare utter a word.");
                break;
            case 14:
                talker.setText("You (" + name + ")");
                animate("Should i say something?");
                break;
            case 15:
                ft.setOnFinished(e -> {
                    soundEffectMediaPlayer.stop();
                    soundEffectMediaPlayer.setCycleCount(1);
                });
                fade.setOnFinished(e -> {
                    decisionMusic();
                    musicMediaPlayer.pause();
                    decision("Talk", "Don't Talk");
                    ft.play();
                });
                fade.play();  
                break;
            case 16:
                if (talkbool) {
                    talker.setText("Narrator");
                    animate("You talk to the guy next to you.");
                }
                else {
                    startScreenLayout.setBottom(vDBox);
                    talker.setText("");
                    animate("*silence*");
                }
                break;
            case 17:
                if (talkbool) {
                    talker.setText("You (" + name + ")");
                    animate("Hey, I'm " + name + ".");
                }
                else {
                    talker.setText("Narrator");
                    animate("You stay silent, wondering if anyone else will say something.");
                }
                break;
            case 18:
                if (talkbool) {
                    talker.setText("Gayry");
                    animate("Hey " + name + ", I'm Gayry :)");
                }
                else {
                    talker.setText("Lt. Homes");
                    animate("You guy are one chatty group! Now, it's time to hit the hay soldiers.");
                }
                break;
            case 19: 
                if (talkbool) {
                    talker.setText("Narrator");
                    animate("You and Gayry hit it off and get to know each other for the rest of the night before heading to sleep.");
                }
                else {
                    talker.setText("Narrator");
                    animate("Everyone scrambles to their bunks and goes to sleep.");
                }
                break;
            case 20: 
                ft.setOnFinished(e -> {
                });
                fade.setOnFinished(e -> {
                    ft.play();
                    startScreenLayout.setCenter(letterImage);
                    letterImageView.setImage(saveOrDontImage);
                    startScreenLayout.setBottom(null);
                });
                fade.play();
                break;
            case 21:
                startScreenLayout.setBottom(vDBox);
                talker.setText("Narrator");
                animate("You see a soldier, he looks like the one who was sitting next to you the previous night.");
                break;
            case 22:
                if (talkbool)
                        talker.setText("Gayry");
                else 
                    talker.setText("Soldier who's stuck");
                animate("HELP! PLEASE HELP ME!");
                break;
            case 23: 
                talker.setText("You (" + name + ")");
                    if (talkbool)
                        animate("Gayry! Hang in there!");
                    else   
                        animate("Hey man! Don't worry!");
                break;
            case 24:
                ft.setOnFinished(e -> {
                    soundEffectMediaPlayer.stop();
                    soundEffectMediaPlayer.setCycleCount(1);
                });
                fade.setOnFinished(e -> {
                    decisionMusic();
                    musicMediaPlayer.pause();
                    decision("Save", "Don't Save");
                    ft.play();
                });
                fade.play(); 
                break;
            case 25:
                if (savebool) {
                    if (Math.random() > .3) {
                        diebool = true;
                        die();
                    }
                    else {
                        talker.setText("Narrator");
                        animate("You successfully save Gary.");
                        letterImageView.setImage(saveImage);
                    }
                }
                else {
                    if (Math.random() < .3) {
                        diebool = true;
                        die();
                    }
                    else {
                        talker.setText("Narrator");
                        if (talkbool) {
                            animate("You abandon him and get to safety, but at the cost of Gayry's life.");
                            letterImageView.setImage(dontSave2Image);
                        }
                        else {
                            animate("You abandon him and get to safety, but at the cost of the soldier's life.");
                            letterImageView.setImage(dontSave1Image);
                        }
                    }
                }
                    break;
                case 26:
                if (diebool)
                    gameOverMethod();
                else 
                    progressInt++;
                    break;
        }
    }
    boolean dontopenletter;
    boolean openletter;
    boolean gotToWarBool;
    boolean talkbool;
    boolean donttalkbool;
    boolean dontsavebool;
    boolean savebool;
    boolean diebool;
    public void decision(String choice1, String choice2) {
        decisionScreen = true;
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
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.play();
                decisionScreen = false;
                openletter = true;
                progressInt++;
                dialogueMethod();
            });
            choice2Button.setOnAction(e -> {
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.play();
                decisionScreen = false;
                dontopenletter = true;
                progressInt++;
                dialogueMethod();
            });
        }
        if (progressInt == 11) {
            choice1Button.setOnAction(e -> {
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.stop();
                decisionScreen = false;
                dodgeDraft();
            });
            choice2Button.setOnAction(e -> {
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.play();
                gotToWarBool = true;
                decisionScreen = false;
                GoToWar();
            });
        }
        if (progressInt == 15) {
            choice1Button.setOnAction(e -> {
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.play();
                talkbool = true;
                decisionScreen = false;
                talk();
            });
            choice2Button.setOnAction(e -> {
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.play();
                donttalkbool = true;
                decisionScreen = false;
                dontTalk();
            });
        }
        if (progressInt == 24) {
            choice1Button.setOnAction(e -> {
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.play();
                savebool = true;
                decisionScreen = false;
                save();
            });
            choice2Button.setOnAction(e -> {
                decisionMusicMediaPlayer.stop();
                musicMediaPlayer.play();
                dontsavebool = true;
                decisionScreen = false;
                dontSave();
            });
        } 
    }
    
    int countDown;
    Timeline animationSad = new Timeline(new KeyFrame(Duration.millis(600), e -> {
        if (countDown > 0) {
            countDown--;
            sadPoints+=1;
            sadText.setText("Sad Points: " + sadPoints);
            ding();
        }
    }));

    Timeline animationReallySad = new Timeline(new KeyFrame(Duration.millis(50), e -> {
        if (countDown > 0) {
            countDown--;
            sadPoints+=1;
            sadText.setText("Sad Points: " + sadPoints);
            ding();
        }
    }));

    Timeline animationHappy = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
        if (countDown < 0) {
            countDown++;
            sadPoints-=1;
            sadText.setText("Sad Points: " + sadPoints);
            happyDing();
        }
    }));

    Timeline animationReallyHappy = new Timeline(new KeyFrame(Duration.millis(100), e -> {
        if (countDown < 0) {
            countDown++;
            sadPoints-=1;
            sadText.setText("Sad Points: " + sadPoints);
            happyDing();
        }
    }));

    public void addSadPoints(int amount) {
        countDown = amount;
        if (amount > 0) {
            animationSad.setCycleCount(amount);
            animationSad.play();
        }
        else if (amount > 9) {
            animationReallySad.setCycleCount(amount);
            animationReallySad.play();
        }
        else {
            if (amount < -9) {
                animationReallyHappy.setCycleCount(amount*-1);
                animationReallyHappy.play();
            }
            else {
                animationHappy.setCycleCount(amount*-1);
                animationHappy.play();
            }
            
        }
    }
    public void dontOpenLetter() {
        startScreenLayout.setCenter(root4);
        mediaPlayer4.setOnEndOfMedia(() -> {
            progressInt++;
            dialogueMethod();
        });    
        mediaPlayer4.play();
        mediaPlayer4.setRate(1.5);
        startScreenLayout.setBottom(null);
    }
    public void openLetter() {
        talker.setText("Narrator");
        letterImageView.setImage(letter2);
        animate("You open the letter.");
        addSadPoints(2);
    }
    public void GoToWar() {
        ft.setOnFinished(e -> {
            crickets();
        });
        fade3.setOnFinished(e -> {
            ft.play();
            startScreenLayout.setCenter(letterImage);
            letterImageView.setImage(silentImage);
            startScreenLayout.setBottom(null);
        });
        addSadPoints(4);
        fade3.play();
    }
    public void dodgeDraft() {
        startScreenLayout.setCenter(root3);
        mediaPlayer3.play();
        mediaPlayer3.setRate(1.5);
        musicMediaPlayer.pause();
        emotional();
        startScreenLayout.setBottom(null);
        mediaPlayer3.setOnEndOfMedia(() -> gameOverMethod());
    }
    public void talk() {
        ft.setOnFinished(e -> {
        });
        fade3.setOnFinished(e -> {
            ft.play();
            startScreenLayout.setCenter(letterImage);
            letterImageView.setImage(talkingImage);
            startScreenLayout.setBottom(vDBox);
            talker.setText("");
            animate("*chatter*");
        });
        addSadPoints(-2);
        fade3.play();
    }
    public void dontTalk() {
        ft.setOnFinished(e -> {
            crickets();
        });
        fade3.setOnFinished(e -> {
            ft.play();
            startScreenLayout.setCenter(letterImage);
            letterImageView.setImage(silentImage);
            startScreenLayout.setBottom(null);
        });
        fade3.play();
    }

    public void die() {
        talker.setText("Narrator");
        animate("You died too bc ur a fucking dumbass.");
        letterImageView.setImage(bothDieImage);
        startScreenLayout.setCenter(letterImage);
        // save: 80% chance of death
        // dontsave: 20% death (cry if talkbool)
    }
    public void save() {
        // -2 points if talkbool = false
        // -10 points if talkbool
        ft.setOnFinished(e -> {
            startScreenLayout.setBottom(vDBox);
            talker.setText("You (" + name + ")");
            animate("I'm coming to save you!");
        });
        fade3.setOnFinished(e -> {
            ft.play();
            startScreenLayout.setCenter(letterImage);
            letterImageView.setImage(saveOrDontImage);
            startScreenLayout.setBottom(null);
        });
        fade3.play();
    }
    public void dontSave() {
        ft.setOnFinished(e -> {
            startScreenLayout.setBottom(vDBox);
            talker.setText("Narrator");
            animate("You decide to not risk your life and save him.");
        });
        fade3.setOnFinished(e -> {
            ft.play();
            startScreenLayout.setCenter(letterImage);
            letterImageView.setImage(saveOrDontImage);
            startScreenLayout.setBottom(null);
        });
        fade3.play();
    }

    public void gameOverMethod() {
        ft.setOnFinished(e -> {});
        fade.setOnFinished(e -> {
            startScreenLayout.setBottom(null);
            startScreenLayout.setCenter(gameOverBox);
            ft.play();
        });
        fade.play();
    }
    public void ding() {
        String s = "sounds/ding.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        dingMediaPlayer = new MediaPlayer(h);
        dingMediaPlayer.setVolume(0.1);
        dingMediaPlayer.setRate(1.2);
        dingMediaPlayer.play();
    }

    public void happyDing() {
        String s = "sounds/reverseDing.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        dingMediaPlayer = new MediaPlayer(h);
        dingMediaPlayer.setVolume(0.1);
        dingMediaPlayer.setRate(1.2);
        dingMediaPlayer.play();
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
        soundEffectMediaPlayer.setVolume(0.2);
        soundEffectMediaPlayer.play();
    }

    public void crickets() {
        String s = "sounds/crickets.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.1);
        soundEffectMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        soundEffectMediaPlayer.play();
    }

    public void music() {
        String s = "sounds/bgm.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        musicMediaPlayer = new MediaPlayer(h);
        musicMediaPlayer.setVolume(0.1);
        musicMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        musicMediaPlayer.play();
    }

    public void decisionMusic() {
        String s = "sounds/dm.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        decisionMusicMediaPlayer = new MediaPlayer(h);
        decisionMusicMediaPlayer.setVolume(0.1);
        decisionMusicMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        decisionMusicMediaPlayer.play();
    }

    public void emotional() {
        String s = "sounds/emotional.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        soundEffectMediaPlayer = new MediaPlayer(h);
        soundEffectMediaPlayer.setVolume(0.1);
        soundEffectMediaPlayer.play();
    }

}