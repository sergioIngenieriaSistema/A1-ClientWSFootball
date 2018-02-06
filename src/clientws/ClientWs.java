/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientws;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.TCountryInfo;
import java.util.List;

/**
 *
 * @author sergio
 */
public class ClientWs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("YellowCardTotal: " + yellowCardsTotal());
        ArrayOfString allDefendersOfSpain = allDefenders("spain");
        List<String> list = allDefendersOfSpain.getString();
        
        System.out.println("Defenders of Spain:");
        list.stream().forEach((list1) -> {
            System.out.println("Name: " + list1);
        });
        
        ArrayOftCountryInfo countryNames = countryNames(true);
        List<TCountryInfo> tCountryInfo = countryNames.getTCountryInfo();
        for (TCountryInfo tCountryInfo1 : tCountryInfo) {
            System.out.println(tCountryInfo1.getSName());
            getAllDefenders(allDefenders(tCountryInfo1.getSName()));
        }
    }
    
    private static void getAllDefenders(ArrayOfString allDefenders){
        List<String> list = allDefenders.getString();
        list.stream().forEach((list1) -> {
            System.out.println("Name: " + list1);
        });
    }

    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }
    
}
