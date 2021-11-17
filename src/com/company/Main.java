package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) {
        JSONGetter jsonGetter = new JSONGetter();
        System.out.println("Waiting for data...");
        JSONGetter.url = "https://api-mobilespecs.azharimm.site/v2/top-by-interest";
        jsonGetter.run();


        String jsonString = jsonGetter.jsonIn;
        //System.out.println(jsonString);

        // Считываем json
        JSONObject obj = new JSONObject();
        try {
            obj = (JSONObject) new JSONParser().parse(jsonString);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        System.out.println();
        Search search = new Search();
        search.setStatus((boolean) obj.get("status"));
        obj = (JSONObject) obj.get("data");
        Data data = new Data();
        data.setTitle(obj.get("title").toString());
        JSONArray jsonArray = (JSONArray) obj.get("phones");

        for (Object jsonObject : jsonArray) {
            JSONObject current = (JSONObject) jsonObject;
            int hits = Integer.parseInt(current.get("hits").toString());
            String phoneName = (String) current.get("phone_name");
            String detail = (String) current.get("detail");
            String slug = (String) current.get("slug");
            Phone phone = new Phone(phoneName, slug, hits, detail);
            data.add(phone);
        }
        search.setData(data);
        System.out.println("Imported data after parsing:\n" + data);
        if (data != null) {
            search.getData().getPhones().sort(Phone.byNameAsc);
            System.out.println("After sorting by name ascending:\n" + data);
            search.getData().getPhones().sort(Phone.byNameDesc);
            System.out.println("After sorting by name descending:\n" + data);
            search.getData().getPhones().sort(Phone.byValueAsc);
            System.out.println("After sorting by hits value ascending:\n" + data);
            search.getData().getPhones().sort(Phone.byValueDesc);
            System.out.println("After sorting by hits value descending:\n" + data);
        }
    }
}
