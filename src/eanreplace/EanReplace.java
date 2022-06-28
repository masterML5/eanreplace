/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eanreplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Milos Jelic
 */
public class EanReplace {
Connection Con = null;
Statement St = null;
ResultSet Rs = null;
private static String sifraG;
private static Integer brojArtikala;

    public static void main(String[] args) throws SQLException {

double[][] a = {
{8606102152290L,193,45,230,255,8500035},
{8606102152542L,193,45,230,355,8500167},
{8602300204588L,140,20,170,106,2611010},
{8602300204687L,140,20,170,106,2641017},
{8602300204731L,140,20,170,106,2651016},
{8602300204809L,140,20,170,106,2671014},
{8602300200139L,135,25,185,108,3071016},
{8602300200245L,130,15,160,102.3,1251107},
{8602300201464L,130,15,160,102.3,1261106},
{8602300204137L,140,20,170,105.3,2201010},
{8602300207305L,140,20,170,106.3,3011012},
{8602300211920L,140,20,170,96,1310010},
{8602300212385L,135,40,25,20.8,7510373},
{8602300205929L,110,30,12,30.6,7630304},
{8602300205943L,110,30,12,30.6,7500309},
{8602300207541L,110,30,12,30.7,7510340},
{8602300200344L,280,70,45,135,9101155},
{8602300206780L,115,70,180,157,9511528},
{8602300206810L,140,70,235,360.1,9513524},
{8602300208449L,115,70,180,157,9511544},
{8602300213115L,135,40,25,25.8,7510407},
{8602300213160L,135,40,25,25.8,7510456},
{8602300214419L,245,70,35,146,9519075},
{8602300215645L,157,6,79,86,5301072},
{8602300215683L,157,6,79,86,5301080},
{8602300215768L,157,6,79,86,5301106},
{8602300215805L,157,6,79,86,5301114},
{8602300216673L,195,55,30,840,2671022},
{8602300217151L,195,55,30,830,2671147},
{8602300217847L,135,45,25,45,7510662},
{8602300217984L,135,45,25,45,7510670},
{8606106771381L,193,45,230,255,8500621},
{8602300219681L,160,20,210,210,2202026},
{8602300219728L,160,20,210,211,2202034},
{8602300219773L,195,40,220,320,2671204},
{8602300220779L,115,70,160,141,9000449},
{8602300221547L,135,40,25,25.8,7510738},
{8602300221684L,310,16,96,271,5302245},
{8602300221424L,180,110,260,1013.4,9000480},
{8602300223121L,195,40,220,265.5,2679413},
{8606104758018L,126,22,61,36,9002353},
{8606104758094L,126,22,61,36,9002361},
{8606104758131L,126,22,61,36,9002379},
{8602300234004L,115,70,180,157,9495573},
{8602300236022L,115,70,180,157,9519232},
{8602300201631L,140,70,235,360.1,9519240},
{8600091151012L,80,20,220,106,1151012},
{8600091151050L,75,10,188,106.5,1151050},
{8600091151609L,80,20,285,170,1151609},
{8600091320036L,15,35,115,31,1320036},
{8600091320043L,15,35,115,31,1320043},
{8602300217946L,255,95,37,300,1340270},
{8600091340317L,255,95,37,300,1340317},
{8600091340065L,30,140,20,18,1340690},
{8600091450535L,133,133,72,540,1450535},
{8600091680703L,70,70,133,590,1680703},
{8600091680727L,70,70,133,590,1680727},
{8600091680819L,88,88,124,972,1680819},
{8600091680826L,88,88,124,972,1680826},
{8600091680833L,88,88,124,972,1680833},
{8600091680857L,70,70,133,590,1680857},
{8606010873287L,115,70,180,105,8624421},
{8606010873324L,115,70,180,105,8624439},
{8602300217762L,310,16,96,271,5302500},
{8602300217809L,310,16,96,271,5302484},
{8602300225170L,135,40,25,30.8,7510894},
{8602300223848L,90,6,210,111,5302534},
{8606106771749L,160,40,210,52.5,8500795},
{8606106771787L,160,45,340,155,8500803},
{8602300225439L,157,9,79,106,5302559},
{8602300225514L,190,12,87,207,5302575},
{8602300225729L,90,6,210,111,5302591},
{8602300244010L,140,20,140,102,1370147},
{8602300244249L,140,20,140,102,1370154},
{8602300224937L,140,20,140,102,1370188},
{8600091345206L,250,185,37,600,1345206},
{8606106771824L,170,70,270,510,8500811},
{8600091450702L,84,70,111,571,1450702},
{8602300227426L,170,70,285,510,8500845},
{8606010875434L,216,113,46,404,8625121},
{8606010875472L,16,113,46,404,8625139},
{8600091450733L,84,70,111,571,1450733},
{8600091320135L,15,35,115,31,1320135},
{8600091320159L,15,35,115,31,1320159},
{8602300227662L,140,20,170,107,1269232},
{8602300227709L,140,20,170,107,1269240},
{8602300227747L,140,20,170,107,1269257},
{8602300227860L,135,40,25,30.8,7511082},
{8602300227976L,195,40,220,265,1269265},
{8602300220816L,140,70,190,279,9000514},
{8602300225552L,192,15,87,207,5302682},
{8602300228249L,157,6,79,96,5302690},
{8602300228287L,190,14,88,177,5302708},
{8600091150954L,75,8,107,109,1150954},
{8600091150961L,75,8,107,109,1150961},
{8600091150978L,75,8,107,109,1150978},
{8606010875915L,215,50,240,765,8620189},
{8602300228645L,157,6,79,86,5302716},
{8602300228683L,310,16,96,271,5302724},
{8606010875953L,17,38,223,255,8625196},
{8606010875991L,115,10,160,65,8625204},
{8606010876035L,115,10,160,65,8625212},
{8606010876073L,115,10,160,65,8625220},
{8602300207961L,230,18,70,77,6701536},
{8606010876196L,115,10,160,65,8625238},
{8600091370307L,140,20,140,102,1370307},
{8600091370284L,140,20,140,102,1370284},
{8600091372080L,140,20,200,204,1372080},
{8600091372097L,140,20,200,204,1372097},
{8600091372103L,140,20,200,204,1372103},
{8602300219605L,310,17,86,194.5,5302757},
{8602300229178L,135,40,25,20.8,7511116},
{8606010871498L,240,27,95,163,8625253},
{8606010870941L,240,27,95,163,8625261},
{8606010876349L,250,130,35,162,8620197},
{8600091370291L,140,20,140,102,1370291},
{8606010874321L,240,27,95,163,8625279},
{8606010871337L,240,27,95,163,8625287},
{8602300230310L,157,6,79,106,5302799},
{8602300230358L,190,10,87,207,5302807},
{8602300230396L,192,15,87,207,5302815},
{8602300225477L,190,12,87,207,5302823},
{8602300230631L,135,25,185,108,2679538},
{8602300230679L,135,25,185,108,2679546},
{8602300230716L,160,20,215,213,2679553},
{8602300230754L,135,25,185,108,2679561},
{8602300230990L,192,15,87,207,5302849},
{8602300231034L,130,15,160,102.3,1261130},
{8600091151159L,80,20,220,106,1151159},
{8600091151166L,80,20,220,106,1151166},
{8600091151173L,80,20,220,106,1151173},
{8602300231157L,325,17,86,255,6701551},
{8602300231294L,115,70,180,157,9519372},
{8602300231331L,140,70,235,310,9519380},
{8602300231379L,115,70,180,157,9519398},
{8602300231416L,140,70,235,310,9519406},
{8602300232017L,115,70,180,207,9519430},
{8602300232093L,135,40,25,30.8,7511165},
{8602300205424L,325,176,86,164.5,6701569},
{8602300232215L,140,70,235,360,9519448},
{8602300222421L,135,40,18,35.8,7511199},
{8602300200757L,110,30,12,30.7,7510589},
{8602300232987L,115,70,180,157,9519455},
{8602300233090L,110,30,12,30.7,7512007},

};


//for(int j = 0; j<a.length; j++){
    long ean = (long)a[0][0];
    String eanString = Long.toString(ean);
    
    double sirinaDouble = a[0][1];
    int sirina = (int)sirinaDouble;
    String sirinaString =String.valueOf(sirina);  
    
    double duzinaDouble = a[0][2];
    int duzina = (int)duzinaDouble;
    String duzinaString =String.valueOf(duzina);
    
    double visinaDouble = a[0][3];
    int visina = (int)visinaDouble;
    String visinaString =String.valueOf(visina);
    
    double bruto = a[0][4];
    
    
    
    NumberFormat nf = new DecimalFormat("#####");
    double sifra2Double = a[0][5];
    String sifra2String = nf.format(sifra2Double);
    
    
//    System.out.println("Redni br. : " + j);
//    System.out.println("EAN : " + ean);
//    System.out.println("sirina : " + sirina);
//    System.out.println("duzina : " + duzina);
//    System.out.println("visina : " + visina);
//    System.out.println("bruto : " + bruto);
//    
//    try {
//             
//    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/efaktura","root","");
//    PreparedStatement add = Con.prepareStatement("insert into test (ean,sirina,duzina,visina,bruto,aktivan,vazeci) values (?,?,?,?,?,?,?)");
//    Con.setAutoCommit(false);
//    add.setLong(1, ean);
//    add.setDouble(2, sirina);
//    add.setDouble(3, duzina);
//    add.setDouble(4, visina);
//    add.setDouble(5, bruto);
//    add.setInt(6, 1);
//    add.setInt(7, 1);
//    
//    add.addBatch();
//    add.executeBatch();
//    Con.commit();
//        
//        } catch (Exception e) {
//                    e.printStackTrace();
//        }
//    
    Connection Con = DriverManager.getConnection("jdbc:postgresql://10.11.124.202:5432/asoft?user=vlada&password=vladakk");

    String sqlArtikli = "select sifra, count sifra as SifCount from pionir_2022_robnomaterijalno.artikli where aktivan=true and vazeci=true and sifra2 = ?";
    PreparedStatement pstmt = Con.prepareStatement(sqlArtikli); 
    pstmt.setString(1,sifra2String);
    java.sql.ResultSet rs = pstmt.executeQuery();
    if(rs.next()){
    sifraG = rs.getString(1);
    brojArtikala = rs.getInt("SifCount");
    }
    
    if(brojArtikala == 1){
    System.out.println(sifraG);
    System.out.println(rs);
    System.out.println(rs.getClass());
//   Connection Con = DriverManager.getConnection("jdbc:postgresql://10.11.124.202:5432/asoft?user=vlada&password=vladakk");
//   String Query = "Update pionir_2022_robnomaterijalno.artikli_pakovanja set sirina='"+sirinaString+"'"+",duzina='"+duzinaString+"'"+",visina='"+visinaString+"'"+",brutojm="+bruto+""+" where ean='"+eanString+"' AND aktivan=true AND vazeci=true AND sifra='"+sifraG+"'";
//   System.out.println(Query);
//   Statement Add = Con.createStatement();
//   Add.executeUpdate(Query);
// a
    }else{
    System.out.println("ima vise artikala pod istom sifrom!");
    }
  
    
 
    // +++++++++++ UPDATE ++++++++++++++++
    
//   Connection Con = DriverManager.getConnection("jdbc:postgresql://10.11.124.202:5432/asoft?user=vlada&password=vladakk");
//   String Query = "Update pionir_2022_robnomaterijalno.artikli_pakovanja set sirina='"+sirinaString+"'"+",duzina='"+duzinaString+"'"+",visina='"+visinaString+"'"+",brutojm="+bruto+""+" where ean='"+eanString+"' AND aktivan=true AND vazeci=true AND sifra='"+sifraG+"'";
//   System.out.println(Query);
//   Statement Add = Con.createStatement();
//   Add.executeUpdate(Query);
  
//}




    }


    
}
