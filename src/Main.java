//Imports ==============================================================================
import java.util.concurrent.TimeUnit;
//throws InterruptedException
import java.util.Scanner;
import java.util.Random;

public class Main { //Variáveis ========================================================
    private static String Estado = "";
    private static int hunger = 0;
    private static int fatigue = 0;

    public static void main(String[] args) { //Loop dos métodos ========================
        int running = 0;//Faz o switch virar um loop
        Estado = "Working";
        String[] WorkingReactions = {"(╬▔皿▔)╯", "( •̀ ω •́ )y", "(┬┬﹏┬┬)", "ಥ_ಥ", "눈_눈"};
        Random random = new Random();

        while (running < 50) {
            switch (Estado) {
                case "Working":
                    hunger += 2;
                    fatigue += 5;
                    int WorkingReactionID = random.nextInt(WorkingReactions.length); // Sorteio de reações durante o trabalho (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
                    System.out.println("Juca está trabalhando ... " + WorkingReactions[WorkingReactionID]);
                    System.out.println("Fome: " + hunger);
                    System.out.println("Cansaço: " + fatigue);
                    if (fatigue > 50) //Condição para ir dormir
                    {
                        System.out.println("Bateu um soninho ... ^o^");
                        Estado = "Sleeping";
                    }else if (hunger > 10) { //Condição para ir comer
                        System.out.println("Bateu uma fome ... ผ(•̀_•́ผ)");
                        Estado = "Eating";
                    }
                    break;
                case "Eating":
                    hunger -= 5;
                    hunger = Math.max(0, hunger);
                    System.out.println("Juca está comendo ... ( *^-^)b");
                    System.out.println("Fome: " + hunger);
                    System.out.println("Cansaço: " + fatigue);

                    if(hunger <= 0){
                        hunger = 0;
                        System.out.println("Ufa! Já estou cheio... ( *︾▽︾)");
                        System.out.println("Hora de ir para o trabalho! o(TヘTo)");
                        Estado = "Working";
                    }

                    break;
                case "Sleeping":
                    hunger += 1;
                    fatigue -= 10;
                    fatigue = Math.max(0, fatigue);
                    System.out.println("Juca está dormindo ... (∪.∪ )zzz");
                    System.out.println("Fome: " + hunger);
                    System.out.println("Cansaço: " + fatigue);

                    if(fatigue <= 0) {
                        fatigue = 0;
                        if (hunger <=0)
                        {
                            System.out.println("Hora de ir para o trabalho! o(TヘTo)");
                            Estado ="Working";
                        }else if (hunger > 10){
                            System.out.println("Bateu uma fome ... ผ(•̀_•́ผ)");
                            Estado = "Eating";
                        }
                    }
                    break;
            }
            running ++;
        }
    }
}