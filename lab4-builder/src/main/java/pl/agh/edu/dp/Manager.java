package pl.agh.edu.dp;

import pl.agh.edu.dp.objects.FloatObject;
import pl.agh.edu.dp.objects.IntegerObject;
import pl.agh.edu.dp.objects.JsonObject;
import pl.agh.edu.dp.objects.StringObject;

public class Manager {
    private final String jsonContent;
    private int index;

    public Manager(String jsonContent) {
        this.jsonContent = jsonContent.replace(" ", "")
                .replace(System.lineSeparator(), "");
    }

    public JsonObject createJson(){
        index = 1;
        return buildJson();
    }

    private boolean isCurrentChar(char toCheck){
        return jsonContent.charAt(index) == toCheck;
    }

    private boolean isCurrentDigit(){
        return Character.isDigit(jsonContent.charAt(index));
    }
    private JsonObject buildJson(){
        JSONBuilder builder = new JSONBuilderImpl();

        String name;
        while (!isCurrentChar('}')){
            //Creating name
            name = getSentence();
            incrementIndex();

            //creating specific object
            if (isCurrentChar('{')){
                incrementIndex();
                builder.add(buildJson());
            }
            else if (isCurrentChar('"')){
                builder.add(new StringObject(name, getSentence()));
            }
            else if (isCurrentDigit()){
                String numberRepresentation = getNumberString();
                if (isCurrentChar('.')){
                    incrementIndex();
                    builder.add(new FloatObject(name, Float.valueOf(numberRepresentation + '.' + getNumberString())));
                }
                else{
                    builder.add(new IntegerObject(name, Integer.valueOf(numberRepresentation)));
                }
            }

            if (isCurrentChar(','))
                incrementIndex();
        }

        incrementIndex();
        return builder.build();
    }

    private void incrementIndex() {
        index++;
    }

    private String getNumberString() {
        int startingNameIndex = index;
        while (Character.isDigit(jsonContent.charAt(index)))
            incrementIndex();

        return jsonContent.substring(startingNameIndex, index);
    }

    private String getSentence() {
        incrementIndex();
        int startingNameIndex = index;
        while (!isCurrentChar('"'))
            incrementIndex();

        incrementIndex();
        return jsonContent.substring(startingNameIndex, index - 1);
    }


}
