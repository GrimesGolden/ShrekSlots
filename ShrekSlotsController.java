// Controller for the shrek slot game.

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Random;

public class ShrekSlotsController {

    // Declare private components
    @FXML
    private ImageView imgOne;

    @FXML
    private ImageView imgTwo;

    @FXML
    private ImageView imgThree;

    @FXML
    private TextField userInput;

    @FXML
    private TextField amountWon;

    @FXML
    private TextField totalWon;

    @FXML
    private Button spinButton;

    // Declare images.

    private Image shrek;

    private Image donkey;

    private Image farquad; 

    // Declare total.
    double total = 0.00; // Total winnings. 

    public void initialize()
    // Loads images for GUI.
    {
        shrek = new Image("shrek.jpg");
        donkey = new Image("donkey.jpg");
        farquad = new Image("farquad.jpg");
    }

    public void spinSlot(ImageView i)
    // Simulates spinning a lot machine.
    {
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(3);

        if (randomInt == 0)
        {
            i.setImage(shrek);
        }

        else if (randomInt == 1)
        {
            i.setImage(donkey);
        }

        else
        {
            i.setImage(farquad);
        }

    }

    public void calculateEarnings(int i)
    // Calculates earnings using user input. 
    {   
        double earnings = i;

        if (imgOne.getImage() == imgTwo.getImage() && imgOne.getImage() == imgThree.getImage())
        {
            earnings *= 3;
        }

        else if (imgOne.getImage() == imgTwo.getImage() || imgOne.getImage() == imgThree.getImage())
        {
            earnings *= 2;
        }

        else if (imgTwo.getImage() == imgOne.getImage() || imgTwo.getImage() == imgThree.getImage())
        {
            earnings *= 2;
        }

        else if (imgThree.getImage() == imgOne.getImage() || imgThree.getImage() == imgTwo.getImage())
        {
            earnings *= 2;
        }

        else
        {
            earnings = 0.00;
        }


        total += earnings;

        String intAmountWon = String.valueOf(earnings);
        String intTotalWon = String.valueOf(total);
        

        amountWon.setText(intAmountWon);
        totalWon.setText(intTotalWon);

    }

    public void spinButtonListener()
    //Spins all three slot wheels.  
    // Then calculates earnings accordingly. 
    {	
    	spinSlot(imgOne);
        spinSlot(imgTwo);
        spinSlot(imgThree);

        String message = userInput.getText();

        int i = Integer.parseInt(message);

        calculateEarnings(i);
    }
}