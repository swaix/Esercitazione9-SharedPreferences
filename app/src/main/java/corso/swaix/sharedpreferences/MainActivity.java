package corso.swaix.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    // Identificatore delle preferenze dell'applicazione
    private final static String MY_PREFERENCES = "MyPref";
    // Costante relativa al nome della particolare preferenza
    private final static String TEXT_DATA_KEY = "textData";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updatePreferencesData();
    }

    /**
     * Metodo di gestione del pulsante che salva le preferences
     *
     * @param view
     *            Riferimento al button premuto
     */
    public void savePreferencesData(View view) {
        // Otteniamo il riferimento alle Preferences
        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Otteniamo il corrispondente Editor
        SharedPreferences.Editor editor = prefs.edit();
        // Modifichiamo il valore con quello inserito nell'EditText
        EditText outputView = (EditText) findViewById(R.id.inputData);
        CharSequence textData = outputView.getText();
        if (textData != null) {
            // Lo salviamo nelle Preferences
            editor.putString(TEXT_DATA_KEY, textData.toString());
            editor.commit();
        }
        updatePreferencesData();
    }

    private void updatePreferencesData(){
        // Leggiamo le Preferences
        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        // Leggiamo l'informazione associata alla propriet� TEXT_DATA
        String textData = prefs.getString(TEXT_DATA_KEY, "No Preferences!");
        // Lo impostiamo alla TextView
        TextView outputView = (TextView) findViewById(R.id.outputData);
        outputView.setText(textData);
    }
}