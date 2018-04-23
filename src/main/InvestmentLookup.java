package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

//https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=4CBI4YYCQ46VPK7I
/*Instance class which establishes a connection to
 *the Alpha Vantage API endpoint to perform GET requests.
 */
public class InvestmentLookup {


    public InvestmentLookup(){

    }


    public void lookupStockDaily(String symbol){
        try {
            URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                    + symbol + "&apikey=4CBI4YYCQ46VPK7I");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);


            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            System.out.print(content);
        } catch (MalformedURLException urlException) {

        } catch (IOException ioException) {

        }


    }

    public void lookupCryptoDaily(String symbol){
        try {
            URL url = new URL("https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_DAILY&symbol="
                    + symbol + "&market=USD&apikey=4CBI4YYCQ46VPK7I");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);


            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            System.out.print(content);
        } catch (MalformedURLException urlException) {

        } catch (IOException ioException) {

        }
    }
}
