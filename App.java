import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        String arquivoCSV = "pesquisa.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";

        Mulheres[] mulheres = new Mulheres[30];

        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            for (int i = 0; (linha = br.readLine()) != null; i++) {

                String[] pais = linha.split(csvDivisor);

                mulheres[i] = new Mulheres();

                mulheres[i].setId(Integer.parseInt(pais[pais.length - 5]));
                mulheres[i].setTrabalho(Integer.parseInt(pais[pais.length - 4]));
                mulheres[i].setCasada(Integer.parseInt(pais[pais.length - 3]));
                mulheres[i].setIdade(Integer.parseInt(pais[pais.length - 2]));
                mulheres[i].setEscolaridade(Integer.parseInt(pais[pais.length - 1]));

                //System.out.println(mulheres[i].toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("MULHERES QUE TRABALHAM, NÃO SÃO CASADAS E TEM MAIS DE 10 ANOS DE ESCOLARIDADE:");
        System.out.println("Suporte regra 1:");
        System.out.printf("%.2f\n", suporteRegra1(mulheres));
        System.out.println("Confiança regra 1:");
        System.out.printf("%.2f\n", confiancaRegra1(mulheres));
        System.out.println("Lift regra 1:");
        System.out.printf("%.4f\n", liftRegra1(mulheres));

        System.out.println("=======================");
        
        System.out.println("MULHERES COM MAIS DE 25 ANOS, QUE TENHAM MAIS DE 10 ANOS DE ESCOLARIDADE E QUE SÃO CASADAS:");
        System.out.println("Suporte regra 2:");
        System.out.printf("%.2f\n", suporteRegra2(mulheres));
        System.out.println("Confiança regra 2:");
        System.out.printf("%.2f\n", confiancaRegra2(mulheres));
        System.out.println("Lift regra 2:");
        System.out.printf("%.4f\n", liftRegra2(mulheres));
    }


    //MULHERES QUE TRABALHAM, NÃO SÃO CASADAS E TEM MAIS DE 10 ANOS DE ESCOLARIDADE
    //suporte
    public static double suporteRegra1(Mulheres[] mulheres) {

        int frequencia = 0;
    
        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getTrabalho() == 1 && mulheres[i].getCasada() == 0 && mulheres[i].getEscolaridade() >= 10) {
                frequencia += 1;
            }
        }

        return frequencia / (double) mulheres.length;
    }

    //confiança
    public static double confiancaRegra1(Mulheres[] mulheres) {

        int frequencia1 = 0;
        int frequencia2 = 0;
    
        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getTrabalho() == 1 && mulheres[i].getCasada() == 0 && mulheres[i].getEscolaridade() >= 10) {
                frequencia1 += 1;
            }
        }

        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getTrabalho() == 1 && mulheres[i].getCasada() == 0) {
                frequencia2 += 1;
            }
        }
        return (double) frequencia1 / (double) frequencia2;
    }

    //lift
    public static double liftRegra1(Mulheres[] mulheres) {

        int frequencia1 = 0;
        int frequencia2 = 0;
        int frequencia3 = 0;
    
        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getTrabalho() == 1 && mulheres[i].getCasada() == 0 && mulheres[i].getEscolaridade() >= 10) {
                frequencia1 += 1;
            }
        }

        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getTrabalho() == 1 && mulheres[i].getCasada() == 0) {
                frequencia2 += 1;
            }
        }

        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getCasada() == 0) {
                frequencia3 += 1;
            }
        }

        return (double) frequencia1 / (double) (frequencia2 * frequencia3);
    }

    //MULHERES COM MENOS DE 30 ANOS, QUE TENHAM MAIS DE 10 ANOS DE ESCOLARIDADE E QUE SÃO CASADAS
    public static double suporteRegra2(Mulheres[] mulheres) {

        int frequencia = 0;
    
        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getIdade() >= 25 && mulheres[i].getEscolaridade() >= 10 && mulheres[i].getCasada() == 1) {
                frequencia += 1;
            }
        }

        return frequencia / (double) mulheres.length;
    }

    public static double confiancaRegra2(Mulheres[] mulheres) {

        int frequencia1 = 0;
        int frequencia2 = 0;
    
        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getIdade() >= 25 && mulheres[i].getEscolaridade() >= 10 && mulheres[i].getCasada() == 1) {
                frequencia1 += 1;
            }
        }

        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getIdade() >= 25 && mulheres[i].getEscolaridade() >= 10) {
                frequencia2 += 1;
            }
        }

        return (double) frequencia1 / (double) frequencia2;
    }

    //lift
    public static double liftRegra2(Mulheres[] mulheres) {

        int frequencia1 = 0;
        int frequencia2 = 0;
        int frequencia3 = 0;
    
        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getIdade() >= 25 && mulheres[i].getEscolaridade() >= 10 && mulheres[i].getCasada() == 1) {
                frequencia1 += 1;
            }
        }

        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getIdade() >= 25 && mulheres[i].getEscolaridade() >= 10) {
                frequencia2 += 1;
            }
        }

        for (int i = 0; i < mulheres.length; i++) {
            if (mulheres[i].getCasada() == 1) {
                frequencia3 += 1;
            }
        }

        return (double) frequencia1 / (double) (frequencia2 * frequencia3);
    }
}
