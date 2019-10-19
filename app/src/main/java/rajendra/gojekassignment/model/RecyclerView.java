package rajendra.gojekassignment.model;


public class RecyclerView {

    private String Aavatar;

    public String getAavatar() {
        return Aavatar;
    }

    public void setAavatar(String aavatar) {
        Aavatar = aavatar;
    }

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

    private String Aauthor;
    private String Nname;

    public RecyclerView(String aavatar, String aauthor, String nname) {
        Aavatar = aavatar;
        Aauthor = aauthor;
        Nname = nname;
    }


    public RecyclerView() {
    }

}



