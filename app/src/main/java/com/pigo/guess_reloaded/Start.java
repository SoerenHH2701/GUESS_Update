package com.pigo.guess_reloaded;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        DB_Handler db = new DB_Handler(this);

        // Prüfe Größe der Tabelle; wenn Tabellengröße abweichend wird die Tabelle gedropped und die Fragen hinzugefügt (onUpgrade)

        if (db.getSize("questions_and_answers_table") != 0) {
        } else {

            db.addQANDA(new DB_Columns_QANDA("Wie viele Weihnachtsbäume werden in Deutschland pro Jahr verkauft?","30000000","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Im Jahr 2013 gab es in Deutschland ungefähr 15.000 Tankstellen. Wie viele Tankstellen gab es vor noch 50 Jahren um das Jahr 1970?","60000","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Piratenüberfälle gab es 2012 weltweit?","300","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen in Deutschland nutzen ein Smartphone?","40000000","aktuelles", "leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Krankenkassen gibt es in Deutschland?","113","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder wurden 2014 nicht im Krankenhaus geboren?","11391","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Durchschnittliche Entferung, in der Menschen in den USA zu Ihrer Mutter Wohnen (km)","29","aktuelles","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Tinder Nutzer sind in einer Beziehung?","42","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Betrag, den Facebook-Mitarbeiter bekommen können, wenn sie ihre Eizelle einfrieren lassen ($)","20000","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch den StraÃŸenverkehr eines Monats (t)","2222","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch die Feuerwerke einer Sylvesternacht (t)","4000","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Bei welchen Olympischen Spielen gab es die ersten Goldmedaillen für die Sieger?","1908","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wann wurde das World Wide Web öffentlich nutzbar gemacht?","1990","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("In Welchem Jahr wurde die erste Domain unter der Top Level Domain .com registriert?","1985","allgemein","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele .com Domains gab es im September 2009?","82447376","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie hoch ist das höchste Gebäude (m) ?","828","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Mt. Everest (m) ?","8848","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("In welchem Jahr fiel die Berliner Mauer ?","1989","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie schnell ist ein Gepard (km/h) ?","120","aktuelles","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie lang ist der Mittellandkanal (km) ?","325","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel darf ein Boxer der Fliegengewichtklasse maximal wiegen (kg) ?","51","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("In welchem Jahr kam die CD auf den Markt ?","1982","allgemein","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Stellen hat der Strichcode der EuropÃ¤ischen Artikelnummer ?","19","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie oft wird der Deutsche Aktienindex (DAX) pro Stunde errechnet ?","3600","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Federn hat ein ausgewachsener Schwan ?","25000","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Berliner Fernsehturm (m) ?","365","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Jahre braucht ein Mensch, um bis 1 Milliarde zu zÃ¤hlen ?","80","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Buchstaben hat das hawaiianische Alphabet?","12","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Einkerbungen hat ein Golfball ?","336","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Buchstaben hat das lÃ¤ngste englische Wort laut dem Oxford Dictionary ?","44","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Räume hat der Buckingham Palast ?","602","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Minuten muss man ein Straußenei kochen, bis es hartgekocht ist ?","40","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Ein ausgewachsener Mensch besitzt 206 Knochen - aber mit Wie vielen werden wir geboren?","301","allgemein","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie hoch ist das weltweite Durchschnittsalter beim 1. Sex ?","17","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Teile Besteck gibt es im WeiÃŸen Haus ?","13092","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Weltbevölkerung hat noch nie einen Telefonanruf erhalten oder getÃ¤tigt ?","53","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wann wurde die Riesenschildkröte Awiata geboren, die 2006 als Ã¤lteste ihrer Art im Zoo von Kalkutta gestorben ist ?","1750","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie tief ist der tiefste natÃ¼rliche See Deutschlands ?","254","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder brachten unter 15 Jährige Mädchen 2014 insgesamt zur Welt ?","66","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen saßen 2015 in Deutschland im Gefängnis ?","61872","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("In welchem Jahr fand die Markteinführung der Playmobilfiguren statt?","1974","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Spiele absolvierte Franz Beckenbauer für die deutsche Nationalmannschaft ?","103","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("In welchem Jahr startete in Deutschland Wer wird MillionÃ¤r ?","1999","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie alt wurde Konrad Adenauer?","91","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wann wurde der erste McDonals-Drive-In eingeführt ?","1975","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Aus Wie vielen Inseln bestehen die Malediven ?","1196","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Stunden Videomaterial werden pro Minute weltweit bei YouTube hochgeladen ?","48","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("In welchem Jahr wurde in Berlin das erste deutsche Telefonbuch veröffentlicht ?","1881","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Seit wann existiert die Verkehrssünderkartei in Flensburg ?","1958","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der höchste Baum Deutschlands (m) ?","63","aktuelles","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Sterne sieht man von der Erde aus mit dem bloÃŸen Auge ?","6000","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Vor wie vielen Jahren wurde Geld erfunden ? ","7000","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Schritte muss man etwa gehen, um von Karlsruhe nach Stuttgart zu kommen ?","118500","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Satelliten befinden sich im All ?","1200","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Scheidungen gab es 2013 in Deutschland ?","170000","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder sterben weltweit täglich infolge unsauberem Trinkwasser ?","6000","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Liter Wasser werden benötigt, um 1 Kilo Baumwolle anzubauen ?","10000","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie warm kann es an der OberflÃ¤che der Sonne werden (Grad Celsius) ?","5780","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele (bekannte) Insektenarten gibt es in der Schweiz ?","22300","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Unternehmen gab es 2015 in Deutschland ?","3469039","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Kilometer legt ein TShirt insgesamt zurÃ¼ck bis es fertig im Laden hÃ¤ngt ?","50000","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie lang ist ein Marathon (m) ?","42195","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie hoch war das durchschnittliche Bruttoentgelt in Deutschland 2015","34999","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Kennzeichenkürzel gab es 2013 in Deutschland","777","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben MÃ¤nner durchschnittlich im Monat für Kleidung aus? (€)","23","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Frauen durchschnittlich im Monat für Kleidung aus? (€)","44","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Deutsche durchschnittlich für einen Neuwagen aus (€)","31400","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Der niedrigste Gewinn bei 6 richtigen im Lotto? (€)","8644","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen lebten jemals auf der Erde ? (Mrd.)","108","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Polizisten gibt es in Sachsen? ","10772","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie alt wurde das Älteste Pferd Deutschlands ?","52","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel verdient Bill Gates pro Sekunde ? (â‚¬)","76","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Liter Bier trinkt jeder Deutsche pro Jahr","107","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie schwer ist ein Blauwal ? (t)","190","aktuelles","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Mitarbeiter hat VW (2016) ?","626715","allgemein","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Kalorien hat ein Apfel?","52","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie groÃŸ ist Michael Jordan (cm)?","198","allgemein","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Haustiere gibt es in Deutschland? (Mio)","30","allgemein","schwer"));
            db.addQANDA(new DB_Columns_QANDA("In welcher Höhe befindet sich die internationale Raumstation ISS (km)?","400","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie schnell dreht sich die Erde am Ãquator ? (km/h)","1650","aktuelles","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie schnell dreht sich die Erde um die Sonne ? (km/h)","107000","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Würfelzucker sind in einem Liter Cola?","40","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Seiten hatte der gedruckte IKEA-Katalog 2011?","388","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Anteil der Menschen, die sich bei den Mahlzeiten Frühstück, Mittagessen und Abendessen an feste Zeiten halten (%)?","33","geschichte","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Mahlzeiten nimmt ein Deutscher bis zu seinem 50. Lebensjahr durchschnittlich zu sich?","100000","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Wasser steckt in Salatgurken (%)? ","95","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Muskeln sind am Schlucken beteiligt?","20","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Apfelsorten gibt es weltweit?","20000","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Lebensmittel werden in Haushalten weggeworfen (%)?","20","aktuelles","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Verbraucher würden zu Hause Lebensmittel wegwerfen, weil das Mindesthaltbarkeitsdatum (MHD) abgelaufen ist (%)?","33","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Suren hat der Koran?","114","aktuelles","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie viel Niederschlag gibt es in der Sahara pro Jahr? (mm)","250","allgemein","mittel"));
            db.addQANDA(new DB_Columns_QANDA("Wie schwer war Manuel Uribe Garza (der schwerste Mensch der Welt)? (kg)","592","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wieviel Liter Wasser kann ein Kamel in 15 Minuten trinken?","200","allgemein","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wieviele Kilogramm Haut schuppen sich im Laufe eines Lebens vom Körper ab (kg)?","20","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wann wurde das Mobiltelefon zum Patent angemeldet?","1942","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Um wieviele Zentimeter schrumpft der Eifelturm bei Kälte (cm)?","15","aktuelles","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie lang dauerte der 100-jährige Krieg?","116","geschichte","schwer"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Strophen hat die griechische Nationalhymne? ?","158","geschichte","leicht"));
            db.addQANDA(new DB_Columns_QANDA("Wie viele Hamster werden benötigt, um ein Haus mit Strom zu versorgen ? :-)","2400","allgemein","mittel"));

            System.out.println("DB ROWS ADDED");

        }

        Button start = (Button) findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Difficulty.class);
                startActivity(i);
            }
        });

    }



}
