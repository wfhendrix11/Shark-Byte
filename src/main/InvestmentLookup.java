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


    public static String lookupStockDaily(String symbol){

        String searchResult = "";

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

            searchResult = content.toString();
        } catch (MalformedURLException urlException) {

        } catch (IOException ioException) {

        }

        return searchResult;
    }

    public static String lookupCryptoDaily(String symbol){

        String searchResult = "";

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
            searchResult = content.toString();

        } catch (MalformedURLException urlException) {

        } catch (IOException ioException) {

        }
        return searchResult;
    }

    public static double getMostRecentStockPrice(String symbol){
        String searchResult = lookupStockDaily(symbol);
        int indexOfMostRecentClose = searchResult.indexOf("4. close") + 12;
        double mostRecentClose = Double.parseDouble(searchResult.substring(indexOfMostRecentClose, indexOfMostRecentClose + 7));
        return mostRecentClose;
    }

    public static double getMostRecentCryptoPrice(String symbol){
        String searchResult = InvestmentLookup.lookupCryptoDaily(symbol);
        int indexOfMostRecentClose = searchResult.indexOf("close") + 15;
        int indexOfEndOfClose = searchResult.indexOf("\"", indexOfMostRecentClose);
        double mostRecentClose = Double.parseDouble(searchResult.substring(indexOfMostRecentClose, indexOfEndOfClose));
        return mostRecentClose;
    }
}
