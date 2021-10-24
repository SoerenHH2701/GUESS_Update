package com.pigo.guess_reloaded;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        DB_Handler db = new DB_Handler(this);

        // Lösche Tabelle und erstelle neu. Notwendig für Updates der Fragen

        db.dropTableQANDA();
        db.createTableQANDA();

        // Füge Fragen hinzu

        db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Tinder Nutzer sind in einer Beziehung?", "42", "schwer", "379727", "1418559", "2279631"));
        db.addQANDA(new DB_Columns_QANDA("Betrag, den Facebook-Mitarbeiter bekommen können, wenn sie ihre Eizelle einfrieren lassen ($)", "20000", "mittel", "215182", "2171267", "3003873"));
        db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch den Straßenverkehr eines Monats (t)", "2222", "leicht", "172034", "2148375", "2869535"));
        db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch die Feuerwerke einer Sylvesternacht (t)", "4000", "leicht", "49330", "1643339", "2265368"));
        db.addQANDA(new DB_Columns_QANDA("Bei welchen Olympischen Spielen gab es die ersten Goldmedaillen für die Sieger?", "1908", "leicht", "199956", "2010772", "2437579"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde das World Wide Web öffentlich nutzbar gemacht?", "1990", "schwer", "214677", "1284382", "2361776"));
        db.addQANDA(new DB_Columns_QANDA("In Welchem Jahr wurde die erste Domain unter der Top Level Domain .com registriert?", "1985", "schwer", "593771", "2202112", "2659513"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele .com Domains gab es im September 2009?", "82447376", "leicht", "183992", "2030244", "2373504"));
        db.addQANDA(new DB_Columns_QANDA("Wer hoch ist das höchste Gebäude (m) ?", "828", "leicht", "693414", "1429590", "2970797"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Mt. Everest (m) ?", "8848", "schwer", "943686", "2023354", "2414778"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr fiel die Berliner Mauer ?", "1989", "schwer", "3053", "1502113", "2908544"));
        db.addQANDA(new DB_Columns_QANDA("Wie schnell ist ein Gepard (km/h) ?", "120", "leicht", "1028177", "2046177", "3207608"));
        db.addQANDA(new DB_Columns_QANDA("Wie lang ist der Mittellandkanal (km) ?", "325", "schwer", "832568", "2204043", "2245580"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel darf ein Boxer der Fliegengewichtklasse maximal wiegen (kg) ?", "51", "mittel", "555873", "1939083", "2242886"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr kam die CD auf den Markt ?", "1982", "mittel", "481089", "1877280", "3167256"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Stellen hat der Strichcode der Europäischen Artikelnummer ?", "19", "schwer", "132851", "1818830", "2486062"));
        db.addQANDA(new DB_Columns_QANDA("Wie oft wird der Deutsche Aktienindex (DAX) pro Stunde errechnet ?", "3600", "schwer", "1041425", "1523792", "3023454"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Federn hat ein ausgewachsener Schwan ?", "25000", "leicht", "448347", "1519392", "3220337"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Berliner Fernsehturm (m) ?", "365", "mittel", "602409", "1312820", "2608728"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Jahre braucht ein Mensch, um bis 1 Milliarde zu zählen ?", "80", "mittel", "740224", "1240435", "3166547"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Buchstaben hat das hawaiianische Alphabet?", "12", "mittel", "90635", "1523064", "2995212"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Einkerbungen hat ein Golfball ?", "336", "mittel", "418111", "1724321", "2321512"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Buchstaben hat das längste englische Wort laut dem Oxford Dictionary ?", "44", "mittel", "279200", "1423356", "3134356"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Räume hat der Buckingham Palast ?", "602", "leicht", "323519", "1596318", "2491379"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Minuten muss man ein Straußenei kochen, bis es hartgekocht ist ?", "40", "mittel", "834269", "1288136", "2903589"));
        db.addQANDA(new DB_Columns_QANDA("Ein ausgewachsener Mensch besitzt 206 Knochen - aber mit Wie vielen werden wir geboren?", "301", "schwer", "546267", "2085080", "2995816"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist das weltweite Durchschnittsalter beim 1. Sex ?", "17", "schwer", "1013631", "1340347", "2738840"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Teile Besteck gibt es im Weißen Haus ?", "13092", "leicht", "870852", "1333098", "3102290"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Weltbevölkerung hat noch nie einen Telefonanruf erhalten oder getätigt ?", "53", "leicht", "51842", "1524474", "2786634"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde die Riesenschildkröte Awiata geboren, die 2006 als älteste ihrer Art im Zoo von Kalkutta gestorben ist ?", "1750", "leicht", "562047", "1597894", "2430162"));
        db.addQANDA(new DB_Columns_QANDA("Wie tief ist der tiefste natürliche See Deutschlands ?", "254", "leicht", "139986", "2139523", "2334884"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder brachten unter 15 Jährige Mädchen 2014 insgesamt zur Welt ?", "66", "schwer", "696565", "1500060", "2607179"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen saßen 2015 in Deutschland im Gefängnis ?", "61872", "leicht", "1133420", "1584294", "2302462"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr fand die Markteinführung der Playmobilfiguren statt?", "1974", "leicht", "114596", "1416691", "2629772"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Spiele absolvierte Franz Beckenbauer für die deutsche Nationalmannschaft ?", "103", "leicht", "251490", "2152151", "2655840"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr startete in Deutschland Wer wird Millionär ?", "1999", "mittel", "123784", "1864560", "3044372"));
        db.addQANDA(new DB_Columns_QANDA("Wie alt wurde Konrad Adenauer?", "91", "leicht", "300826", "1387474", "3031408"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde der erste McDonals-Drive-In eingeführt ?", "1975", "schwer", "1189698", "1670253", "2520140"));
        db.addQANDA(new DB_Columns_QANDA("Aus Wie vielen Inseln bestehen die Malediven ?", "1196", "schwer", "558994", "1440121", "2618880"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Stunden Videomaterial werden pro Minute weltweit bei YouTube hochgeladen ?", "48", "mittel", "904633", "1915399", "2501950"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr wurde in Berlin das erste deutsche Telefonbuch veröffentlicht ?", "1881", "leicht", "1003549", "2188345", "3216218"));
        db.addQANDA(new DB_Columns_QANDA("Seit wann existiert die Verkehrssünderkartei in Flensburg ?", "1958", "leicht", "25619", "1790064", "2306639"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der höchste Baum Deutschlands (m) ?", "63", "mittel", "137835", "1769950", "2560347"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Sterne sieht man von der Erde aus mit dem bloßen Auge ?", "6000", "schwer", "314487", "1765071", "2422794"));
        db.addQANDA(new DB_Columns_QANDA("Vor wie vielen Jahren wurde Geld erfunden ? ", "7000", "mittel", "870524", "1409123", "2483608"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Schritte muss man etwa gehen, um von Karlsruhe nach Stuttgart zu kommen ?", "118500", "leicht", "1146798", "1564681", "2853551"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Satelliten befinden sich im All ?", "1200", "mittel", "915718", "1806852", "2620538"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Scheidungen gab es 2013 in Deutschland ?", "170000", "mittel", "773411", "2000668", "2437370"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder sterben weltweit täglich infolge unsauberem Trinkwasser ?", "6000", "schwer", "1123110", "1571087", "2986456"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Liter Wasser werden benötigt, um 1 Kilo Baumwolle anzubauen ?", "10000", "leicht", "390375", "1462185", "3080326"));
        db.addQANDA(new DB_Columns_QANDA("Wie warm kann es an der Oberfläche der Sonne werden (Grad Celsius) ?", "5780", "schwer", "280096", "1794430", "2413146"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele (bekannte) Insektenarten gibt es in der Schweiz ?", "22300", "schwer", "492994", "2059358", "2636498"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Unternehmen gab es 2015 in Deutschland ?", "3469039", "schwer", "70620", "1289318", "2724252"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kilometer legt ein TShirt insgesamt zurück bis es fertig im Laden hängt ?", "50000", "mittel", "529130", "1546119", "2341269"));
        db.addQANDA(new DB_Columns_QANDA("Wie lang ist ein Marathon (m) ?", "42195", "mittel", "893095", "1795292", "2499455"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch war das durchschnittliche Bruttoentgelt in Deutschland 2015", "34999", "leicht", "213603", "1924412", "2766876"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kennzeichenkürzel gab es 2013 in Deutschland", "777", "leicht", "1154543", "2008999", "2574313"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Männer durchschnittlich im Monat für Kleidung aus? (€)", "23", "mittel", "404572", "1648202", "3201680"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Frauen durchschnittlich im Monat für Kleidung aus? (€)", "44", "mittel", "954188", "1340897", "3142178"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Deutsche durchschnittlich für einen Neuwagen aus (€)", "31400", "mittel", "706667", "1636804", "2681478"));
        db.addQANDA(new DB_Columns_QANDA("Der niedrigste Gewinn bei 6 richtigen im Lotto? (€)", "8644", "leicht", "900505", "1672713", "2661497"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen lebten jemals auf der Erde ? (Mrd.)", "108", "mittel", "251899", "1418641", "2396491"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Polizisten gibt es in Sachsen? ", "10772", "leicht", "230914", "1826902", "2970912"));
        db.addQANDA(new DB_Columns_QANDA("Wie alt wurde das älteste Pferd Deutschlands ?", "52", "leicht", "378346", "1713517", "3099828"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel verdient Bill Gates pro Sekunde ? (€)", "76", "schwer", "618819", "1830620", "2688715"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Liter Bier trinkt jeder Deutsche pro Jahr", "107", "leicht", "329868", "1713098", "2513801"));
        db.addQANDA(new DB_Columns_QANDA("Wie schwer ist ein Blauwal ? (t)", "190", "leicht", "766406", "1994147", "2291053"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Mitarbeiter hat VW (2016) ?", "626715", "schwer", "842793", "1687350", "2483639"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kalorien hat ein Apfel?", "52", "leicht", "718598", "1794454", "3073450"));
        db.addQANDA(new DB_Columns_QANDA("Wie groß ist Michael Jordan (cm)?", "198", "schwer", "558857", "1262889", "2633895"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Haustiere gibt es in Deutschland? (Mio)", "30", "mittel", "763022", "2016420", "2677205"));
        db.addQANDA(new DB_Columns_QANDA("In welcher Höhe befindet sich die internationale Raumstation ISS (km)?", "400", "mittel", "657314", "2162346", "2359311"));
        db.addQANDA(new DB_Columns_QANDA("Wie schnell dreht sich die Erde am Ã„quator ? (km/h)", "1650", "schwer", "70500", "1686607", "2248479"));
        db.addQANDA(new DB_Columns_QANDA("Wie schnell dreht sich die Erde um die Sonne ? (km/h)", "107000", "schwer", "1123865", "1732859", "3013240"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Würfelzucker sind in einem Liter Cola?", "40", "schwer", "1159753", "1896796", "3206520"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Seiten hatte der gedruckte IKEA-Katalog 2011?", "388", "mittel", "700264", "1584941", "2614490"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Anteil der Menschen, die sich bei den Mahlzeiten Frühstück, Mittagessen und Abendessen an feste Zeiten halten (%)?", "33", "leicht", "770004", "2023468", "2379785"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Mahlzeiten nimmt ein Deutscher bis zu seinem 50. Lebensjahr durchschnittlich zu sich?", "100000", "leicht", "120031", "1972609", "2975673"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Wasser steckt in Salatgurken (%)? ", "95", "leicht", "865859", "1625971", "3219886"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Muskeln sind am Schlucken beteiligt?", "20", "leicht", "1004676", "2035503", "2324033"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Apfelsorten gibt es weltweit?", "20000", "schwer", "495606", "1842441", "2937904"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Lebensmittel werden in Haushalten weggeworfen (%)?", "20", "leicht", "1026583", "1855315", "2812751"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Verbraucher würden zu Hause Lebensmittel wegwerfen, weil das Mindesthaltbarkeitsdatum (MHD) abgelaufen ist (%)?", "33", "schwer", "716901", "1868497", "3046288"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Suren hat der Koran?", "114", "leicht", "1165763", "1996067", "3136799"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Niederschlag gibt es in der Sahara pro Jahr? (mm)", "250", "schwer", "328358", "1479673", "2680470"));
        db.addQANDA(new DB_Columns_QANDA("Wie schwer war Manuel Uribe Garza (der schwerste Mensch der Welt)? (kg)", "592", "schwer", "630164", "1576349", "2390216"));
        db.addQANDA(new DB_Columns_QANDA("Wieviel Liter Wasser kann ein Kamel in 15 Minuten trinken?", "200", "leicht", "1109752", "1366698", "2630354"));
        db.addQANDA(new DB_Columns_QANDA("Wieviele Kilogramm Haut schuppen sich im Laufe eines Lebens vom Körper ab (kg)?", "20", "mittel", "819142", "1554021", "2532878"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde das Mobiltelefon zum Patent angemeldet?", "1942", "leicht", "361090", "1528899", "2852375"));
        db.addQANDA(new DB_Columns_QANDA("Um wieviele Zentimeter schrumpft der Eifelturm bei Kälte (cm)?", "15", "mittel", "464318", "1852788", "2621535"));
        db.addQANDA(new DB_Columns_QANDA("Wie lang dauerte der 100-jährige Krieg?", "116", "mittel", "1216591", "1610516", "2889539"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Strophen hat die griechische Nationalhymne? ?", "158", "mittel", "1136363", "2103819", "2629727"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Hamster werden benötigt, um ein Haus mit Strom zu versorgen ? :-)", "2400", "schwer", "739874", "2100480", "2275875"));

        System.out.println("DB ROWS ADDED");

        Button start = findViewById(R.id.btnStart);
        start.setVisibility(View.GONE);

        TextView tvLogo = findViewById(R.id.tvLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("G");
            }
        }, 600);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("U");
            }
        }, 900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("E");
            }
        }, 1200);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("S");
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLogo.append("S");
            }
        }, 1800);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                start.setVisibility(View.VISIBLE);
            }
        }, 2100);

        start.setOnClickListener(v -> {
            Intent i = new Intent(Start.this, Difficulty.class);
            startActivity(i);
        });

    }

}
