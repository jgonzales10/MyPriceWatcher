package edu.utep.cs.cs4330.mypricewatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //2 buttons, 4 descriptors
    private Button refreshButton;
    private Button searchButton;
    private EditText urlDisplay;
    private TextView nameDisplay;
    private TextView initPriceDisplay;
    private TextView currPriceDisplay;
    private TextView percentChangeDisplay;
    private String URL;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item = new Item();
        //Buttons
        refreshButton = findViewById(R.id.refreshButton);
        searchButton = findViewById(R.id.searchButton);
        //Displays
        urlDisplay = findViewById(R.id.urlDisplay);
        nameDisplay = findViewById(R.id.nameDisplay);
        initPriceDisplay = findViewById(R.id.initPriceDisplay);
        currPriceDisplay = findViewById(R.id.currPriceDisplay);
        percentChangeDisplay = findViewById(R.id.percentChangeDisplay);
    }
    public void searchClicked(View view){
        Toast.makeText(this, "Search Tapped!", Toast.LENGTH_SHORT).show();
        URL = urlDisplay.getText().toString();
        //item.setUrl(URL);
        if (URL.isEmpty()) {//checks that URL is not blank
            Toast.makeText(this, "Please insert a URL when searching!", Toast.LENGTH_SHORT).show();
        }
        else{
            if(!item.isEmpty() && !item.getURL().equals(URL)){ //if user inserts different url
                item = new Item();
                item.setUrl(URL);
                double price = PriceFinder.findPrice(URL);
                item.setInitialPrice(price);
            }
            else{ //user is using same url, doesn't change the InitialPrice
                item.setUrl(URL);
            }
            item.setCurrPrice(PriceFinder.findPrice(URL));

            if (item.initIsZero()) {
                item.setInitialPrice(item.getCurrPrice());
            }
            displayInfo();
        }

    }
    public void refreshClicked(View view) {
        Toast.makeText(this, "Refresh Tapped!", Toast.LENGTH_SHORT).show();
        if (!item.initIsZero()){
            item.setCurrPrice(PriceFinder.findPrice(item.getURL()));
            displayInfo();
        }
        else{
            Toast.makeText(this, "Please Provide URL first!", Toast.LENGTH_SHORT).show();
        }
        }
    private void displayInfo(){
        String URL = item.getURL();
        String name = item.getName();
        double initialPrice = item.getInitialPrice();
        double currPrice = item.getCurrPrice();
        double percent = item.percentageChange();

        urlDisplay.setText(URL);
        nameDisplay.setText(URL); //For now i'm just calling the item by its url
        initPriceDisplay.setText(String.format("%.02f",initialPrice));
        currPriceDisplay.setText(String.format("%.02f",currPrice));
        percentChangeDisplay.setText(String.format("%.0f",percent,"%"));
    }
}
