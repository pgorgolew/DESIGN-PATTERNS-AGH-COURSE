package pl.agh.edu.dp;

public class Manager {
    String jsonContent;

    public Manager(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public JSON createJson(){
        String withoutSpacesContent = jsonContent.replace(" ", "").replace(System.lineSeparator(), "");
        System.out.println(withoutSpacesContent);
        return null;
    }



}
