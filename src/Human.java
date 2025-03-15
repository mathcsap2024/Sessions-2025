import Json.JsonSerializable;

public class Human implements JsonSerializable {
    String name;
    private Integer ID;
    Double height;
    Foot[] foots;
    Integer gitTest;
    Double gitDoubleTest;

    /*
    {   "name": "Hossein", "ID": 134, "gitTest": 12,
        "foots": [
            1234,
            {"id": 13},
            [12,15,"324"]
        ]
    }
     */

    public String serializeToJson() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"name\":");
        builder.append("\""+name+"\"");
        builder.append(",");

        builder.append("\"ID\":");
        builder.append(ID);

        builder.append("\"foots\":");
        builder.append("[");
        builder.append(foots[0].serializeToJson());
        builder.append(",");
        builder.append(foots[1].serializeToJson());
        builder.append("]");

        return builder.toString();
    }

    public Human(String name, Integer identity) {
        this.ID=ID;
        this.name=name;
        height=100.0;
        foots = new Foot[2];
        foots[1] = new Foot();
        foots[0] = new Foot();
    }

    class Foot implements JsonSerializable{
        Double height;

        public String serializeToJson() {
            return "";
        }

        public Foot() {
            this.height=Human.this.height/2;
            ID=5;
        }
    }

    static class Medicine {

    }
}
