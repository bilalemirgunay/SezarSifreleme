package sezar_sifreleme;
import java.util.Scanner;

//bilalemirgunay

class sifreleme{
static String mesaj,sifreli_mesaj;
static int oteleme;

 public String sifrele(){
     char metinDizisi[]=mesaj.toCharArray();
     for(int i =0;i<metinDizisi.length;i++){
         int asciiDegeri=(int)metinDizisi[i];
         if(asciiDegeri!=32){                                       // BOŞLUĞA EŞİT DEĞİLKEN
             if(asciiDegeri>=65 && asciiDegeri<=90){                   // BÜYÜK HARFLER İÇİN
                if((asciiDegeri+oteleme)>90)
                     metinDizisi[i]=(char)(((asciiDegeri+oteleme)%90)+64);
                else
                     metinDizisi[i]=(char)(asciiDegeri+oteleme);
         }
             if(asciiDegeri>=97 && asciiDegeri<=122){                      //KÜÇÜK HARFLER İÇİN
                 if(asciiDegeri+oteleme>122)
                     metinDizisi[i]=(char)(((asciiDegeri+oteleme)%122)+96);
                 else
                     metinDizisi[i]=(char)(asciiDegeri+oteleme); 
             }
     }  
 }
     sifreli_mesaj=String.valueOf(metinDizisi);                               // DİZİYİ TEKRAR METNE ÇEVİRİYOR
     return sifreli_mesaj;
}
}

class sifreCozme{
    static String mesaj,sifreli_mesaj;
    static int oteleme;
    
    public String sifreCoz(){
      char metinDizisi[]=sifreli_mesaj.toCharArray();
      for(int i = 0 ;i<metinDizisi.length;i++){
          int asciiDegeri=(int)metinDizisi[i];
          if(asciiDegeri!=32){
              if(asciiDegeri>=65 && asciiDegeri<=90){
                  if(asciiDegeri-oteleme<65)
                      metinDizisi[i]=(char)(asciiDegeri-oteleme+26);
                  else 
                      metinDizisi[i]=(char)(asciiDegeri-oteleme);
              }
              if(asciiDegeri>=97 && asciiDegeri<=122){
                  if(asciiDegeri-oteleme<97)
                      metinDizisi[i]=(char)(asciiDegeri-oteleme+26);
                  else
                      metinDizisi[i]=(char)(asciiDegeri-oteleme);             
              } 
          } 
      }
      mesaj=String.valueOf(metinDizisi);
      return mesaj;
    } 

}

public class Sezar_sifreleme{
    public static void main(String[]args){
        Scanner giris=new Scanner(System.in);
        sifreleme sinif1=new sifreleme();
        sifreCozme sinif2=new sifreCozme();
        System.out.println("Metin girin:");
        sifreleme.mesaj=giris.nextLine();
        
        while(1==1){
            System.out.println("Key girin:");
            sifreleme.oteleme=giris.nextInt();
            if(sifreleme.oteleme>4){
                break;
            }
        }
        sifreCozme.oteleme=sifreleme.oteleme;
        String sifreli=sinif1.sifrele();
        sifreCozme.sifreli_mesaj=sifreli;
        System.out.println("Şifreli mesaj: "+sifreli);
        System.out.println("Çözülen mesaj: "+sinif2.sifreCoz());
        
    }
    
}


