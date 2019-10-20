package rajendra.gojekassignment.model;


public class RecyclerView {

    public String getAauthor() {
        return Aauthor;
    }

    public void setAauthor(String aauthor) {
        Aauthor = aauthor;
    }

    public String getNname() {
        return Nname;
    }

    public void setNname(String nname) {
        Nname = nname;
    }

    public String getAavatar() {
        return Aavatar;
    }

    public void setAavatar(String aavatar) {
        Aavatar = aavatar;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    public String getLangcolor() {
        return Langcolor;
    }

    public void setLangcolor(String langcolor) {
        Langcolor = langcolor; }

    public Integer getStars() {
        return Stars;
    }

    public void setStars(Integer stars) {
        Stars = stars;
    }

    public Integer getForks() {
        return Forks;
    }

    public void setForks(Integer forks) {
        Forks = forks;
    }

    private String Aauthor;
    private String Nname;
    private String Aavatar;
    private String Lang;
    private String Langcolor;
    private Integer Stars;
    private Integer Forks;

    public RecyclerView(String aauthor, String nname, String aavatar, String lang, Integer stars, Integer forks, String langcolor) {
        Aauthor = aauthor;
        Nname = nname;
        Aavatar = aavatar;
        Lang = lang;
        Stars = stars;
        Forks = forks;
        Langcolor = langcolor;
    }






    public RecyclerView() {
    }

}



