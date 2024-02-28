package core;

import Exceptions.NotCorrectCountOfParametrs;
import Exceptions.NotCorrectDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserView {
    private Controller controller;

    public void run(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                System.out.println("Введите следующие данные через пробел: Фамилия Имя Отчество дата _ рождения номер _ телефона пол");
                String date = reader.readLine();
                try{
                    String[] parameters = checkCountOfParametrs(date);
                    controller.writeDates(parameters);
                    break;
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
