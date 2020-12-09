package com.masteril.librairie.model;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Parser {

    public static String parse(String json) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        StringBuilder sb = new StringBuilder();
        if (json == null) return "Aucun livre trouvé.";
        try {
            obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            sb.append(parseBook(jsonObject));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String parseList(String json) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        StringBuilder sb = new StringBuilder();
        if (json == null) return "Aucun livre trouvé.";
        try {
            obj = parser.parse(json);
            JSONArray array = (JSONArray) obj;
            for(Object object: array) {
                JSONObject jsonObject = (JSONObject) object;
                sb.append(parseBook(jsonObject));
                sb.append("\n--------------------------------------------------------------------------------------------\n");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static String parseBook(JSONObject jsonObject) {
        return "\n   Titre : " + jsonObject.get("title") + "\n" +
                "   Auteur : " + jsonObject.get("author") + "\n" +
                "   Description : " + jsonObject.get("description") + "\n" +
                "   Prix : " + jsonObject.get("price") + "\n";
    }

    public static int getId(String json) {
        if (json == null) return -1;
        JSONParser parser = new JSONParser();
        Object obj = null;
        String id = "";
        try {
            obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            id = jsonObject.get("id").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(id);
    }

    public static String getTitle(String json) {
        if (json == null) return "Aucun livre trouvé.";
        JSONParser parser = new JSONParser();
        Object obj = null;
        String titre = "";
        try {
            obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            titre = jsonObject.get("title").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return titre;

    }

    public static String getAuthor(String json) {
        if (json == null) return "Aucun livre trouvé.";
        JSONParser parser = new JSONParser();
        Object obj = null;
        String titre = "";
        try {
            obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            titre = jsonObject.get("author").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return titre;

    }

    public static String getDescription(String json) {
        if (json == null) return "Aucun livre trouvé.";
        JSONParser parser = new JSONParser();
        Object obj = null;
        String titre = "";
        try {
            obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            titre = jsonObject.get("description").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return titre;

    }
    public static String getPrice(String json) {
        if (json == null) return "Aucun livre trouvé.";
        JSONParser parser = new JSONParser();
        Object obj = null;
        String prix = "";
        try {
            obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            prix = jsonObject.get("price").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return prix;
    }


}
