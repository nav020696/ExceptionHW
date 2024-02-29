package core;

import Exceptions.NotCorrectCountOfParametrs;
import Exceptions.NotCorrectDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserView {
    private Controller controller;

    public UserView(Controller controller) {
        this.controller = controller;
    }

    public void run(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                System.out.print("Введите следующие данные через пробел: Фамилия Имя Отчество дата_рождения номер_телефона пол. ");
                System.out.println("Или введите exit для выхода");
                String date = reader.readLine();
                try{
                    if (date.equals("exit")){
                        break;
                    }
                    String[] parameters = checkCountOfParametrs(date);
                    controller.writeDates(parameters);
                }catch (NotCorrectCountOfParametrs | NotCorrectDate e){
                    System.err.println(e);
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private String[] checkCountOfParametrs(String param) throws NotCorrectCountOfParametrs {
        String[] params = param.split(" ");
        if (params.length != 6){
            throw new NotCorrectCountOfParametrs(params.length);
        }
        return params;
    }
}
