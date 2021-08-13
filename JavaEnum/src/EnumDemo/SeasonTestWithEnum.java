package EnumDemo;

public class SeasonTestWithEnum {

    public static void main(String[] args) {
        System.out.println(Seasons.SUMMER);//直接印出來不是記憶體位置，表示父類別不是Object
        System.out.println(Seasons.class.getSuperclass());//看看他的父類別
    }
}

enum Seasons{
    //1.提供當前枚舉物件 多個物件以","隔開,最後以";"結束
   SPRING("spring","春天"),
   SUMMER("summer","夏天"),
   AUTUMN("autumn","秋天"),
   WINTER("winter","冬天");
    //2.聲明屬性
    private final String seasonName;
    private final String seasonDesc;

    private Seasons(String seasonName,String seasonDesc){
        this.seasonName= seasonName;
        this.seasonDesc = seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //提供toString

}