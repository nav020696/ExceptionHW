package core;

import Exceptions.NotCorrectDate;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Model {
    public void writeToFile(String[] parameters) throws NotCorrectDate {
        checkParameters(parameters);
        try(FileWriter writer = new FileWriter("test.txt")){
            StringBuilder sb = new StringBuilder();
            sb.append("ФИО ").append(parameters[0] + " ").append(parameters[1] + " ").append(parameters[2] + "\n");
            sb.append("Дата рождения" + parameters[3] + "\n");
            sb.append("Номер телефона" + parameters[4] + "\n");
            if (parameters[5].equals("f")){
                sb.append("Пол: женский");
            }else{
                sb.append("Пол: мужской");
            }
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("Файла на запись данных не существует");
        }
    }

    private void checkParameters(String[] parameters) throws NotCorrectDate {
        if (!parameters[5].equals("f") || !parameters[5].equals("m")){
            throw new NotCorrectDate("Некорректное значение пола. Допустимые значения только f или m");
        }
        if (!parameters[4].equals("+")){
            throw new NotCorrectDate("Телефон содержит знак +");
        }
        try{
            long param = Long.parseLong(parameters[4]);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.parse(parameters[3]);
        }catch (NumberFormatException e){
            throw new NotCorrectDate("В телефоне содержатся не только числа");
        } catch (ParseException e) {
            throw new NotCorrectDate("Некорректная дата. Дата должна быть в формате dd.mm.yyyy");
        }

    }
}
