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
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr wurde in Berlin das erste deutsche Telefonbuch veröffentlicht?","1881","mittel","1721","1911","1799"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der höchste Baum Deutschlands? (m)","63","schwer","69","61","78"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele (bekannte) Insektenarten gibt es in der Schweiz?","22300","schwer","19867","24360","26242"));
        db.addQANDA(new DB_Columns_QANDA("Um wieviele Zentimeter schrumpft der Eifelturm bei Kälte? (cm)","15","schwer","13","10","11"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist das weltweite Durchschnittsalter beim 1. Sex?","17","leicht","15","13","21"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent aller weltweiten Schäden an Kopieren werden dadurch verursacht, dass Menschen ihr Hinterteil fotokopieren? (%)","32","mittel","37","28","39"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Minuten muss man ein Straußenei kochen, bis es hartgekocht ist?","40","leicht","47","29","40"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Sterne sieht man von der Erde aus mit dem bloßen Auge?","6000","schwer","5285","4321","5750"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Scheidungen gab es 2013 in Deutschland?","170000","mittel","218000","900000","20000"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kilometer legt ein T-Shirt insgesamt zurück bis es fertig im Laden hängt?","50000","leicht","40000","10000","25000"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Hamster werden benötigt, um ein Haus mit Strom zu versorgen?","2400","schwer","10","2800","500"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr der olympischen Spiele gab es die ersten Goldmedaillen für die Sieger?","1908","mittel","1752","1844","1938"));
        db.addQANDA(new DB_Columns_QANDA("Wie warm kann es an der Oberfläche der Sonne werden? (Grad Celsius)","5780","schwer","15000","3300","1080"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Joints raucht Snoop Dog pro Jahr?","29565","leicht","21306","31512","36173"));
        db.addQANDA(new DB_Columns_QANDA("Der niedrigste Gewinn bei 6 richtigen im Lotto? (€)","8644","mittel","10545","6914","6139"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Mitarbeiter hat VW? (2016)","626715","mittel","505171","117031","988286"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Unternehmen gab es 2015 in Deutschland?","3469039","schwer","3316924","2954299","2449978"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Seiten hatte der gedruckte IKEA-Katalog? (2011)","388","mittel","238","481","741"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr wurde Lucky Luke zum Nichtraucher? Der belgische Comic erschien erstmals im Jahr 1946.","1982","leicht","1951","2008","1999"));
        db.addQANDA(new DB_Columns_QANDA("Wie lang ist der Mittellandkanal? (km)","325","schwer","265","294","243"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Liter Bier trinkt jeder Deutsche pro Jahr","107","leicht","57","120","135"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Sprachen werden auf der Welt gesprochen?","6500","mittel","4777","4849","8447"));
        db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch die Feuerwerke einer Sylvesternacht? (t)","4000","schwer","5500","310","77"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Federn hat ein ausgewachsener Schwan?","25000","schwer","100000","10000","2200"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen lebten bis 2019 jemals auf der Erde? (Mrd.)","108","mittel","121","131","178"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Weltbevölkerung hat noch nie einen Telefonanruf erhalten oder getätigt?","53","schwer","60","32","17"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Höhenunterschied im Amazonas? (Tiefster bis höchster Punkt) (m)","5170","schwer","4154","5603","4920"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Jahre braucht ein Mensch, um bis 1 Milliarde zu zählen?","80","schwer","91","65","69"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Lebensmittel werden in Haushalten weggeworfen? (%)","20","schwer","50","7","34"));
        db.addQANDA(new DB_Columns_QANDA("Wie schnell dreht sich die Erde um die Sonne? (km/h)","107000","schwer","100","45000","88000"));
        db.addQANDA(new DB_Columns_QANDA("Wie tief ist der tiefste natürliche See Deutschlands?","254","leicht","318","89","204"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde das World Wide Web öffentlich nutzbar gemacht?","1990","schwer","1871","2008","1910"));
        db.addQANDA(new DB_Columns_QANDA("Wie alt wurde das älteste Pferd Deutschlands?","52","mittel","64","32","27"));
        db.addQANDA(new DB_Columns_QANDA("Wie oft schauen wir pro Tag durchschnittlich auf das Handy?","88","leicht","490","190","18"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde das Mobiltelefon zum Patent angemeldet?","1942","leicht","1917","1858","1933"));
        db.addQANDA(new DB_Columns_QANDA("Bis zu welchem Jahr musste bei Geburten im britischen Königshaus der Innenminister dabei sein?","1948","schwer","2013","2001","1849"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Niederschlag gibt es in der Sahara pro Jahr? (mm)","250","schwer","500","0","2830"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch war das durchschnittliche Bruttoentgelt in Deutschland 2015 pro Jahr?","34999","mittel","61573","40377","28220"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Menschen ersticken jährlich an Kugelschreibern?","100","mittel","90","27","6"));
        db.addQANDA(new DB_Columns_QANDA("Wie schwer kann eine Schönwetterwolke werden? (t)","1000","mittel","80","4","335"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Mahlzeiten nimmt ein Deutscher bis zu seinem 50. Lebensjahr durchschnittlich zu sich?","100000","leicht","30000","150000","12800"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele km machen alle Straßen in den USA aus? (km)","6592","schwer","18280","5107","966"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen in Deutschland nutzen ein Smartphone? (Mio)","40","leicht","51","28","16"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Deutsche durchschnittlich für einen Neuwagen aus? (€)","31400","leicht","17800","24000","53200"));
        db.addQANDA(new DB_Columns_QANDA("Aus Wie vielen Inseln bestehen die Malediven?","1196","leicht","740","417","883"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel verdient Bill Gates pro Sekunde? (€)","76","leicht","56","196","90"));
        db.addQANDA(new DB_Columns_QANDA("Bei wie vielen Stunden liegt der Weltrekord im Wachbleiben?","266","schwer","316","158","335"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Schafe gibt es in Neuseeland? (Mio)","30","schwer","35","40","45"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Zeit pro Jahr verbringt jeder Deutsche im Durchschnitt mit Warten am PC? (Tage)","6","mittel","14","5","11"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Strophen hat die griechische Nationalhymne?","158","schwer","200","111","195"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Liter Wasser werden benötigt, um 1 Kilo Baumwolle anzubauen?","10000","schwer","5000","2000","100"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Männer durchschnittlich im Monat für Kleidung aus? (€)","23","leicht","280","122","79"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele kcal hat 100ml Vollmilch?","64","schwer","174","15","460"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kennzeichenkürzel gab es 2013 in Deutschland?","777","leicht","678","960","943"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Tage verbringt ein Deutscher in seinem Leben durchschnittlich auf dem Klo?","230","leicht","214","187","329"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Krankenkassen gibt es in Deutschland? (2021)","103","mittel","13","22","77"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Jahre hält eine Ehe im Schnitt?","15","leicht","10","12","14"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Buchstaben hat das längste englische Wort laut dem Oxford Dictionary?","44","schwer","41","36","29"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Teile Besteck gibt es im Weißen Haus?","13092","leicht","14734","10211","16907"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde der erste McDonals-Drive-In eröfnnet?","1975","schwer","1481","1905","1976"));
        db.addQANDA(new DB_Columns_QANDA("Vor wie vielen Jahren wurde Geld erfunden?","7000","schwer","1700","5000","2500"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr kam die CD auf den Markt?","1982","mittel","1916","1876","1975"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr startete in Deutschland Wer wird Millionär?","1999","leicht","1980","1967","1995"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Verbraucher würden zu Hause Lebensmittel wegwerfen, weil das Mindesthaltbarkeitsdatum (MHD) abgelaufen ist?","33","leicht","28","20","45"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen sterben weltweit jährlich, die durch von einem Blitz getroffen werden?","24000","mittel","50000","50","1400"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Prozent der Tinder Nutzer sind in einer Beziehung?","42","schwer","20","17","34"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Piratenüberfälle gab es 2012 weltweit?","300","mittel","326","341","367"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Suren hat der Koran?","114","mittel","83","143","94"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Schritte muss man etwa gehen, um von Karlsruhe nach Stuttgart zu kommen?","118500","mittel","83131","124039","108860"));
        db.addQANDA(new DB_Columns_QANDA("Wie oft wird der Deutsche Aktienindex (DAX) pro Stunde errechnet?","3600","mittel","2450","200","10"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr gab es den ersten selbst gebastelten Adventskalender?","1851","mittel","1994","1777","1303"));
        db.addQANDA(new DB_Columns_QANDA("Wie schwer ist ein Blauwal? (t)","190","schwer","178","160","192"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Würfelzucker sind in einem Liter Cola?","40","schwer","100","5","70"));
        db.addQANDA(new DB_Columns_QANDA("Durchschnittliche Entferung, in der Menschen in den USA zu Ihrer Mutter Wohnen? (km)","29","schwer","32","19","23"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr fand die Markteinführung der Playmobilfiguren statt?","1974","leicht","1994","1945","1924"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Entenarten gibt es auf der Welt?","150","mittel","123","25","61"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Geld geben Frauen durchschnittlich im Monat für Kleidung aus? (€)","44","schwer","110","53","29"));
        db.addQANDA(new DB_Columns_QANDA("Feinstaubbelastung in Deutschland durch den Straßenverkehr eines Monats? (t)","2222","mittel","11897","5022","20701"));
        db.addQANDA(new DB_Columns_QANDA("Wie lang dauerte der 100-jährige Krieg?","116","mittel","122","135","98"));
        db.addQANDA(new DB_Columns_QANDA("Wie alt wurde Konrad Adenauer?","91","leicht","88","69","90"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Stellen hat der Strichcode der Europäischen Artikelnummer?","19","schwer","21","24","17"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele blutsaugende Stechmücken wären nötig, um einen Menschen auf einen Schlag leer zu trinken? (Mio)","1","mittel","5","24","17"));
        db.addQANDA(new DB_Columns_QANDA("Wie lange musste der Weltrekordhalter planken um seinen Rekord aufzubauen? (Stunden)","8","leicht","6","2","11"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Muskeln sind am Schlucken beteiligt?","20","schwer","2","3","11"));
        db.addQANDA(new DB_Columns_QANDA("Entfernung von NY nach Chicago in km (Luftlinie)? (km)","1146","mittel","185","521","1260"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder sterben weltweit täglich infolge unsauberem Trinkwasser?","6000","schwer","1000","40000","100000"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Satelliten befinden sich im All? (2021)","4084","mittel","83","443","1190"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Wasser steckt in Salatgurken? (%)","95","leicht","87","72","79"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Stunden Videomaterial werden pro Minute weltweit bei YouTube hochgeladen? (2021)","400","mittel","377","499","419"));
        db.addQANDA(new DB_Columns_QANDA("Ein ausgewachsener Mensch besitzt 206 Knochen; mit wie vielen werden wir geboren?","301","leicht","204","253","377"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele .com Domains gab es im September 2009?","82447376","schwer","69954225","89734241","86764188"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Berliner Fernsehturm? (m)","365","leicht","449","301","296"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele karibische Inseln waren 2019 vom Hurrikan Irma betroffen?","13","mittel","6","15","11"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder wurden in Deutschland 2014 nicht im Krankenhaus geboren?","11391","leicht","13987","8656","9053"));
        db.addQANDA(new DB_Columns_QANDA("Seit wann existiert die Verkehrssünderkartei in Flensburg?","1958","leicht","1878","1949","1984"));
        db.addQANDA(new DB_Columns_QANDA("Wieviel Prozent der im menschlichen Körper befindlichen Atome werden innerhalb eines Jahres ersetzt? (%)","98","mittel","33","100","52"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Gramm Futter (Mais, Weizen, Soja) frisst ein Huhn pro Tag?","120","leicht","105","55","10"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kalorien hat ein Apfel?","52","leicht","37","52","40"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Weihnachtsbäume werden in Deutschland pro Jahr verkauft?","30000000","leicht","40000000","10000000","20000000"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Spiele absolvierte Franz Beckenbauer für die deutsche Nationalmannschaft?","103","leicht","121","87","85"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Liter Kunstblut gingen für beide Teile des Kultfilms Kill Bill drauf?","1700","schwer","1746","1217","1577"));
        db.addQANDA(new DB_Columns_QANDA("Wann wurde die Riesenschildkröte Awiata geboren, die 2006 als älteste ihrer Art im Zoo von Kalkutta gestorben ist?","1750","leicht","1357","1369","1697"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Anteil der Menschen in Deutschland, die sich bei den Mahlzeiten Frühstück, Mittagessen und Abendessen an feste Zeiten halten (%)?","33","leicht","37","41","38"));
        db.addQANDA(new DB_Columns_QANDA("In welchem Jahr fiel die Berliner Mauer?","1989","schwer","1999","1963","1945"));
        db.addQANDA(new DB_Columns_QANDA("In welcher Höhe befindet sich die internationale Raumstation ISS? (km)","400","leicht","341","280","472"));
        db.addQANDA(new DB_Columns_QANDA("Wieviele Kilogramm Haut schuppen sich im Laufe eines Lebens vom Körper ab (kg)?","20","leicht","15","10","19"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Apfelsorten gibt es weltweit?","20000","schwer","7000","19000","14000"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Räume hat der Buckingham Palast?","602","leicht","693","449","545"));
        db.addQANDA(new DB_Columns_QANDA("Wieviel Liter Wasser kann ein Kamel in 15 Minuten trinken?","200","leicht","160","246","182"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel darf ein Boxer der Fliegengewichtklasse maximal wiegen? (kg)","51","schwer","47","38","59"));
        db.addQANDA(new DB_Columns_QANDA("Wie hoch ist der Mt. Everest? (m)","8848","mittel","8322","8107","7981"));
        db.addQANDA(new DB_Columns_QANDA("Wie schwer war Manuel Uribe Garza (der schwerste Mensch der Welt)? (kg)","592","leicht","647","331","441"));
        db.addQANDA(new DB_Columns_QANDA("Wie viel Einkerbungen hat ein Golfball?","336","schwer","30","256","777"));
        db.addQANDA(new DB_Columns_QANDA("In Welchem Jahr wurde die erste Domain unter der Top Level Domain .com registriert?","1985","schwer","1999","1979","1982"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Polizisten gibt es in Sachsen?","10772","mittel","8302","11894","12504"));
        db.addQANDA(new DB_Columns_QANDA("Wie lang ist ein Marathon? (m)","42195","leicht","35488","51174","49793"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Haustiere gibt es in Deutschland? (Mio)","30","mittel","34","36","28"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Buchstaben hat das hawaiianische Alphabet?","12","leicht","11","10","9"));
        db.addQANDA(new DB_Columns_QANDA("Im Jahr 2013 gab es in Deutschland ungefähr 15.000 Tankstellen. Wie viele Tankstellen gab es vor noch 50 Jahren um das Jahr 1970?","60000","leicht","67000","73000","48000"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Menschen saßen 2015 in Deutschland im Gefängnis?","61872","mittel","48423","72096","19962"));
        db.addQANDA(new DB_Columns_QANDA("Betrag, den Facebook-Mitarbeiter bekommen können, wenn sie ihre Eizelle einfrieren lassen? ($)","20000","mittel","5000","100","45000"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Zähne hat ein Eisbär?","42","schwer","33","29","37"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Sekunden braucht es zum Mond mit einer Rakete? (Sekunden)","259200","schwer","207977","251694","224742"));
        db.addQANDA(new DB_Columns_QANDA("Wie schnell dreht sich die Erde am Äquator? (km/h)","1650","schwer","2137","1463","1945"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Kinder brachten unter 15 Jährige Mädchen 2014 insgesamt zur Welt?","66","mittel","72","49","62"));
        db.addQANDA(new DB_Columns_QANDA("Wie viele Alben hat Eminem insgesamt weltweit verkauft? (Mio)","100","schwer","77","91","88"));
        db.addQANDA(new DB_Columns_QANDA("Wer hoch ist das höchste Gebäude? (m)","828","mittel","640","954","785"));
        db.addQANDA(new DB_Columns_QANDA("Aus wie vielen Kräutern wird Jägermeister gemacht?","56","mittel","13","7","47"));
        db.addQANDA(new DB_Columns_QANDA("Wie schnell ist ein Gepard? (km/h)","120","schwer","88","148","106"));
        db.addQANDA(new DB_Columns_QANDA("Wie groß ist Michael Jordan? (cm)","198","leicht","205","206","189"));



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
